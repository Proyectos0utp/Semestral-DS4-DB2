<%-- 
    Document   : acerca_de
    Created on : 19-dic-2021, 20:52:18
    Author     : manue
--%>

<%@page import="servlet.Controlador"%>
<%@page import="procesos.Sesion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Acerca de nosotros</title>
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
                    <h1 style="color: rgb(0,0,0);">Acerca de nosotros</h1>
                    <hr style="color: rgba(255,255,255,0);">
                    <div class="row row-cols-1 text-center text-dark">
                        <div class="col-12 mb-4">
                            <h1 style="color: rgb(0,0,0);">Campus Virtual</h1>
                            <p>El Campus Virtual es una plataforma de aprendizaje para estudiantes en donde se ofrece una una gran variedad de temas, cada uno con su sección de aprendizaje y exámenes para poner a prueba tus conocimientos. Además poseemos rankings para cada tema, así puedes comparar tu desempeño con el de tus compañeros. También contamos con un panel de administración para profesores, el cual facilita el manejo y monitoreo de sus grupos de estudiantes. Únete hoy y forma parte de nuestra gran familia de estudiantes y educadores. <br><br>Campus Virtual fue desarrollado por el grupo 3 como proyecto semestral para el curso de Desarrollo de Software IV.</p>
                        </div>
                        <div class="col-12 align-self-center mb-4">
                            <div class="row row-cols-sm-1 row-cols-md-2 row-cols-lg-3 row-cols-xl-3 row-cols-xxl-4 justify-content-center align-items-center">
                                <div class="col-2 col-sm-auto align-self-center mb-4"><img class="rounded-circle" src="https://i.ibb.co/1dKRnXh/Victor.jpg" alt="Foto de Victor Abrego" width="250" height="250">
                                    <h6>Victor Abrego</h6>
                                </div>
                                <div class="col-2 col-sm-auto align-self-center mb-4"><img class="rounded-circle" src="https://i.ibb.co/fVg8KQW/photo0.jpg" alt="Foto de Joel Carrillo" width="250" height="250">
                                    <h6>Joel Carrillo</h6>
                                </div>
                                <div class="col-2 col-sm-auto align-self-center mb-4"><img class="rounded-circle" src="https://i.ibb.co/TrQX165/Whats-App-Image-2021-12-13-at-4-01-35-PM.jpg" alt="Foto Estefanny Cisneros" width="250" height="250">
                                    <h6>Estefanny Cisneros</h6>
                                </div>
                                <div class="col-2 align-self-center mb-4"><img class="rounded-circle" src="https://i.ibb.co/SJRcDY0/photo1.jpg" alt="Foto de Manuel Matute" width="250" height="250">
                                    <h6>Manuel Matute</h6>
                                </div>
                                <div class="col-2 align-self-center mb-4"><img class="rounded-circle" src="https://i.ibb.co/st9y0GL/photo2.png" alt="Foto de David Pollard" width="250" height="250">
                                    <h6>David Pollard</h6>
                                </div>
                                <div class="col-2 align-self-center mb-4"><img class="rounded-circle" src="https://i.ibb.co/whKQTZM/Eyner.jpg" alt="Foto de Eyner Vergara" width="250" height="250">
                                    <h6>Eyner Vergara</h6>
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
