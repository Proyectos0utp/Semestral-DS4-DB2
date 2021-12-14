<%-- 
    Document   : logout
    Created on : Nov 19, 2020, 4:17:29 PM
    Author     : jotaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session.removeAttribute("userId");
%>
<h3>Cerrado todo, favor regresar al login <a href="../login.jsp">aqui</a> </h3>
