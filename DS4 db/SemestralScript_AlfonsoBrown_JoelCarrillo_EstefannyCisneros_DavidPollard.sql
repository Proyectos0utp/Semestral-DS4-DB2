-- Configuracion de email para la base de datos
sp_configure 'show advanced options', 1;
GO
RECONFIGURE;
GO
 
sp_configure 'Database Mail XPs', 1;
GO
RECONFIGURE
GO


IF NOT EXISTS(SELECT 1 FROM msdb.dbo.sysmail_profile WHERE name = 'Notificaciones') OR NOT EXISTS(SELECT 1 FROM msdb.dbo.sysmail_account WHERE name = 'Gmail')
	BEGIN
	-- Creacion de perfil
	EXECUTE msdb.dbo.sysmail_add_profile_sp  
		@profile_name = 'Notificaciones',  
		@description = 'Perfil usado para mandar emails a traves de Gmail' ;

	-- Otorgar permisos al perfil creado
	EXECUTE msdb.dbo.sysmail_add_principalprofile_sp  
		@profile_name = 'Notificaciones',  
		@principal_name = 'public',  
		@is_default = 1 ;

	-- Creacion de la cuenta de email para database
	EXECUTE msdb.dbo.sysmail_add_account_sp  
		@account_name = 'Gmail',  
		@description = 'Cuenta usada para mandar emails a traves de gmail',  
		@email_address = 'educacionvirtualutp@gmail.com',  
		@display_name = 'Educacion Virtual - Notificacion',  
		@mailserver_name = 'smtp.gmail.com',
		@port = 587,
		@enable_ssl = 1,
		@username = 'educacionvirtualutp@gmail.com',
		@password = 'semestraldb123' ;  

	-- Añadir cuenta al perfil
	EXECUTE msdb.dbo.sysmail_add_profileaccount_sp  
		@profile_name = 'Notificaciones',  
		@account_name = 'Gmail',  
		@sequence_number = 1 ;  

	END
GO

-- Creacion de base de datos
CREATE DATABASE EducacionVirtual
GO
USE EducacionVirtual
GO

-- Creacion de Tablas
CREATE TABLE Usuario(
  cedula VARCHAR(13) NOT NULL UNIQUE,
  CONSTRAINT UsuarioFormatoCedula_CK
  CHECK(cedula like '[1-9][-][0-9][0-9][0-9][-][0-9][0-9][0-9][0-9]' or
		cedula like '[1][0-3][-][0-9][0-9][0-9][-][0-9][0-9][0-9][0-9]'),
  correo NVARCHAR(30)
  CONSTRAINT Correo_Usuario_PK
  PRIMARY KEY(correo),
  CONSTRAINT UsuarioFormatoCorreo_CK
  CHECK(correo like '%@%'),
  contraseña NVARCHAR(15) NOT NULL,
  nombre NVARCHAR(25) NOT NULL,
  apellido NVARCHAR(25) NOT NULL
)

CREATE TABLE Maestro(
  correo_usuario nvarchar(30)
  CONSTRAINT Correo_Maestro_PK
  PRIMARY KEY(correo_usuario),
  CONSTRAINT Correo_Maestro_FK
  FOREIGN KEY (correo_usuario)
  REFERENCES Usuario(correo),
  estud_didact CHAR(2) NOT NULL
  CONSTRAINT Validar_Estudio_Didacticos_CK
  CHECK(estud_didact like 'si' or estud_didact like 'no'),
)

CREATE TABLE Grupo(
  cod_grupo CHAR(6)
  CONSTRAINT Codigo_Grupo_PK
  PRIMARY KEY(cod_grupo),
  correo_maestro NVARCHAR(30) NOT NULL
  CONSTRAINT Correo_Maestro_Grupo_FK
  FOREIGN KEY (correo_maestro)
  REFERENCES Maestro(correo_usuario),
  nivel INT NOT NULL
)

CREATE TABLE Estudiante(
  correo_usuario nvarchar(30)
  constraint Correo_Estudiante_PK
  PRIMARY KEY (correo_usuario)
  CONSTRAINT Correo_Estudiante_FK
  FOREIGN KEY (correo_usuario)
  REFERENCES Usuario(correo),
  cod_grupo CHAR(6) NOT NULL
  CONSTRAINT Codigo__Grupo_FK
  FOREIGN KEY(cod_grupo)
  REFERENCES Grupo(cod_grupo)
)

