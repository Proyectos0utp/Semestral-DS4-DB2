<%-- 
    Document   : aprendizaje
    Created on : 20-dic-2021, 2:00:20
    Author     : manue
--%>

<%@page import="entidades.Usuario"%>
<%@page import="entidades.Ranking"%>
<%@page import="entidades.Grupo"%>
<%@page import="java.util.List"%>
<%@page import="procesos.Sesion"%>
<%@page import="servlet.Controlador"%>
<%@page import="entidades.Tema"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <%
            Tema tema = Controlador.temaIngresado;
        %>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Ranking de <%=tema.getTitulo()%></title>
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
                        <h1 style="color: rgb(0,0,0);">Ranking</h1>
                        <div class="row row-cols-1 text-center text-dark">
                            <div class="col-12 text-center order-first"><span class="text-start" style="color: rgb(0,0,0);">Tema</span>
                                <h1 class="text-center" style="color: rgb(0,0,0);"><%=tema.getTitulo()%></h1>
                            </div>
                            <div class="col-12 text-center order-last">
                                <div class="table-responsive">
                                    <table class="table table-borderless">
                                        <thead>
                                            <tr>
                                                <th style="color: rgb(0,0,0);">Posición</th>
                                                <th style="color: rgb(0,0,0);">Estudiante</th>
                                                <th style="color: rgb(0,0,0);">Puntaje</th>
                                            </tr>
                                        </thead>
                                        <%
                                            String usuario = Controlador.usuarioLogeado.getNombre();
                                            String grupo = Controlador.usuarioLogeado.getGrupo();
                                            List<Usuario> estudiantes = Grupo.generarListaEstudiantes(grupo);
                                            List<Ranking> ranking = Ranking.generarRanking(estudiantes);
                                            /*for (Tema tema : lista) {
                                                    Controlador.usuarioLogeado.calcularMedallas(tema.getCodTema(), medallas);
                                                }*/
                                        %>
                                        <tbody>
                                            <%
                                                for (int i=0; i<ranking.size(); i++) {
                                            %>
                                            <tr>
                                                <td>#<%= i %></td>
                                                <td><%= ranking.get(i).getEstudiante() %></td>
                                                <td><%= ranking.get(i).getPuntaje() %></td>
                                            </tr>
                                            <% }
                                            %>
                                        </tbody>
                                    </table>
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

