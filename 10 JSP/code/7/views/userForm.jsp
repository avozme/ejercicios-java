<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="models.User" %>

<!-- Esta vista muestra el formulario para crear o editar un usuario.
     Usaremos el mismo código para CREAR y para EDITAR, por lo que haremos pequeños cambios
     en algunos puntos según la acción que se esté realizando.
     Podemos saber qué acción es gracias al parámetro "action" -->
<%
    // Recogemos el usuario y la acción enviados desde el controlador
    User user = (User) request.getAttribute("user");
    String formAction = (String) request.getAttribute("action");
    // Copiamos todos los datos del usuario a variables sencillas para usarlas en el formulario sin escribir tanto.
    // Si el usuario es null, los valores serán null y no se mostrarán en el formulario.
    String username = user.getUsername();
    String email = user.getEmail();
    String firstName = user.getFirstName();
    String lastName = user.getLastName();
    String githubUrl = user.getGithubUrl();
    String photo = user.getPhoto();
    int userId = user.getId();
%>

<h2>
<%
    // Mostramos el título de la página web según la acción que se esté realizando.
    if (formAction.equals("user/insert"))
        out.println("Crear nuevo usuario");
    else
        out.println("Editar usuario");
%>
</h2>

<form action="index.jsp?do=<%= formAction %>" method="post">
    <% 
        // Si la acción es "user/update", añadimos un campo oculto con el id del usuario
        // (es necesario para que el controlador sepa qué usuario actualizar)
        if ("user/update".equals(formAction)) { 
            out.println("<input type='hidden' name='id' value='" + userId + "'>");
        } 
    %>

    <!-- Mostramos los campos del formulario con los valores de los datos del usuario,
         que estarán vacíos si estamos creando un usuario nuevo -->
    <label>Username:<br>
        <input type="text" name="username" value="<%= username %>" required>
    </label><br><br>

    <label>Email:<br>
        <input type="email" name="email" value="<%= email %>" required>
    </label><br><br>

    <label>Nombre:<br>
        <input type="text" name="firstName" value="<%= firstName %>" required>
    </label><br><br>

    <label>Apellido:<br>
        <input type="text" name="lastName" value="<%= lastName %>" required>
    </label><br><br>

    <label>GitHub URL:<br>
        <input type="url" name="githubUrl" value="<%= githubUrl %>">
    </label><br><br>

    <label>Nombre del archivo de foto:<br>
        <input type="text" name="photo" value="<%= photo %>">
    </label><br><br>

    <button type="submit">💾 Guardar</button>
    <a href="index.jsp?do=user/getAll">↩️ Cancelar</a>
</form>
