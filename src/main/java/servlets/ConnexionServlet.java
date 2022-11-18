package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import classes.Utilisateur;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.JoueurDAOImpl;

@WebServlet (name = "connexion", value = "/connexion")

public class ConnexionServlet extends HttpServlet{

    //CONSRUCTEUR
    /*private void doProcess(HttpServletRequest req, HttpServletResponse resp) {

        resp.setContentType("text/html");
        String pageName = "/public/test.jsp";
        //indique la vue à afficher
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);

        try {
            rd.forward(req, resp);

        } catch (ServletException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();


        }

    }*/

    //GET REQUEST
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        /*String variable = "Liste des joueurs";
        request.setAttribute("joueurs", variable);*/
        //indique la vue à afficher
        this.getServletContext().getRequestDispatcher("/public/connexion.jsp").forward(request, response);
    }
    //POST REQUEST
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //Récupération des paramètres POST
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        //affichage des paramètres
        System.out.println("login : " + login);
        System.out.println("password : " + password);

        //nouvelle instance d'utilisateur
        Utilisateur unUser = new Utilisateur(login, password);

        //get role
        char role = unUser.getRole(login);
        System.out.println("role : " + role);

        //utilisateur existant ?
        if(unUser.utilisateurExiste(login)) {
            //redirection vers la page d'accueil
            System.out.println("utilisateur existant");
            response.sendRedirect(request.getContextPath() + "/");
            //creation de la session
        } else {
            System.out.println("utilisateur inexistant");
            //redirection vers la page de connexion
            response.sendRedirect(request.getContextPath() + "/connexion");
        }





    }
}
