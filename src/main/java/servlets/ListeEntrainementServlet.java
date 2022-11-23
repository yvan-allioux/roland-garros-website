package servlets;

import java.io.IOException;
import java.util.List;

import classes.Entrainement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import models.EntrainementDAOimpl;

@WebServlet (name = "entrainement", value = "/entrainement")

public class ListeEntrainementServlet extends HttpServlet{
    //GET REQUEST
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doProcess(request, response);

    }
    //POST REQUEST
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
    //doProcess
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EntrainementDAOimpl entrainementDAO = new EntrainementDAOimpl();
        List<Entrainement> uneListeEntrainement = entrainementDAO.getAllEntrainement();
        request.setAttribute("entrainement", uneListeEntrainement);
        request.setAttribute("editMod", false);
        this.getServletContext().getRequestDispatcher("/prive/listeEntrainement.jsp").forward(request, response);
    }

}
