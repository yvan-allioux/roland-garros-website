package models;

import classes.Court;
import classes.Joueur;

public interface EntrainementDAO {

    //test si l'entrainement existe
    public boolean entrainementExiste(String id_entrainement);


    //retourne l'horaire de l'entrainement
    public String getHoraire(String id_entrainement);//objet date/heur ?



    /*//retourne le date de l'entrainement
    public String getDAte(String id_entrainement);//objet date/heur ?

    //retourne le joueur de l'entrainement
    public Joueur getJoueur(String id_entrainement);//retourne un objet joueur

    //retourne le court de l'entrainement
    public Court getCourt(String id_entrainement);*/

}
