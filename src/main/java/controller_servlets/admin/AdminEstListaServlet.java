/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller_servlets.admin;

import dao.EstudianteDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Estudiante;

/**
 *
 * @author mayre
 */
@WebServlet(name = "AdminEstListaServlet", urlPatterns = {"/AdminEstListaServlet"})
public class AdminEstListaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cedula = request.getParameter("cedula");
        EstudianteDaoImpl estudianteDao = new EstudianteDaoImpl();
        Estudiante estudiante= estudianteDao.getEstudiante(cedula);
        
    }
}
