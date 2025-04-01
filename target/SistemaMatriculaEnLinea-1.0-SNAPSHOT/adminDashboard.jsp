<%-- 
    Document   : estudianteDashboard
    Created on : 03/03/2025, 9:51:25 p. m.
    Author     : mayre
--%>

<%@page import="dao.EstudianteDaoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String correo = (String) request.getSession().getAttribute("correo");
    int id = (int) request.getSession().getAttribute("id");
    if (correo == null || id<0) {
    response.sendRedirect("login.jsp");
    }
    EstudianteDaoImpl estudiante = new EstudianteDaoImpl();
    int activos = estudiante.contarActivos();
    int matricula = estudiante.contarMatriculados();    
%>  

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página Principal - Administradores</title>
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
                    <li><a href="adminDashboard.jsp">Inicio</a></li>
                    <li><a href="adminEstLista.jsp">Estudiantes</a></li>
                    <li><a href="adminMatriLista.jsp">Matrículas</a></li>
                    <li><a href="">Cerrar Sesión</a></li>
                </ul>
            </nav>
        </aside>
        <div class="contenido">
             <h2>Bienvenido</h2>
            <p>Correo Electrónico <%=correo%></p>
            <p>Id: <%=id%></p>
            <p>Periodo Académico: II del 2025</p>
            <p>Inicio de Matrícula: 5-2-2025</p>
            <p>Fin de Matrícula: 10-2-2025</p>

            <p>Estudiantes Matriculados: <%=matricula%></p>
            <p>Estudiantes Activos: <%=activos%></p>
            
             
        </div>
    </main>
    <footer>
        <p>
            Copyright © 2025, Todos los derechos reservados | Desarrollado por Mayrenis Gómez
        </p>
    </footer>
</body>
</html>
