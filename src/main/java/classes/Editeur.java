package classes;

public class Editeur {
	//ATTRIBUTS
	private Integer id;
	private String pseudo;
	private String password;
	private Integer role;
	//CONSTRUCTEUR
	public Editeur(Integer id, String pseudo, String password, Integer role) {
		this.id = id;
		this.pseudo = pseudo;
		this.password = password;
		this.role = role;
	}
	//METHODES

	//GETTERS

	//SETTERS
	public void setId(Integer id) {
		this.id = id;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	
}
