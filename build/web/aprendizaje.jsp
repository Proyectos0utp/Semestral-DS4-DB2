<%-- 
    Document   : aprendizaje
    Created on : 20-dic-2021, 2:00:20
    Author     : manue
--%>

<%@page import="procesos.Sesion"%>
<%@page import="servlet.Controlador"%>
<%@page import="entidades.Tema"%>
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

                        <br><br><br>
                        <div class="row row-cols-1 text-start text-dark">
                            <div class="col-12 mb-4">
                                <div class="row row-cols-2">
                                    <div class="col-auto col-sm-12 col-md-8 order-first" style="margin-bottom: 1em;">
                                        <p><%=tema.getAprendizaje()%></p>
                                    </div>
                                    <div class="col-auto col-sm-12 col-md-4 text-center align-self-center order-first" style="margin-bottom: 1em;"><img class="img-fluid" src="assets/img/temas/<%=tema.getCodTema().concat("-A.png")%>"></div>
                                    <div class="col-auto col-sm-12 col-md-4 text-center align-self-center order-first" style="margin-bottom: 1em;"><img class="img-fluid" src="assets/img/temas/<%=tema.getCodTema().concat("-B.png")%>"></div>
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
