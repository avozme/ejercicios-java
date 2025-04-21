<!-- Punto de entrada y controlador principal de la aplicación.
     Utiliza el parámetro "do" de la URL para saber qué hacer. 
     
     ¡¡OJO!! Esto no es una solución MVC óptima. Eso lo aprenderás a hacer
     en 2º curso. En particular, en controlador no debería hacer en enrutamiento.

     ¡¡ESTO SOLO ES UNA PRIMERA APROXIMACIÓN!! -->

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="models.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%
    String doParam = request.getParameter("do");
    if (doParam == null) {
        doParam = "index";
    }

    // Enrutamos a la acción correspondiente
    switch (doParam) {
        case "index":
        case "user/getAll":
            // Llamamos al modelo para obtener la lista de usuarios de la BD
            List users = User.getAll();
            // Preparamos la variable users para la vista
            request.setAttribute("users", users);    
            // Llamamos a la vista (ahora tendrá disponible la variable users)
            %><jsp:include page="views/userList.jsp" /><%
            break;
        default:
            // Acción no reconocida, redirigir a la página de inicio
            response.sendRedirect("index.jsp");
    }  
%>