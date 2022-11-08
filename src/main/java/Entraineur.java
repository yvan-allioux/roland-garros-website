import java.time.LocalDate;

public class Entraineur {

	private int id;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance = null;
	private String nationalite = null;
	private String main = null;
	private LocalDate dateCarriere = null;
	private int meilleurClassement = (Integer)null;
	
	public Entraineur(int id, String nom, String prenom, LocalDate dateNaissance, String nationalite, String main, LocalDate dateCarriere, int meilleurClassement) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.nationalite = nationalite;
		this.main = main;
		this.dateCarriere = dateCarriere;
		this.meilleurClassement = meilleurClassement;
	}
	
	public Entraineur(int id, String nom, String prenom) {
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
	
	public String getNationalite() {
		return nationalite;
	}
	
	public String getMain() {
		return main;
	}
	
	public LocalDate getDateCarriere() {
		return dateCarriere;
	}
	
	public int getMeilleurClassement() {
		return meilleurClassement;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	
	public void setMain(String main) {
		this.main = main;
	}
	
	public void setDateCarriere(LocalDate dateCarriere) {
		this.dateCarriere = dateCarriere;
	}
	
	public void setMeilleurClassement(int meilleurClassement) {
		this.meilleurClassement = meilleurClassement;
	}
		
}