package classes;
import java.time.LocalDate;
import java.time.LocalTime;

public class Entrainement {

	//ATTRIBUTS
	private Integer id;
	private LocalDate date;
	private Joueur joueur;
	private Court court;
	private LocalTime heure;

	//CONSTRUCTEUR
	public Entrainement(Integer id, LocalDate date, LocalTime heure) {
		this.id = id;
		this.date = date;
		this.heure = heure;
	}
	public Entrainement(Integer id, LocalDate date, LocalTime heure, Joueur joueur, Court court) {
		this.id = id;
		this.date = date;
		this.joueur = joueur;
		this.court = court;
		this.heure = heure;
	}

	//METHODES

	//GETTERS
	public Integer getId() {
		return id;
	}
	public LocalDate getDate() {
		return date;
	}
	public LocalTime getHeure() {
		return heure;
	}
	public Joueur getJoueur() {
		return joueur;
	}
	public Court getCourt() {
		return court;
	}

	//SETTERS
	public void setId(Integer id) {
		this.id = id;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}


}
