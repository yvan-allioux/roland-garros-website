package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import db.DBManager;

//add querytool
import models.QueryTool;


public class EntrainementDAOimpl implements EntrainementDAO {
    @Override
    //constructeur

    //test si l'entrainement existe
    public boolean entrainementExiste(String id_entrainement) {
        QueryTool monQueryTool = new QueryTool();

        String queryPrepare = "SELECT * FROM `Entrainement` WHERE id_entrainement='"+id_entrainement+"'";

        ResultSet rs = monQueryTool.getResult(queryPrepare);
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

    //retourne l'horaire de l'entrainement
    public String getHoraire(String id_entrainement){//objet date/heur ?
        QueryTool monQueryTool = new QueryTool();

        String queryPrepare = "SELECT heure FROM `Entrainement` WHERE id_entrainement='"+id_entrainement+"'";

        ResultSet rs = monQueryTool.getResult(queryPrepare);
        //test si l'utilisateur existe
        if(rs!=null) {

            try {
                while (rs.next()) { //Itérer sur le resultSet :
                    return rs.getString("heure");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //retourne le date de l'entrainement
    public String getDate(String id_entrainement){//objet date/heur ?
        QueryTool monQueryTool = new QueryTool();

        String queryPrepare = "SELECT date FROM `Entrainement` WHERE id_entrainement='"+id_entrainement+"'";

        ResultSet rs = monQueryTool.getResult(queryPrepare);
        //test si l'utilisateur existe
        if(rs!=null) {

            try {
                while (rs.next()) { //Itérer sur le resultSet :
                    return rs.getString("date");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
