<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="models.User" %>
<%
    User user = (User) request.getAttribute("user");
    String formAction = (String) request.getAttribute("action");
    String username = user.getUsername();
    String email = user.getEmail();
    String firstName = user.getFirstName();
    String lastName = user.getLastName();
    String githubUrl = user.getGithubUrl();
    String photo = user.getPhoto();
    int userId = user.getId();


    if (user == null) {
        user = new User(); // Evita null pointer en campos vacíos
    }
%>

<h2>
<%
if (formAction.equals("user/insert"))
    out.println("Crear nuevo usuario");
else
    out.println("Editar usuario");
%>
</h2>

<form action="index.jsp?do=<%= formAction %>" method="post">
    <% if ("user/update".equals(formAction)) { %>
        <input type="hidden" name="id" value="<%= userId %>">
    <% } %>

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
