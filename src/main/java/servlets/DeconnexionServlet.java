package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet (name = "deconnexion", value = "/deconnexion")



public class DeconnexionServlet extends HttpServlet{
    //GET REQUEST
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    //supression de la session
    HttpSession session = request.getSession();
    session.invalidate();
    //redirection vers la page d'accueil
    response.sendRedirect(request.getContextPath() + "/home");

    }
    //POST REQUEST
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }




}
