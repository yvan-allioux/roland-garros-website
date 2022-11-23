package models;
import classes.Joueur;

import java.sql.SQLException;
import java.util.List;


public interface JoueurDAO {
	
	public List<Joueur> getAllJoueurs();
	public List<Joueur> getAllJoueursOrderedByClassement();
	public List<Joueur> getAllJoueursOrderedByNom();
	public Joueur getJoueurById(Integer id);
	public void updateJoueur(Joueur j);
	public void deleteJoueur(Integer id);
	public void createJoueur(Joueur j);

}

