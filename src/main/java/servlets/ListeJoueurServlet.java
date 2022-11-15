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
        
        //PrintWriter out = resp.getWriter()
       
        //Création d'une instance du DAO des jouers
        JoueurDAOImpl joueurDAO = new JoueurDAOImpl();
        //Récupération de tous les joueurs dans listeJoueurs
        List<Joueur> listeJoueurs = joueurDAO.getAllJoueurs();
        
        //pour chaque joueur de la liste
        /*for(int i =0;i<listeJoueurs.size();i++) {
        	//on affiche les infos 
        	out.println(listeJoueurs.get(i).getPrenom());
        	out.println(listeJoueurs.get(i).getNom());
        	out.println(listeJoueurs.get(i).getEntraineur());
        	out.println("\n");
        }*/
        
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

}