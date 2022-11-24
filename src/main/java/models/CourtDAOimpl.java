package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;


import classes.Court;
import classes.Entraineur;
import classes.Joueur;

import java.util.*;

public class CourtDAOimpl implements CourtDAO {

    //getCourtById
	private QueryTool monQueryTool = new QueryTool();
    @Override
    public Court getCourtById(int id) {
        
        Court c = null;

        ResultSet rs = monQueryTool.getResult("SELECT * FROM Court WHERE id_court="+id);

        if(rs!=null) {
            try {
                while (rs.next()) {
                    c = new Court(rs.getInt("id_court"), rs.getString("nom_court"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return c;
    }

    //getAllCourts
    @Override
    public List<Court> getAllCourt() {

        List<Court> allCourts = new ArrayList<Court>();

		ResultSet rs = monQueryTool.getResult("SELECT * FROM Court");

		if (rs != null) {

			try {
				while (rs.next()) { // Itérer sur le resultSet :
					// Pour chaque instance de joueur retournée par la requête on créé un nouveau joueur
					Court c = new Court(rs.getInt("id_court"), rs.getString("nom_court"));
					// On ajoute le joueur créé à la liste des joueurs
					allCourts.add(c);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return allCourts;
	}

	@Override
	public int getCourtByNom(String nom) {
		// TODO Auto-generated method stub
		return 0;
	}

}
