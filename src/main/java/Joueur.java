import java.time.LocalDate;

public class Joueur{
	
	private Integer id;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance = null;
	private String lieuNaissance = null;
	private String nationalite = null;
	private Integer taille = null;
	private float poids = (Float)null;
	private String sexe;
	private String main = null;
	private LocalDate dateCarriere = null;
	private Integer classement = null;
	private Integer entraineur;

	public Joueur(Integer id, String nom, String prenom, String sexe, Integer entraineur, LocalDate dateNaissance, String lieuNaissance, String nationalite, Integer taille, float poids, String main, LocalDate dateCarriere, Integer classement) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.entraineur = entraineur;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.nationalite = nationalite;
		this.taille = taille;
		this.poids = poids;
		this.main = main;
		this.dateCarriere = dateCarriere;
		this.classement = classement;
	}
	
	public Joueur(Integer id, String nom, String prenom, String sexe, Integer entraineur) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.entraineur = entraineur;
	}
	
	//méthode fixe un ID
	public void setId(Integer id) {
		this.id = id;
	}
	
	//méthode fixe un nom
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	//méthode fixe un prenom
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	//méthode fixe un sexe
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	//méthode fixe un entraineur
	public void setEntraineur(Integer entraineur) {
		this.entraineur = entraineur;
	}
	
	//méthode fixe une date de naissance
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	//méthode fixe un lieu de naissance
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}
	
	//méthode fixe une nationalite
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	
	//méthode fixe une taille
	public void setTaille(Integer taille) {
		this.taille = taille;
	}
	
	//méthode fixe un poids
	public void setPoids(float poids) {
		this.poids = poids;
	}
	
	//méthode fixe une main
	public void setMain(String main) {
		this.main = main;
	}
	
	//méthode fixe une date de début de carrière
	public void setDateCarriere(LocalDate dateCarriere) {
		this.dateCarriere = dateCarriere;
	}
	
	//méthode fixe un classement
	public void setClassement(Integer classement) {
		this.classement = classement;
	}		
	
	//méthode obtenir l'ID du joueur
	public Integer getId() {
		return id;
	}
	
	//méthode obtenir le nom du joueur
	public String getNom() {
		return nom;
	}
	
	//méthode obtenir le prenom du joueur
	public String getPrenom() {
		return prenom;
	}
	
	//méthode obtenir la date de naissance du joueur
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	
	//méthode obtenir le lieu de naissance du joueur
	public String getLieuNaissance() {
		return lieuNaissance;
	}
	
	//méthode obtenir la nationalite du joueur
	public String getNationalite() {
		return nationalite;
	}
	
	//méthode obtenir la taille du joueur
	public Integer getTaille() {
		return taille;
	}
	
	//méthode obtenir le poids du joueur
	public float getPoids() {
		return poids;
	}
	
	//méthode obtenir le sexe du joueur
	public String getSexe() {
		return sexe;
	}
	
	//méthode obtenir la main du joueur
	public String getMain() {
		return main;
	}
	
	//méthode obtenir la date de début de carrière du joueur
	public LocalDate getDateCarriere() {
		return dateCarriere;
	}
	
	//méthode obtenir le classement du joueur
	public Integer getClassement() {
		return classement;
	}
	
	//méthode obtenir l'entraineur du joueur
	public Integer getEntraineur() {
		return entraineur;
	}
}
