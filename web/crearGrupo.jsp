<%-- 
    Document   : iniciarsesion.jsp
    Created on : Dec 13, 2021, 5:07:55 PM
    Author     : Polar
--%>

<%@page import="servlet.Controlador"%>
<%@page import="procesos.Sesion"%>
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
        <title>Crear Grupo</title>
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
                        <h1 style="color: rgb(0,0,0);">Crear Grupo</h1>
                        <hr style="color: rgba(255,255,255,0);">
                        <div class="row row-cols-1 text-center text-dark">
                            <div class="col-auto col-sm-12 col-md-12 col-lg-12 col-xl-6 col-xxl-6 text-start mb-4">
                                <form action="Controlador">
                                    <label class="form-label" for="cod_grupo" style="margin-right: 12em;">Codigo</label><br>
                                    <input type="text" style="margin-bottom: 20px; width: 300px;" name="cod_grupo"><br>
                                    <label class="form-label" for="nivel" style="margin-right: 12em;">Nivel</label><br>
                                    <input type="text" style="width: 300px;margin-bottom: 20px;" name="nivel"><br>
                                    <input type="hidden" style="margin-bottom: 20px;width: 300px;" name="correo_maestro" value="<%=Controlador.usuarioLogeado.getCorreo()%>"><br>
                                    <input class="btn btn-primary text-center border rounded-pill border-dark" name="accion" type="submit" style="color: rgb(0,0,0);background: rgba(255,255,255,0);width: 125px;height: 50px;margin-right: 10em;" value="Crear Grupo">
                                </form>
                                <br>
                                ${avisoGrupo}
                            </div>
                            <div class="col-auto col-sm-12 col-md-6 col-lg-6 col-xl-6 col-xxl-6 align-self-center mb-4">
                                <img class="img-fluid" src="assets/img/utp_logo_big.png">
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
