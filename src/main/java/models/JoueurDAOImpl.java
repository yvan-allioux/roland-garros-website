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
				rs = statement.executeQuery("SELECT * FROM Joueur");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs!=null) {
			
			try {
				while (rs.next()) { //Itérer sur le resultSet :
					//Pour chaque instance de joueur retournée par la requête on créé un nouveau joueur
					//Joueur j = new Joueur(rs.getInt("id_joueur"), rs.getString("nom_joueur"), rs.getString("prenom_joueur"), rs.getString("sexe"),rs.getInt("entraineur"));
					Joueur j = new Joueur(rs.getInt("id_joueur"), rs.getString("nom_joueur"), rs.getString("prenom_joueur"), rs.getString("sexe"), rs.getInt("entraineur"), rs.getDate("date_naissance").toLocalDate(), rs.getString("lieu_naissance"), rs.getString("nationalite"), rs.getInt("taille"), rs.getFloat("poids"), rs.getString("main"), rs.getDate("date_debut_carriere").toLocalDate(), rs.getInt("classement"));
					//On ajout le joueur créé à la liste des joueurs
					listeJoueurs.add(j);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listeJoueurs;
	
	}

}
