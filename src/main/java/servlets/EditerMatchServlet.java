package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import classes.Court;
import classes.Joueur;
import classes.Match;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.MatchDAOimpl;
import models.CourtDAOimpl;
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
		}
		
		if(req.getHttpServletMapping().getPattern().equals("/match/supprimer")) {
			matchDAO.deleteMatch(id_match);
			resp.sendRedirect("/matchs/editer");
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
		
		JoueurDAOimpl joueurDAO = new JoueurDAOimpl();
		CourtDAOimpl courtDAO = new CourtDAOimpl();
		
		Joueur joueur1 = joueurDAO.getJoueurById(Integer.parseInt(req.getParameter("joueur1")));
		Joueur joueur2 = joueurDAO.getJoueurById(Integer.parseInt(req.getParameter("joueur2")));
		LocalDate ddm = LocalDate.parse(req.getParameter("ddm"), dateFormatter);
		LocalTime hdm = LocalTime.parse("16:00:00", timeFormatter);
		Court court = courtDAO.getCourtById(Integer.parseInt(req.getParameter("court")));
		
		if(req.getHttpServletMapping().getPattern().equals("/joueur/ajouter")) {
			
			Match match = new Match(ddm,hdm,court,joueur1,joueur2);
			
			matchDAO.createMatch(match);
		}
		if(req.getHttpServletMapping().getPattern().equals("/joueur/modifier")) {
			Integer id_match = Integer.parseInt(req.getParameter("id"));
			
			match = matchDAO.getMatchById(id_match);
			
			match.setHeure(hdm);
			match.setDate(ddm);
			match.setJoueur1(joueur1);
			match.setJoueur2(joueur2);
		
			matchDAO.updateMatch(match);
		}   
		resp.sendRedirect("/matchs/editer");
    }
}
