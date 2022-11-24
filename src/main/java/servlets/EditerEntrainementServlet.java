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
            //todo
            System.out.println("SUPPRIMER");
            resp.sendRedirect("/entrainement/editer");
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
            //todo
            String pageName = "/prive/modifierEntrainement.jsp";
            //On renvoie la requête
            req.getRequestDispatcher(pageName).forward(req, resp);
    }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Récupération des paramètres

        //id_entrainement
        int id_entrainement = Integer.parseInt(req.getParameter("id-entrainement"));
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


        String prenomJOUEURentrainement = req.getParameter("prenom-entrainement");


        entrainementDAOimpl = new EntrainementDAOimpl();

        if(req.getHttpServletMapping().getPattern().equals("/entrainement/ajouter")) {
            //todo
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
            LocalDate dateN= LocalDate.parse("1998-06-06", formatter);
            LocalDate dateC= LocalDate.parse("2017-06-06", formatter);



        }
        if(req.getHttpServletMapping().getPattern().equals("/entrainement/modifier")) {
            entrainementDAOimpl.updateEntrainement(id_entrainement, date, heure, court, prenom, nom);
        }

        resp.sendRedirect("/entrainement/edit");//sucess ?
    }
}
