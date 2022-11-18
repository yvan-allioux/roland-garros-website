package classes;

import models.UtilisateurDAOimpl;

public class Utilisateur {
    //ATTRIBUTS
    private String login;
    private String password;
    private char type;

    //CONSTUCTEUR
    public Utilisateur(String login, String password, char type) {
        this.login = login;
        this.password = password;
        this.type = type;
    }
    public Utilisateur(String login, String password) {
        this.login = login;
        this.password = password;
        if(new UtilisateurDAOimpl().utilisateurExiste(login)){
            this.type = new UtilisateurDAOimpl().getRole(login);
        }else{
            this.type = 'Z';//erreur
        }
    }
    //METHODES

    //utilisateur existe
    public boolean utilisateurExiste(String login) {
        //test si l'utilisateur existe
        UtilisateurDAOimpl unUtilisateurDAO = new UtilisateurDAOimpl();
        return unUtilisateurDAO.utilisateurExiste(login);
    }
    //get role
    public char getRole(String login) {
        //retour du role
        UtilisateurDAOimpl unUtilisateurDAO = new UtilisateurDAOimpl();
        return unUtilisateurDAO.getRole(login);
    }

    //GETTERS
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public char getType() {
        return type;
    }
    //SETTERS
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setType(char type) {
        this.type = type;
    }

}
