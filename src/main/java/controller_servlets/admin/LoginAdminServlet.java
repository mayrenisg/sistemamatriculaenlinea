package controller_servlets.admin;

import dao.AdministradorDaoImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author mayre
 */
@WebServlet(name = "LoginAdminServlet", urlPatterns = {"/LoginAdminServlet"})
public class LoginAdminServlet extends HttpServlet {
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        AdministradorDaoImpl admin = new AdministradorDaoImpl();
        HttpSession misesion = request.getSession();
        int id = admin.validarAdministrador(correo, contrasena);
        
         if (id>0) {
                  misesion.setAttribute("correo", correo);
                  misesion.setAttribute("id", id);
                  response.sendRedirect("adminDashboard.jsp");
         } else {
                misesion.setAttribute("mensaje", "Credenciales Incorrectas");
                response.sendRedirect("adminLogin.jsp");
                 }
         }     
}


