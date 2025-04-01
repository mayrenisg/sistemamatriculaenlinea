package controller_servlets.student;

import dao.EstudianteDaoImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Estudiante;

/**
 *
 * @author mayre
 */
@WebServlet(name = "LoginEstudianteServlet", urlPatterns = {"/LoginEstudianteServlet"})

public class LoginEstudianteServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        EstudianteDaoImpl estudianteDao = new EstudianteDaoImpl();
        Estudiante estudiante= estudianteDao.validarEstudiante(correo, contrasena);
        
        HttpSession misesion = request.getSession();
         if (estudiante != null) {
                 misesion.setAttribute("estudiante", estudiante);
                 
                 response.sendRedirect("estudianteDashboard.jsp");
         } else {
                misesion.setAttribute("mensaje", "Credenciales Incorrectas");
                response.sendRedirect("estudianteLogin.jsp");
                 }
         }   
}


