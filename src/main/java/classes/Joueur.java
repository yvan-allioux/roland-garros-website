package classes;

import java.time.LocalDate;

public class Joueur{

	//ATTRIBUTS
	private Integer id;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String lieuNaissance;
	private String nationalite ;
	private int taille;
	private float poids;
	private String sexe;
	private String main;
	private LocalDate dateCarriere;
	private int classement;
	private Integer entraineur;

	//CONSTRUCTEURS
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
	
	public Joueur(int id, String nom, String prenom, String sexe,Integer entraineur) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.entraineur = entraineur;
	}

	//GETTERS
	public Integer getId() {
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
	public Integer getTaille() {
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
	public Integer getClassement() {
		return classement;
	}
	public Integer getEntraineur() {
		return entraineur;
	}
	
	//SETTERS
	public void setId(Integer id) {
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
	public void setEntraineur(Integer entraineur) {
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
	public void setTaille(Integer taille) {
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
	public void setClassement(Integer classement) {
		this.classement = classement;
	}
	

}
