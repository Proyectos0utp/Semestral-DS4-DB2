<%-- 
    Document   : administrar
    Created on : 19 dic 2021, 0:55:32
    Author     : Polar
--%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Dashboard - Brand</title>
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
                    <h1 style="color: rgb(0,0,0);">Administración de Grupo: &lt;cod grupo&gt;</h1>
                    <div class="row row-cols-1 text-start text-dark">
                        <div class="col-auto order-first">
                            <h3 class="text-start" style="color: rgb(0,0,0);">Temas</h3>
                        </div>
                        <div class="col-12 text-center order-first">
                            <div class="table-responsive border-dark">
                                <table class="table">
                                    <tbody class="border-dark">
                                        <tr>
                                            <td style="color: rgb(0,0,0);">&lt;nombre tema&gt;</td>
                                            <td><button class="btn btn-primary border rounded-0" type="button" style="color: rgb(0,0,0);background: rgba(255,255,255,0);border-color: rgb(0,0,0);width: 150px;margin-bottom: 30px;">Administrar</button></td>
                                        </tr>
                                        <tr>
                                            <td style="color: rgb(0,0,0);">&lt;nombre tema&gt;</td>
                                            <td><button class="btn btn-primary border rounded-0" type="button" style="color: rgb(0,0,0);background: rgba(255,255,255,0);border-color: rgb(0,0,0);width: 150px;margin-bottom: 30px;">Administrar</button></td>
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
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/script.min.js"></script>
</body>

</html>