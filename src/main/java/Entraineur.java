import java.time.LocalDate;

public class Entraineur {

	private Integer id;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance = null;
	private String nationalite = null;
	private String main = null;
	private LocalDate dateCarriere = null;
	private Integer meilleurClassement = null;
	
	public Entraineur(Integer id, String nom, String prenom, LocalDate dateNaissance, String nationalite, String main, LocalDate dateCarriere, Integer meilleurClassement) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.nationalite = nationalite;
		this.main = main;
		this.dateCarriere = dateCarriere;
		this.meilleurClassement = meilleurClassement;
	}
	
	public Entraineur(Integer id, String nom, String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	//méthode fixe un ID
	public void setId(Integer id) {
		this.id = id;
	}
	
	//méthode fixe un nom
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	//méthode fixe un prénom
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	//méthode fixe une date de naissance
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	//méthode fixe une nationalite
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	
	//méthode fixe une main
	public void setMain(String main) {
		this.main = main;
	}
	
	//méthode fixe une date de début de carrière
	public void setDateCarriere(LocalDate dateCarriere) {
		this.dateCarriere = dateCarriere;
	}
	
	//méthode fixe un meilleur classement
	public void setMeilleurClassement(Integer meilleurClassement) {
		this.meilleurClassement = meilleurClassement;
	}
	
	//méthode obtenir l'ID de l'entraineur
	public Integer getId() {
		return id;
	}
	
	//méthode obtenir le nom de l'entraineur
	public String getNom() {
		return nom;
	}
	
	//méthode obtenir le prénom de l'entraineur
	public String getPrenom() {
		return prenom;
	}
	
	//méthode obtenir la date de naissance de l'entraineur
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	
	//méthode obtenir la nationalite de l'entraineur
	public String getNationalite() {
		return nationalite;
	}
	
	//méthode obtenir la main de l'entraineur
	public String getMain() {
		return main;
	}
	
	//méthode obtenir la date de début de carrière de l'entraineur
	public LocalDate getDateCarriere() {
		return dateCarriere;
	}
	
	//méthode obtenir le meilleur classement de l'entraineur
	public Integer getMeilleurClassement() {
		return meilleurClassement;
	}
		
}
