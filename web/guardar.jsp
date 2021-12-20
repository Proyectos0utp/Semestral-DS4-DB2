<%-- 
    JSP: Insertar
    David Pollard
--%>

<%@page import="Entidades.Usuarios"%>
<%@page import="procesos.Insertar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Guardando...</title>
    </head>
    <body>
        <%
            int result = 0;
            if (request.getParameter("edad") != null) {
                Insertar insert = new Insertar();
                Usuarios user = new Usuarios();
                user.setNombre(request.getParameter("name"));
                user.setApellido(request.getParameter("ape"));
                user.setEdad(Integer.parseInt(request.getParameter("edad")));
                user.setFecha(request.getParameter("fecha"));
                user.setUsuario(request.getParameter("user"));
                user.setContrasena(request.getParameter("pass"));
                result = insert.InsertarUsuario(user);
            }
            if (result == 1) {
        %>
        <h1>Usuario Guardado con exito</h1>
        <a href='index.html'>Guardar otro usuario</a>
        <%
        } else {
        %>
        <h1>Usuarios No Guardado - Error</h1>
        <a href='index.html'>Ver error</a>
        <%
            }
        %>
    </body>
</html>