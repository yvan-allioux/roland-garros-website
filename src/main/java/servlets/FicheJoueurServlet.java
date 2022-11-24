package servlets;

import java.io.IOException;

import classes.Joueur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.JoueurDAOimpl;

@WebServlet ("/joueur")
public class FicheJoueurServlet extends HttpServlet {
	
	private Joueur joueur;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id_joueur = Integer.parseInt(req.getParameter("id"));
		
		JoueurDAOimpl joueurDAO = new JoueurDAOimpl();
		joueur = joueurDAO.getJoueurById(id_joueur);
		
		req.setAttribute("joueur", joueur);
		
		String pageName = "/public/ficheJoueur.jsp";
        
        req.getRequestDispatcher(pageName).forward(req, resp);
		
		
	}

}
