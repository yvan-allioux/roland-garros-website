package classes;

public class Equipe {

	private Integer id;
	private Joueur joueur1, joueur2;
	private String nom;

	// CONSTRUCTEUR
	public Equipe(Integer id, Joueur j1, Joueur j2) {
		this.id = id;
		this.joueur1 = j1;
		this.joueur2 = j2;
		this.nom = j1.getNom() + " & " + j2.getNom();
	}

	// METHODES

	// GETTERS
	public Integer getId() {
		return id;
	}

	public Joueur getJoueur1() {
		return joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

	public String getNom() {
		return nom;
	}

	// SETTERS
	public void setId(Integer id) {
		this.id = id;
	}

	public void setJoueurs(Joueur joueur1, Joueur joueur2) {
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
	}

}