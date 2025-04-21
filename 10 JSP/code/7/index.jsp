<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="UserController.jsp" %>
<!-- Punto de entrada y enrutador de la aplicación.
     Utiliza el parámetro "do" de la URL para saber qué hacer. -->

<%
    String doParam = request.getParameter("do");
    if (doParam == null) {
        doParam = "index";
    }
    // Enrutamos a la acción correspondiente
    switch (doParam) {
        case "index":
        case "user/getAll":
            // Mostrar la lista de usuarios
            UserController.getAll();
            break;
        default:
            // Acción no reconocida, redirigir a la página de inicio
            response.sendRedirect("index.jsp");
    }  
%>