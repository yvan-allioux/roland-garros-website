package servlets;

import classes.Match;
import models.MatchDAOImpl;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet ("/matchs/editer")
public class ListeMatchServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		this.doProcess(req, resp);
        
	} 
	
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) {
		
		resp.setContentType("text/html");
       
        //Création d'une instance du DAO des matchs
        MatchDAOImpl matchDAO = new MatchDAOImpl();
        //Récupération de tous les matchs dans listeMatchs
        List<Match> listeMatchs = matchDAO.getAllMatchs();
        
        req.setAttribute("matchs", listeMatchs);
        
        String pageName = "/prive/listeMatchs.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        
        try {
            rd.forward(req, resp);

      } catch (ServletException e) {

            e.printStackTrace();

      } catch (IOException e) {

            e.printStackTrace();


      }
		
	}
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Création d'une instance du DAO des matchs
        MatchDAOImpl matchDAO = new MatchDAOImpl();
        
        	 List<Match> listeMatchs = matchDAO.getAllMatchs();
        	 req.setAttribute("matchs", listeMatchs);
        
        //On stocke le chemin vers le fichier correspondant à la vue pour la liste des matchs
        String pageName = "/prive/listeMatchs.jsp";
        //On renvoie la requête 
        req.getRequestDispatcher(pageName).forward(req, resp);
    }
	
	

}
