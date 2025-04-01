/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Progreso;

public class ProgresoDaoImpl implements ProgresoDao {
    private Connection conexion;

    public ProgresoDaoImpl() {
        this.conexion = DbConnection.getInstance().getConnection();
    }
    
    @Override
    public List<Progreso> getAllProgresos() {
        List<Progreso> progresos = null;
        String sql = "SELECT P.Id_Progreso, P.Id_Materia, M.Nombre, P.Cuatrimestre, P.Calificacion, P.Estado, E.Id_Estudiante, E.Nombre1, E.Apellido1 FROM Progreso_Estudiantes P INNER JOIN Estudiantes E ON E.Id_Estudiante=P.Id_Estudiante INNER JOIN Materias M ON M.Id_Materia = P.Id_Materia";
       try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery( );
            while(rs.next()) {
                int idProgreso= rs.getInt("Id_Progreso");
                int  idMateria= rs.getInt("Id_Materia");
                String nombreMateria = rs.getString("Nombre");
                int cuatrimestre = rs.getInt("Cuatrimestre");
                double calificacion = rs.getDouble("Calificacion");
                char estado = rs.getString("Estado").charAt(0);
                int idEstudiante = rs.getInt("Id_Estudiante");
                String nombreEstudiante = rs.getString("Nombre1");
                String apellidoEstudiante = rs.getString("Apellido1");
      
                Progreso progreso = new Progreso(idProgreso, idMateria, nombreMateria, cuatrimestre, calificacion, estado, idEstudiante, nombreEstudiante,apellidoEstudiante);
                progresos.add(progreso);
                return progresos;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }
    
    @Override
    public Progreso getProgreso(int idEstudiante) {
        String sql = "SELECT P.Id_Progreso, P.Id_Materia, M.Nombre, P.Cuatrimestre, P.Calificacion, P.Estado, E.Id_Estudiante, E.Nombre1, E.Apellido1 FROM Progreso_Estudiantes P INNER JOIN Estudiantes E ON E.Id_Estudiante=P.Id_Estudiante INNER JOIN Materias M ON M.Id_Materia = P.Id_Materia WHERE E.Id_Estudiante=?";
       try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idEstudiante); 
            ResultSet rs = stmt.executeQuery( );
            if(rs.next()) {
                int idProgreso= rs.getInt("Id_Progreso");
                int  idMateria= rs.getInt("Id_Materia");
                String nombreMateria = rs.getString("Nombre");
                int cuatrimestre = rs.getInt("Cuatrimestre");
                double calificacion = rs.getDouble("Calificacion");
                char estado = rs.getString("Estado").charAt(0);
                String nombreEstudiante = rs.getString("Nombre1");
                String apellidoEstudiante = rs.getString("Apellido1");
      
                Progreso progreso = new Progreso(idProgreso, idMateria, nombreMateria, cuatrimestre, calificacion, estado, idEstudiante, nombreEstudiante,apellidoEstudiante);
                return progreso;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }    

    @Override
    public void updateProgreso(Progreso progreso) {
    }

    @Override
    public void deleteProgreso(Progreso progreso) {
    }

    @Override
    public void deleteProgreso(int idEstudiante) {
        String sql = "DELETE Progreso_Estudiantes WHERE Id_Estudiante=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idEstudiante); 
            stmt.executeQuery( );
        } catch (SQLException e) {
            e.printStackTrace();
        }           
    }
    
}
