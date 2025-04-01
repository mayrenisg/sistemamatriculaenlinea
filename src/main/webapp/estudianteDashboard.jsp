<%-- 
    Document   : estudianteDashboard
    Created on : 03/03/2025, 9:51:25 p. m.
    Author     : mayre
--%>

<%@page import="model.Estudiante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%Estudiante estudiante = (Estudiante) session.getAttribute("estudiante");%>
<% String nombre="";
if (estudiante != null) {
    nombre= estudiante.getNombre(); 
    }else{
                 response.sendRedirect("estudianteLogin.jsp");
    }
%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página Principal - Estudiantes</title>
    <link rel="stylesheet" href="css/dashboards.css">
</head>
<body>
    <header>
        <img class="logo" src="images/logoitse.png">
    </header>
    <main>
        <aside>
            <nav>
                <ul>
                    <li><a href="">Inicio</a></li>
                    <li><a href="">Matrícula</a></li>
                    <li><a href="">Historial Académico</a></li>
                    <li><a href="">Mi Perfil</a></li>
                    <li><a href="">Cerrar Sesión</a></li>
                </ul>
            </nav>
        </aside>
        <div class="contenido">
            
             <h2>Bienvenido</h2>
            <p>Nombre: <%=nombre%></p>
            <p>Id:</p>
            <p>Periodo Académico: </p>
            <p>Materias Cursadas: </p>
            <p>Materias Aprobadas: </p>
            <p>Materias Desaprobadas: </p>
            
             
        </div>
    </main>
    <footer>
        <p>
            Copyright © 2025, Todos los derechos reservados | Desarrollado por Mayrenis Gómez
        </p>
    </footer>
</body>
</html>
