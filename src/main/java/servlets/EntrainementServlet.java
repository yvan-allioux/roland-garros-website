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

public class EntrainementServlet extends HttpServlet{
    //GET REQUEST
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doProcess(request, response);

    }
    //POST REQUEST
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {



    }
    //doProcess
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //indique la vue à afficher
        //System.out.println("entrainement Servlet doProcess");

        //Création d'une instance du DAO EntrainementDAOimpl
        EntrainementDAOimpl entrainementDAO = new EntrainementDAOimpl();

        //test si l'entrainement existe
        //System.out.println("entrainement existe 1 : "+ entrainementDAO.entrainementExiste("1"));
        //System.out.println("entrainement existe 7 : "+ entrainementDAO.entrainementExiste("7"));

        //affichage de la l'oraires de l'entrainement
        //System.out.println("entrainement horaire 1 : "+ entrainementDAO.getHoraire("1"));

        //affichage de la date de l'entrainement
        //System.out.println("entrainement date 1 : "+ entrainementDAO.getDate("1"));

        //joueur de l'entrainement
        //System.out.println("entrainement joueur 1 : "+ entrainementDAO.getIdJoueur("1"));

        //court de l'entrainement
        //System.out.println("entrainement court 1 : "+ entrainementDAO.getIdCourt("1"));

        //initialisation de la liste des entrainements getAllEntrainement
        List<Entrainement> uneListeEntrainement = entrainementDAO.getAllEntrainement();

        //affichage du contenu de la liste des entrainements
        /*for (Entrainement unEntrainement : uneListeEntrainement) {
            System.out.println("entrainement liste : "+ unEntrainement.getId());
        }*/

        //set attribut
        request.setAttribute("entrainement", uneListeEntrainement);

        //Récupération de tous les Entrainement dans listeEntrainement
        //List<Entrainement> listeEntrainement = entrainementDAO.getAllEntrainement();
        //set listeEntrainement en attribut de la requête
        //request.setAttribute("listeEntrainement", listeEntrainement);


        this.getServletContext().getRequestDispatcher("/prive/listeEntrainement.jsp").forward(request, response);

    }

}
