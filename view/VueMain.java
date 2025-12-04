package view;

import model.Carte;
import model.Joueur;

public class VueMain {

    public void afficherMain(Joueur joueur) {
        System.out.println("Main de " + joueur.getNom() + ":");
        for (int i = 0; i < joueur.getMain().size(); i++) {
            Carte c = joueur.getMain().get(i);
            System.out.println("indice carte : " + i + ", carte :" + c.afficherCarte());
        }
    }
}