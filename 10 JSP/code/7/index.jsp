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
        case "user/getAll":  // ********** LISTA DE USUARIOS *******
            // Llamamos al modelo para obtener la lista de usuarios de la BD
            List users = User.getAll();
            // Preparamos la variable users para la vista
            request.setAttribute("users", users);    
            // Llamamos a la vista (ahora tendrá disponible la variable users)
            %><jsp:include page="views/userList.jsp" /><%
            break;
        
        case "user/create":  // ********** MOSTRAR FORMULARIO CREAR USUARIO *******
            // Preparamos un usuario vacío para el formulario
            request.setAttribute("user", new User()); 
            // Preparamos la variable action para la acción del formulario
            request.setAttribute("action", "user/insert");
            %><jsp:include page="views/userForm.jsp" /><%
            break;

        case "user/insert":  // ********** INSERTAR USUARIO *******
            // Recogemos los datos del formulario y creamos un nuevo usuario con él
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String githubUrl = request.getParameter("githubUrl");
            String photo = request.getParameter("photo");
            // Creamos un nuevo objeto User y lo insertamos en la base de datos
            User newUser = new User(username, email, firstName, lastName, githubUrl, photo);
            newUser.save();
            // Redirigimos a la lista de usuarios
            response.sendRedirect("?do=user/getAll");
            break;

        case "user/delete":  // ********** BORRAR USUARIO *******
            // Recogemos de la URL el id del usuario a borrar
            int deleteId = Integer.parseInt(request.getParameter("id"));
            // Llamamos al modelo para borrar el usuario
            User.delete(deleteId);
            // Redirigimos a la lista de usuarios
            response.sendRedirect("?do=user/getAll");
            break;

        case "user/edit":   // ********** MOSTRAR FORMULARIO EDITAR USUARIO *******
            // Recogemos de la URL el id del usuario a editar
            int editId = Integer.parseInt(request.getParameter("id"));
            // Llamamos al modelo para obtener el usuario a editar
            User editUser = User.getById(editId);
            // Preparamos la variable user y la variable action para la vista
            request.setAttribute("user", editUser);
            request.setAttribute("action", "user/update");
            // Llamamos a la vista (ahora tendrá disponible las variables user y action)
            %><jsp:include page="views/userForm.jsp" /><%
            break;

        case "user/update":  // ********** ACTUALIZAR USUARIO *******
            // Recogemos los datos del formulario y creamos un nuevo objeto usuario con él
            int updateId = Integer.parseInt(request.getParameter("id"));
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String githubUrl = request.getParameter("githubUrl");
            String photo = request.getParameter("photo");
            // Creamos un nuevo objeto User y lo actualizamos en la base de datos
            User updatedUser = new User(updateId, username, email, firstName, lastName, githubUrl, photo);
            // Llamamos al modelo para actualizar el usuario en la BD
            updatedUser.save();
            // Redirigimos a la lista de usuarios
            response.sendRedirect("?do=user/getAll");
            break;

        default:   // ********** ACCIÓN NO ENCONTRADA *******
            // En caso de que no se encuentre la acción, mostramos una página de error
            response.sendRedirect("404.jsp");
    }
%>
