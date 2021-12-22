<%-- 
    Document   : administracion CRUD (adminProf)
    Created on : 18 dic 2021, 0:55:32
    Author     : Polar
--%>

<%@page import="entidades.Grupo"%>
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
        %>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Admin-Docente</title>
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
                    <div class="container-fluid">
                        <hr style="color: rgba(255,255,255,0);">
                        <h1 style="color: rgb(0,0,0);">Administración</h1>
                        <div class="row row-cols-1 text-start text-dark">
                            <div class="col-auto col-sm-12 col-md-12 col-lg-6 col-xl-6 col-xxl-6 order-first">
                                <br><br>
                                <h2 class="text-start" style="color: rgb(0,0,0);">Grupos</h2>
                                <form action="Controlador">
                                    <input class="btn btn-primary border rounded-0" type="submit" name="accion" style="color: rgb(0,0,0);background: rgba(255,255,255,0);border-color: rgb(0,0,0);width: 175px;margin-bottom: 30px;" value="Crear Nuevo Grupo">
                                </form>
                            </div>

                            <br><br>
                            <div class="col-12 text-center order-first">
                                <div class="table-responsive border-dark">
                                    <table class="table">
                                        <tbody class="border-dark">
                                            <%
                                                out.print(Grupo.listarParaProfesor(Controlador.usuarioLogeado.getCorreo()));
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