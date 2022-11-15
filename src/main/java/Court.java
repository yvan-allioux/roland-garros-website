
public class Court {
	//ATTRIBUTS
	private int id;
	private String nom;
	//CONSTRUCTEUR
	public Court(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}
	//GETTERS
	public int getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	//SETTERS
	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
