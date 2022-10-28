import java.time.LocalDate;

public class Joueur{
	
	private int id;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String lieuNaissance;
	private String nationalite;
	private int taille;
	private int poids;
	private int sexe;
	private String main;
	private LocalDate dateCarriere;
	private int classement;

	public Joueur(int id, String nom, String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	
	public String getLieuNaissance() {
		return lieuNaissance;
	}
	
	public String getNationalite() {
		return nationalite;
	}
	
	public int getTaille() {
		return taille;
	}
	
	public int getPoids() {
		return poids;
	}
	
	public int getSexe() {
		return sexe;
	}
	
	public String getMain() {
		return main;
	}
	
	public LocalDate getDateCarriere() {
		return dateCarriere;
	}
	
	public int getClassement() {
		return classement;
	}
	
	
}
