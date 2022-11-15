import java.time.LocalDate;
import java.time.LocalTime;

public class Match {

	//ATTRIBUTS
	private Integer id;
	private LocalDate date;
	private LocalTime heure;
	private Integer gagnant;

	//CONSTRUCTEUR
	public Match(Integer id, LocalDate date, LocalTime heure, Integer gagnant) {
		this.id = id;
		this.date = date;
		this.heure = heure;
		this.gagnant = gagnant;
	}
	
	public Match(Integer id, LocalDate date, LocalTime heure) {
		this.id = id;
		this.date = date;
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
	public Integer getGagnant() {
		return gagnant;
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
	public void setGagnant(Integer gagnant) {
		this.gagnant = gagnant;
	}
	
	
	
}
