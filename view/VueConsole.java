package view;

import model.*;
import java.util.Scanner;

public class VueConsole {

    private Scanner scanner;

    public VueConsole() {
        scanner = new Scanner(System.in);
    }

    public void afficherMessage(String msg) {
        System.out.println(msg);
    }

    public void afficherMain(Joueur joueur) {
        System.out.println("Main de " + joueur.getNom() + ":");
        for (int i = 0; i < joueur.getMain().size(); i++) {
            Carte c = joueur.getMain().get(i);
            System.out.println("[" + i + "] " + c.afficherCarte());
        }
    }

    public int demanderChoix(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    public void afficherPlateau(Plateau plateau) {
        System.out.println("===== PLATEAU =====");

        for (Borne b : plateau.getBornes()) {
            System.out.println("Borne " + b.getId());

            System.out.print("A: ");
            for (Carte c : b.getCartesJ1()) {
                System.out.print(c.afficherCarte() + " ");
            }
            System.out.println();

            System.out.print("B: ");
            for (Carte c : b.getCartesJ2()) {
                System.out.print(c.afficherCarte() + " ");
            }
            System.out.println();
        }
    }
}