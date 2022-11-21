package models;

import classes.Joueur;
import classes.Utilisateur;
import db.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UtilisateurDAOimpl implements UtilisateurDAO {

    @Override
    public boolean checkLogin(String login, String password) {
        //

        return false;
    }

    public boolean utilisateurExiste(String login) {

        String queryPrepare = "SELECT * FROM Utilisateur WHERE pseudo='"+login+"'";
        System.out.println("test dao : " + queryPrepare);

        ResultSet rs = getResult(queryPrepare);
        //test si l'utilisateur existe
        if(rs!=null) {

            try {
                while (rs.next()) { //Itérer sur le resultSet :
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public char getRole(String login) {
        String queryPrepare = "SELECT role FROM Utilisateur WHERE pseudo='"+login+"'";
        ResultSet rs = getResult(queryPrepare);
        //retour du role
        if(rs!=null) {
            try {
                while (rs.next()) { //Itérer sur le resultSet :
                    return rs.getString("role").charAt(0);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return 'Z';//erreur
            }
        }else{
            return 'Z';//erreur
        }
        return 'Z';//erreur
    }

    public String getPassewordDataBase(String login) {
        String queryPrepare = "SELECT mdp FROM Utilisateur WHERE pseudo='"+login+"'";
        ResultSet rs = getResult(queryPrepare);
        //retour du role
        if(rs!=null) {

            try {
                while (rs.next()) { //Itérer sur le resultSet :
                    return rs.getString("mdp");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return "Z";//erreur
            }
        }else{
            return "Z";//erreur
        }
        return "Z";//erreur
    }


    public ResultSet getResult(String txtRequest) {
        //Récupérer une connexion de type java.sql.Connection par la méthode
        Connection connexion = DBManager.getInstance().getConnection();
        //Créer un java.sql.Statement à partir de cette connexion en utilisant:
        Statement statement = null;
        try {
            //Initialisation du statement
            statement = connexion.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        if(statement!=null) {

            try {
                //Exécuter la requête SQL  et récupérer un java.sql.ResultSet :
                rs = statement.executeQuery(txtRequest);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }
}



