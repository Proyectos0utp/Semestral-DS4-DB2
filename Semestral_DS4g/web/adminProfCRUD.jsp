<%-- 
    Document   : administracion CRUD (adminProf)
    Created on : 18 dic 2021, 0:55:32
    Author     : Polar
--%>

<%@page import="servlet.Controlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Admin Prof. CRUD</title>
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
                    <li class="nav-item"><a class="nav-link" href="perfil.html"><span class="text-dark" style="font-size: 20px;">Inicio</span></a></li>
                    <li class="nav-item"><a class="nav-link" href="iniciarsesion.html"><span class="text-dark" style="font-size: 20px;">Busqueda</span></a></li>
                    <li class="nav-item"><a class="nav-link" href="acerca_de.html"><span class="text-dark" style="font-size: 20px;">Acerca de</span></a></li>
                    <li class="nav-item"><a class="nav-link" href="contacto.html"><span class="text-dark" style="font-size: 20px;">Contacto</span></a></li>
                    <li class="nav-item"><a class="nav-link" href="registro.html"><span class="text-dark" style="font-size: 20px;">Salir</span></a></li>
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
                    <h1 style="color: rgb(0,0,0);">Administración</h1>
                    <div class="row row-cols-1 text-start text-dark">
                        <div class="col-auto col-sm-12 col-md-12 col-lg-4 col-xl-4 col-xxl-4 mb-4">
                            <div class="row row-cols-2">
                                <div class="col-auto col-sm-12 col-md-12 col-lg-6 col-xl-6 col-xxl-6 order-first">
                                    <h3 class="text-start" style="color: rgb(0,0,0);">Grupos</h3>
                                </div>
                                <div class="col-auto col-sm-12 col-md-12 col-lg-6 col-xl-6 col-xxl-6 align-self-center order-first"><button class="btn btn-primary border rounded-0" type="button" style="color: rgb(0,0,0);background: rgba(255,255,255,0);border-color: rgb(0,0,0);width: 150px;margin-bottom: 30px;">Crear Grupo</button></div>
                                <div class="col-12 text-center order-first">
                                    <div class="table-responsive border-dark">
                                        <table class="table">
                                            <tbody class="border-dark">
                                                <tr>
                                                    <td style="color: rgb(0,0,0);">01</td>
                                                    <td><button class="btn btn-primary border rounded-0" type="button" style="color: rgb(0,0,0);background: rgba(255,255,255,0);border-color: rgb(0,0,0);width: 150px;margin-bottom: 30px;">Administrar</button></td>
                                                </tr>
                                                <tr>
                                                    <td style="color: rgb(0,0,0);">02</td>
                                                    <td><button class="btn btn-primary border rounded-0" type="button" style="color: rgb(0,0,0);background: rgba(255,255,255,0);border-color: rgb(0,0,0);width: 150px;margin-bottom: 30px;">Administrar</button></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-auto col-sm-12 col-md-12 col-lg-8 col-xl-8 col-xxl-8 mb-4">
                            <div class="row row-cols-2">
                                <div class="col-auto col-sm-12 col-md-12 col-lg-8 col-xl-8 col-xxl-8 text-center order-first">
                                    <h3 class="text-start" style="color: rgb(0,0,0);">Estudiantes de grupo:</h3>
                                </div>
                                <div class="col-auto col-sm-12 col-md-12 col-lg-4 col-xl-4 col-xxl-4 text-center align-self-center order-first"><select style="width: 80px;height: 50px;">
                                        <optgroup label="grupos">
                                            <option value="1" selected="">01</option>
                                            <option value="2">02</option>
                                            <option value="3">03</option>
                                        </optgroup>
                                    </select></div>
                                <div class="col-12 text-center order-first">
                                    <div class="table-responsive border rounded-0">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th style="color: rgb(0,0,0);">Estudiante</th>
                                                    <th style="color: rgb(0,0,0);">Temas</th>
                                                    <th style="color: rgb(0,0,0);">Preguntas</th>
                                                    <th style="color: rgb(0,0,0);">Puntaje</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td style="color: rgb(0,0,0);">nombre apellido</td>
                                                    <td><select style="width: 100px;height: 30px;">
                                                            <optgroup label="temas">
                                                                <option value="1" selected="">Sistema Digestivo</option>
                                                                <option value="2">Los Alimentos son necesarios para dar energía y movimientos al cuerpo</option>
                                                                <option value="3">El sistema Respiratorio</option>
                                                                <option value="4">La reproducción de los seres vivos</option>
                                                            </optgroup>
                                                        </select></td>
                                                    <td><select style="width: 100px;height: 30px;">
                                                            <optgroup label="preguntas">
                                                                <option value="101" selected="">101</option>
                                                                <option value="201">201</option>
                                                                <option value="301">301</option>
                                                                <option value="401">401</option>
                                                            </optgroup>
                                                        </select></td>
                                                    <td style="color: rgb(0,0,0);">25</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
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