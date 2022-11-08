public class Equipe{
	
	private Integer id;
	private Joueur joueur1, joueur2;
	
	public Equipe(Integer id) {
		this.id = id;
		joueur1 = new Joueur(id, null, null, null, id);
		joueur2 = new Joueur(id, null, null, null, id);
	}
	
	//méthode fixe un ID
	public void setId(Integer id) {
		this.id = id;
		}
	
	//méthode fixe deux joueurs dans une équipe
	public void setJoueurs(Joueur joueur1, Joueur joueur2) {
		joueur1 = joueur1;
		joueur2 = joueur2;
	}
	
	//méthode obtenir l'ID d'une équipe
	public Integer getId() {
		return id;
	}
	
	//méthode obtenir le joueur1 de l'équipe
	public Joueur getJoueur1() {
		return joueur1;
	}
	
	//méthode obtenir le joueur2 de l'équipe
	public Joueur getJoueur2() {
		return joueur2;
	}
	
}