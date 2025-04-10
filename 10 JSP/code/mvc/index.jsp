<%
  // Punto de entrada y enrutador de la aplicación.
  // Leemos el parámetro "do" de la URL
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