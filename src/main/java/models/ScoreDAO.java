package models;

import classes.Score;

public interface ScoreDAO {
	
	public void createScore(Score s);
	public void createScoreWithId(Score s);
	public Score getScoreById(int id);

}
