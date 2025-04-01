<%-- 
    Document   : estudianteLogin
    Created on : 03/03/2025, 10:04:01 p. m.
    Author     : mayre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%   String mensaje = (String) request.getSession().getAttribute("mensaje");
        if(mensaje ==null) {
            mensaje="";
    }              
 %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de Sesión</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
    <header>
        <img class="logo" src="images/logoitse.png">
    </header>

    <section>
            <form class="login" action="LoginEstudianteServlet" method="POST">
                <h2>Inicio de Sesión - Estudiantes</h2>
                <label>Correo Electrónico
                    <input type="email" name="correo" required>
                </label> <br>
                <label>Contraseña
                    <input type="password" name="contrasena" required>
                </label> <br>
                <p><%=mensaje%></p><br>
                
                <button class="acceso" type="submit">Acceder</button><br>
                <a href="adminLogin.jsp">Iniciar Sesión como Administrador</a>
            </form>
    </section>

    <footer>
        <p>
            Copyright © 2025, Todos los derechos reservados | Desarrollado por Mayrenis Gómez
        </p>
    </footer>
</body>
</html>
