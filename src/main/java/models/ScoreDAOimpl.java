package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Court;
import classes.Joueur;
import classes.Match;
import classes.Score;
import db.DBManager;

public class ScoreDAOimpl implements ScoreDAO {
	private Connection connexion = DBManager.getInstance().getConnection();
	private QueryTool queryTool = new QueryTool();
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
	
	@Override
	public void createScoreWithId(Score s) {
		String attributsTxt = String.format("%d,%d, %d, '%s'",s.getId(), s.getNbSet(),s.getNbJeu(),s.getTemps());
		String query = "INSERT INTO Score (id_score,nombre_set,nombre_jeu,temps) VALUES (" + attributsTxt + ")";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = connexion.prepareStatement(query);
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public Integer getLastScoreId() {

		ResultSet rs = queryTool.getResult("SELECT id_score FROM Score ORDER BY id_score DESC LIMIT 1;");		
		Integer id =null;
		if (rs != null) {

			try {
				while (rs.next()) {
		
					// Pour chaque instance de match retournée par la requête on créé un nouveau
					id = rs.getInt("id_score");
					System.out.println(id);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
		
	}
	
	@Override
	public Score getScoreById(int id) {
		Score s = null;

		ResultSet rs = queryTool.getResult("SELECT * FROM Score WHERE id_score=" + id);
		
		if (rs != null) {

			try {
				while (rs.next()) {
		
					// Pour chaque instance de match retournée par la requête on créé un nouveau
					s = new Score(id, rs.getInt("nombre_set"),rs.getInt("nombre_jeu"),rs.getTime("temps").toLocalTime());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return s;
		
	}

}
