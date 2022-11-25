package servlets;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import classes.Match;
import classes.Score;
import classes.Joueur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.MatchDAOimpl;
import models.ScoreDAOimpl;
import models.JoueurDAOimpl;

@WebServlet("/match/finaliser")
public class FinaliserMatchServlet extends HttpServlet{
	
	private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

	private MatchDAOimpl matchDAO = new MatchDAOimpl();
	private Match match=null;
	
	private ScoreDAOimpl scoreDAO = new ScoreDAOimpl();
	private JoueurDAOimpl joueurDAO = new JoueurDAOimpl();
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id_match = null;

		if(req.getParameter("id")!=null){
			//Récupération de l'id passé en paramètre
			id_match = Integer.parseInt(req.getParameter("id"));
			 //Récupération du joueur correspondant à l'id passé en paramètre
	        match = matchDAO.getMatchById(id_match);
		}
		List<Joueur> joueurs = joueurDAO.getAllJoueurs();
		
		req.setAttribute("match", match);
		req.setAttribute("joueurs", joueurs);
		String pageName = "/prive/finaliserMatch.jsp";
        //On renvoie la requête
        req.getRequestDispatcher(pageName).forward(req, resp);
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id_match = Integer.parseInt(req.getParameter("id"));
		Joueur gagnant = joueurDAO.getJoueurById(Integer.parseInt(req.getParameter("gagnant")));

		LocalTime temps = LocalTime.parse(req.getParameter("temps"), timeFormatter);
		Integer nb_sets = Integer.parseInt(req.getParameter("nbSets"));
		Integer nb_jeux = Integer.parseInt(req.getParameter("nbJeux"));
		
		
		Integer lastId = scoreDAO.getLastScoreId();
		Score score = new Score(lastId+1,nb_sets,nb_jeux,temps);
		
		scoreDAO.createScoreWithId(score);
		
		match = matchDAO.getMatchById(id_match);
		
		match.setScore(score);
		match.setGagnant(gagnant);
		matchDAO.finaliserMatch(match);
	
		resp.sendRedirect("/matchs/editer");
	}
	
	
}
