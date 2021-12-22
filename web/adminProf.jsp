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
                            <div class="col-auto col-sm-12 col-md-12 col-lg-4 col-xl-4 col-xxl-4 mb-4">
                                <div class="row row-cols-2">
                                    <div class="col-auto col-sm-12 col-md-12 col-lg-6 col-xl-6 col-xxl-6 order-first">
                                        <h3 class="text-start" style="color: rgb(0,0,0);">Grupos</h3>
                                    </div>
                                    <div class="col-auto col-sm-12 col-md-12 col-lg-6 col-xl-6 col-xxl-6 align-self-center order-first">
                                        <form action="Controlador">
                                            <input class="btn btn-primary border rounded-0" type="submit" name="accion" style="color: rgb(0,0,0);background: rgba(255,255,255,0);border-color: rgb(0,0,0);width: 150px;margin-bottom: 30px;" value="Crear Grupo">
                                        </form>
                                    </div>
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