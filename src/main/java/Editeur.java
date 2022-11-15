
public class Editeur {
	
	private Integer id;
	private String pseudo;
	private String password;
	private Integer role;
	
	public Editeur(Integer id, String pseudo, String password, Integer role) {
		this.id = id;
		this.pseudo = pseudo;
		this.password = password;
		this.role = role;
	}

	//méthode fixe un ID
	public void setId(Integer id) {
		this.id = id;
	}
	
	//méthode fixe un pseudo
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	//méthode fixe un mot de passe
	public void setPassword(String password) {
		this.password = password;
	}
	
	//méthode fixe un rôle
	public void setRole(Integer role) {
		this.role = role;
	}
	
}
