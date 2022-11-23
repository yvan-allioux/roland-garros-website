package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import classes.Court;
import classes.Entrainement;
import classes.Joueur;

//add querytool


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

    //retourne le joueur de l'entrainement
    public int getIdJoueur(String id_entrainement){
        QueryTool monQueryTool = new QueryTool();

        String queryPrepare = "SELECT joueur FROM `Entrainement` WHERE id_entrainement='"+id_entrainement+"'";

        ResultSet rs = monQueryTool.getResult(queryPrepare);
        //test si l'utilisateur existe
        if(rs!=null) {

            try {
                while (rs.next()) { //Itérer sur le resultSet :
                    return rs.getInt("joueur");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    //retourne le court de l'entrainement
    public int getIdCourt(String id_entrainement){
        QueryTool monQueryTool = new QueryTool();

        String queryPrepare = "SELECT court FROM `Entrainement` WHERE id_entrainement='"+id_entrainement+"'";

        ResultSet rs = monQueryTool.getResult(queryPrepare);
        //test si l'utilisateur existe
        if(rs!=null) {

            try {
                while (rs.next()) { //Itérer sur le resultSet :
                    return rs.getInt("court");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    //retourne la liste des entrainements
    public List<Entrainement> getAllEntrainement() {
        QueryTool monQueryTool = new QueryTool();

        //nouveaux JoueurDAO
        JoueurDAOimpl unJoueurDAOimpl = new JoueurDAOimpl();
        CourtDAOimpl unCourtDAOimpl = new CourtDAOimpl();

        //Liste des entrainements
        List<Entrainement> allEntrainement = new ArrayList<Entrainement>();

        ResultSet rs = monQueryTool.getResult("SELECT * FROM Entrainement");

        if(rs!=null) {

            try {
                while (rs.next()) {

                    int id_entrainement = rs.getInt("id_entrainement");
                    //nouvelle objet joueur
                    Joueur unJoueur = unJoueurDAOimpl.getJoueurById(rs.getInt("joueur"));

                    String date = rs.getString("date");
                    LocalDate dateParse = LocalDate.parse(date);

                    String heur = rs.getString("heure");
                    LocalTime heurParse = LocalTime.parse(heur);

                    //nouvelle objet court
                    Court unCourt = unCourtDAOimpl.getCourtById(rs.getInt("court"));



                    Entrainement j = new Entrainement(id_entrainement,dateParse,heurParse, unJoueur,unCourt);
                    allEntrainement.add(j);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return allEntrainement;

    }

}