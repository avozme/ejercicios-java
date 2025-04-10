<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hola mundo con JSP</title>
</head>
<body>
    <h1>Hola, mundo</h1>
    <p>Soy un archivo JSP servido a través de un servidor Tomcat.</p>
    <p>Ejemplo de llamada a la API estándar de Java:
       voy a generar un número aleatorio entre 0 y 99 -->
       <% 
           out.println("<span style='font-size: 150%; color: red'>" + (int)(Math.random()*100) + "</span>");
        %>
    </p>
    <p>Ejemplo de bucle for:</p>
    <ul>
        <%
            for (int i = 1; i <= 10; i++) {
                out.println("<li>Contador = " + i + "</li>");
            }
        %>
</body>
</html>