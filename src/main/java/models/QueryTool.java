package models;

import db.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryTool {

    //getResult
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
