package models;

import classes.Court;
import classes.Joueur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CourtDAO {
    //getCourtById
    public Court getCourtById(int id) throws SQLException;


    //getAllCourts
    List<Court> getAllCourt();
}
