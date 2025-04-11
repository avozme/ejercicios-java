<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*, java.io.*" %>

<!-- Este script recoge los datos del formulario de alta de usuario
     y los envía a la tabla Users para añadirlo a la base de datos -->

<%
    // Recibir datos del formulario
    String username = request.getParameter("username");
    String email = request.getParameter("email");
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String github = request.getParameter("github");
    String photo = request.getParameter("photo");

    out.println("<h2>Datos recibidos:</h2>");
    out.println("<p>Username: " + username + "</p>");
    out.println("<p>Email: " + email + "</p>");
    out.println("<p>First Name: " + firstName + "</p>");
    out.println("<p>Last Name: " + lastName + "</p>");
    out.println("<p>GitHub URL: " + github + "</p>");
    out.println("<p>Photo: " + photo + "</p>");
    out.println("<hr>");
/*
    // Manejo del archivo de la foto (opcional)
    String photo = null;
    Part filePart = request.getPart("photo");
    if (filePart != null && filePart.getSize() > 0) {
        String fileName = filePart.getSubmittedFileName();
        String uploadPath = getServletContext().getRealPath("/imgs") + File.separator + fileName;
        filePart.write(uploadPath);
        photo = fileName;
    }
*/
    // Conexión a la base de datos
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://mysql:3306/pruebasJSP", "root", "");

        String query = "INSERT INTO Users (username, email, first_name, last_name, github_url, photo) VALUES (?, ?, ?, ?, ?, ?)";
        ps = conn.prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, email);
        ps.setString(3, firstName);
        ps.setString(4, lastName);
        ps.setString(5, github);
        ps.setString(6, photo);
        
        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            out.println("<p>User added correctly</p>");
        } else {
            out.println("<p>Error adding user</p>");
        }
        ps.close();
        conn.close();
    } catch (Exception e) {
        out.println("Error: " + e.toString());
    } 
%>

<a href="newUser.jsp">Back</a>
