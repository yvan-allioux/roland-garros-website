public class Equipe{
	
	private int id;
	private Joueur joueur1, joueur2;
	
	public Equipe(int id) {
		this.id = id;
		joueur1 = new Joueur(id, null, null, null, id);
		joueur2 = new Joueur(id, null, null, null, id);
	}
	
	public void setId(int id) {
		this.id = id;
		}
	
	public void setJoueurs(Joueur joueur1, Joueur joueur2) {
		joueur1 = joueur1;
		joueur2 = joueur2;
	}
	
	public int getId() {
		return id;
	}
	
	public Joueur getJoueur1() {
		return joueur1;
	}
	
	public Joueur getJoueur2() {
		return joueur2;
	}
	
}