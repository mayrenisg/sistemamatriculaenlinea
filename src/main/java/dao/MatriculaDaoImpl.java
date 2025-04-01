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
import model.Matricula;

public class MatriculaDaoImpl implements MatriculaDao {
    private Connection conexion;

    public MatriculaDaoImpl() {
        this.conexion = DbConnection.getInstance().getConnection();
    }
    
    @Override
    public List<Matricula> getAllMatriculas() {
        List<Matricula> matriculas = new ArrayList<>();
         String sql = "SELECT Mt.Id_Matricula, Mt.Fecha_Matricula, Mt.Id_Estudiante, E.Nombre1, E.Apellido1, Mr.Id_Materia ,Mr.Nombre FROM Matriculas Mt INNER JOIN Estudiantes E ON Mt.Id_Estudiante=E.Id_Estudiante INNER JOIN Materias Mr ON Mt.Id_Materia=Mr.Id_Materia";
         try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery( );
            while(rs.next()) {
                int idMatricula= rs.getInt("Id_Matricula");
                Date fechaMatricula = rs.getDate("Fecha_Matricula");
                int  idMateria= rs.getInt("Id_Materia");
                String nombreMateria = rs.getString("Nombre");
                int idEstudiante = rs.getInt("Id_Estudiante");
                String nombreEstudiante = rs.getString("Nombre1");
                String apellidoEstudiante = rs.getString("Apellido1");
      
                Matricula matricula = new Matricula(idMatricula, idMateria, nombreMateria, fechaMatricula, idEstudiante, nombreEstudiante,apellidoEstudiante);
                matriculas.add(matricula);
            }
            return matriculas;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }

    @Override
    public Matricula getMatricula(int idEstudiante) {
        String sql = "SELECT E.Nombre1, E.Apellido1, E.Cedula, E.Fecha_Nacimiento, E.Correo, E.Estado, C.Nombre FROM Estudiantes E INNER JOIN Carreras C ON E.Id_Carrera=C.Id_Carrera WHERE E.Id_Estudiante= ?" ;
         try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idEstudiante); 
            ResultSet rs = stmt.executeQuery( );
            if(rs.next()) {
                int idMatricula= rs.getInt("Id_Matricula");
                Date fechaMatricula = rs.getDate("Fecha_Matricula");
                int  idMateria= rs.getInt("Id_Materia");
                String nombreMateria = rs.getString("Nombre");
                String nombreEstudiante = rs.getString("Nombre1");
                String apellidoEstudiante = rs.getString("Apellido1");
                Matricula matricula = new Matricula(idMatricula, idMateria, nombreMateria, fechaMatricula, idEstudiante, nombreEstudiante,apellidoEstudiante);
                return matricula;    
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }

    @Override
    public void updateMatricula(Matricula matricula) {
    }

    @Override
    public void deleteMatricula(Matricula matricula) {
    }

    @Override
    public void deleteMatricula(int idEstudiante) {
        String sql = "DELETE Matriculas WHERE Id_Estudiante=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idEstudiante); 
            stmt.executeQuery( );
        } catch (SQLException e) {
            e.printStackTrace();
        }           
    }
    
}
