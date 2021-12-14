
<%@page import="procesos.Registrar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <%
            String correo = request.getParameter("correo");
            String pass = request.getParameter("pass");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String cedula = request.getParameter("cedula");

            Registrar registro = new Registrar();
            int resultado = registro.InsertarUsuario(cedula, correo, pass, nombre, apellido);
            if (resultado > 0) {
        %>
        <h1>Registro exitoso</h1>
        <a href='index.html'>Volver...</a>
        <%
        } else {
        %>
        <h1>Usuarios No Registrado - Error</h1>
        <a href='index.html'>Ver error</a>
        <%
            }
        %>
    </body>
</html>
