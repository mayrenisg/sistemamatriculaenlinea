<%-- 
    Document   : adminEstLista
    Created on : 06/03/2025, 9:51:25 p. m.
    Author     : mayre
--%>

<%@page import="model.Estudiante"%>
<%@page import="java.util.List"%>
<%@page import="dao.EstudianteDaoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Estudiantes</title>
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
            <form action="AdminEstListaServlet" method="POST">
                <p>Filtrar por Cédula (Escribir sin Guiones)</p>
                <input type="text" required id="cedula">
                <button type="submit">Buscar</button>

            </form>
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Cédula</th>
                        <th>Fecha de Nacimiento</th>
                        <th>Correo Electrónico</th>
                        <th>Estado</th>
                        <th>Carrera</th>
                    </tr>
                </thead>
                <tbody>
                          <%EstudianteDaoImpl leerEst = new EstudianteDaoImpl();
                            List<Estudiante> listaest = leerEst.getAllEstudiantes();
                            for(Estudiante e : listaest){            
                         %>  
<tr>                           
    <td><%= e.getId() %></td>
    <td><%= e.getNombre() %></td>
    <td><%= e.getApellido() %></td>
    <td><%= e.getCedula() %></td>
    <td><%= e.getNacimiento() %></td>
     <td><%= e.getCorreo() %></td>
     <td><%= e.getCarrera() %></td>
     <td><%= e.getEstado() %></td>
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