CREATE TABLE Tema(
  cod_tema CHAR(7)
  constraint Codigo_Tema_PK
  Primary Key (cod_tema)
  constraint Validar_Codigo_Tema_CK
  CHECK ( cod_tema like '[T][C][N][0-1][1-9][-][0-9]'
		or cod_tema like '[T][C][S][0-1][1-9][-][0-9]'),
  tema VARCHAR(100) NOT NULL,
  imagen VARCHAR(MAX),
  Contenido VARCHAR(300) NOT NULL
)

CREATE TABLE Pregunta(
  cod_pregunta INT IDENTITY(101,1) 
  CONSTRAINT Codigo_Pregunta_PK 
  PRIMARY KEY(cod_pregunta) NOT NULL,
  cod_tema CHAR(7) NOT NULL
  CONSTRAINT Codigo_tema_FK 
  FOREIGN KEY (cod_tema) 
  REFERENCES Tema(cod_tema),
  pregunta VARCHAR(300) NOT NULL,
  imagen VARCHAR(MAX)
)

CREATE TABLE Contestan(
  correo_est nvarchar(30)
  CONSTRAINT Correo_Estudiante_Contesta_PK
  PRIMARY KEY(correo_est, cod_pregunta, fecha)
  CONSTRAINT Contestan_Correo_Estudiante_FK
  FOREIGN KEY (correo_est)
  REFERENCES Estudiante(correo_usuario),
  cod_pregunta INT NOT NULL
  CONSTRAINT Contesta_Pregunta_FK
  FOREIGN KEY (cod_pregunta)
  REFERENCES Pregunta(cod_pregunta),
  puntos_obtenidos INT,
  fecha DATETIME DEFAULT SYSUTCDATETIME() NOT NULL
)

CREATE TABLE Respuesta(
  cod_pregunta INT 
  CONSTRAINT Codigo_Pregunta_Ident_Opcion_PK 
  PRIMARY KEY(cod_pregunta, ident_opcion)	
  CONSTRAINT Respuesta_Pregunta_FK 
  FOREIGN KEY(cod_pregunta) 
  REFERENCES Pregunta(cod_pregunta),
  ident_opcion CHAR(1) NOT NULL,	
  opcion_resp VARCHAR(300) NOT NULL,
  respuesta VARCHAR(10) NOT NULL,
  retroalimentacion VARCHAR(300) NOT NULL,
  imagen VARCHAR(MAX)
)

GO

CREATE TRIGGER verificarDuplicados
ON Usuario
INSTEAD OF INSERT
AS
BEGIN
	DECLARE
		@cedula VARCHAR(13)
	SELECT
		@cedula = i.cedula
	FROM inserted i

	IF EXISTS (SELECT 1 FROM Usuario WHERE cedula = @cedula)
		BEGIN

		RAISERROR('Ya existe una cuenta con la cedula ingresada.', 16, 1)

		DECLARE
			@correo NVARCHAR(30),
			@contraseña NVARCHAR(15),
			@mensaje NVARCHAR(255)
		SELECT @correo=[correo], @contraseña=[contraseña] FROM Usuario WHERE cedula = @cedula
		SET @mensaje = 'Se intento crear una nueva cuenta utilizando la cedula que esta asociada a este email. Su contraseña para la cuenta registrada con este email es la siguiente: ' + @contraseña
		
		EXEC msdb.dbo.sp_send_dbmail 
		@profile_name = 'Notificaciones', 
		@recipients = @correo, 
		@subject = 'Recuperacion de contraseña', 
		@body = @mensaje,
		@body_format = 'text'

		END
	ELSE
		BEGIN

		INSERT INTO Usuario (cedula, correo, contraseña, nombre, apellido)
		SELECT i.cedula, i.correo, i.contraseña, i.nombre, i.apellido
		FROM inserted i

		END
END

GO

CREATE PROC estudiantes_grupo(@cod_grupo CHAR(6))
AS
BEGIN
	IF EXISTS (SELECT 1 FROM Grupo WHERE cod_grupo = @cod_grupo)
		BEGIN

		SELECT u.apellido, u.nombre, u.cedula, u.correo, u.contraseña
		FROM Usuario u
		INNER JOIN Estudiante e
		ON (u.correo = e.correo_usuario)
		WHERE e.cod_grupo = '01'
		ORDER BY apellido ASC

		END
	ELSE
		BEGIN
		RAISERROR('El grupo ingresado no existe.', 16, 1)
		END
