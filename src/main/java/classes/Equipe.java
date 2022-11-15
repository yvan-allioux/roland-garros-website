public class Equipe{

	private Integer id;
	private Joueur joueur1, joueur2;
	
	//CONSTRUCTEUR
	public Equipe(Integer id) {
		this.id = id;
		this.joueur1 = new Joueur(id, null, null, null, id);
		this.joueur2 = new Joueur(id, null, null, null, id);
	}

	//METHODES

	//GETTERS
	public Integer getId() {
		return id;
	}

	public Joueur getJoueur1() {
		return joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

	//SETTERS
	public void setId(Integer id) {
		this.id = id;
	}
	public void setJoueurs(Joueur joueur1, Joueur joueur2) {
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
	}
	
}