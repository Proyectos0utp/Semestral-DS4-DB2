<%-- 
    Document   : buscar
    Created on : 22-dic-2021, 1:37:00
    Author     : manue
--%>

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
                        <form action="Controlador">
                            <input type="text" name="busqueda" placeholder="Escriba el titulo del tema" style="width: 250px;margin-bottom: 1em;"><br>
                            <input class="btn btn-primary border rounded-0" type="submit" name="accion" style="color: rgb(0,0,0);background: rgba(255,255,255,0);border-color: rgb(0,0,0);width: 175px;margin-bottom: 30px;" value="Buscar Tema">
                        </form>
                        <br>
                        <div class="row row-cols-1 text-start text-dark">
                            <div class="col-12 mb-4">
                                <div class="row row-cols-2">
                                    <div class="col-auto col-sm-12 col-md-4 text-center align-self-center order-last order-sm-last order-md-first"><img class="img-fluid" src="http://via.placeholder.com/150x150"></div>
                                    <div class="col-auto col-sm-12 col-md-8 order-first order-sm-first order-md-last">
                                        <h1 style="color: rgb(0,0,0);">Nombre tema</h1>
                                        <p><strong>Lorem Ipsum</strong>&nbsp;is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.<br></p><button class="btn btn-primary border rounded-0" type="button" style="color: rgb(0,0,0);background: rgba(255,255,255,0);border-color: rgb(0,0,0);width: 150px;">Ingresar</button><span style="margin-left: 2em;">completado</span><span><span><i class="fa fa-check-circle" style="margin-right: 0.5em;margin-left: 0.5em;"></i></span>25 pts</span>
                                    </div>
                                </div>
                                <div class="row row-cols-2">
                                    <div class="col-auto col-sm-12 col-md-4 text-center align-self-center order-last order-sm-last order-md-first"><img class="img-fluid" src="http://via.placeholder.com/150x150"></div>
                                    <div class="col-auto col-sm-12 col-md-8 order-first order-sm-first order-md-last">
                                        <h1 style="color: rgb(0,0,0);">Nombre tema</h1>
                                        <p><strong>Lorem Ipsum</strong>&nbsp;is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.<br></p><button class="btn btn-primary border rounded-0" type="button" style="color: rgb(0,0,0);background: rgba(255,255,255,0);border-color: rgb(0,0,0);width: 150px;">Ingresar</button><span style="margin-left: 2em;">completado</span><span><span><i class="fa fa-check-circle" style="margin-right: 0.5em;margin-left: 0.5em;"></i></span>25 pts</span>
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
