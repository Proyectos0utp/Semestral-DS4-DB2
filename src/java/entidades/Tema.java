package entidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import procesos.BaseDeDatos;

public class Tema {

    public static void eliminarTema(String cod_tema) {
        
        Connection cn = null;
        Statement stmt = null;
        String query;

        try {
            cn = BaseDeDatos.conectar();
            stmt = cn.createStatement();
            query = "DELETE FROM Tema WHERE cod_tema='" + cod_tema + "'";
            stmt.executeUpdate(query);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(cn, stmt);
        }
        
    }

    private String codTema;
    private String titulo;
    private String imagen;
    private String contenido;
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

    public void insertarRespuesta() {
    }

    public static String generarListaTemasProf(String codGrupo) {
        String tag = "";
        List<Tema> lista = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            conn = BaseDeDatos.conectar();
            stmt = conn.createStatement();
            String query;
            Tema tema;

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

        for (Tema tema : lista) {

            tag += "<form action=\"Controlador\">"
                    + "<input type=\"hidden\" name=\"cod_tema\" value=\"" + tema.getCodTema() + "\">"
                    + "<tr>"
                    + "<td style=\"color: rgb(0,0,0);\"><h3>" + tema.getTitulo() + "</h3></td>"
                    + "<td><input class=\"btn btn-primary border rounded-0\" type=\"submit\" name=\"accion\" style=\"color: rgb(0,0,0);background: rgba(255,255,255,0);border-color: rgb(0,0,0);width: 150px;margin-bottom: 30px;\" value=\"Administrar Tema\"></td>"
                    + "</form>";

        }

        return tag;
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

    public static List<Tema> buscarCoincidencia(String posibleTitulo, List<Tema> listaTotalTemas) {
        List<Tema> listaTemasSeleccionados = new ArrayList<>();
        for (Tema tema1 : listaTotalTemas) {
            if (tema1.getTitulo().toLowerCase().contains(posibleTitulo.toLowerCase())) {
                listaTemasSeleccionados.add(tema1);
            }

        }

        return listaTemasSeleccionados;
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
                tema.setAprendizaje("<h2>??Qu?? es el Sistema Digestivo?</h2>\n"
                        + "<p>El sistema digestivo es el encargado de digerir los alimentos que tomamos, haci??ndolos aptos para que puedan ser primero absorbidos y luego asimilados. El sistema digestivo comprende el tubo digestivo y las gl??ndulas anejas. El tubo digestivo es un largo conducto que se extiende desde la boca, que es un orificio de entrada, hasta el ano, que es el orificio terminal o de salida de los residuos de la digesti??n. En el tubo digestivo se distinguen la boca, la faringe, el es??fago, el est??mago, el intestino delgado y el intestino grueso.</p>\n"
                        + "<h2>Partes del Sistema Digestivo</h2>\n"
                        + "<h3>La Cavidad Bucal</h3>\n"
                        + "<p>La boca es una cavidad en cuyo interior est??n la lengua y los dientes. La lengua es un ??rgano musculoso en el que reside el sentido del gusto. Los dientes son piezas duras encajadas en los orificios o alv??olos de los huesos mandibulares. La parte inferior del diente se llama ra??z y la porci??n libre externa se llama corona, figurando entre ambas una zona llamada cuello. Existen tres clases de dientes; los incisivos, los caninos, los premolares y los molares. El hombre adulto posee treinta y dos dientes, diecis??is en cada mand??bula; cuatro incisivos, dos caninos, cuatro premolares y seis molares.</p>\n"
                        + "<h3>La Faringe</h3>\n"
                        + "<p>La faringe es una cavidad m??sculo-membranosa situada en el fondo de la boca y con la cual comunica. La faringe comunica a su vez con las fosas nasales mediante dos orificios, llamados coanas, y con el o??do medio mediante las trompas de Eustaquio.</p>\n"
                        + "<h3>El Es??fago</h3>\n"
                        + "<p>El es??fago es un tubo que va desde la faringe hasta el est??mago. Desciende verticalmente entre la tr??quea y la columna vertebral, atraviesa el diafragma y comunica con el est??mago por un orificio llamado cardias. El est??mago es un ensanchamiento del tubo digestivo en forma de fuelle de gaita alargada.</p>\n"
                        + "<h3>El Est??mago</h3>\n"
                        + "<p>El est??mago est?? situado debajo del diafragma. En la pared del est??mago hay fibras musculares lisas, oblicuas, longitudinales y circulares, y su interior no es liso, sino que presenta arrugas y pliegues. Adem??s est?? tapizado por una t??nica mucosa en la que est??n instaladas las gl??ndulas encargadas de segregar el jugo g??strico.</p>\n"
                        + "<h3>El Intestino</h3>\n"
                        + "<p>El intestino es un tubo de unos ocho metros de longitud situado a continuaci??n del est??mago. En ??l se distinguen el intestino delgado y el intestino grueso. El intestino delgado se halla a continuaci??n del est??mago y comprende el duodeno, el yeyuno y el ??leon. En el interior del intestino delgado existen multitud de salientes de un mil??metro de longitud, las vellosidades intestinales. En estas vellosidades circula la sangre por una arteriola y una venita, y la linfa por un peque??o vaso llamado vaso quil??fero. El intestino grueso comprende tres regiones: el ciego, el colon y el recto. El ciego es la primera parte y se une al intestino delgado por la v??lvula ??leco-cecal. El ciego lleva una prolongaci??n lateral, el ap??ndice vermiforme. El colon comprende una porci??n ascendente, una porci??n transversal y una porci??n descendente que termina en el recto, que se comunica con el exterior por el ano, por donde son expulsados los excrementos.</p>\n"
                        + "<h3>Las Gl??ndulas Anejas</h3>\n"
                        + "<p>Dentro de las gl??ndulas anejas se distinguen las gl??ndulas salivares, el h??gado y el p??ncreas, que elaboran, respectivamente, la saliva, la bilis y el jugo pancre??tico. Las gl??ndulas salivares se clasifican en tres pares: dos par??tidas, dos submaxilares y dos sublinguales. El h??gado es la gl??ndula m??s voluminosa del cuerpo humano. Est?? situado debajo del diafragma, en la regi??n abdominal derecha, cubriendo algo al est??mago. Del h??gado sale la bilis por el conducto hep??tico. El p??ncreas elabora el jugo pancre??tico. Es un ??rgano alargado situado detr??s del est??mago, cerca del duodeno. Posee un conducto que recoge el jugo pancre??tico elaborado en el interior de la gl??ndula.</p>\n"
                        + "<h2>Funci??n del Sistema Digestivo</h2>\n"
                        + "<p>La fisiolog??a del aparato digestivo comprende, una serie de fen??menos motores, secretores y de absorci??n, que tienen lugar desde el momento de la ingesta del alimento, hasta la eliminaci??n final de los residuos no ??tiles para el organismo. Para ello a de pasar el alimento por la boca, la faringe, el es??fago, el est??mago , el intestino delgado y el intestino grueso, para terminar con la defecaci??n, para la cual existe el ano o esf??nter anal.</p>");
            }

            if (tema.getCodTema().contains("TCN01-1")) {
                tema.setAprendizaje("<p>??Por qu?? comer saludable? Porque te ayuda a cuidar tu salud, sentirte y verte mejor, as?? como prevenir diversas enfermedades. Es por ello que la alimentaci??n desempe??a un rol determinante en el cuidado de la salud. Una alimentaci??n saludable es aquella que aporta todos los nutrientes esenciales y la energ??a que cada persona necesita para mantenerse sana. Por eso, es necesario consumir alimentos de todos los grupos y en las cantidades adecuadas.</p>\n"
                        + "<p>Los alimentos nos proporcionan la energ??a necesaria para mantener nuestra actividad diaria. Esta energ??a puede calcularse a trav??s del calor producido por el cuerpo, que es consecuencia de la oxidaci??n de los nutrientes y se mide en calor??as.</p>\n"
                        + "<h2>Grupos de comidas</h2>\n"
                        + "<h3>Verduras y frutas</h3>\n"
                        + "<p>Este grupo representa la mitad de la gr??fica. Esto evidencia la necesidad de aumentar su consumo en la alimentaci??n diaria. Son ricas en vitaminas, minerales, fibra, agua y fitoqu??micos lo que las hacen muy beneficiosas para la salud. ??Cu??nto es la porci??n? Se recomiendan 3 frutas al d??a y 2 porciones de verduras, las cuales se pueden distribuir medio plato de verduras en el almuerzo y medio plato en la cena.</p>\n"
                        + "<h3>Legumbres, cereales, papa, pan y pastas</h3>\n"
                        + "<p>En este grupo se incluye papa, batata, choclo y mandioca porque la composici??n nutricional de estas verduras es m??s parecida a los cereales. Son fuente principal de energ??a. Para aprovechar m??s sus nutrientes es conveniente elegir cereales integrales.</p>\n"
                        + "<h3>Leche, yogur y queso</h3>\n"
                        + "<p>Este grupo es muy importante para la incorporaci??n de calcio, as?? como por su aporte de prote??nas, zinc, y vitaminas. Se recomienda que sean preferentemente descremados para disminuir su contenido en grasas.</p>\n"
                        + "<h3>Aceites, frutas secas y semillas</h3>\n"
                        + "<p>Este grupo aporta ??cidos grasos esenciales com??nmente llamadas grasas buenas, as?? como prote??nas, vitaminas, minerales y fibra.</p>\n"
                        + "<h3>Opcionales: dulces y grasas</h3>\n"
                        + "<p>A este grupo se lo llama ???opcional??? ya que no son indispensables de consumir, y cuando se los incorpora se deben elegir porciones peque??as. Esto es debido a que aportan exceso de calor??as y escasos nutrientes, su consumo de forma frecuente predispone a la obesidad, hipertensi??n, diabetes y enfermedades cardiovasculares, entre otras.</p>\n"
                        + "<h3>Agua</h3>\n"
                        + "<p>El agua tiene una ubicaci??n central en la gr??fica, debido a su importancia para la salud. La recomendaci??n es tomar a diario 8 vasos de agua segura.</p>");
            }

            if (tema.getCodTema().contains("TCN01-3")) {
                tema.setAprendizaje("<h2>??Qu?? es el Sistema Respiratorio?</h2>\n"
                        + "<p>El aparato respiratorio es el conjunto de estructuras cuya funci??n es la de abastecer de ox??geno al organismo, principalmente al cerebro, mediante la incorporaci??n de aire rico en ox??geno y la expulsi??n de aire enrarecido por el anh??drido carb??nico.</p>\n"
                        + "<h2>??Cu??l es su funci??n?</h2>\n"
                        + "<p>La funci??n del Sistema Respiratorio es incorporar ox??geno al organismo; para que al llegar a la c??lula se produzca la \"combusti??n\" y poder as?? \"quemar\" los nutrientes y liberar energ??a. De ??sta combusti??n quedan desechos, tal como el di??xido de carbono, el cual es expulsado al exterior a trav??s del proceso de espiraci??n (proceso llevado a cabo por el sistema respiratorio).\n"
                        + "\n"
                        + "  El aparato respiratorio es el encargado de realizar el intercambio de gases entre el aire y la sangre.</p>\n"
                        + "<h2>Partes del Sistema Respiratorio</h2>\n"
                        + "<h3>V??as respiratorias</h3>\n"
                        + "<p>Conducen el aire del exterior a los pulmones y viceversa.</p>\n"
                        + "<ul>\n"
                        + "  <li>Fosas Nasales</li>\n"
                        + "  <li>Faringe</li>\n"
                        + "  <li>Laringe</li>\n"
                        + "  <li>Tr??quea</li>\n"
                        + "  <li>Bronquios</li>\n"
                        + "</ul>\n"
                        + "<h3>Pulmones</h3>\n"
                        + "<p> Son dos masas esponjosas recubiertas de un tejido de doble pared llamado pleura, con una fina capa de l??quido entre ambas para suavizar los movimientos respiratorios. El pulm??n derecho est?? dividido en tres l??bulos y el izquierdo en dos. Est??n constituidos por los bronquiolos que se dividen repetidamente en ramas cada vez m??s finas que terminan en unas bolsas llamadas alv??olos, recubiertas de capilares sangu??neos.</p>");
            }

            if (tema.getCodTema().contains("TCN01-4")) {
                tema.setAprendizaje("<p>Uno de los aspectos m??s importantes de los seres vivientes es su capacidad de autorreproducirse. A todo organismo le llega el momento en que sus capacidades de metabolismo, crecimiento e irritabilidad se vuelven insuficientes para mantener en contra de otras fuerzas su compleja organizaci??n. El ataque de depredadores, la acci??n de par??sitos, las ??pocas de hambre, otros cambios da??inos del ambiente, o simplemente aquellos procesos no bien definidos que denominamos envejecimiento, llevan finalmente a la muerte del organismo. Sin embargo, la especie sobrevive por un periodo de tiempo mayor que el periodo de vida de cualquiera de sus individuos. Esto se logra mediante la producci??n de nuevos individuos por parte de los individuos de mayor edad antes de que estos mueran.\n"
                        + "\n"
                        + "  Muchos de los principales problemas de la biolog??a conciernen a la capacidad de los seres vivos de producir copias de s?? mismos.\n"
                        + "  \n"
                        + "  En los seres vivos se presentan dos modos diferentes de producir cr??a. Uno de estos modos es la reproducci??n sexual; esto es, la reproducci??n de nuevos individuos, en los cuales se combina la informaci??n gen??tica de las c??lulas diferentes, generalmente provenientes, a su vez, de dos padres distintos. En la mayor??a de los organismos, estas c??lulas son los gametos. En el otro modo de reproducci??n toma parte solamente un progenitor. Se llama reproducci??n asexual.</p>\n"
                        + "<h2>Tipos de reproducci??n</h2>\n"
                        + "<h3>Reproducci??n sexual</h3>\n"
                        + "<p>Es la forma de reproducci??n, tanto en plantas como en animales, por la que se desarrollan nuevos individuos, para ello los organismos tienen unos ??rganos especiales llamados g??nadas en donde se forman los gametos o c??lulas reproductoras.\n"
                        + "\n"
                        + "  Se necesita de la intervenci??n de dos individuos: los machos y las hembras. Las g??nadas en los machos son los test??culos y los gametos son los espermatozoides. En el caso de las hembras las g??nadas son los ovarios y los gametos son los ??vulos.</p>\n"
                        + "<h3>Reproducci??n asexual</h3>\n"
                        + "<p>es el proceso fisiol??gico que permite a los organismos vivos transmitir su informaci??n gen??tica a sus descendientes sin la uni??n de gametos procedentes de individuos de diferente sexo para que se produzca dicha descendencia.\n"
                        + "\n"
                        + "  Se trata de un proceso mucho m??s simple y r??pido que la reproducci??n sexual. En la siguiente lista se incluyen muchas de las caracter??sticas m??s destacadas del proceso de reproducci??n asexual que pueden llevar a cabo muchos seres vivos.</p>");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(conn, stmt, rs);
        }

        return tema;
    }

