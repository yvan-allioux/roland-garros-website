package models;

import classes.Entraineur;
import classes.Joueur;
import db.DBManager;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JoueurDAOimpl implements JoueurDAO {

	private Connection connexion;
	private List<Joueur> listeJoueurs;
	EntraineurDAOimpl entraineurDAO;
	QueryTool queryTool = new QueryTool();

	public JoueurDAOimpl(){
		connexion = DBManager.getInstance().getConnection();
		listeJoueurs = this.getAllJoueurs();
		entraineurDAO = new EntraineurDAOimpl();
	}

	@Override
	public List<Joueur> getAllJoueurs() {

		EntraineurDAOimpl entraineurDAO = new EntraineurDAOimpl();
		List<Joueur> allJoueurs = new ArrayList<Joueur>();

		ResultSet rs = queryTool.getResult("SELECT * FROM Joueur");

		if (rs != null) {

			try {
				while (rs.next()) { // Itérer sur le resultSet :
					// Pour chaque instance de joueur retournée par la requête on créé un nouveau joueur
					Entraineur e = entraineurDAO.getEntraineurById(rs.getInt("entraineur"));
					Joueur j = new Joueur(rs.getInt("id_joueur"), rs.getString("nom_joueur"),
							rs.getString("prenom_joueur"), rs.getString("sexe"), e,
							rs.getDate("date_naissance").toLocalDate(), rs.getString("lieu_naissance"),
							rs.getString("nationalite"), rs.getInt("taille"), rs.getFloat("poids"),
							rs.getString("main"), rs.getDate("date_debut_carriere").toLocalDate(),
							rs.getInt("classement"));
					// On ajoute le joueur créé à la liste des joueurs
					allJoueurs.add(j);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return allJoueurs;

	}

	@Override
	public List<Joueur> getAllJoueursOrderedByClassement() {

		List<Joueur> listeJoueursClassement = new ArrayList<Joueur>();

		ResultSet rs = queryTool.getResult("SELECT * FROM Joueur ORDER BY classement ASC");

		if (rs != null) {

			try {
				while (rs.next()) { // Itérer sur le resultSet :
					// Pour chaque instance de joueur retournée par la requête on créé un nouveau
					// joueur
					// Joueur j = new Joueur(rs.getInt("id_joueur"), rs.getString("nom_joueur"),
					// rs.getString("prenom_joueur"), rs.getString("sexe"),rs.getInt("entraineur"));
					Entraineur e = entraineurDAO.getEntraineurById(rs.getInt("entraineur"));
					Joueur j = new Joueur(rs.getInt("id_joueur"), rs.getString("nom_joueur"),
							rs.getString("prenom_joueur"), rs.getString("sexe"), e,
							rs.getDate("date_naissance").toLocalDate(), rs.getString("lieu_naissance"),
							rs.getString("nationalite"), rs.getInt("taille"), rs.getFloat("poids"),
							rs.getString("main"), rs.getDate("date_debut_carriere").toLocalDate(),
							rs.getInt("classement"));
					// On ajoute le joueur créé à la liste des joueurs
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

		ResultSet rs = queryTool.getResult("SELECT * FROM Joueur ORDER BY nom_joueur ASC, prenom_joueur ASC");

		if (rs != null) {

			try {
				while (rs.next()) { // Itérer sur le resultSet :
					// Pour chaque instance de joueur retournée par la requête on créé un nouveau
					// joueur
					Entraineur e = entraineurDAO.getEntraineurById(rs.getInt("entraineur"));
					Joueur j = new Joueur(rs.getInt("id_joueur"), rs.getString("nom_joueur"),
							rs.getString("prenom_joueur"), rs.getString("sexe"), e,
							rs.getDate("date_naissance").toLocalDate(), rs.getString("lieu_naissance"),
							rs.getString("nationalite"), rs.getInt("taille"), rs.getFloat("poids"),
							rs.getString("main"), rs.getDate("date_debut_carriere").toLocalDate(),
							rs.getInt("classement"));
					// On ajoute le joueur créé à la liste des joueurs
					listeJoueursNom.add(j);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listeJoueursNom;
	}

	@Override
	public Joueur getJoueurById(Integer id) {

		Joueur j = null;

		ResultSet rs = queryTool.getResult("SELECT * FROM Joueur WHERE id_joueur=" + id);

		if (rs != null) {

			try {
				while (rs.next()) {
					Entraineur e = entraineurDAO.getEntraineurById(rs.getInt("entraineur"));
					j = new Joueur(rs.getInt("id_joueur"), rs.getString("nom_joueur"), rs.getString("prenom_joueur"),
							rs.getString("sexe"),e, rs.getDate("date_naissance").toLocalDate(),
							rs.getString("lieu_naissance"), rs.getString("nationalite"), rs.getInt("taille"),
							rs.getFloat("poids"), rs.getString("main"), rs.getDate("date_debut_carriere").toLocalDate(),
							rs.getInt("classement"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return j;
	}

	@Override
	public void createJoueur(Joueur j) {

		String attributsTxt = String.format("'%s', '%s', '%s', '%s', '%s','%s','%d','%s','%s','%d','%d','%d'", j.getNom(), j.getPrenom(), j.getSexe(),
				j.getNationalite(), j.getDateNaissance().toString(), j.getAnneeCarriere(),j.getEntraineur().getId(),j.getMain(),j.getLieuNaissance(),j.getClassement(),j.getTaille(),(int)j.getPoids());
		String query = "INSERT INTO Joueur (nom_joueur,prenom_joueur,sexe,nationalite,date_naissance,date_debut_carriere,entraineur,main,lieu_naissance,classement,taille,poids) VALUES ("
				+ attributsTxt + ")";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = connexion.prepareStatement(query);
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateJoueur(Joueur j) {

		String attributsTxt = String.format("nom_joueur='%s', prenom_joueur='%s', sexe='%s', date_debut_carriere=%s, date_naissance='%s',nationalite='%s',main='%s',taille='%d',poids='%d',entraineur='%d'", j.getNom(), j.getPrenom(),
				j.getSexe(),j.getDateCarriere().getYear(),j.getDateNaissance(),j.getNationalite(),j.getMain(),j.getTaille(),(int)j.getPoids(),j.getEntraineur().getId());
		String query = "UPDATE Joueur SET " + attributsTxt + " WHERE id_joueur=" + j.getId();
		PreparedStatement preparedStmt;
		try {
			preparedStmt = connexion.prepareStatement(query);
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteJoueur(Integer id) {

		String query = "DELETE FROM Joueur WHERE id_joueur=" + id;
		PreparedStatement preparedStmt;
		try {
			preparedStmt = connexion.prepareStatement(query);
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Joueur> getListeJoueurs() {
		return listeJoueurs;
	}

	public void setListeJoueurs(List<Joueur> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}

}
