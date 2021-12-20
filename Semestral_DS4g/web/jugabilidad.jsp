<%-- 
    Document   : jugabilidad
    Created on : 20-dic-2021, 11:01:00
    Author     : manue
--%>

<%@page import="procesos.Sesion"%>
<%@page import="entidades.Tema"%>
<%@page import="servlet.Controlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    
    <%
        Tema tema = Controlador.temaIngresado; 
        
    %>
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title><%=tema.getCodTema()%></title>
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
                    <h1 style="color: rgb(0,0,0);"><%=tema.getTitulo()%></h1>
                    <form>
                        <div class="row row-cols-1 text-start text-dark">
                            <div class="col-12 mb-4">
                                <div class="row row-cols-2">
                                    <div class="col-auto col-sm-12 col-md-8 col-xl-12 order-first" style="margin-bottom: 0.5em;">
                                        <h2 style="color: rgb(0,0,0);">Pregunta 1</h2>
                                        <p style="color: rgb(0,0,0);"><strong>Lorem Ipsum</strong>&nbsp;is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.<br></p>
                                    </div>
                                    <div class="col-auto col-sm-12 col-md-4 col-xl-12 text-center align-self-center order-2" style="margin-bottom: 0.5em;"><img class="img-fluid" src="http://via.placeholder.com/150x150"></div>
                                    <div class="col-auto col-sm-12 order-last" style="margin-bottom: 0.5em;">
                                        <div class="form-check" style="margin-bottom: 0.5em;"><input class="form-check-input" type="radio" id="formCheck-1" value="A" name="respuesta"><label class="form-check-label" for="formCheck-1">A)&nbsp;respuesta a</label></div>
                                        <div class="form-check" style="margin-bottom: 0.5em;"><input class="form-check-input" type="radio" id="formCheck-4" value="B" name="respuesta"><label class="form-check-label" for="formCheck-4">B)&nbsp;respuesta b</label></div>
                                        <div class="form-check" style="margin-bottom: 0.5em;"><input class="form-check-input" type="radio" id="formCheck-3" value="C" name="respuesta"><label class="form-check-label" for="formCheck-3">C)&nbsp;respuesta c</label></div>
                                        <div class="form-check" style="margin-bottom: 0.5em;"><input class="form-check-input" type="radio" id="formCheck-2" value="D" name="respuesta"><label class="form-check-label" for="formCheck-2">D)&nbsp;respuesta d</label></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row row-cols-1 text-start text-dark">
                            <div class="col-12 mb-4">
                                <div class="row row-cols-2">
                                    <div class="col-auto col-sm-12 col-md-8 col-xl-12 order-first" style="margin-bottom: 0.5em;">
                                        <h2 style="color: rgb(0,0,0);">Pregunta 2</h2>
                                        <p style="color: rgb(0,0,0);"><strong>Lorem Ipsum</strong>&nbsp;is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.<br></p>
                                    </div>
                                    <div class="col-auto col-sm-12 col-md-4 col-xl-12 text-center align-self-center order-2" style="margin-bottom: 0.5em;"><img class="img-fluid" src="http://via.placeholder.com/150x150"></div>
                                    <div class="col-auto col-sm-12 order-last" style="margin-bottom: 0.5em;">
                                        <div class="form-check" style="margin-bottom: 0.5em;"><input class="form-check-input" type="radio" id="formCheck-5" value="A" name="respuesta"><label class="form-check-label" for="formCheck-5">A)&nbsp;respuesta a</label></div>
                                        <div class="form-check" style="margin-bottom: 0.5em;"><input class="form-check-input" type="radio" id="formCheck-6" value="B" name="respuesta"><label class="form-check-label" for="formCheck-6">B)&nbsp;respuesta b</label></div>
                                        <div class="form-check" style="margin-bottom: 0.5em;"><input class="form-check-input" type="radio" id="formCheck-7" value="C" name="respuesta"><label class="form-check-label" for="formCheck-7">C)&nbsp;respuesta c</label></div>
                                        <div class="form-check" style="margin-bottom: 0.5em;"><input class="form-check-input" type="radio" id="formCheck-8" value="D" name="respuesta"><label class="form-check-label" for="formCheck-8">D)&nbsp;respuesta d</label></div>
                                    </div>
                                </div>
                            </div>
                        </div><button class="btn btn-primary border rounded-0" type="button" style="color: rgb(0,0,0);background: rgba(255,255,255,0);border-color: rgb(0,0,0);width: 150px;margin-bottom: 30px;">Finalizar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/script.min.js"></script>
</body>

</html>
