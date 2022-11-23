package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import classes.Entraineur;
import classes.Joueur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.EntraineurDAOImpl;
import models.JoueurDAOImpl;

@WebServlet(name="joueur", urlPatterns={"/joueur/supprimer", "/joueur/modifier", "/joueur/ajouter"})
public class EditerJoueurServlet extends HttpServlet {
	
	private JoueurDAOImpl joueurDAO;
	private Joueur joueur=null;
	private Integer id_joueur=null;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id_joueur = null;
		joueurDAO = new JoueurDAOImpl();
		EntraineurDAOImpl entraineurDAO = new EntraineurDAOImpl();
		
		if(req.getParameter("id")!=null){
			//Récupération de l'id passé en paramètre
			id_joueur = Integer.parseInt(req.getParameter("id"));
			 //Récupération du joueur correspondant à l'id passé en paramètre
	        joueur = joueurDAO.getJoueurById(id_joueur);
		}
		
		if(req.getHttpServletMapping().getPattern().equals("/joueur/supprimer")) {
		
			joueurDAO.deleteJoueur(id_joueur);
			
			resp.sendRedirect("/joueurs/editer");
		}
		
		if(req.getHttpServletMapping().getPattern().equals("/joueur/modifier")) {
			
			
			List<Entraineur> entraineurs = entraineurDAO.getAllEntraineurs();
			req.setAttribute("entraineurs", entraineurs);
			
			String pageName = "/prive/modifierJoueurs.jsp";
	        //On renvoie la requête
			req.setAttribute("joueur", joueur);
	        req.getRequestDispatcher(pageName).forward(req, resp);
		}
		/*A rediriger direct sur le bouton*/
		if(req.getHttpServletMapping().getPattern().equals("/joueur/ajouter")) {
			List<Entraineur> entraineurs = entraineurDAO.getAllEntraineurs();

			req.setAttribute("entraineurs", entraineurs);
			
			String pageName = "/prive/ajouterJoueur.jsp";
	        //On renvoie la requête
	        req.getRequestDispatcher(pageName).forward(req, resp);
		}
	}
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		joueurDAO = new JoueurDAOImpl();
		String nom = req.getParameter("nom-joueur");
		String prenom = req.getParameter("prenom-joueur");
		String sexe = req.getParameter("sexe");
		String nationalite = req.getParameter("nationalite");
		
		
		if(req.getHttpServletMapping().getPattern().equals("/joueur/ajouter")) {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
			LocalDate dateN= LocalDate.parse("1998-06-06", formatter);
			LocalDate dateC= LocalDate.parse("2017-06-06", formatter);
			
			/*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			LocalTime dateC= LocalTime.parse("18:02:04", formatter);*/
			
			Joueur joueur = new Joueur(nom, prenom,sexe,nationalite,dateN,dateC);
			
			joueurDAO.createJoueur(joueur);
		}
		if(req.getHttpServletMapping().getPattern().equals("/joueur/modifier")) {
			Integer id_joueur = Integer.parseInt(req.getParameter("id"));
			
			joueur = joueurDAO.getJoueurById(id_joueur);
			
			joueur.setNom(nom);
			joueur.setPrenom(prenom);
			
			joueurDAO.updateJoueur(joueur);
		}
        
		resp.sendRedirect("/joueurs/editer");
    }
}
