package models;
import classes.Match;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;


public interface MatchDAO {
	
	public List<Match> getAllMatchs() throws SQLException;
	public Match getMatchById(Integer id) throws SQLException;
	public void updateMatch(Match m) throws SQLException;
	public void deleteMatch(Integer id) throws SQLException;
	public void createMatch(Match m) throws SQLException;
	public List<Match> getAllMatchsByDate(LocalDate date) throws SQLException;
	public List<Match> updateListeMatchs();

}

