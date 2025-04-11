<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!-- Este script muestra el formulario para añadir un usuario nuevo a la tabla Users -->

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Add New User</title>
</head>
<body>

<h2>Add New User</h2>

<form action="addUser.jsp" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName" required><br><br>

    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName" required><br><br>

    <label for="github">GitHub URL:</label>
    <input type="url" id="github" name="github"><br><br>

    <label for="photo">Photo (optional):</label>
    <input type="file" id="photo" name="photo"><br><br>

    <button type="submit">Añadir Usuario</button>
</form>

</body>
</html>
