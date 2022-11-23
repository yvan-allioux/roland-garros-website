package models;

import models.CourtDAOimpl;
import models.JoueurDAOimpl;
import classes.Court;
import classes.Joueur;
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
	private JoueurDAOimpl joueurDAO = new JoueurDAOimpl();
	private CourtDAOimpl courtDAO = new CourtDAOimpl();

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
					Joueur j1 = joueurDAO.getJoueurById(rs.getInt("joueur1"));
					Joueur j2 = joueurDAO.getJoueurById(rs.getInt("joueur2"));
					Court court = courtDAO.getCourtById(rs.getInt("court"));
					// Pour chaque instance de match retournée par la requête on créé un nouveau
					Match m = new Match(rs.getInt("id_match"), rs.getDate("date").toLocalDate(),
							rs.getTime("heure").toLocalTime(),j1,j2,court);
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
	public Match getMatchById(Integer id) {
		Match m = null;

		ResultSet rs = getResult("SELECT * FROM Matchs WHERE id_match=" + id);

		if (rs != null) {

			try {
				while (rs.next()) {
					Joueur j1 = joueurDAO.getJoueurById(rs.getInt("joueur1"));
					Joueur j2 = joueurDAO.getJoueurById(rs.getInt("joueur2"));
					Court court = courtDAO.getCourtById(rs.getInt("court"));
					// Pour chaque instance de match retournée par la requête on créé un nouveau
					m = new Match(rs.getInt("id_match"), rs.getDate("date").toLocalDate(),
							rs.getTime("heure").toLocalTime(),j1,j2,court);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return m;
	}

	@Override
	public void updateMatch(Match m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMatch(Integer id){
		// TODO Auto-generated method stub

	}

	@Override
	public void createMatch(Match m){
		// TODO Auto-generated method stub

	}

	@Override
	public List<Match> getAllMatchsByDate(LocalDate date){
		// TODO Auto-generated method stub
		return null;
	}

}
