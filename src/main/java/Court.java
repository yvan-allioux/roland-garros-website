
public class Court {
	
	private int id;
	private String nom;
	
	public Court(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}

}
