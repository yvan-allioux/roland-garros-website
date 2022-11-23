package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import classes.Entrainement;
import classes.Joueur;
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
            System.out.println("id entrainement : " + id_entrainement);
            //Récupération du joueur correspondant à l'id passé en paramètre
            unEntrainement = entrainementDAOimpl.getEntrainementById(id_entrainement);
        }

        if(req.getHttpServletMapping().getPattern().equals("/entrainement/supprimer")) {

            //entrainementDAOimpl.deleteEntrainement(id_entrainement);

            resp.sendRedirect("/entrainement/editer");
        }

        if(req.getHttpServletMapping().getPattern().equals("/entrainement/modifier")) {

            String pageName = "/prive/modifierEntrainement.jsp";
            //On renvoie la requête
            req.setAttribute("entrainement", unEntrainement);
            req.getRequestDispatcher(pageName).forward(req, resp);
        }
        /*A rediriger direct sur le bouton*/
        if(req.getHttpServletMapping().getPattern().equals("/entrainement/ajouter")) {

            String pageName = "/prive/modifierEntrainement.jsp";
            //On renvoie la requête
            req.getRequestDispatcher(pageName).forward(req, resp);
        }


		/*
		PrintWriter out = resp.getWriter();
		out.print(id_joueur);
		out.print(req.getHttpServletMapping().getPattern());*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        entrainementDAOimpl = new EntrainementDAOimpl();
        String nom = req.getParameter("nom-entrainement");
        String prenom = req.getParameter("prenom-entrainement");

        if(req.getHttpServletMapping().getPattern().equals("/entrainement/ajouter")) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
            LocalDate dateN= LocalDate.parse("1998-06-06", formatter);
            LocalDate dateC= LocalDate.parse("2017-06-06", formatter);

            Joueur joueur = new Joueur(nom, prenom,"H", "Français",dateN,dateC);

            //entrainementDAOimpl.createEntrainement(joueur);
        }
        if(req.getHttpServletMapping().getPattern().equals("/entrainement/modifier")) {
            Integer id_joueur = Integer.parseInt(req.getParameter("id"));

            unEntrainement = entrainementDAOimpl.getEntrainementById(id_joueur);

            //unEntrainement.setNom(nom);
            //unEntrainement.setPrenom(prenom);

            //entrainementDAOimpl.updateEntrainement(unEntrainement);
        }

        resp.sendRedirect("/entrainement/editer");
    }
}
