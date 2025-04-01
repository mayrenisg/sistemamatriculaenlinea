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
import model.Estudiante;

/**
 *
 * @author mayre
 */
public class AdministradorDaoImpl implements AdministradorDao {
    private final Connection conexion;

    public AdministradorDaoImpl() {
        this.conexion = DbConnection.getInstance().getConnection();
    }
    
    @Override
    public int validarAdministrador(String correo, String contrasena) {
        String query = "SELECT Id_Admin AS id FROM Administradores WHERE correo = ? AND contrasena = ?";
        try {
                PreparedStatement preparedStatement = conexion.prepareStatement(query);
                preparedStatement.setString(1, correo);
                preparedStatement.setString(2, contrasena);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                            return resultSet.getInt("id");
                    }
            }catch (SQLException e) {
                    System.err.println("Error al validar usuario: " + e.getMessage());
            }
                return -1;
            }
}
