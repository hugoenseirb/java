package view;

import model.Joueur;
import model.Plateau;
import java.util.Scanner;

public class VueConsole {

    private Scanner scanner;
    private VueMain vueMain;
    private VuePlateau vuePlateau;
    private VueMenu vueMenu;

    public VueConsole() {
        scanner = new Scanner(System.in);
        vueMain = new VueMain();
        vuePlateau = new VuePlateau();
        vueMenu = new VueMenu();
    }

    public void afficherMessage(String msg) {
        System.out.println(msg);
    }

    public void afficherMain(Joueur joueur) {
        vueMain.afficherMain(joueur);
    }

    public void afficherPlateau(Plateau plateau) {
        vuePlateau.afficherPlateau(plateau);
    }

    public void afficherMenuPrincipal() {
        vueMenu.afficherMenuPrincipal();
    }

    public int demanderChoix(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }
}