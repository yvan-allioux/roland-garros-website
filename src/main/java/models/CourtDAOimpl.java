package models;

import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Court;


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

    //getCourtByNom
    @Override
    public int getCourtByNom(String nom) {
        QueryTool monQueryTool = new QueryTool();

        int idCour = 0;

        ResultSet rs = monQueryTool.getResult("SELECT * FROM Court WHERE nom_court='" + nom + "'");

        if (rs != null) {
            try {
                while (rs.next()) {
                    idCour = rs.getInt("id_court");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return idCour;
    }

}
