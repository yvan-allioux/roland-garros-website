package classes;

import java.time.LocalDate;
import java.time.LocalTime;

public class Match {

	// ATTRIBUTS
	private Integer id;
	private LocalDate date;
	private LocalTime heure;
	private Joueur gagnant;
	private Court court;
	private Joueur joueur1, joueur2;
	private Equipe equipe1, equipe2;
	private Score score;

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
	
	public Match(LocalDate date, LocalTime heure, Court court, Joueur joueur1, Joueur joueur2) {
		this.date = date;
		this.heure = heure;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.court = court;
	}
	
	public Match(Integer id,LocalDate date, LocalTime heure, Court court, Joueur joueur1, Joueur joueur2,Joueur gagnant, Score score) {
		this.id = id;
		this.date = date;
		this.heure = heure;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.court = court;
		this.gagnant = gagnant;
		this.score = score;
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

	public Joueur getGagnant() {
		return gagnant;
	}

	public Joueur getJoueur1() {
		return joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

	public Equipe getEquipe1() {
		return equipe1;
	}

	public Equipe getEquipe2() {
		return equipe1;
	}

	public Court getCourt() {
			return court;
	}
	
	public Score getScore() {
		return score;
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

	public void setGagnant(Joueur gagnant) {
		this.gagnant = gagnant;
	}

	public void setJoueur1(Joueur j1) {
		this.joueur1=j1;
	}

	public void setJoueur2(Joueur j2) {
		this.joueur2=j2;
	}
	
	public void setScore(Score s) {
		this.score = s;
	}

}
