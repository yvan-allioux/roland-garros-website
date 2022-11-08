import java.time.LocalTime;

public class Score {
	
	private Integer nbSet;
	private Integer nbJeu;
	private LocalTime temps;
	
	public Score(Integer nbSet, Integer nbJeu, LocalTime temps) {
		this.nbSet = nbSet;
		this.nbJeu = nbJeu;
		this.temps = temps;
	}
	
	//méthode fixe un nombre de sets
	public void setNbSet(Integer nbSet) {
		this.nbSet = nbSet;
	}
	
	//méthode fixe un nombre de jeux
	public void setNbJeu(Integer nbJeu) {
		this.nbJeu = nbJeu;
	}
	
	//méthode fixe un temps de jeu
	public void setTemps(LocalTime temps) {
		this.temps = temps;
	}
	
	//méthode obtenir le nombre de sets joué pendant le match
	public Integer getNbSet() {
		return nbSet;
	}
	
	//méthode obtenir le nombre de jeux joué pendant le match
	public Integer getNbJeu() {
		return nbJeu;
	}
	//méthode obtenir la durée du match
	public LocalTime getTemps() {
		return temps;
	}

}
