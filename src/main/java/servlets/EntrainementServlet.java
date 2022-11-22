package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import models.JoueurDAOImpl;
import classes.Utilisateur;

@WebServlet (name = "entrainement", value = "/entrainement")

public class EntrainementServlet extends HttpServlet{
    //GET REQUEST
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //indique la vue à afficher
        System.out.println("entrainement Servlet doGet");
        this.getServletContext().getRequestDispatcher("/public/entrainement.jsp").forward(request, response);

    }
    //POST REQUEST
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

}
