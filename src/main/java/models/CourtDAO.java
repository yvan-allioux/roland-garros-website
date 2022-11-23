package models;

import classes.Court;
import classes.Joueur;

import java.sql.SQLException;

public interface CourtDAO {
    //getCourtById
    public Court getCourtById(int id) throws SQLException;
}
