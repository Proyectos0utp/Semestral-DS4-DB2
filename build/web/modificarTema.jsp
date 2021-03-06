<%-- 
    Document   : administrar
    Created on : 18 dic 2021, 0:55:32
    Author     : Polar
--%>

<%@page import="entidades.Tema"%>
<%@page import="procesos.Sesion"%>
<%@page import="servlet.Controlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <%
            Tema tema = Controlador.temaIngresado;
            if (Controlador.usuarioLogeado.getNombre().equals("")) {
                RequestDispatcher ventana = request.getRequestDispatcher("iniciarsesion.jsp");
                request.setAttribute("avisoSesion", "Inicie sesion.");
                ventana.forward(request, response);
            } else {

                if (tema.getCodTema().equals("")) {
                    RequestDispatcher ventana = request.getRequestDispatcher("adminEst.jsp");
                    ventana.forward(request, response);
                }
            }
        %>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Administrar tema</title>
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
                        <h1 style="color: rgb(0,0,0);">Administrar contenido</h1>
                        <hr style="color: rgba(255,255,255,0);">
                        <div class="row row-cols-1 text-center text-dark">
                            <div class="col-auto col-sm-12 col-md-6 col-lg-6 col-xl-6 col-xxl-6 text-start order-first mb-4">
                                <form action="Controlador">
                                    <input type="text" placeholder="Codigo de tema..." name="cod_tema" value="<%=tema.getCodTema()%>" readonly="true" style="margin-bottom: 20px;width: 300px;"><br>
                                    <input type="text" placeholder="Nombre de tema..." name="titulo" value="<%=tema.getTitulo()%>" style="margin-bottom: 20px;width: 300px;"><br>
                                    <textarea placeholder="Contenido..." name="contenido" style="margin-bottom: 20px;width: 300px;" rows="10" cols="30"><%=tema.getContenido()%></textarea><br>
                                    <input type="url" name="imagen" placeholder="Inserte el link HTML de la imagen..." value="<%=tema.getImagen()%>" style="margin-bottom: 20px;width: 300px;"><br>
                                    <input class="btn btn-primary text-center border rounded-pill border-dark" type="submit" name="accion" style="color: rgb(0,0,0);background: rgba(255,255,255,0);width: 175px;height: 50px;" value="Actualizar Tema">
                                </form>
                                <br>
                                ${avisoTema}
                            </div>
                            <div class="col-auto col-sm-12 col-md-6 col-lg-6 col-xl-6 col-xxl-6 align-self-center mb-4">
                                <img class="img-fluid" src="<%=tema.getImagen()%>" alt="imagen ya cargada si existe, si no aparece placeholder"></div>
                            <div class="col-12 align-self-center order-last mb-4" style="text-align: center;"><br><br>
                                <h3 class="text-center">Preguntas</h3><br><span>(marque el check de la respuesta correcta)<br></span>
                                <button class="btn btn-primary text-center border rounded-pill border-dark" type="button" style="color: rgb(0,0,0);background: rgba(255,255,255,0);width: 200px;height: 50px;">Insertar nueva pregunta</button><br><br>
                                <form action="Controlador">
                                    <div class="table-responsive border rounded-0">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th style="color: rgb(0,0,0);">Pregunta</th>
                                                    <th style="color: rgb(0,0,0);">Respuestas</th>
                                                    <th style="color: rgb(0,0,0);">Retroalimentaci??n</th>
                                                    <th style="color: rgb(0,0,0);">Imagen</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>

                                                    <td style="color: rgb(0,0,0);">
                                                        <textarea placeholder="Pregunta..." style="margin-bottom: 20px;width: 300px;" rows="5" cols="30"></textarea></td>
                                                    <td>
                                                        <div class="form-check"><input class="form-check-input" type="radio" id="formCheck-1" value="A" name="respuestas"><label class="form-check-label" for="formCheck-1">A</label></div><input type="text" placeholder="respuesta...">
                                                        <div class="form-check"><input class="form-check-input" type="radio" id="formCheck-2" value="B" name="respuestas"><label class="form-check-label" for="formCheck-2">B</label></div><input type="text" placeholder="respuesta...">
                                                        <div class="form-check"><input class="form-check-input" type="radio" id="formCheck-3" value="C" name="respuestas"><label class="form-check-label" for="formCheck-3">C</label></div><input type="text" placeholder="respuesta...">
                                                        <div class="form-check"><input class="form-check-input" type="radio" id="formCheck-4" value="D" name="respuestas"><label class="form-check-label" for="formCheck-4">D</label></div><input type="text" placeholder="respuesta...">
                                                    </td>
                                                    <td><textarea placeholder="Retroalimentaci??n..." style="margin-bottom: 20px;width: 300px;" rows="5" cols="30"></textarea></td>
                                                    <td><input type="url" placeholder="Inserte el link HTML de la imagen..." style="margin-bottom: 20px;"></td>

                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <input class="btn btn-primary text-center border rounded-pill border-dark" type="submit" name="accion" style="color: rgb(0,0,0);background: rgba(255,255,255,0);width: 100px;height: 50px;" value="Crear Pregunta"><br>
                                </form>
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
