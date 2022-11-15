
public class Court {
	
	private Integer id;
	private String nom;
	
	public Court(Integer id, String nom) {
		this.id = id;
		this.nom = nom;
	}
	
	//méthode fixe un ID
	public void setId(Integer id) {
		this.id = id;
	}
	
	//méthode fixe un nom
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	//méthode obtenir l'ID d'un joueur
	public Integer getId() {
		return id;
	}
	
	//méthode obtenir le nom d'un joueur
	public String getNom() {
		return nom;
	}

}
