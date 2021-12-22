<%-- 
    Document   : index
    Created on : 19-dic-2021, 20:53:18
    Author     : manue
--%>

<%@page import="servlet.Controlador"%>
<%@page import="procesos.Sesion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Campus Virtual - Inicio</title>
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
                        <div class="row row-cols-1 text-start text-dark">
                            <div class="col-12 mb-4">
                                <div class="row row-cols-2">
                                    <div class="col-8">
                                        <h1 style="color: rgb(0,0,0);">Bienvenido al Campus Virtual</h1>
                                        <p>El Campus Virtual es una plataforma de aprendizaje para estudiantes en donde se ofrece una una gran variedad de temas, cada uno con su sección de aprendizaje y exámenes para poner a prueba tus conocimientos. Además poseemos rankings para cada tema, así puedes comparar tu desempeño con el de tus compañeros. También contamos con un panel de administración para profesores, el cual facilita el manejo y monitoreo de sus grupos de estudiantes. Únete hoy y forma parte de nuestra gran familia de estudiantes y educadores.</p>
                                    </div>
                                    <div class="col-4 text-center m-auto"><img class="img-fluid" src="assets/img/fisc_soy_fisc.png"></div>
                                </div>
                            </div>
                            <div class="col-12 mb-4">
                                <div class="row row-cols-2">
                                    <div class="col-8">
                                        <h1 style="color: rgb(0,0,0);">¡Educación de calidad siempre a tu alcance!</h1>
                                        <p>¡Accesa a una gran variedad de temas accesibles en todo momento y aprende a tu propia velocidad! Campus Virtual es una oportunidad para poner en marcha tu crecimiento académico, entre, aprende y pon a prueba tus conocimientos a través de nuestros exámenes.</p>
                                    </div>
                                    <div class="col-4 text-center m-auto"><img class="img-fluid" src="assets/img/fisc_logo.png"></div>
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

