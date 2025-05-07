<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="models.User" %>
<!-- Esta vista muestra la lista de usuarios. -->
<!-- La lista de usuarios viene del controlador llega a esta vista como un parámetro de la URL -->
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Users List - Versión MVC</title>
</head>
<body>
    <h2>Users List - Versión MVC</h2>
    <p><a href="index.jsp?do=user/create">➕ Create new user</a></p>

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
                <th colspan="2">Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
            // Recogemos la lista de usuarios que viene del controlador
            // y la guardamos en una variable para usarla en el bucle.
            List<User> users = (List<User>) request.getAttribute("users");
            for (User user : users) {
                out.print("<tr>");
                out.print("<td>" + user.getId() + "</td>");
                out.print("<td>" + user.getUsername() + "</td>");
                out.print("<td>" + user.getEmail() + "</td>");
                out.print("<td>" + user.getFirstName() + "</td>");
                out.print("<td>" + user.getLastName() + "</td>");
                out.print("<td><a href='" + user.getGithubUrl() + "' target='_blank'>Click here</a></td>");
                out.print("<td><img src='/imgs/" + user.getPhoto() + "' height='100px'></td>");
                out.print("<td><a href='index.jsp?do=user/edit&id=" + user.getId() + "'>✏️ Editar</a></td>");
                out.print("<td><a href='index.jsp?do=user/delete&id=" + user.getId() + "' onclick=\"return confirm('¿Estás seguro de que quieres borrar a " + user.getUsername() + "?');\">🗑️ Borrar</a></td>");
                out.print("</tr>");
            }
            %>
        </tbody>
    </table>
    
    </body>
</html>
