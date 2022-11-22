package models;

import java.sql.SQLException;

import classes.Entraineur;

public interface EntraineurDAO {
	
	public Entraineur getEntraineurById(Integer id);

}
