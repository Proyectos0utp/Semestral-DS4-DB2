<%-- 
    Document   : buscar
    Created on : 22-dic-2021, 1:37:00
    Author     : manue
--%>

<%@page import="entidades.Tema"%>
<%@page import="java.util.List"%>
<%@page import="procesos.Sesion"%>
<%@page import="servlet.Controlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <%
            if (Controlador.usuarioLogeado.getNombre().equals("")) {
                RequestDispatcher ventana = request.getRequestDispatcher("iniciarsesion.jsp");
                request.setAttribute("avisoSesion", "Inicie sesion.");
                ventana.forward(request, response);
            }
            List<Tema> lista = (Controlador.buscando.equals("")) ? Tema.generarListaTemasEst(Controlador.usuarioLogeado.getGrupo()) : Tema.buscarCoincidencia(Controlador.buscando, Tema.generarListaTemasEst(Controlador.usuarioLogeado.getGrupo()));
        %>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Busqueda</title>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
        <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
        <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
        <link rel="stylesheet" href="assets/fonts/fontawesome5-overrides.min.css">
        <link rel="stylesheet" href="assets/css/styles.min.css">
    </head>

    <body id="page-top">
        <div id="wrapper">
            <%
                out.print(Sesion.generarMenuHTML(Controlador.usuarioLogeado));
            %>
            <div class="d-flex flex-column" id="content-wrapper">
                <div id="content" style="margin-top: 15;">
                    <nav class="navbar navbar-light navbar-expand-md bg-white shadow d-print-none d-md-none d-lg-none d-xl-none d-xxl-none mb-4 topbar static-top">
                        <div class="container-fluid"><button class="btn btn-link d-md-none rounded-circle me-3" id="sidebarToggleTop" type="button"><i class="fas fa-bars"></i></button></div>
                    </nav>
                    <div class="container-fluid">
                        <hr style="color: rgba(255,255,255,0);">
                        <h1 style="color: rgb(0,0,0);">Busqueda</h1>
                        ${avisoBusqueda}
                        <form action="Controlador">
                            <input type="text" name="busqueda" placeholder="Escriba el titulo del tema" style="width: 250px;margin-bottom: 1em;"><br>
                            <input class="btn btn-primary border rounded-0" type="submit" name="accion" style="color: rgb(0,0,0);background: rgba(255,255,255,0);border-color: rgb(0,0,0);width: 175px;margin-bottom: 30px;" value="Buscar Tema">
                        </form>
                        <br>
                        <div class="row row-cols-1 text-start text-dark">
                            <div class="col-12 mb-4">

                                <%
                                    for (Tema tema : lista) {
                                        out.print("<div class=\"row row-cols-2\">");
                                        out.print("<div class=\"col-auto col-sm-12 col-md-4 text-center align-self-center order-last order-sm-last order-md-first\">");
                                        out.print("<img class=\"img-fluid\" src=\"" + tema.getImagen() + "\">");
                                        out.print("</div>");
                                        out.print("<div class=\"col-auto col-sm-12 col-md-8 order-first order-sm-first order-md-last\">");
                                        out.print("<h1 style=\"color: rgb(0,0,0);\">" + tema.getTitulo() + "</h1>");
                                        out.print("<form action=\"Controlador\">");
                                        out.print("<input type=\"hidden\" name=\"cod_tema\" value=\"" + tema.getCodTema() + "\">");
                                        out.print("<p><strong>" + tema.getContenido().split("\\s")[0] + "</strong>&nbsp;" + tema.getContenido().replaceAll(tema.getContenido().split("\\s")[0], "") + "...<br></p>" + "<input class=\"btn btn-primary text-center border rounded-pill border-dark\" name=\"accion\" type=\"submit\" style=\"color: rgb(0,0,0);background: rgba(255,255,255,0);width: 100px;height: 50px;margin-right: 10em;\" value=\"Ingresar\"");
                                        out.print(Tema.estatus(tema.getCodTema(), Controlador.usuarioLogeado.getCorreo()));
                                        out.print("</div>");
                                        out.print("</form>");
                                        out.print("</div><br>");
                                    }
                                %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/script.min.js"></script>
</body>

</html>