    public static String estatus(String codTema, String correoEstudiante) {

        String query, estatus = "";
        int i, puntos = 0;

        Examen examen = new Examen();
        examen.setCod_tema(codTema);
        examen.setCorr_est(codTema);
        examen.cargarPreguntas();
        Object cod_preguntas[] = examen.getPreguntas().keySet().toArray();

        Connection conn1 = null;
        Statement stmt1 = null;
        ResultSet rs1 = null;

        try {

            conn1 = BaseDeDatos.conectar();
            stmt1 = conn1.createStatement();
            query = "SELECT * FROM Contestan";
            rs1 = stmt1.executeQuery(query);

            while (rs1.next()) {

                for (i = 0; i < cod_preguntas.length; i++) {

                    if (cod_preguntas[i].toString().contains(rs1.getString("cod_pregunta"))) {
                        puntos += rs1.getInt("puntos_obtenidos");
                    }

                }

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            BaseDeDatos.cerrarConexiones(conn1, stmt1, rs1);
        }

        if (puntos > 0) {
            estatus = "<span style=\\\"margin-left: 2em;\\\"><strong>Completado</strong></span>" + "<span><span><i class=\\\"fa fa-check-circle\\\" style=\\\"margin-right: 0.5em;margin-left: 0.5em;\\\"></i></span>   " + puntos + " pts</span>";
        } else {
            estatus = "<span style=\\\"margin-left: 2em;\\\"></span>" + "<span><span><i class=\\\"fa fa-check-circle\\\" style=\\\"margin-right: 0.5em;margin-left: 0.5em;\\\"></i></span></span>";
        }

        return estatus;
    }

    public String cargarImagenes() {

        String tag = "<br><br><br><br><br>"
                + "<div class=\"col-auto col-sm-12 col-md-6 text-center order-2\"><img class=\"img-fluid\" src=\"assets//img//temas//" + this.getCodTema() + "-A.png\" width=\"350\" height=\"350\"></div>"
                + "<div class=\"col-auto col-sm-12 col-md-6 text-center order-2\"><img class=\"img-fluid\" src=\"assets//img//temas//" + this.getCodTema() + "-B.png\" width=\"350\" height=\"350\"></div>";

        return tag;
    }

    public void crearTema() throws SQLException {

        Connection cn = null;
        Statement stmt = null;
        String query;

        cn = BaseDeDatos.conectar();
        stmt = cn.createStatement();
        query = "INSERT INTO Tema VALUES('"
                + this.getCodTema() + "','"
                + this.getTitulo() + "','"
                + this.getImagen() + "','"
                + this.getContenido() + "')";

        stmt.executeUpdate(query);

        BaseDeDatos.cerrarConexiones(cn, stmt);

    }

    public void actualizarTema() throws SQLException {
        Connection cn = null;
        Statement stmt = null;
        String query;

        cn = BaseDeDatos.conectar();
        stmt = cn.createStatement();
        query = "UPDATE Tema SET "
                + "tema='" + this.getTitulo() + "',"
                + "imagen='" + this.getImagen() + "',"
                + "contenido='" + this.getContenido() + "' "
                + "WHERE cod_tema='" + this.getCodTema() + "'";

        stmt.executeUpdate(query);

        BaseDeDatos.cerrarConexiones(cn, stmt);
    }

}
