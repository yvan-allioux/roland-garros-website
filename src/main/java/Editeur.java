
public class Editeur {
	//ATTRIBUTS
	private int id;
	private String pseudo;
	private String password;
	private int role;
	//CONSTRUCTEUR
	public Editeur(int id, String pseudo, String password, int role) {
		this.id = id;
		this.pseudo = pseudo;
		this.password = password;
		this.role = role;
	}
	//METHODES

	//GETTERS

	//SETTERS
	public void setId(int id) {
		this.id = id;
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setRole(int role) {
		this.role = role;
	}
	
}
