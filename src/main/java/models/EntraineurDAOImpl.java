package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import classes.Entraineur;
import classes.Joueur;
import db.DBManager;

public class EntraineurDAOImpl implements EntraineurDAO{
	
	private Connection connexion;

	public EntraineurDAOImpl(){
		connexion = DBManager.getInstance().getConnection();
	}

	@Override
	public Entraineur getEntraineurById(Integer id) {
		Entraineur entraineur = null;
		
		ResultSet rs = getResult("SELECT * FROM Entraineur WHERE id_entraineur="+id);
		
		if(rs!=null) {

				try {
					while(rs.next()) {
						entraineur = new Entraineur(rs.getInt("id_entraineur"),rs.getString("nom_entraineur"),rs.getString("prenom_entraineur"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return entraineur;
	}
	
	/**
	 * Retourne les résultat d'une requête SELECT
	 * @param txtRequest
	 * @return
	 */
	public ResultSet getResult(String query) {
		//Créer un java.sql.Statement à partir de cette connexion en utilisant:
		Statement statement = null;
		ResultSet rs = null;
		try {
			//Initialisation du statement
			statement = connexion.createStatement();
			
			if(statement!=null) {
				rs = statement.executeQuery(query);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}

}
