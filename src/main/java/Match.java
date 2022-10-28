import java.time.LocalDate;
import java.time.LocalTime;

public class Match {
	
	private int id;
	private LocalDate date;
	private LocalTime heure;
	private int gagnant;
	
	public Match(int id, LocalDate date, LocalTime heure, int gagnant) {
		this.id = id;
		this.date = date;
		this.heure = heure;
		this.gagnant = gagnant;
	}
	
	public Match(int id, LocalDate date, LocalTime heure) {
		this.id = id;
		this.date = date;
		this.heure = heure;
	}
	
	public int getId() {
		return id;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public LocalTime getHeure() {
		return heure;
	}
	
	public int getGagnant() {
		return gagnant;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}
	
	public void setGagnant(int gagnant) {
		this.gagnant = gagnant;
	}
	
	

}
