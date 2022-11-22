package servlets;

import java.io.IOException;

import classes.Utilisateur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet (name = "connexion", value = "/connexion")

public class ConnexionServlet extends HttpServlet{

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


        //erreur ?
        System.out.println("param erreur : "+request.getParameter("erreur"));

        //affichage des paramètres
        //System.out.println("login : " + login);
        //System.out.println("password : " + password);

        //nouvelle instance d'utilisateur
        Utilisateur unUser = new Utilisateur(login, password);
        System.out.println( "get role : " + unUser.getType());

        //utilisateur existant ?
        if(!(unUser.utilisateurExiste(login))) {
            //redirection vers la page de connexion + parametre erreur
            response.sendRedirect(request.getContextPath() + "/connexion?erreur=loginInexistant");

        } else {
            //redirection vers la page d'accueil
            System.out.println("utilisateur existant");

            System.out.println( "get password : " + unUser.getPasswordDataBase(login));
            //test du mot de passe
            //todo : chifffrer le mot de passe, pas urgent
            if(unUser.getPasswordDataBase(login).equals(password)) {
                //redirection vers la page d'accueil
                System.out.println("mot de passe correct avec la database");
                response.sendRedirect(request.getContextPath() + "/");
                //set session
                HttpSession maSession = request.getSession();
                maSession.setAttribute("login", login);
                maSession.setAttribute("role", unUser.getType());

            } else {
                //redirection vers la page de connexion + parametre erreur
                response.sendRedirect(request.getContextPath() + "/connexion?erreur=mdpInvalide");
            }

        }





    }
}
