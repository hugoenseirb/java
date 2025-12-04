package view;

import model.Borne;
import model.Carte;

public class VueBorne {

    public void afficherBorne(Borne borne) {
        System.out.println("Borne ID" + borne.getId());

        System.out.print("Joueur 1 : ");
        for (Carte c : borne.getCartesJ1()) {
            System.out.print(c.afficherCarte() + " ");
        }
        System.out.println();

        System.out.print("Joueur 2 : ");
        for (Carte c : borne.getCartesJ2()) {
            System.out.print(c.afficherCarte() + " ");
        }
        System.out.println();
    }
}