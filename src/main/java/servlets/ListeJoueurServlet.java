package servlets;

import classes.Joueur;
import models.JoueurDAOImpl;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet ("/joueurs")
public class ListeJoueurServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		this.doProcess(req, resp);
        
	} 
	
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) {
		
		resp.setContentType("text/html");
       
        //Création d'une instance du DAO des jouers
        JoueurDAOImpl joueurDAO = new JoueurDAOImpl();
        //Récupération de tous les joueurs dans listeJoueurs
        List<Joueur> listeJoueurs = joueurDAO.getListeJoueurs();
        
        req.setAttribute("joueurs", listeJoueurs);
        
        String pageName = "/prive/listeJoueurs.jsp";
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
		
		//Création d'une instance du DAO des jouers
        JoueurDAOImpl joueurDAO = new JoueurDAOImpl();

        if (req.getParameter("btn-homme") != null) { //Si le bouton "Homme" a été cliqué
        	 List<Joueur> listeJoueurs = joueurDAO.getAllJoueursBySexe("H");
        	 req.setAttribute("joueurs", listeJoueurs);
        } else if (req.getParameter("btn-femme") != null) { //Si le bouton "Femme" a été cliqué
        	List<Joueur> listeJoueurs = joueurDAO.getAllJoueursBySexe("F");
        	req.setAttribute("joueurs", listeJoueurs);
        } else if (req.getParameter("btn-classement") != null) { //Si le bouton "Classement" a été cliqué
        	List<Joueur> listeJoueurs = joueurDAO.getAllJoueursOrderedByClassement();
        	req.setAttribute("joueurs", listeJoueurs);
        } else if (req.getParameter("btn-nom") != null) { //Si le bouton "Nom" a été cliqué
        	List<Joueur> listeJoueurs = joueurDAO.getAllJoueursOrderedByNom();
        	req.setAttribute("joueurs", listeJoueurs);
        } else {
        	 List<Joueur> listeJoueurs = joueurDAO.getAllJoueurs();
        	 req.setAttribute("joueurs", listeJoueurs);
        }
        
        //On stocke le chemin vers le fichier correspondant à la vue pour la liste des joueurs
        String pageName = "/prive/listeJoueurs.jsp";
        //On renvoie la requête 
        req.getRequestDispatcher(pageName).forward(req, resp);
    }
	
	

}
