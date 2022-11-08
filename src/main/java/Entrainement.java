import java.time.LocalDate;
import java.time.LocalTime;

public class Entrainement {
	private Integer id;
	private LocalDate date;
	private LocalTime heure;
	
	public Entrainement(Integer id, LocalDate date, LocalTime heure) {
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
	
	//méthode obtenir l'ID d'un entraînement
	public Integer getId() {
		return id;
	}
	
	//méthode obtenir la date d'un entraînement
	public LocalDate getDate() {
		return date;
	}
	
	//méthode obtenir l'heure d'un entraînement
	public LocalTime getHeure() {
		return heure;
	}

}
