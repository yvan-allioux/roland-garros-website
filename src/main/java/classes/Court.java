
public class Court {
	
	private Integer id;
	private String nom;
	
	//CONSTRUCTEURS
	public Court(Integer id, String nom) {
		this.id = id;
		this.nom = nom;
	}
	

	//GETTERS
	public String getNom() {
		return nom;
	}
	public Integer getId() {
		return id;
	}

	//SETTERS
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

}
