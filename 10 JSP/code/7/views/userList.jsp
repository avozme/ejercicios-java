<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="models.User" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Users List - Versión MVC</title>
</head>
<body>
    <h2>Users List - Versión MVC</h2>
    
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Email</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Github Profile</th>
                <th>Photo</th>
                <th>Editar</th>
                <th>Borrar</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Recuperamos la variable users que nos preparó el controlador
                List<User> users = (List<User>) request.getAttribute("users");
                for (User user : users) {
            %>
            <tr>
                <td><%= user.getId() %></td>
                <td><%= user.getUsername() %></td>
                <td><%= user.getEmail() %></td>
                <td><%= user.getFirstName() %></td>
                <td><%= user.getLastName() %></td>
                <td><a href="<%= user.getGithubUrl() %>" target="_blank">Click here</a></td>
                <td><img src="/imgs/<%= user.getPhoto() %>" height="100px"></td>
                <td><a href="?do=user/edit&id=<%= user.getId() %>">✏️ Editar</a></td>
                <td><a href="?do=user/delete&id=<%= user.getId() %>" onclick="return confirm('¿Estás seguro de que quieres borrar a <%= user.getUsername() %>?');">🗑️ Borrar</a></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    
    </body>
</html>
