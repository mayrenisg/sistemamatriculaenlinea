<%-- 
    Document   : adminMatriLista
    Created on : 06/03/2025, 9:51:25 p. m.
    Author     : mayre
--%>

<%@page import="model.Matricula"%>
<%@page import="java.util.List"%>
<%@page import="dao.MatriculaDaoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Matrículas</title>
    <link rel="stylesheet" href="css/dashboards.css">
   <link rel="stylesheet" href="css/tablas.css">

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
            <form action="" method="POST">
                <p>Filtrar</p>
                <select name="filtro">
                    <option>Nombre</option>
                    <option>Materia</option>
                </select>
                <input type="text">
                <button>Buscar</button>
               <button type="submit">Mostrar Estudiantes</button>

            </form>
            <table>
                <thead>
                    <tr>
                        <th>Id de Matrícula</th>
                        <th>Fecha de Matrícula</th>
                        <th>Id de Materia</th>
                        <th>Nombre de Materia</th>
                        <th>Id de Estudiante</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                    </tr>
                </thead>
                <tbody>
                        <%
                            MatriculaDaoImpl leerMatricula = new MatriculaDaoImpl();
                            List<Matricula> listamatricula = leerMatricula.getAllMatriculas();
                            for(Matricula m : listamatricula){            
                         %>                     
      <tr>                           
    <td><%= m.getIdMatricula() %></td>
    <td><%= m.getFechaMatricula()%></td>
    <td><%= m.getIdMateria() %></td>
    <td><%= m.getNombreMateria() %></td>
    <td><%= m.getIdEstudiante() %></td>
    <td><%= m.getNombreEstudiante() %></td>
     <td><%=m.getApellidoEstudiante() %></td>
</tr>  
                            <% }%>                      
                </tbody>
            </table>
        </div>
    </main>
    <footer>
        <p>
            Copyright © 2025, Todos los derechos reservados | Desarrollado por Mayrenis Gómez
        </p>
    </footer>
</body>
</html>
