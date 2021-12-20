<%-- 
    Document   : reportar
    Created on : 18 dic 2021, 0:55:32
    Author     : Polar
--%>

<%@page import="procesos.Sesion"%>
<%@page import="servlet.Controlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Reportar</title>
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
                    <h1 style="color: rgb(0,0,0);">Reportar</h1>
                    <hr style="color: rgba(255,255,255,0);">
                    <div class="row row-cols-1 text-center text-dark">
                        <div class="col-auto col-sm-12 col-md-6 col-lg-6 col-xl-6 col-xxl-6 text-start mb-4"><select class="border rounded-0 border-dark" style="margin-bottom: 20px;height: 30px;width: 300px;">
                                <optgroup label="tipo de reporte">
                                    <option value="1" selected="">Error de inicio de sesión</option>
                                    <option value="2">Error al cargar contenido</option>
                                    <option value="3">Error al realizar examen</option>
                                </optgroup>
                            </select><input type="email" placeholder="Ingrese su correo..." style="margin-bottom: 20px;width: 300px;"><textarea placeholder="Descripción del reporte..." style="margin-bottom: 20px;width: 300px;" rows="10" cols="30"></textarea><button class="btn btn-primary text-center border rounded-pill border-dark" type="button" style="color: rgb(0,0,0);background: rgba(255,255,255,0);width: 100px;height: 50px;margin-right: 10em;">Reportar</button></div>
                        <div class="col-auto col-sm-12 col-md-6 col-lg-6 col-xl-6 col-xxl-6 align-self-center mb-4"><img class="img-fluid" src="http://via.placeholder.com/500x500"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/script.min.js"></script>
</body>

</html>