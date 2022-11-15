import java.time.LocalDate;
import java.time.LocalTime;

public class Match {
	
	private Integer id;
	private LocalDate date;
	private LocalTime heure;
	private Integer gagnant;
	
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
	
	//méthode fixe un ID
	public void setId(Integer id) {
		this.id = id;
	}
	
	//méthode fixe une date
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	//méthode fixe une heure
	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}
	
	//méthode fixe un gagnant
	public void setGagnant(Integer gagnant) {
		this.gagnant = gagnant;
	}
	
	//méthode obtenir l'ID d'un match
	public Integer getId() {
		return id;
	}
	
	//méthode obtenir l'a date d'un match
	public LocalDate getDate() {
		return date;
	}
	
	//méthode obtenir l'heure d'un match
	public LocalTime getHeure() {
		return heure;
	}
	
	//méthode obtenir le gagnant d'un match
	public Integer getGagnant() {
		return gagnant;
	}
	
}