END

GO

CREATE PROC validar_respuesta(@correo NVARCHAR(30), @pregunta INT, @letra CHAR(1))
AS
BEGIN
	DECLARE
		@respuesta VARCHAR(10)
	SELECT @respuesta=[respuesta] FROM Respuesta 
	WHERE cod_pregunta = @pregunta AND ident_opcion = @letra

	IF EXISTS (SELECT 1 FROM Contestan WHERE correo_est = @correo AND puntos_obtenidos = 0 AND cod_pregunta = @pregunta)
		BEGIN
		IF (@respuesta = 'Correcto')
			BEGIN
			DELETE FROM Contestan
			WHERE correo_est = @correo AND puntos_obtenidos = 0 AND cod_pregunta = @pregunta

			INSERT INTO Contestan(correo_est, cod_pregunta, puntos_obtenidos)
			VALUES (@correo, @pregunta, 1)

			RETURN 1
			END
		ELSE
			BEGIN
			DELETE FROM Contestan
			WHERE correo_est = @correo AND puntos_obtenidos = 0 AND cod_pregunta = @pregunta

			INSERT INTO Contestan(correo_est, cod_pregunta, puntos_obtenidos)
			VALUES (@correo, @pregunta, -2)
			RETURN 0
			END
		END
	ELSE
		IF (@respuesta = 'Correcto')
			BEGIN
			INSERT INTO Contestan(correo_est, cod_pregunta, puntos_obtenidos)
			VALUES (@correo, @pregunta, 1)
			RETURN 1
			END
		ELSE
			BEGIN
			INSERT INTO Contestan(correo_est, cod_pregunta, puntos_obtenidos)
			VALUES (@correo, @pregunta, 0)
			RETURN 0
			END
END

GO

CREATE PROC listar_puntajes(@cod_grupo CHAR(6))
AS
BEGIN
	DECLARE
		@nombre NVARCHAR(25),
		@apellido NVARCHAR(25),
		@correo NVARCHAR(30),
		@cedula VARCHAR(13),
		@tema CHAR(7),
		@prev CHAR(7) = '',
		@pregunta VARCHAR(300),
		@puntos_obtenidos INT


	DECLARE cursor_estudiantes CURSOR FOR
	SELECT u.nombre, u.apellido, u.correo, u.cedula
	FROM Estudiante e
	JOIN Usuario u
	ON (e.correo_usuario = u.correo)
	WHERE e.cod_grupo = @cod_grupo

	OPEN cursor_estudiantes

	FETCH NEXT FROM cursor_estudiantes INTO @nombre, @apellido, @correo, @cedula

	WHILE @@FETCH_STATUS = 0
	BEGIN
		PRINT 'NOMBRE: ' + @nombre
		PRINT 'APELLIDO: ' + @apellido
		PRINT 'CEDULA: ' + @cedula
		PRINT 'CORREO: ' + @correo + char(10)

		DECLARE cursor_puntajes CURSOR FOR
		SELECT t.tema, p.pregunta, c.puntos_obtenidos
		FROM Tema t
		JOIN Pregunta p
		ON (t.cod_tema = p.cod_tema)
		JOIN Contestan c
		ON (c.cod_pregunta = p.cod_pregunta)
		WHERE c.correo_est = @correo

		OPEN cursor_puntajes
		FETCH NEXT FROM cursor_puntajes INTO @tema, @pregunta, @puntos_obtenidos

		IF (@@FETCH_STATUS = -1)
		BEGIN
			PRINT char(9) + char(9) + 'NO HA RESPONDIDO NINGUNA PREGUNTA' + char(10)
		END
		ELSE
		BEGIN
			WHILE @@FETCH_STATUS = 0
			BEGIN
				IF NOT (@tema = @prev)
				BEGIN
					PRINT char(9) + char(9) + 'TEMA: ' + @tema + char(10)
				END

				PRINT char(9) + char(9) + char(9) + 'PREGUNTA: ' + @pregunta
				PRINT char(9) + char(9) + char(9) + 'PUNTOS OBTENIDOS: ' + CAST(@puntos_obtenidos AS VARCHAR) + char(10)
				SET @prev = @tema
				FETCH NEXT FROM cursor_puntajes INTO @tema, @pregunta, @puntos_obtenidos
			END
		END
		CLOSE cursor_puntajes
		DEALLOCATE cursor_puntajes
		FETCH NEXT FROM cursor_estudiantes INTO @nombre, @apellido, @correo, @cedula
	END
	CLOSE cursor_estudiantes
	DEALLOCATE cursor_estudiantes
