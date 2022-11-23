package classes;

import java.time.LocalDate;
import java.time.LocalTime;

public class Match {

	// ATTRIBUTS
	private Integer id;
	private LocalDate date;
	private LocalTime heure;
	private Integer gagnant;
	private Court court;
	private Joueur joueur1, joueur2;
	private Equipe equipe1, equipe2;
	private Integer score;

	// CONSTRUCTEUR
	// Match sans joueur
	public Match(Integer id, LocalDate date, LocalTime heure) {
		this.id = id;
		this.date = date;
		this.heure = heure;
		this.court = null;
	}

	// match avec joueurs
	public Match(Integer id, LocalDate date, LocalTime heure, Joueur joueur1, Joueur joueur2, Court court) {
		this.id = id;
		this.date = date;
		this.heure = heure;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.court = court;
	}

	// match avec equipe
	public Match(Integer id, LocalDate date, LocalTime heure, Equipe equipe1, Equipe equipe2, Court court) {
		this.id = id;
		this.date = date;
		this.heure = heure;
		this.equipe1 = equipe1;
		this.equipe2 = equipe2;
		this.court = court;
	}
	// METHODES

	// GETTERS

	public Integer getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public LocalTime getHeure() {
		return heure;
	}

	public Integer getGagnant() {
		return gagnant;
	}

	public String getJoueur1() {
		return joueur1.getPrenom() + joueur1.getNom();
	}

	public String getJoueur2() {
		return joueur2.getPrenom() + joueur2.getNom();
	}

	public String getEquipe1() {
		return equipe1.getNom();
	}

	public String getEquipe2() {
		return equipe1.getNom();
	}

	public String getCourt() {
		if (court == null) {
			return " /";
		} else {
			return court.getNom();
		}
	}

	// SETTERS
	public void setId(Integer id) {
		this.id = id;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}

	public void setGagnant(Integer gagnant) {
		this.gagnant = gagnant;
	}

	public void setJoueur1(String prenom, String nom) {
		this.joueur1.setPrenom(prenom);
		this.joueur1.setNom(nom);
	}

	public void setJoueur2(String prenom, String nom) {
		this.joueur2.setPrenom(prenom);
		this.joueur2.setNom(nom);
	}

}
