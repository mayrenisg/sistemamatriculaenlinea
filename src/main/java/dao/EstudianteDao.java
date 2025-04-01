/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Estudiante;

/**
 *
 * @author mayre
 */
public interface EstudianteDao {
    public List<Estudiante> getAllEstudiantes();
    public Estudiante getEstudiante(int id);
    public Estudiante getEstudiante(String cedula);
    public void updateEstudiante(Estudiante student);
    public void deleteEstudiante(Estudiante student);
    public void deleteEstudiante(int id);
    public Estudiante validarEstudiante(String correo, String contrasena);
    public int contarMatriculados();
    public int contarActivos();
}
