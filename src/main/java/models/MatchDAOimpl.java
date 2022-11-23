package models;

import classes.Match;
import db.DBManager;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
public class MatchDAOimpl implements MatchDAO{
	
	private Connection connexion;
	private List<Match> listeMatchs;

	public MatchDAOimpl(){
		connexion = DBManager.getInstance().getConnection();
		listeMatchs = this.getAllMatchs();
	}

	@Override
	public List<Match> getAllMatchs() {

		List<Match> allMatchs = new ArrayList<Match>();

		ResultSet rs = getResult("SELECT * FROM Matchs");

		if (rs != null) {

			try {
				while (rs.next()) { // Itérer sur le resultSet :
					// Pour chaque instance de match retournée par la requête on créé un nouveau
					// match
					Match m = new Match(rs.getInt("id_match"), rs.getDate("date").toLocalDate(),
							rs.getTime("heure").toLocalTime());
					// On ajoute le match créé à la liste des matchs
					allMatchs.add(m);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return allMatchs;

	}

	/**
	 * Retourne les résultats d'une requête SELECT
	 * 
	 * @param txtRequest
	 * @return
	 */
	public ResultSet getResult(String query) {
		// Créer un java.sql.Statement à partir de cette connexion en utilisant:
		Statement statement = null;
		ResultSet rs = null;
		try {
			// Initialisation du statement
			statement = connexion.createStatement();

			if (statement != null) {
				rs = statement.executeQuery(query);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	public List<Match> getListeMatchs() {
		return listeMatchs;
	}

	public void setListeJoueurs(List<Match> listeMatchs) {
		this.listeMatchs = listeMatchs;
	}

	@Override
	public List<Match> updateListeMatchs() {

		listeMatchs = this.getAllMatchs();
		return listeMatchs;
	}

	@Override
	public Match getMatchById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMatch(Match m) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMatch(Integer id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void createMatch(Match m) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Match> getAllMatchsByDate(LocalDate date) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
