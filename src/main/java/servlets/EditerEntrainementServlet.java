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

@WebServlet(name = "entrainement-edit", value = "/entrainement/edit")

public class EditerEntrainementServlet extends HttpServlet {
    //GET REQUEST
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doProcess(request, response);

    }
    //POST REQUEST
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
    //doProcess
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //Création d'une instance du DAO EntrainementDAOimpl
        EntrainementDAOimpl entrainementDAO = new EntrainementDAOimpl();

        //initialisation de la liste des entrainements getAllEntrainement
        List<Entrainement> uneListeEntrainement = entrainementDAO.getAllEntrainement();

        //set attribut
        request.setAttribute("entrainement", uneListeEntrainement);
        request.setAttribute("editMod", true);

        this.getServletContext().getRequestDispatcher("/prive/listeEntrainement.jsp").forward(request, response);

    }

}
