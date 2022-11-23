package models;

import java.sql.SQLException;
import java.util.List;

import classes.Entraineur;

public interface EntraineurDAO {
	
	public List<Entraineur> getAllEntraineurs();
	public Entraineur getEntraineurById(Integer id);

}
