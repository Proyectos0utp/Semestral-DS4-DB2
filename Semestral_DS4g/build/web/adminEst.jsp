<%-- 
    Document   : perfil
    Created on : Dec 13, 2021, 6:13:08 PM
    Author     : Administrator
--%>
<%@page import="procesos.Sesion"%>
<%@page import="java.util.List"%>
<%@page import="entidades.Tema"%>
<%@page import="entidades.Grupo"%>
<%@page import="servlet.Controlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <%
            String usuario = Controlador.usuarioLogeado.getNombre();
            String grupo = Controlador.usuarioLogeado.getGrupo();
            String nombreProf = Grupo.buscarProfesor(grupo);
            List<Tema> lista = Tema.generarListaTemasEst(grupo);
        %>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Perfil de <%=usuario%> </title>
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
                        <h1 style="color: rgb(0,0,0);">¡Bienvenido <%=usuario%>!</h1>
                        <div class="row row-cols-1 text-start text-dark">
                            <div class="col-12 mb-4">
                                <div class="row row-cols-2">
                                    <div class="col-4">
                                        <h1 style="color: rgb(0,0,0);">Grupo</h1>
                                        <p><strong><%=grupo%></strong></p>
                                    </div>
                                    <div class="col-8">
                                        <h1 style="color: rgb(0,0,0);">Maestro/a</h1>
                                        <p><strong><%=nombreProf%></strong></p>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <h1 class="text-start" style="color: rgb(0,0,0);">Temas</h1>
                            </div>
                            <div class="col-12 mb-4">
                                
                                <%
                                    for (Tema tema : lista) {
                                        out.print("<div class=\"row row-cols-2\">");
                                        out.print("<div class=\"col-4 text-center align-self-center order-first\">" + "<img class=\"img-fluid\" src=\"" + tema.getImagen() + "\">" + "</div>");
                                        out.print("<div class=\"col-8\">");
                                        out.print("<h1 style=\"color: rgb(0,0,0);\">" + tema.getTitulo() + "</h1>");
                                %>
                                <form action="Controlador">
                                    <input type="hidden" name="cod_tema" value="<%=tema.getCodTema()%>">
                                <%
                                        out.print("<p>" + tema.getContenido().substring(0,40) + "<br></p>" + "<input class=\"btn btn-primary text-center border rounded-pill border-dark\" name=\"accion\" type=\"submit\" style=\"color: rgb(0,0,0);background: rgba(255,255,255,0);width: 100px;height: 50px;margin-right: 10em;\" value=\"Ingresar\"");
                                        out.print(Tema.estatus(tema.getCodTema(), Controlador.usuarioLogeado.getCorreo()));
                                        out.print("</div>");
                                        out.print("</div><br>");
                                    }
                                %>
                                </form>
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