package entidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import procesos.BaseDeDatos;

public class Tema {

    private String codTema;
    private String titulo;
    private String imagen;
    private String contenido;
    private double completado;
    private String aprendizaje;

    public String getCodTema() {
        return codTema;
    }

    public void setCodTema(String codTema) {
        this.codTema = codTema;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String tema) {
        this.titulo = tema;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setAprendizaje(String aprendizaje) {
        this.aprendizaje = aprendizaje;
    }

    public String getAprendizaje() {
        return aprendizaje;
    }

    public static List<Tema> generarListaTemasProf(String codGrupo) {
        List<Tema> lista = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            conn = BaseDeDatos.conectar();
            stmt = conn.createStatement();
            String query, codTema, tableRows = "";
            Tema tema = new Tema();

            if (codGrupo.contains("01")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN01%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("02")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN02%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("03")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN03%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("04")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN04%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("05")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN05%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("06")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN06%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("07")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN07%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("08")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN08%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("09")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN09%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("10")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS10%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("11")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS11%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("12")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS12%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("13")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS13%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("14")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS14%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("15")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS15%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            for (int i = 0; i < lista.size(); i++) {
                tableRows += (lista.get(i)) + "<tr><td style=\"color: rgb(0,0,0);\">" + lista.get(i).getTitulo() + "</td><td><button class=\"btn btn-primary border rounded-0\" type=\"button\" style=\"color: rgb(0,0,0);background: rgba(255,255,255,0);border-color: rgb(0,0,0);width: 150px;margin-bottom: 30px;\">Administrar</button></td></tr>";
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(conn, stmt, rs);
        }

        return lista;
    }

    public static List<Tema> generarListaTemasEst(String codGrupo) {
        List<Tema> lista = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Tema tema;

        try {

            conn = BaseDeDatos.conectar();
            stmt = conn.createStatement();
            String query;

            if (codGrupo.contains("01")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN01%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("02")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN02%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("03")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN03%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("04")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN04%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("05")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN05%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("06")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN06%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("07")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN07%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("08")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN08%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("09")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCN09%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("10")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS10%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("11")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS11%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("12")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS12%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("13")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS13%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("14")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS14%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

            if (codGrupo.contains("15")) {
                query = "SELECT * FROM Tema WHERE cod_tema LIKE 'TCS15%'";
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    tema = new Tema();
                    tema.setCodTema(rs.getString("cod_tema"));
                    tema.setTitulo(rs.getString("tema"));
                    tema.setImagen(rs.getString("imagen"));
                    tema.setContenido(rs.getString("Contenido"));
                    lista.add(tema);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(conn, stmt, rs);
        }

        return lista;
    }

    public static List<Tema> buscarPorTitulo(String titulo) {
        List<Tema> lista = new ArrayList<>();
        Tema tema;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            conn = BaseDeDatos.conectar();
            stmt = conn.createStatement();
            String query = "SELECT * FROM Tema WHERE tema ='" + titulo + "'";
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                tema = new Tema();
                tema.setCodTema(rs.getString("cod_tema"));
                tema.setContenido(rs.getString("Contenido"));
                tema.setImagen(rs.getString("imagen"));
                tema.setTitulo(rs.getString("tema"));
                lista.add(tema);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(conn, stmt, rs);
        }

        return lista;
    }

    public static Tema buscarPorCodigo(String codTema) {
        Tema tema = null;

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query;

        try {

            conn = BaseDeDatos.conectar();
            stmt = conn.createStatement();
            query = "SELECT * FROM Tema WHERE cod_tema ='" + codTema + "'";
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                tema = new Tema();
                tema.setCodTema(codTema);
                tema.setContenido(rs.getString("Contenido"));
                tema.setImagen(rs.getString("imagen"));
                tema.setTitulo(rs.getString("tema"));
            }
            if (tema.getCodTema().contains("TCN01-1")) {
                tema.setAprendizaje("<h2>¿Qué es el Sistema Digestivo?</h2>\n" +
"<p>El sistema digestivo es el encargado de digerir los alimentos que tomamos, haciéndolos aptos para que puedan ser primero absorbidos y luego asimilados. El sistema digestivo comprende el tubo digestivo y las glándulas anejas. El tubo digestivo es un largo conducto que se extiende desde la boca, que es un orificio de entrada, hasta el ano, que es el orificio terminal o de salida de los residuos de la digestión. En el tubo digestivo se distinguen la boca, la faringe, el esófago, el estómago, el intestino delgado y el intestino grueso.</p>\n" +
"<h2>Partes del Sistema Digestivo</h2>\n" +
"<h3>La Cavidad Bucal</h3>\n" +
"<p>La boca es una cavidad en cuyo interior están la lengua y los dientes. La lengua es un órgano musculoso en el que reside el sentido del gusto. Los dientes son piezas duras encajadas en los orificios o alvéolos de los huesos mandibulares. La parte inferior del diente se llama raíz y la porción libre externa se llama corona, figurando entre ambas una zona llamada cuello. Existen tres clases de dientes; los incisivos, los caninos, los premolares y los molares. El hombre adulto posee treinta y dos dientes, dieciséis en cada mandíbula; cuatro incisivos, dos caninos, cuatro premolares y seis molares.</p>\n" +
"<h3>La Faringe</h3>\n" +
"<p>La faringe es una cavidad músculo-membranosa situada en el fondo de la boca y con la cual comunica. La faringe comunica a su vez con las fosas nasales mediante dos orificios, llamados coanas, y con el oído medio mediante las trompas de Eustaquio.</p>\n" +
"<h3>El Esófago</h3>\n" +
"<p>El esófago es un tubo que va desde la faringe hasta el estómago. Desciende verticalmente entre la tráquea y la columna vertebral, atraviesa el diafragma y comunica con el estómago por un orificio llamado cardias. El estómago es un ensanchamiento del tubo digestivo en forma de fuelle de gaita alargada.</p>\n" +
"<h3>El Estómago</h3>\n" +
"<p>El estómago está situado debajo del diafragma. En la pared del estómago hay fibras musculares lisas, oblicuas, longitudinales y circulares, y su interior no es liso, sino que presenta arrugas y pliegues. Además está tapizado por una túnica mucosa en la que están instaladas las glándulas encargadas de segregar el jugo gástrico.</p>\n" +
"<h3>El Intestino</h3>\n" +
"<p>El intestino es un tubo de unos ocho metros de longitud situado a continuación del estómago. En él se distinguen el intestino delgado y el intestino grueso. El intestino delgado se halla a continuación del estómago y comprende el duodeno, el yeyuno y el íleon. En el interior del intestino delgado existen multitud de salientes de un milímetro de longitud, las vellosidades intestinales. En estas vellosidades circula la sangre por una arteriola y una venita, y la linfa por un pequeño vaso llamado vaso quilífero. El intestino grueso comprende tres regiones: el ciego, el colon y el recto. El ciego es la primera parte y se une al intestino delgado por la válvula íleco-cecal. El ciego lleva una prolongación lateral, el apéndice vermiforme. El colon comprende una porción ascendente, una porción transversal y una porción descendente que termina en el recto, que se comunica con el exterior por el ano, por donde son expulsados los excrementos.</p>\n" +
"<h3>Las Glándulas Anejas</h3>\n" +
"<p>Dentro de las glándulas anejas se distinguen las glándulas salivares, el hígado y el páncreas, que elaboran, respectivamente, la saliva, la bilis y el jugo pancreático. Las glándulas salivares se clasifican en tres pares: dos parótidas, dos submaxilares y dos sublinguales. El hígado es la glándula más voluminosa del cuerpo humano. Está situado debajo del diafragma, en la región abdominal derecha, cubriendo algo al estómago. Del hígado sale la bilis por el conducto hepático. El páncreas elabora el jugo pancreático. Es un órgano alargado situado detrás del estómago, cerca del duodeno. Posee un conducto que recoge el jugo pancreático elaborado en el interior de la glándula.</p>\n" +
"<h2>Función del Sistema Digestivo</h2>\n" +
"<p>La fisiología del aparato digestivo comprende, una serie de fenómenos motores, secretores y de absorción, que tienen lugar desde el momento de la ingesta del alimento, hasta la eliminación final de los residuos no útiles para el organismo. Para ello a de pasar el alimento por la boca, la faringe, el esófago, el estómago , el intestino delgado y el intestino grueso, para terminar con la defecación, para la cual existe el ano o esfínter anal.</p>");
            }

            if (tema.getCodTema().contains("TCN01-3")) {
                tema.setAprendizaje("<h2>¿Qué es el Sistema Respiratorio?</h2>\n" +
"<p>El aparato respiratorio es el conjunto de estructuras cuya función es la de abastecer de oxígeno al organismo, principalmente al cerebro, mediante la incorporación de aire rico en oxígeno y la expulsión de aire enrarecido por el anhídrido carbónico.</p>\n" +
"<h2>¿Cuál es su función?</h2>\n" +
"<p>La función del Sistema Respiratorio es incorporar oxígeno al organismo; para que al llegar a la célula se produzca la \"combustión\" y poder así \"quemar\" los nutrientes y liberar energía. De ésta combustión quedan desechos, tal como el dióxido de carbono, el cual es expulsado al exterior a través del proceso de espiración (proceso llevado a cabo por el sistema respiratorio).\n" +
"\n" +
"  El aparato respiratorio es el encargado de realizar el intercambio de gases entre el aire y la sangre.</p>\n" +
"<h2>Partes del Sistema Respiratorio</h2>\n" +
"<h3>Vías respiratorias</h3>\n" +
"<p>Conducen el aire del exterior a los pulmones y viceversa.</p>\n" +
"<ul>\n" +
"  <li>Fosas Nasales</li>\n" +
"  <li>Faringe</li>\n" +
"  <li>Laringe</li>\n" +
"  <li>Tráquea</li>\n" +
"  <li>Bronquios</li>\n" +
"</ul>\n" +
"<h3>Pulmones</h3>\n" +
"<p> Son dos masas esponjosas recubiertas de un tejido de doble pared llamado pleura, con una fina capa de líquido entre ambas para suavizar los movimientos respiratorios. El pulmón derecho está dividido en tres lóbulos y el izquierdo en dos. Están constituidos por los bronquiolos que se dividen repetidamente en ramas cada vez más finas que terminan en unas bolsas llamadas alvéolos, recubiertas de capilares sanguíneos.</p>");
            }

            if (tema.getCodTema().contains("TCN04")) {
            }

            if (tema.getCodTema().contains("TCN05")) {
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(conn, stmt, rs);
        }

        return tema;
    }

    public static String estatus(String codTema, String correoEstudiante) {

        String query, estatus = "", tag;
        int i = 0, j, cantPreg = 0, puntos[], respuestas = 0;

        Connection conn1 = null;
        Statement stmt1 = null;
        ResultSet rs1 = null;

        try {

            conn1 = BaseDeDatos.conectar();
            stmt1 = conn1.createStatement();
            query = "SELECT * FROM Pregunta WHERE cod_tema ='" + codTema + "'";
            rs1 = stmt1.executeQuery(query);

            while (rs1.next()) {
                cantPreg++;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(conn1, stmt1, rs1);
        }

        puntos = new int[cantPreg];

        Connection conn2 = null;
        Statement stmt2 = null;
        ResultSet rs2 = null;
        try {

            conn2 = BaseDeDatos.conectar();
            stmt2 = conn2.createStatement();
            query = "SELECT * FROM Pregunta WHERE cod_tema ='" + codTema + "'";
            rs2 = stmt2.executeQuery(query);

            while (rs2.next()) {
                puntos[i] = rs2.getInt("cod_pregunta");
                i++;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(conn2, stmt2, rs2);
        }

        Connection conn3 = null;
        Statement stmt3 = null;
        ResultSet rs3 = null;
        
        try {
            
            conn3 = BaseDeDatos.conectar();
            stmt3 = conn3.createStatement();
            query = "SELECT * FROM Contestan WHERE correo_est='" + correoEstudiante + "'";
            rs3 = stmt3.executeQuery(query);

            while (rs3.next()) {
               
                for (j = 0; j < cantPreg; j++) {
                    if(rs3.getString("cod_pregunta").equals(String.valueOf(puntos[j]))){
                        respuestas++;
                    }
                }
                
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(conn3, stmt3, rs3);
        }
        
        if (respuestas >= 0) {
            estatus = "<span style=\\\"margin-left: 2em;\\\">   Completado</span>" + "<span><span><i class=\\\"fa fa-check-circle\\\" style=\\\"margin-right: 0.5em;margin-left: 0.5em;\\\"></i></span>   " + cantPreg + " pts</span>";
        } 
        
        tag = estatus;

        return tag;
    }
    
    public String cargarImagenes(){
    
        String tag = "<br><br><br><br><br>"
                + "<div class=\"col-auto col-sm-12 col-md-6 text-center order-2\"><img class=\"img-fluid\" src=\"assets//img//temas//" + this.getCodTema() + "-A.png\" width=\"350\" height=\"350\"></div>"
                + "<div class=\"col-auto col-sm-12 col-md-6 text-center order-2\"><img class=\"img-fluid\" src=\"assets//img//temas//" + this.getCodTema() + "-B.png\" width=\"350\" height=\"350\"></div>";
    
        return tag;
    }
    
    /**
     * @return the completado
     */
    public double getCompletado() {
        return completado;
    }

    /**
     * @param completado the completado to set
     */
    public void setCompletado(double completado) {
        this.completado = completado;
    }

}
