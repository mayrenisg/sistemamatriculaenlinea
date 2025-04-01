/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author mayre
 */
public class Estudiante {
    private int id; 
    private String nombre;
    private String apellido;
    private String cedula;
    private Date nacimiento;
    private String correo;
    private char estado;
    private String carrera;

    public Estudiante() {
    }

    public Estudiante(int id, String nombre, String apellido, String cedula,Date nacimiento, String correo, char estado, String carrera) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.nacimiento = nacimiento;
        this.correo = correo;
        this.estado = estado;
        this.carrera = carrera;
    }
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public char getEstado() {
        return estado;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    
    
    
}