END
GO

-- INSERCION DE DATOS

USE EducacionVirtual

INSERT INTO Tema(cod_tema,tema,imagen,Contenido )
VALUES('TCN01-1','Sistema Digestivo',
	'https://drive.google.com/uc?export=view&id=1ow-bMg7f9P2nW5jJ2f8cW7XuxFUZTfXO',
	'Identificación de los órganos del sistema.'),
	('TCN01-2','Los Alimentos son necesarios para dar energía y movimientos al cuerpo',
	'https://drive.google.com/uc?export=view&id=1p9LHhmasfkureVWlY3a6o9arzTTyuhm_',
	'Clasificación de los alimentos según su origen, y función.
	Distinción de las clases de alimentos según su origen.
	Clasificación y análisis de los alimentos según su función.'),
	('TCN01-3','El sistema Respiratorio',
	'https://drive.google.com/uc?export=view&id=1j1OqV09JUgJDUie4ISNNeXz4tIO1Eht7',
	'Ejecución de los mecanismos de la respiración (inhalación y exhalación), 
	mediante pruebas corporales y de laboratorio.'),
	('TCN01-4','La reproducción de los seres vivos',
	'https://drive.google.com/uc?export=view&id=1dCHz10vxyJb2DGQUt-ksldDh79IvK2pV',
	'Clasificación de los tipos de reproducción: sexual, animales mamíferos, 
	plantas con flores, asexual, en plantas, artificial, natural, 
	brotes o yemas, animales.');

INSERT INTO Pregunta(cod_tema,pregunta,imagen)
VALUES('TCN01-1','Las partes del aparato digestivo son:','https://i.ibb.co/TPScrh3/bd1.png'),
	('TCN01-1','¿Que hace el aparato digestivo, cual es su funcion?',''),
	('TCN01-1','Las glandulas salivales se encargan de',''),
	('TCN01-1','El proceso de digestion inicia en:',''),
	('TCN01-1','Estructura con forma de tubo, que forma parte tanto del aparato digestivo como del respiratorio: conecta la boca con el esófago',''),
	('TCN01-2','¿Cómo se clasifican los alimentos de acuerdo a su origen?',''),
	('TCN01-2','¿Cuáles son los alimentos según su función?',''),
	('TCN01-2','Un ejemplo de los alimentos constructores es:','https://i.ibb.co/Zft6cy5/bd2.png'),
	('TCN01-2','¿Cuál de los siguientes es un alimento de origen vegetal?',''),
	('TCN01-2','Un ejemplo de alimento regulador es:',''),
	('TCN01-3','Cuando el aire entra a los pulmones se llama:','https://i.ibb.co/kxt9BQb/bd3.png'),
	('TCN01-3','Cuando el aire sale de los pulmones se llama:',''),
	('TCN01-3','El aire que entra a los pulmones se llama:',''),
	('TCN01-3','El aire que sale de los pulmones se llama:',''),
	('TCN01-3','El sistema respiratorio está formado por',''),
	('TCN01-4','La reproducción puede ser:',''),
	('TCN01-4','Es la función por la cual un ser vivo da lugar a otros seres vivos semejantes a ellos:',''),
	('TCN01-4','Escoga cual de las siguientes afirmaciones es verdadera:',''),
	('TCN01-4','Escoga la opción que pertenece a la reproducción asexual de la planta',''),
	('TCN01-4','Los animales que se reproducen por huevos son:','https://i.ibb.co/cJQVMDg/bd4.png');

INSERT INTO Respuesta(cod_pregunta,ident_opcion,opcion_resp,respuesta,retroalimentacion)
VALUES(101,'A','Boca, Faringe, Esófago, Estómago, Páncreas, Intestino delgado, Intestino grueso.',
'Incorrecto','Faltan partes: Higado y ano.'),
(101,'B','Boca, Faringe, Esófago, Estómago, Páncreas, Hígado, Intestino delgado, Intestino grueso, Ano.',
'Correcto','Felicidades!! Todos ellos son partes del aparato digestivo.'),
(101,'C','Boca, Faringe, Esófago, Hígado, Intestino delgado, Intestino grueso, Ano.',
'Incorrecto','Faltan partes: Estomago y páncreas.'),
(102,'A','El aparato digestivo es responsable de descomponer los alimentos, absorber los nutrientes 
y librar al organismo de los productos de desecho de los alimentos.',
'Correcto','Felicidades!! El aparato digestivo es de vital importancia para vivir.'),
(102,'B','Contiene el corazón y los vasos sanguíneos, y que mueve la sangre por todo el cuerpo.',
'Incorrecto','El sistema que contiene el corazon y los vasos sanguíneos es el sistema circulatorio'),
(102,'C','Proveerle oxígeno a la sangre',
'Incorrecto','El en cargado de proveer oxigeno a la sangre es el sistema respiratorio.'),
(103,'A','Producen saliva y ayudan a lubricar y descomponer los alimentos.',
'Correcto','Felicidades!! Las glandulas salivales producen saliva, una mezcla de secreciones que ayudan a lubricar y descomponer los alimentos.'),
(103,'B','Bombea sangre a todas las partes del cuerpo.',
'Incorrecto','El encargado de bombear la sangre a todo el cuerpo es el corazon'),
(103,'C','Esófago',
'Incorrecto','El esófago transporta alimentos y líquidos desde la boca al estómago.'),
(104,'A','Estomago',
'Incorrecto','En el estomago se descomponen los alimentos y se absorben los nutrientes.'),
(104,'B','Esófago',
'Incorrecto','El esófago transporta el alimento de la faringe al estómago.'),
(104,'C','Boca',
'Correcto','Felicidades!! El proceso digestivo comienza en la boca cuando una persona mastica.'),
(105,'A','Faringe ',
'Correcto','Felicidades!! La faringe es un tubo que continúa a la boca y constituye el extremo superior común de los tubos respiratorio y digestivo.'),
(105,'B','Intestino delgado',
'Incorrecto','La función del intestino delgado es continuar el proceso de la digestión de los alimentos que vienen del estómago, y absorber los nutrientes.'),
(105,'C','Páncreas',
'Incorrecto','La función principal de páncreas es neutralizar la acidez'),
(106,'A','Origen marino, origen vegetal y origen mineral.',
'Incorrecto','Los alimentos se clasifican segun origen en animal, vegetal y mineral'),
(106,'B','Origen animal y origen mineral',
'Correcto','Felicidades!! Dependiendo de su origen pueden ser alimentos de origen animal, como la carne, y alimentos de origen vegetal, la sal son alimentos de origen mineral.'),
(106,'C','Origen animal y origen mineral',
'Incorrecto','Dependiendo de su origen pueden ser alimentos de origen animal, alimentos de origen vegetal, como las frutas y alimentos de origen mineral.'),
(107,'A','Alimentos energéticos y reguladores',
'Incorrecto','Los alimentos segun su función se clasifican en constructores, energéticos y reguladores.'),
(107,'B','Alimentos minerales, energéticos y reguladores',
'Incorrecto','Los alimentos minerales estan dentro de los reguladores.'),
(107,'C','Alimentos constructores, energéticos y reguladores',
'Correcto','Felicidades!! Haz dominado la clasificacion de los alimentos segun su función. Sabías que? A los alimentos reguladores tambien se les llama protectores.'),
(108,'A','Jugos naturales',
'Incorrecto','Los jugos naturales son alimentos reguladores.'),
(108,'B','Leche',
'Correcto','Felicidades!! La leche es un alimento constructor que ayuda a mantener los huesos fuertes y dientes sanos.'),
(108,'C','Dulces',
'Incorrecto','Los dulces son alimentos energeticos.'),
(109,'A','Carne',
'Incorrecto','La carne es un alimento de origen animal.'),
(109,'B','Leche',
'Incorrecto','La carne es un alimento de origen animal.'),
(109,'C','Avena',
'Correcto','Felicidades!! La avena es un alimento de origen vegetal.'),
(110,'A','Ensaladas de frutas',
'Correcto','Felicidades!! las frutas nos brindan muchas vitaminas.'),
(110,'B','Dulces',
'Incorrecto','Los dulces son alimentos energeticos.'),
(110,'C','Leche',
'Incorrecto','La leche es un alimento constructor que ayuda a mantener los huesos fuertes y dientes sanos.'),
(111,'A','Inhalación ',
'Correcto','Felicidades!! La inhalación o inspiración es el proceso por el cual entra aire desde el exterior hacia el interior de los pulmones.'),
(111,'B','Exhalación',
'Incorrecto','La exhalación o espiración consiste en la salida del aire de los pulmones.'),
(111,'C','Todas las anteriores',
'Incorrecto','La respuesta correcta es inhalación ya que la exhalación o espiración consiste en la salida del aire de los pulmones.'),
(112,'A','Inhalación',
'Incorrecto','La inhalación o inspiración es el proceso por el cual entra aire desde el exterior hacia el interior de los pulmones.'),
(112,'B','Exhalación',
'Correcto','Felicidades!! La exhalación o espiración consiste en la salida del aire de los pulmones.'),
(112,'C','Todas las anteriores',
'Incorrecto','Felicidades!! La respuesta correcta es exhalación ya que la inhalación o espiración consiste en la salida del aire de los pulmones'),
(113,'A','Aire',
'Incorrecto','El aire es una mezcla de gases, principalmente son el nitrógeno, oxígeno, dióxido de carbono.'),
(113,'B','Oxígeno',
'Correcto','Felicidades!! Nuestro cuerpo necesita el oxígeno para producir energía.'),
(114,'A','Respirar',
'Incorrecto','Respirar es bsorber el aire.'),
(114,'B','Dióxido de carbono',
'Correcto','Felicidades!! El dióxido de carbono se genera como residuo de la respiración.'),
(115,'A','Fosas nasales, faringe, laringe, traque, bronquios y pulmones',
'Correcto','Felicidades!! Todos los mencionados forman parte de nuestro sistema respiratorio.'),
(115,'B','Boca, nariz, estomago, garganta',
'Incorrecto','Estas partes del cuerpo se encuentran en otros sistemas, como el digestivo.'),
(116,'A','Asexual o sexual',
'Correcto','Felicidades!! La reproduccion se divide en sexual y asexual.'),
(116,'B','Femenina o masculina',
'Incorrecto','Femenino y masculino son generos, no tipos de reproducción.'),
(116,'C','Ninguna de las anteriores',
'Incorrecto','.La respuesta correcta es asexual y sexual, ya que masculino y femenino son generos, no tipos de reproducción.'),
(117,'A','Digestión',
'Incorrecto','La digestión es el proceso en el que absorbemos los nutrientes, vitaminas y minerales.'),
(117,'B','Circulación',
'Incorrecto','La circulacion es la función que hace que la sangre corra por todo nuestro cuerpo, llevando oxígeno, etc...'),
(117,'C','Reproducción',
'Correcto','Felicidades!! La reproducción da lugar a otros seres vivos semejantes a ellos.'),
(118,'A','En los machos, los órganos sexuales son los ovarios',
'Incorrecto','En los machos los órganos sexuales son los testiculos.'),
(118,'B','En las hembras, los órganos sexuales son los testículos',
'Incorrecto','En las hembras los ovarios.'),
(118,'C','En los machos, los órganos sexuales son los testiculos',
'Correcto','Felicidades!! En los machos los órganos sexuales son los testiculos y en las hembras los ovarios.'),
(119,'A','Gemación',
'Correcto','Felicidades!! La gemación es un tipo de reproducción asexual. Es una división desigual.'),
(119,'B','Huevos',
'Incorrecto','Estos forman parte de la reproduccion sexual.'),
(119,'C','Fertilización',
'Incorrecto','Proceso que ocurre en la reproduccion sexual.'),
(120,'A','Oviparos',
'Correcto','Felicidades!! Los animales que producen huevos son los ovíparos.'),
(120,'B','Vivíparos',
'Incorrecto','Los animales vivíparos son aquellos que se caracterizan por desarrollar el embrión dentro del vientre de la madre..'),
(120,'C','Ovuliparos',
'Incorrecto','Los animales ovulíparos son los que poseen fecundación y desarrollo embrionario externo, lo que quiere decir es que, en el marco de una reproducción sexual, tanto la fecundación del óvulo como el desarrollo por el que toma forma se produce fuera del cuerpo de la hembra.');



