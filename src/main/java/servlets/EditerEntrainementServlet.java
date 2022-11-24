package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import classes.Entrainement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.EntrainementDAOimpl;

@WebServlet(name="entrainement-form", urlPatterns={"/entrainement/supprimer", "/entrainement/modifier", "/entrainement/ajouter"})

public class EditerEntrainementServlet extends HttpServlet {
    private EntrainementDAOimpl entrainementDAOimpl;
    private Entrainement unEntrainement = null;
    private Integer id_entrainement = null;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id_entrainement = null;
        entrainementDAOimpl = new EntrainementDAOimpl();
        if(req.getParameter("id")!=null){
            //Récupération de l'id passé en paramètre
            id_entrainement = Integer.parseInt(req.getParameter("id"));
            //Récupération du entrainement correspondant à l'id passé en paramètre
            unEntrainement = entrainementDAOimpl.getEntrainementById(id_entrainement);
        }

        if(req.getHttpServletMapping().getPattern().equals("/entrainement/supprimer")) {
            entrainementDAOimpl = new EntrainementDAOimpl();
            entrainementDAOimpl.supprimerEntrainement(id_entrainement);

            resp.sendRedirect("/entrainement/edit");
        }

        if(req.getHttpServletMapping().getPattern().equals("/entrainement/modifier")) {
            //page de modification
            String pageName = "/prive/modifierEntrainement.jsp";
            //On renvoie la requête
            req.setAttribute("entrainement", unEntrainement);
            req.getRequestDispatcher(pageName).forward(req, resp);
        }
        /*A rediriger direct sur le bouton*/
        if(req.getHttpServletMapping().getPattern().equals("/entrainement/ajouter")) {
            String pageName = "/prive/ajouterEntrainement.jsp";
            //On renvoie la requête
            req.getRequestDispatcher(pageName).forward(req, resp);
    }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Récupération des paramètres

        //id_entrainement
        if(req.getParameter("id_entrainement")!=null){
            int id_entrainement = Integer.parseInt(req.getParameter("id-entrainement"));
        }

        //date
        String date = req.getParameter("date-entrainement");
        //prenom
        String prenom = req.getParameter("joueursPrenom-entrainement");
        //nom
        String nom = req.getParameter("joueursNom-entrainement");
        //heure
        String heure = req.getParameter("heure-entrainement");
        //id_court
        String court = req.getParameter("court-entrainement");

        entrainementDAOimpl = new EntrainementDAOimpl();

        if(req.getHttpServletMapping().getPattern().equals("/entrainement/ajouter")) {
            //Création d'un entrainement
            //todo : verifier que l'entrainement n'existe pas déjà
            //todo : proposer des joueurs dans le formulaire
            //todo : proposer des courts dans le formulaire
            //todo : message d'erreur dans le formulaire
            entrainementDAOimpl.ajouterEntrainement(date, prenom, nom, heure, court);
        }
        if(req.getHttpServletMapping().getPattern().equals("/entrainement/modifier")) {
            //todo : message d'erreur dans le formulaire
            entrainementDAOimpl.updateEntrainement(id_entrainement, date, heure, court, prenom, nom);
        }

        resp.sendRedirect("/entrainement/edit");//sucess ?
    }
}
