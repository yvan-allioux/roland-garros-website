package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import classes.Joueur;
import classes.Match;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.MatchDAOimpl;
import models.JoueurDAOimpl;

@WebServlet(name="match", urlPatterns={"/match/supprimer", "/match/modifier", "/match/ajouter"})
public class EditerMatchServlet extends HttpServlet{
	
	private MatchDAOimpl matchDAO = new MatchDAOimpl();
	private Match match=null;
	private Integer id_joueur=null;
	private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
	private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id_match = null;

		if(req.getParameter("id")!=null){
			//Récupération de l'id passé en paramètre
			id_match = Integer.parseInt(req.getParameter("id"));
			 //Récupération du joueur correspondant à l'id passé en paramètre
	        match = matchDAO.getMatchById(id_match);
	        System.out.println(match.getCourt());
		}
		
		if(req.getHttpServletMapping().getPattern().equals("/match/supprimer")) {
		
			//match.deleteJoueur(id_joueur);
			
			//resp.sendRedirect("/matchs/editer");
		}
		
		if(req.getHttpServletMapping().getPattern().equals("/match/modifier")) {
			
			JoueurDAOimpl joueurDAO = new JoueurDAOimpl();
			List<Joueur> joueurs = joueurDAO.getAllJoueurs();
			String pageName = "/prive/modifierMatch.jsp";
	        //On renvoie la requête
			req.setAttribute("match", match);
			req.setAttribute("joueurs", joueurs);
	        req.getRequestDispatcher(pageName).forward(req, resp);
		}
		/*A rediriger direct sur le bouton*/
		if(req.getHttpServletMapping().getPattern().equals("/match/ajouter")) {
			
			String pageName = "/prive/ajouterMatch.jsp";
	        //On renvoie la requête
	        req.getRequestDispatcher(pageName).forward(req, resp);
		}
	}
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*String nom = req.getParameter("nom-joueur");
		String prenom = req.getParameter("prenom-joueur");
		String sexe = req.getParameter("sexe");
		String nationalite = req.getParameter("nationalite");
		String main = req.getParameter("main");
		Integer taille = Integer.parseInt(req.getParameter("taille"));
		Float poids = Float.parseFloat(req.getParameter("poids"));
		LocalDate ddc = LocalDate.parse(req.getParameter("ddc"), dateFormatter);
		LocalDate ddn = LocalDate.parse(req.getParameter("ddn"), dateFormatter);
		String ldn = req.getParameter("ldn");
		
		EntraineurDAOimpl entraineurDAO
		   = new EntraineurDAOimpl();
		Entraineur entraineur = entraineurDAO.getEntraineurById(Integer.parseInt(req.getParameter("entraineur")));
		
		if(req.getHttpServletMapping().getPattern().equals("/joueur/ajouter")) {
			
			Joueur joueur = new Joueur(nom,prenom,sexe,entraineur,ddn,ldn,nationalite,taille,poids,main,ddc);
			
			joueurDAO.createJoueur(joueur);
		}
		if(req.getHttpServletMapping().getPattern().equals("/joueur/modifier")) {
			Integer id_joueur = Integer.parseInt(req.getParameter("id"));
			
			joueur = joueurDAO.getJoueurById(id_joueur);
			
			joueur.setNom(nom);
			joueur.setPrenom(prenom);
			joueur.setEntraineur(entraineur);
			joueur.setMain(main);
			joueur.setSexe(sexe);
			joueur.setNationalite(nationalite);
			joueur.setDateCarriere(ddc);
			joueur.setLieuNaissance(ldn);
			joueur.setDateNaissance(ddn);
			joueur.setPoids(poids);
			joueur.setTaille(taille);
			
			joueurDAO.updateJoueur(joueur);
		}
        
		resp.sendRedirect("/joueurs/editer");*/
    }

}
