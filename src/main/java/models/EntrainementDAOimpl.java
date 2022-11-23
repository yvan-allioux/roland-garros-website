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

    //retourne un entrainements par son id
    public Entrainement getEntrainementById(Integer id_entrainement) {
        QueryTool monQueryTool = new QueryTool();

        //nouveaux JoueurDAO
        JoueurDAOimpl unJoueurDAOimpl = new JoueurDAOimpl();
        CourtDAOimpl unCourtDAOimpl = new CourtDAOimpl();

        ResultSet rs = monQueryTool.getResult("SELECT * FROM Entrainement WHERE id_entrainement='"+id_entrainement+"'");

        if(rs!=null) {

            try {
                while (rs.next()) {
                    int id_entrainement2 = rs.getInt("id_entrainement");
                    String date2 = rs.getString("date");
                    LocalDate dateParse2 = LocalDate.parse(date2);
                    String heur2 = rs.getString("heure");
                    LocalTime heurParse2 = LocalTime.parse(heur2);
                    //setup valeur unJoueurDAOimpl
                    Joueur unJoueur2 = unJoueurDAOimpl.getJoueurById(rs.getInt("joueur"));
                    //setup valeur unCourtDAOimpl
                    Court unCourt2 = unCourtDAOimpl.getCourtById(rs.getInt("court"));
                    //Integer id, LocalDate date, LocalTime heure, Joueur joueur, Court court
                    Entrainement unEntrainement2 = new Entrainement(id_entrainement2, dateParse2, heurParse2, unJoueur2, unCourt2);
                    return unEntrainement2;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        Entrainement unEntrainementNULL = new Entrainement(0,null,null, null,null);
        return unEntrainementNULL;
    }

    //modifie un entrainement
    @Override
    public void updateEntrainement(int id_entrainement, String date, String heure, String court, String prenom, String nom) {
        QueryTool monQueryTool = new QueryTool();

        //get id joueur par prenom et nom
        JoueurDAOimpl unJoueurDAOimpl = new JoueurDAOimpl();
        Integer idJoueur = unJoueurDAOimpl.getJoueurByPrenomNom(nom,prenom);
        Joueur unJoueur = unJoueurDAOimpl.getJoueurById(idJoueur);

        //get id court par nom
        /*CourtDAOimpl unCourtDAOimpl = new CourtDAOimpl();
        Court unCourt = unCourtDAOimpl.getCourtByNom(court);
        int id_court = unCourt.getId();*/


        //ResultSet rs = monQueryTool.getResult("UPDATE `Entrainement` SET `date`='"+date+"',`heure`='"+heure+"',`joueur`='"+unJoueur.getId()+"',`court`='"+unCourt.getId()+"' WHERE id_entrainement='"+id_entrainement+"'");


    }

}
