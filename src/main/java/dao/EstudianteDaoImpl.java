/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.DbConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Estudiante;

public class EstudianteDaoImpl implements EstudianteDao {
    private final Connection conexion;

    public EstudianteDaoImpl() {
        this.conexion = DbConnection.getInstance().getConnection();
        System.out.println("Conexión en EstudianteDaoImpl: " + this.conexion);
    }
    
    @Override
    public List<Estudiante> getAllEstudiantes() {
          List<Estudiante> estudiantes = new ArrayList<>();
         String sql = "SELECT E.Id_Estudiante, E.Nombre1, E.Apellido1, E.Cedula, E.Fecha_Nacimiento, E.Correo, E.Estado, C.Nombre FROM Estudiantes E INNER JOIN Carreras C ON E.Id_Carrera=C.Id_Carrera";
         try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery( );
            while(rs.next()) {
                int id = rs.getInt("Id_Estudiante");
                String nombre = rs.getString("Nombre1");
                String apellido = rs.getString("Apellido1");
                String cedula = rs.getString("Cedula");
                Date fechaNacimiento = rs.getDate("Fecha_Nacimiento");
                String correo = rs.getString("Correo");
                char estado = rs.getString("Estado").charAt(0);
                String carrera = rs.getString("Nombre");
                Estudiante estudiante = new Estudiante(id,nombre,apellido,cedula,fechaNacimiento,correo,estado,carrera);
                estudiantes.add(estudiante);
            }
            return estudiantes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }

    @Override
    public Estudiante getEstudiante(int id) {
        String sql = "SELECT E.Nombre1, E.Apellido1, E.Cedula, E.Fecha_Nacimiento, E.Correo, E.Estado, C.Nombre FROM Estudiantes E INNER JOIN Carreras C ON E.Id_Carrera=C.Id_Carrera WHERE E.Id_Estudiante= ?" ;
         try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);  
            ResultSet rs = stmt.executeQuery( );
            if(rs.next()) {
                String nombre = rs.getString("Nombre1");
                String apellido = rs.getString("Apellido1");
                String cedula = rs.getString("Cedula");
                Date fechaNacimiento = rs.getDate("Fecha_Nacimiento");
                String correo = rs.getString("Correo");
                char estado = rs.getString("Estado").charAt(0);
                String carrera = rs.getString("Nombre");
                Estudiante estudiante = new Estudiante(id,nombre,apellido,cedula,fechaNacimiento,correo,estado,carrera);
                return estudiante;    
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }

    @Override
    public Estudiante getEstudiante(String cedula) {
        String sql = "SELECT E.Nombre1, E.Apellido1, E.Cedula, E.Fecha_Nacimiento, E.Correo, E.Estado, C.Nombre FROM Estudiantes E INNER JOIN Carreras C ON E.Id_Carrera=C.Id_Carrera WHERE Cedula= ?" ;
         try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, cedula);
            ResultSet rs = stmt.executeQuery( );
            if(rs.next()) {
                int id = rs.getInt("Id_Estudiante");
                String nombre = rs.getString("Nombre1");
                String apellido = rs.getString("Apellido1");
                Date fechaNacimiento = rs.getDate("Fecha_Nacimiento");
                String correo = rs.getString("Correo");
                char estado = rs.getString("Estado").charAt(0);
                String carrera = rs.getString("Nombre");
                Estudiante estudiante = new Estudiante(id,nombre,apellido,cedula,fechaNacimiento,correo,estado,carrera);
                return estudiante;    
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }

    @Override
    public void updateEstudiante(Estudiante student) {
    }

    @Override
    public void deleteEstudiante(Estudiante student) {
    }

    @Override
    public void deleteEstudiante(int id) {
        String sql = "DELETE Estudiantes WHERE Id_Estudiante=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id); 
            stmt.executeQuery( );
        } catch (SQLException e) {
            e.printStackTrace();
        }           
    }
    
   @Override
    public Estudiante validarEstudiante(String correo, String contrasena) {
        String query = "SELECT Id_Estudiante FROM Estudiantes WHERE correo = ? AND contrasena = ?";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setString(1, correo);
            preparedStatement.setString(2, contrasena);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) { 
                int id = resultSet.getInt("Id_Estudiante");
                return this.getEstudiante(id); // Obtener detalles completos del estudiante
            }
            } catch (SQLException e) {
            System.err.println("Error al validar usuario: " + e.getMessage());
            }
            return null;
            }
    
    
    @Override
    public int contarActivos() {
        String query = "SELECT COUNT(*) as activos from Estudiantes where Estado = 'A'";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) { 
                int total = resultSet.getInt("activos");
                return total;
            }
            } catch (SQLException e) {
            System.err.println("Error al validar usuario: " + e.getMessage());
            }
            return 0;
     }
    
    @Override
    public int contarMatriculados() {
        String query = "SELECT COUNT(*) AS matricula FROM Matriculas WHERE Fecha_Matricula BETWEEN '2025-02-05' AND '2025-02-10'";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) { 
                int total = resultSet.getInt("matricula");
                return total;
            }
            } catch (SQLException e) {
            System.err.println("Error al validar usuario: " + e.getMessage());
            }
            return -1;
     }
}
