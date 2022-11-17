package models;
import classes.Joueur;

import java.sql.SQLException;
import java.util.List;


public interface JoueurDAO {
	public List<Joueur> getAllJoueurs() throws SQLException;
	public List<Joueur> getAllJoueursBySexe(String sexe) throws SQLException;
	public List<Joueur> getAllJoueursOrderedByClassement() throws SQLException;
	public List<Joueur> getAllJoueursOrderedByNom() throws SQLException;
	public Joueur getJoueurById(Integer id) throws SQLException;
	public void updateJoueur(Joueur j) throws SQLException;
	public void deleteJoueur(Integer id) throws SQLException;
	public void createJoueur(Joueur j) throws SQLException;

}

