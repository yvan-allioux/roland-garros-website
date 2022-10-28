import java.time.LocalDate;

public class Joueur{
	
	private int id;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance = null;
	private String lieuNaissance = null;
	private String nationalite = null;
	private int taille = (Integer)null;
	private float poids = (Float)null;
	private String sexe;
	private String main = null;
	private LocalDate dateCarriere = null;
	private int classement = (Integer)null;
	private int entraineur;

	public Joueur(int id, String nom, String prenom, String sexe, int entraineur, LocalDate dateNaissance, String lieuNaissance, String nationalite, int taille, float poids, String main, LocalDate dateCarriere, int classement) {
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
	
	public Joueur(int id, String nom, String prenom, String sexe, int entraineur) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.entraineur = entraineur;
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
	
	public float getPoids() {
		return poids;
	}
	
	public String getSexe() {
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
	
	public int getEntraineur() {
		return entraineur;
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
	
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	public void setEntraineur(int entraineur) {
		this.entraineur = entraineur;
	}
	
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}
	
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	
	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	public void setPoids(float poids) {
		this.poids = poids;
	}
	
	public void setMain(String main) {
		this.main = main;
	}
	
	public void setDateCarriere(LocalDate dateCarriere) {
		this.dateCarriere = dateCarriere;
	}
	
	public void setClassement(int classement) {
		this.classement = classement;
	}	
	
}
