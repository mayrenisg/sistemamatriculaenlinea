/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Matricula;

/**
 *
 * @author mayre
 */
public interface MatriculaDao {
    public List<Matricula> getAllMatriculas();
    public Matricula getMatricula(int idEstudiante);
    public void updateMatricula(Matricula matricula);
    public void deleteMatricula(Matricula matricula);
    public void deleteMatricula(int idEstudiante);
}
