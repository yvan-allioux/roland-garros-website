import java.time.LocalDate;
import java.time.LocalTime;

public class Entrainement {
	//ATTRIBUTS
	private int id;
	private LocalDate date;
	private LocalTime heure;
	//CONSTRUCTEUR
	public Entrainement(int id, LocalDate date, LocalTime heure) {
		this.id = id;
		this.date = date;
		this.heure = heure;
	}
	//GETTERS
	public int getId() {
		return id;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public LocalTime getHeure() {
		return heure;
	}
	//SETTERS
	public void setId(int id) {
		this.id = id;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}
}
