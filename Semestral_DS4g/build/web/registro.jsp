<%-- 
    Document   : iniciarsesion.jsp
    Created on : Dec 13, 2021, 5:07:55 PM
    Author     : Polar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Registro</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/fonts/fontawesome5-overrides.min.css">
    <link rel="stylesheet" href="assets/css/styles.min.css">
</head>

<body id="page-top">
    <div id="wrapper">
        <nav class="navbar navbar-light align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0">
            <div class="container-fluid d-flex flex-column p-0">
                <hr style="color: rgba(255,255,255,0);"><a class="navbar-brand text-center d-flex justify-content-center align-items-center sidebar-brand m-0" href="#"><img class="img-fluid" src="http://via.placeholder.com/50x50"></a>
                <hr class="sidebar-divider my-0">
                <ul class="navbar-nav text-light" id="accordionSidebar">
                    <li class="nav-item"><a class="nav-link" href="index.html"><span class="text-dark" style="font-size: 20px;">Inicio</span></a></li>
                    <li class="nav-item"><a class="nav-link" href="acerca_de.html"><span class="text-dark" style="font-size: 20px;">Acerca de</span></a></li>
                    <li class="nav-item"><a class="nav-link" href="contacto.html"><span class="text-dark" style="font-size: 20px;">Contacto</span></a></li>
                    <li class="nav-item"><a class="nav-link" href="iniciarsesion.jsp"><span class="text-dark" style="font-size: 20px;">Iniciar Sesión</span></a></li>
                    <li class="nav-item"><a class="nav-link active" href="registro.jsp"><span class="text-dark" style="font-size: 20px;">Registro</span></a></li>
                </ul>
            </div>
        </nav>
        <div class="d-flex flex-column" id="content-wrapper">
            <div id="content" style="margin-top: 15;">
                <nav class="navbar navbar-light navbar-expand-md bg-white shadow d-print-none d-md-none d-lg-none d-xl-none d-xxl-none mb-4 topbar static-top">
                    <div class="container-fluid"><button class="btn btn-link d-md-none rounded-circle me-3" id="sidebarToggleTop" type="button"><i class="fas fa-bars"></i></button></div>
                </nav>
                <div class="container-fluid">
                    <hr style="color: rgba(255,255,255,0);">
                    <h1 style="color: rgb(0,0,0);">Registro</h1>
                    <hr style="color: rgba(255,255,255,0);">
                    <div class="row row-cols-1 text-center text-dark">
                        <div class="col-auto col-sm-12 col-md-12 col-lg-12 col-xl-6 col-xxl-6 text-start mb-4">
                            <form method="post" action="procesosJSP/registrar.jsp">
                                <label class="form-label" for="correo" style="margin-right: 12em;">Correo</label>
                                <input type="email" style="margin-bottom: 20px;width: 300px;" name="correo">
                                <label class="form-label" for="pass" style="margin-right: 12em;">Contraseña</label>
                                <input type="password" style="width: 300px;margin-bottom: 20px;" name="pass">
                                <label class="form-label" for="nombre" style="margin-right: 12em;">Nombre</label>
                                <input type="text" style="margin-bottom: 20px;width: 300px;" name="nombre">
                                <label class="form-label" for="apellido" style="margin-right: 12em;">Apellido</label>
                                <input type="text" style="margin-bottom: 20px;width: 300px;" name="apellido">
                                <label class="form-label" for="cedula" style="margin-right: 12em;">Cédula</label>
                                <input type="text" style="margin-bottom: 20px;width: 300px;" name="cedula">
                                <button class="btn btn-primary text-center border rounded-pill border-dark" type="submit" style="color: rgb(0,0,0);background: rgba(255,255,255,0);width: 100px;height: 50px;margin-right: 10em;">Registrarse</button>
                            </form>
                        </div>
                        <div class="col-auto col-sm-12 col-md-6 col-lg-6 col-xl-6 col-xxl-6 align-self-center mb-4">
                            <img class="img-fluid" src="http://via.placeholder.com/500x500">
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