<%-- 
    Document   : registro2.jsp
    Created on : Dec 13, 2021, 5:07:55 PM
    Author     : Polar
--%>

<%@page import="servlet.Controlador"%>
<%@page import="procesos.Sesion"%>
<%@page import="java.util.List"%>
<%@page import="entidades.Grupo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

    <%
        String nomProf, seleccion = request.getParameter("seleccion");
        List<Grupo> lista = Grupo.listarGrupos();
    %>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Registro de <%= seleccion%> </title>
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
                        <h1 style="color: rgb(0,0,0);">Registro de <%= seleccion%></h1>
                        <div class="row row-cols-1 text-start text-dark">

                            <%
                                if (seleccion.contains("estudiante")) {
                                    out.print("<div class=\"col-12 order-first\">");
                                    out.print("<br><br><h3>Seleccione su grupo</h3>");
                                    out.print("<div class=\"table-responsive border rounded-0\">");
                                    out.print("<table class=\"table\">");
                                    out.print("<form action=\"Controlador\">");
                                    out.print("<thead><tr><th style=\"color: rgb(0,0,0);\">Maestro</th><th style=\"color: rgb(0,0,0);\">Grupos</th></tr></thead>");
                                    out.print("<tbody><tr>");
                                    
                                    for (Grupo grupo : lista) {
                                        nomProf = Grupo.buscarProfesor(grupo.getCod_grupo());
                                        out.print("<tr>");
                                        out.print("<td style=\"color: rgb(0,0,0);\">" + nomProf + "</td>");
                                        out.print("<td style=\"color: rgb(0,0,0);\">" + grupo.getCod_grupo() + "</td>");
                                        out.print("</tr>");
                                    }

                                    out.print("<select class=\"form-select\" style=\"width: 100px;height: 35px;\" id=\"seleccion\" name=\"seleccion\">");
                                    out.print("<optgroup label=\"grupos\">");

                                    for (Grupo grupo : lista) {
                                        out.print("<option selected=\"\" value=\"" + grupo.getCod_grupo() + "\">" + grupo.getCod_grupo() + "</option>");
                                    }

                                    out.print("</optgroup></select></td><br>");
                                    out.print("</tr></tbody>");
                                    out.print("</table>");
                                    out.print("</div><br>");
                                    out.print("<input class=\"btn btn-primary text-center border rounded-pill border-dark\" name=\"accion\" type=\"submit\" style=\"color: rgb(0,0,0);background: rgba(255,255,255,0);width: 100px;height: 50px;margin-right: 10em;\" value=\"Culminar\">");
                                    out.print("</form>");
                                    out.print("</div>");
                                } else {
                                    out.print("<div class=\"col-12 order-first\">");
                                    out.print("<form action=\"Controlador\">");
                                    out.print("<h3>¿Tiene maestría?</h3>");
                                    out.print("<div class=\"form-check\"><input class=\"form-check-input\" type=\"radio\" name=\"seleccion\" value=\"si\"><label class=\"form-check-label\">Si</label></div>");
                                    out.print("<div class=\"form-check\"><input class=\"form-check-input\" type=\"radio\" checked=\"\" name=\"seleccion\" value=\"no\"><label class=\"form-check-label\">No</label></div>");
                                    out.print("<br><input class=\"btn btn-primary text-center border rounded-pill border-dark\" name=\"accion\" type=\"submit\" style=\"color: rgb(0,0,0);background: rgba(255,255,255,0);width: 100px;height: 50px;margin-right: 10em;\" value=\"Culminar\">");
                                    out.print("</form>");
                                    out.print("</div>");
                                }
                            %>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/script.min.js"></script>
    </body>

</html>