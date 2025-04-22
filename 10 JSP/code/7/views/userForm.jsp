<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="models.User" %>
<%
    User user = (User) request.getAttribute("user");
    String formAction = (String) request.getAttribute("action");

    if (user == null) {
        user = new User(); // Evita null pointer en campos vacíos
    }
%>

<h2><%= formAction.equals("user/insert") ? "Crear nuevo usuario" : "Editar usuario" %></h2>

<form action="?do=<%= formAction %>" method="post">
    <% if ("user/update".equals(formAction)) { %>
        <input type="hidden" name="id" value="<%= user.getId() %>">
    <% } %>

    <label>Username:<br>
        <input type="text" name="username" value="<%= user.getUsername() != null ? user.getUsername() : "" %>" required>
    </label><br><br>

    <label>Email:<br>
        <input type="email" name="email" value="<%= user.getEmail() != null ? user.getEmail() : "" %>" required>
    </label><br><br>

    <label>Nombre:<br>
        <input type="text" name="firstName" value="<%= user.getFirstName() != null ? user.getFirstName() : "" %>" required>
    </label><br><br>

    <label>Apellido:<br>
        <input type="text" name="lastName" value="<%= user.getLastName() != null ? user.getLastName() : "" %>" required>
    </label><br><br>

    <label>GitHub URL:<br>
        <input type="url" name="githubUrl" value="<%= user.getGithubUrl() != null ? user.getGithubUrl() : "" %>">
    </label><br><br>

    <label>Nombre del archivo de foto:<br>
        <input type="text" name="photo" value="<%= user.getPhoto() != null ? user.getPhoto() : "" %>">
    </label><br><br>

    <button type="submit">💾 Guardar</button>
    <a href="?do=user/getAll">↩️ Cancelar</a>
</form>
