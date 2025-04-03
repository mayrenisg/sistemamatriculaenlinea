/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static DbConnection instancia;
    private Connection conexion;
    
    private final String url = "jdbc:sqlserver://localhost:1433;databaseName=xxxxxxx;user=xxxxx;password=xxxx;encrypt=true;trustServerCertificate=true";
    private final String usuario = "xx";
    private final String contrasena= "xxxxx";
    
    private DbConnection(){
        if (conexion == null) { 
           try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
                conexion = DriverManager.getConnection(url, usuario, contrasena);
                System.out.println("Conexión exitosa");
            } catch (ClassNotFoundException e) {
                System.err.println("ERROR: No se encontró el driver de SQL Server.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("ERROR: No se pudo conectar a la base de datos.");
                e.printStackTrace();
            }
        }
    }
    
    public static DbConnection getInstance() {
        if (instancia == null) {
            instancia = new DbConnection();
        }
        return instancia;
    }

    public Connection getConnection() {
        return conexion;
    }

    public void closeConnection() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
