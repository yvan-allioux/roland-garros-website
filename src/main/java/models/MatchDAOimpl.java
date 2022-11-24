package models;

import models.CourtDAOimpl;
import models.JoueurDAOimpl;
import classes.Court;
import classes.Joueur;
import classes.Match;
import classes.Score;
import db.DBManager;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
public class MatchDAOimpl implements MatchDAO{
	
	private Connection connexion;
	private List<Match> listeMatchs;
	private JoueurDAOimpl joueurDAO = new JoueurDAOimpl();
	private CourtDAOimpl courtDAO = new CourtDAOimpl();
	private ScoreDAOimpl scoreDAO = new ScoreDAOimpl();
	private QueryTool queryTool = new QueryTool();

	public MatchDAOimpl(){
		connexion = DBManager.getInstance().getConnection();
		listeMatchs = this.getAllMatchs();
	}

	@Override
	public List<Match> getAllMatchs() {

		List<Match> allMatchs = new ArrayList<Match>();

		ResultSet rs = queryTool.getResult("SELECT * FROM Matchs");

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

		ResultSet rs = queryTool.getResult("SELECT * FROM Matchs WHERE id_match=" + id);

		if (rs != null) {

			try {
				while (rs.next()) {
					Joueur j1 = joueurDAO.getJoueurById(rs.getInt("joueur1"));
					Joueur j2 = joueurDAO.getJoueurById(rs.getInt("joueur2"));
					Court court = courtDAO.getCourtById(rs.getInt("court"));
					
					Score s=null;
					Joueur j=null;
					if(rs.getInt("score")!=0) {
						s = scoreDAO.getScoreById(rs.getInt("score"));	
					}
					if(rs.getInt("gagnant")!=0) {
						j = joueurDAO.getJoueurById(rs.getInt("gagnant"));
						
					}
					// Pour chaque instance de match retournée par la requête on créé un nouveau
					m = new Match(rs.getInt("id_match"), rs.getDate("date").toLocalDate(),
							rs.getTime("heure").toLocalTime(),court,j1,j2,j,s);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return m;
	}
	
	public List<Court> getMatchsPassesOrderedByDate(){
		return null;
	}

	@Override
	public void updateMatch(Match m) {

		String attributsTxt = String.format("court='%d', joueur1='%d', joueur2='%d',date='%s',heure='%s'", m.getCourt().getId(),m.getJoueur1().getId(),m.getJoueur2().getId(),m.getDate(),m.getHeure());
		String query = "UPDATE Matchs SET " + attributsTxt + " WHERE id_match=" + m.getId();
		PreparedStatement preparedStmt;
		try {
			preparedStmt = connexion.prepareStatement(query);
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteMatch(Integer id){
		String query = "DELETE FROM Matchs WHERE id_match=" + id;
		PreparedStatement preparedStmt;
		try {
			preparedStmt = connexion.prepareStatement(query);
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void createMatch(Match m){
		String attributsTxt = String.format("%d, %d, %d,'%s','%s'", m.getCourt().getId(),m.getJoueur1().getId(),m.getJoueur2().getId(),m.getDate(),m.getHeure());
		String query = "INSERT INTO Matchs (court,joueur1,joueur2,date,heure) VALUES (" + attributsTxt + ")";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = connexion.prepareStatement(query);
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/**
	 * Retourne la liste des matchs passés
	 */
	@Override
	public List<Match> getAllMatchsPasses(){
		List<Match> matchs = new ArrayList<Match>();
			
			for(Match m:this.listeMatchs) {
				if(m.getDate().isBefore(LocalDate.now()) || (m.getDate().equals(LocalDate.now()) && m.getHeure().isBefore(LocalTime.now()))) { //Si la date du match est avant aujourd'hui ou si la date du match est aujourd'hui et que l'heure du match est avant l'heure actuelle
					matchs.add(m);
				}
			}

			return matchs;
	}
	
	/**
	 * Retourne la liste des matchs pas encore passés
	 */
	@Override
	public List<Match> getAllMatchsPasPasses(){
		List<Match> matchs = new ArrayList<Match>();
			
			for(Match m:this.listeMatchs) {
				if(m.getDate().isAfter(LocalDate.now()) || (m.getDate().equals(LocalDate.now()) && m.getHeure().isAfter(LocalTime.now()))) { //Si la date du match est après aujourd'hui ou si la date du match est aujourd'hui et que l'heure du match est après l'heure actuelle
					matchs.add(m);
				}
			}

			return matchs;
	}

}
