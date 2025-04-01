/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Progreso;

/**
 *
 * @author mayre
 */
public interface ProgresoDao {
    public List<Progreso> getAllProgresos();
    public Progreso getProgreso(int idEstudiante);
    public void updateProgreso(Progreso progreso);
    public void deleteProgreso(Progreso progreso);
    public void deleteProgreso(int idEstudiante);
}
