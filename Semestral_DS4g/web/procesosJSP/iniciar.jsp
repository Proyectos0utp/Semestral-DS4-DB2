<%@page import="procesos.Iniciar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String correo = request.getParameter("correo");
    String password = request.getParameter("pass");
    
    Iniciar iniciar = new Iniciar();
    session.setAttribute("correo", correo);
    //int verificar = iniciar.LoginVerificar(correo, password);
    String nombre = iniciar.LoginNombre(correo, password);
    session.setAttribute("Nombre", nombre);
    /*String apellido = iniciar.LoginApellido(correo, password);
    String cedula = iniciar.LoginCedula(correo, password);
    String grupo = iniciar.LoginGrupo(correo);*/
    if(iniciar != null){
        out.println("Exito");
        /*session.setAttribute("Nombre", nombre);
        session.setAttribute("Apellido", apellido);
        session.setAttribute("Cedula", cedula);
        session.setAttribute("Grupo", grupo);*/
        %>
        <a href="../perfil.jsp">Ir a Perfil de Usuario <%= session.getAttribute("correo") %></a>
<%
    }else{
        out.println("Error al iniciar sesion");
        %>
        <a href="../iniciarsesion.jsp">Regresar</a>
<%
    }
%>
