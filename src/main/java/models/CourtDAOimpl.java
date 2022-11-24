package models;

import java.sql.*;

import classes.Court;

import java.util.*;

public class CourtDAOimpl implements CourtDAO {

    //getCourtById
    @Override
    public Court getCourtById(int id) {
        QueryTool monQueryTool = new QueryTool();

        Court j = null;

        ResultSet rs = monQueryTool.getResult("SELECT * FROM Court WHERE id_court="+id);

        if(rs!=null) {
            try {
                while (rs.next()) {
                    j = new Court(rs.getInt("id_court"), rs.getString("nom_court"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return j;
    }

    //getAllCourts
    @Override
    public List<Court> getAllCourt() {
        QueryTool monQueryTool = new QueryTool();

        List<Court> allCourt = new ArrayList<Court>();

        ResultSet rs = monQueryTool.getResult("SELECT * FROM Court");

        if (rs != null) {

            try {
                while (rs.next()) {
                    Court j = new Court(rs.getInt("id_court"), rs.getString("nom_court"));
                    // On ajoute le joueur créé à la liste des joueurs
                    allCourt.add(j);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return allCourt;

    }
}
