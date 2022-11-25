package models;
import classes.Match;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;


public interface MatchDAO {
	
	public List<Match> getAllMatchs();
	public Match getMatchById(Integer id);
	public void updateMatch(Match m);
	public void deleteMatch(Integer id);
	public void createMatch(Match m);
	public List<Match> getAllMatchsPasses();
	public List<Match> getAllMatchsPasPasses();
	public List<Match> updateListeMatchs();
	void finaliserMatch(Match m);

}

