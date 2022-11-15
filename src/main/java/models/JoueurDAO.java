package models;
import classes.Joueur;

import java.util.List;


public interface JoueurDAO {
	public List<Joueur> getAllJoueurs();
	public List<Joueur> getAllJoueursBySexe(String sexe);
	public List<Joueur> getAllJoueursOrderedByClassement();
	public List<Joueur> getAllJoueursOrderedByNom();

}

