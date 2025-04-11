<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*" %>

<!-- Este script muestra la lista de usuarios guardada en la tabla Users. 
     Es una versión monolítica que no usa la arquitectura MVC -->

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Users List</title>
</head>
<body>

<h2>Users List</h2>

<%
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Cambio la IP de del servidor MySQL "mysql" porque así está configurado en mi docker-compose
        conn = DriverManager.getConnection("jdbc:mysql://mysql:3306/pruebasJSP", "root", "");
        String query = "SELECT * FROM Users";
        st = conn.createStatement();
        rs = st.executeQuery(query);
%>

<table border='1'>
    <thead>
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Email</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Github profile</th>
            <th>Photo</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
<%
        // Procesar los resultados
        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String email = rs.getString("email");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String github = rs.getString("github_url");
            String photo = rs.getString("photo");
            out.println("<tr>" +
                        "<td>" + id + "</td>" +
                        "<td>" + username + "</td>" +
                        "<td>" + email + "</td>" +
                        "<td>" + firstName + "</td>" +
                        "<td>" + lastName + "</td>" +
                        "<td><a href='" + github + "'>Click here</a></td>" +
                        "<td><img src='/imgs/" + photo + "' height='100px'></td>" +
                        "<td><a href='/4/deleteUser?idUser=" + id + "'>Delete</a> - Modify</td>" +
                        "</tr>");
        }
%>
    </tbody>
</table>
<p><a href="/3/newUser.jsp">Add New User</a></p>

<%
    } catch (Exception e) {
        out.println("Error al acceder a la BD: " + e.toString());
    } 
%>

</body>
</html>
