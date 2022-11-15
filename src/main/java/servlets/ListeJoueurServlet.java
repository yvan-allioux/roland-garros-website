import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet ("/joueurs")
public class ListeJoueurServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        
        PrintWriter out = resp.getWriter();

        
        //Création d'une instance du DAO des jouers
        JoueurDAOImpl joueurDAO = new JoueurDAOImpl();
        //Récupération de tous les joueurs dans listeJoueurs
        List<Joueur> listeJoueurs = joueurDAO.getAllJoueurs();
        
        //pour chaque joueur de la liste
        for(int i =0;i<listeJoueurs.size();i++) {
        	//on affiche les infos 
        	out.println(listeJoueurs.get(i).getPrenom());
        	out.println(listeJoueurs.get(i).getNom());
        	out.println(listeJoueurs.get(i).getEntraineur());
        	out.println("\n");
        }
        

  }

}
