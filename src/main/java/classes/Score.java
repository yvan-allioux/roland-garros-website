package classes;

import java.time.LocalTime;

public class Score {

	//ATTRIBUTS
	private Integer nbSet;
	private Integer nbJeu;
	private LocalTime temps;

	//CONSTRUCTEUR
	public Score(Integer nbSet, Integer nbJeu, LocalTime temps) {
		this.nbSet = nbSet;
		this.nbJeu = nbJeu;
		this.temps = temps;
	}

	//METHODES

	//GETTERS
	public Integer getNbSet() {
		return nbSet;
	}
	public Integer getNbJeu() {
		return nbJeu;
	}
	public LocalTime getTemps() {
		return temps;
	}

	//SETTERS
	public void setNbSet(Integer nbSet) {
		this.nbSet = nbSet;
	}
	public void setNbJeu(Integer nbJeu) {
		this.nbJeu = nbJeu;
	}
	public void setTemps(LocalTime temps) {
		this.temps = temps;
	}
	
	

}
