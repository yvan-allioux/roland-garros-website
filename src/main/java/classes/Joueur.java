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
	private String nomEntraineur=null;

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
	
	public Joueur(String nom, String prenom, String sexe,String nationalite,LocalDate dateNaissance, LocalDate dateDebutCarriere ) {
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.nationalite = nationalite;
		this.dateCarriere = dateDebutCarriere;
		this.dateNaissance = dateNaissance;
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
	
	public String getNomComplet() {
		return prenom+" "+nom;
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
	public int getAnneeCarriere() {
		return dateCarriere.getYear();
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
	
	public String getMainComplet() {
		
		String mainTxt=null;
		
		 // redéfinition de l'affichage de la main
		if(this.main!=null) {
			 if(this.main.equals("D")&& this.sexe.equals("F")){
		    	  mainTxt = "Droitière";
		      }else if (this.main.equals("D")&& this.sexe.equals("H")){
		    	  mainTxt = "Droitier";
		      }else if (this.main.equals("G")&& this.sexe.equals("F")){
		    	  mainTxt = "Gauchère";
		      }else if (this.main.equals("G")&& this.sexe.equals("H")){
		    	  mainTxt = "Gaucher";
		      }
		}else {
	    	  mainTxt = "Inconnu";
	    }
	      
	      return mainTxt;
		
	}
	
	public String getSexeComplet() {
		
		String sexeTxt;
		
		 // redéfinition de l'affichage de la main
	      if(this.sexe.equals("F")){
	    	  sexeTxt = "Femme";
	      }else if (this.sexe.equals("H")){
	    	  sexeTxt = "Homme";
	      }else {
	    	  sexeTxt = null;
	      }
	      
	      return sexeTxt;
		
	}
	
	public int getAge() {
		
	      // calcul de l'age à partir de la date de naissance 
	      LocalDate dateJour = LocalDate.now();
	      int age =  dateJour.getYear() - dateNaissance.getYear();
	      return age;
	}

	public String getNomEntraineur() {
		return nomEntraineur;
	}

	public void setNomEntraineur(String nomEntraineur) {
		this.nomEntraineur = nomEntraineur;
	}
	

}
