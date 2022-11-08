import java.time.LocalTime;

public class Score {
	
	private int nbSet;
	private int nbJeu;
	private LocalTime temps;
	
	public Score(int nbSet, int nbJeu, LocalTime temps) {
		this.nbSet = nbSet;
		this.nbJeu = nbJeu;
		this.temps = temps;
	}
	
	public void setNbSet(int nbSet) {
		this.nbSet = nbSet;
	}
	
	public void setNbJeu(int nbJeu) {
		this.nbJeu = nbJeu;
	}
	
	public void setTemps(LocalTime temps) {
		this.temps = temps;
	}
	
	public int getNbSet() {
		return nbSet;
	}
	
	public int getNbJeu() {
		return nbJeu;
	}
	
	public LocalTime getTemps() {
		return temps;
	}

}
