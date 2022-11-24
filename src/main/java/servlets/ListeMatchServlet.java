package servlets;

import classes.Match;
import models.MatchDAOimpl;
import java.io.IOException;

import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet (name="matchs",urlPatterns={"/matchs/editer", "/matchs"})
public class ListeMatchServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
	       
        //Création d'une instance du DAO des matchs
        MatchDAOimpl matchDAO = new MatchDAOimpl();
        
        //Récupération des matchs
        List<Match> listeMatchsP = matchDAO.getAllMatchsPasses();
        List<Match> listeMatchsPP = matchDAO.getAllMatchsPasPasses();
      
        req.setAttribute("matchsPasses", listeMatchsP);
        req.setAttribute("matchsPasPasses", listeMatchsPP);
        
        if(req.getHttpServletMapping().getPattern().equals("/matchs")) {
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/public/matchs.jsp");
        	rd.forward(req, resp);
        }else if(req.getHttpServletMapping().getPattern().equals("/matchs/editer")) {
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/prive/listeMatchs.jsp");
        	rd.forward(req, resp);
        }
	} 
	
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) {
		
		
		
	}
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Création d'une instance du DAO des matchs
        MatchDAOimpl matchDAO = new MatchDAOimpl();
        
        	 List<Match> listeMatchs = matchDAO.getAllMatchs();
        	 req.setAttribute("matchs", listeMatchs);
        
        //On stocke le chemin vers le fichier correspondant à la vue pour la liste des matchs
        String pageName = "/prive/listeMatchs.jsp";
        //On renvoie la requête 
        req.getRequestDispatcher(pageName).forward(req, resp);
    }
	
	

}
