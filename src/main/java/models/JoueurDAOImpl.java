package models;
import classes.Joueur;
import db.DBManager;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
public class JoueurDAOImpl implements JoueurDAO{

	@Override
	public List<Joueur> getAllJoueurs() {
		
		List<Joueur> listeJoueurs = new ArrayList<Joueur>();
		
		ResultSet rs = getResult("SELECT * FROM Joueur");
		
		if(rs!=null) {
			
			try {
				while (rs.next()) { //Itérer sur le resultSet :
					//Pour chaque instance de joueur retournée par la requête on créé un nouveau joueur
					//Joueur j = new Joueur(rs.getInt("id_joueur"), rs.getString("nom_joueur"), rs.getString("prenom_joueur"), rs.getString("sexe"),rs.getInt("entraineur"));
					Joueur j = new Joueur(rs.getInt("id_joueur"), rs.getString("nom_joueur"), rs.getString("prenom_joueur"), rs.getString("sexe"), rs.getInt("entraineur"), rs.getDate("date_naissance").toLocalDate(), rs.getString("lieu_naissance"), rs.getString("nationalite"), rs.getInt("taille"), rs.getFloat("poids"), rs.getString("main"), rs.getDate("date_debut_carriere").toLocalDate(), rs.getInt("classement"));
					//On ajoutz le joueur créé à la liste des joueurs
					listeJoueurs.add(j);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listeJoueurs;
	
	}

	@Override
	public List<Joueur> getAllJoueursBySexe(String sexe) {
		List<Joueur> listeJoueursBySexe = new ArrayList<Joueur>();
		
		ResultSet rs = getResult("SELECT * FROM Joueur WHERE sexe='"+sexe+"'");
		
		if(rs!=null) {
			
			try {
				while (rs.next()) { //Itérer sur le resultSet :
					//Pour chaque instance de joueur retournée par la requête on créé un nouveau joueur
					//Joueur j = new Joueur(rs.getInt("id_joueur"), rs.getString("nom_joueur"), rs.getString("prenom_joueur"), rs.getString("sexe"),rs.getInt("entraineur"));
					Joueur j = new Joueur(rs.getInt("id_joueur"), rs.getString("nom_joueur"), rs.getString("prenom_joueur"), rs.getString("sexe"), rs.getInt("entraineur"), rs.getDate("date_naissance").toLocalDate(), rs.getString("lieu_naissance"), rs.getString("nationalite"), rs.getInt("taille"), rs.getFloat("poids"), rs.getString("main"), rs.getDate("date_debut_carriere").toLocalDate(), rs.getInt("classement"));
					//On ajoute le joueur créé à la liste des joueurs
					listeJoueursBySexe.add(j);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listeJoueursBySexe;
	}

	@Override
	public List<Joueur> getAllJoueursOrderedByClassement() {
		List<Joueur> listeJoueursClassement = new ArrayList<Joueur>();
		
		ResultSet rs = getResult("SELECT * FROM Joueur ORDER BY classement ASC");
		
		if(rs!=null) {
			
			try {
				while (rs.next()) { //Itérer sur le resultSet :
					//Pour chaque instance de joueur retournée par la requête on créé un nouveau joueur
					//Joueur j = new Joueur(rs.getInt("id_joueur"), rs.getString("nom_joueur"), rs.getString("prenom_joueur"), rs.getString("sexe"),rs.getInt("entraineur"));
					Joueur j = new Joueur(rs.getInt("id_joueur"), rs.getString("nom_joueur"), rs.getString("prenom_joueur"), rs.getString("sexe"), rs.getInt("entraineur"), rs.getDate("date_naissance").toLocalDate(), rs.getString("lieu_naissance"), rs.getString("nationalite"), rs.getInt("taille"), rs.getFloat("poids"), rs.getString("main"), rs.getDate("date_debut_carriere").toLocalDate(), rs.getInt("classement"));
					//On ajoute le joueur créé à la liste des joueurs
					listeJoueursClassement.add(j);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listeJoueursClassement;
	}

	@Override
	public List<Joueur> getAllJoueursOrderedByNom() {
List<Joueur> listeJoueursNom = new ArrayList<Joueur>();
		
		ResultSet rs = getResult("SELECT * FROM Joueur ORDER BY nom_joueur ASC, prenom_joueur ASC");
		
		if(rs!=null) {
			
			try {
				while (rs.next()) { //Itérer sur le resultSet :
					//Pour chaque instance de joueur retournée par la requête on créé un nouveau joueur
					//Joueur j = new Joueur(rs.getInt("id_joueur"), rs.getString("nom_joueur"), rs.getString("prenom_joueur"), rs.getString("sexe"),rs.getInt("entraineur"));
					Joueur j = new Joueur(rs.getInt("id_joueur"), rs.getString("nom_joueur"), rs.getString("prenom_joueur"), rs.getString("sexe"), rs.getInt("entraineur"), rs.getDate("date_naissance").toLocalDate(), rs.getString("lieu_naissance"), rs.getString("nationalite"), rs.getInt("taille"), rs.getFloat("poids"), rs.getString("main"), rs.getDate("date_debut_carriere").toLocalDate(), rs.getInt("classement"));
					//On ajoute le joueur créé à la liste des joueurs
					listeJoueursNom.add(j);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listeJoueursNom;
	}
	
	public ResultSet getResult(String txtRequest) {
		//Récupérer une connexion de type java.sql.Connection par la méthode
				Connection connexion = DBManager.getInstance().getConnection();
				//Créer un java.sql.Statement à partir de cette connexion en utilisant:
				Statement statement = null;
				try {
					//Initialisation du statement
					statement = connexion.createStatement();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ResultSet rs = null;
				if(statement!=null) {
					
					try {
						//Exécuter la requête SQL  et récupérer un java.sql.ResultSet :
						rs = statement.executeQuery(txtRequest);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				return rs;
	}

}
