<%-- 
    Document   : jugabilidad
    Created on : 20-dic-2021, 11:01:00
    Author     : manue
--%>

<%@page import="java.util.Iterator"%>
<%@page import="entidades.Examen"%>
<%@page import="procesos.Sesion"%>
<%@page import="entidades.Tema"%>
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
            
            Examen examen = new Examen();
            examen.setCod_tema(tema.getCodTema());
            examen.setCorr_est(Controlador.usuarioLogeado.getCorreo());
            examen.cargarPreguntas();
            
            Iterator<String> aux = examen.getPreguntas().keySet().iterator();
            while (aux.hasNext()) {
                String next = aux.next();
                examen.getRespuestas().put(next, examen.buscarRespuestas(next));
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
                        <form>
                            <input type="hidden" name="cod_tema" value="<%=tema.getCodTema()%>">
                            <%
                                out.print(examen.generarExamen());
                            %>
                            <input class="btn btn-primary border rounded-0" type="submit" name="accion" style="color: rgb(0,0,0);background: rgba(255,255,255,0);border-color: rgb(0,0,0);width: 150px;margin-bottom: 30px;" value="Finalizar">
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/script.min.js"></script>
    </body>

</html>
