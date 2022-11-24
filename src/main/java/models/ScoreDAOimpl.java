package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import classes.Score;
import db.DBManager;

public class ScoreDAOimpl implements ScoreDAO {
	private Connection connexion = DBManager.getInstance().getConnection();
	@Override
	public void createScore(Score s) {
		String attributsTxt = String.format("%d, %d, '%s'", s.getNbSet(),s.getNbJeu(),s.getTemps());
		String query = "INSERT INTO Score (nombre_set,nombre_jeu,temps) VALUES (" + attributsTxt + ")";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = connexion.prepareStatement(query);
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
