package controller;

import java.util.Scanner;

import ia.BasicIA;
import model.*;
import view.*;
import java.util.Scanner;

public class Jeu {

    private VueConsole vue;
    private Plateau plateau;
    private BasicIA ia;
    private Joueur joueurA;
    private Joueur joueurB;
    private Joueur joueurCourant;
    private boolean isIA;   // true si Joueur 2 est une IA
    private Edition edition;

    public Jeu(Edition edition) {
        this.edition = edition;
        vue = new VueConsole();
        joueurA = new Joueur("Joueur 1");
        joueurB = new Joueur("Joueur 2");
        plateau = new Plateau(edition, joueurA, joueurB);
        joueurCourant = joueurA;
        ia = new BasicIA();
        isIA = false;
    }

    public Jeu() {
        this(new EditionBase());
    }

    public void lancer() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Voulez-vous jouer contre une IA ? (Y/N) ");
        String rep = sc.nextLine().trim().toUpperCase();
        isIA = rep.equals("Y");

        while (!partieTerminee()) {
            tourDeJeu();
            changerJoueur();
        }
        vue.afficherMessage("Partie terminée.");
    }

    private void tourDeJeu() {
        vue.afficherPlateau(plateau);
        vue.afficherMain(joueurCourant);

        if (joueurCourant.getMain().isEmpty()) {
            vue.afficherMessage("Plus de carte à jouer pour " + joueurCourant.getNom());
            return;
        }

        if (isIA && joueurCourant == joueurB) {
            tourDeJeuIA();
        } else {
            tourDeJeuHumain();
        }
    }

    // Tour de jeu pour l'IA (toujours Joueur 2)
    private void tourDeJeuIA() {
        // Choix de la carte aléatoire dans la main de l'IA (joueurB)
        Carte carte = ia.choisirCarte(joueurCourant);
        int indexCarte = joueurCourant.getMain().indexOf(carte);

        // Choix de la borne random non pleine pour joueur 2
        int indexBorne = ia.choisirBorne(plateau);
        Borne borne = plateau.getBornes().get(indexBorne);

        vue.afficherMessage("L'IA joue la carte " + carte + " sur la borne " + indexBorne);

        if (borne.getCartesJ2().size() >= 3) {
            vue.afficherMessage("Aucune borne disponible pour l'IA.");
            return;
        }

        // Pose de la carte pour Joueur 2 (IA)
        borne.ajouterCarteJ2(carte);

        // Retirer la carte de la main
        joueurCourant.getMain().remove(indexCarte);

        // Piocher si possible
        if (!plateau.getPioche().estVide()) {
            joueurCourant.AjouterCarte(plateau.getPioche().piocher());
        }
    }

    // Tour de jeu pour un joueur humain (Joueur 1 ou Joueur 2 si pas d'IA)
    private void tourDeJeuHumain() {
        int indexCarte = vue.demanderChoix("Indice de la carte à jouer : ");
        if (indexCarte < 0 || indexCarte >= joueurCourant.getMain().size()) {
            vue.afficherMessage("Indice de carte invalide.");
            return;
        }

        int indexBorne = vue.demanderChoix("Indice de la borne : ");
        if (indexBorne < 0 || indexBorne >= plateau.getBornes().size()) {
            vue.afficherMessage("Indice de borne invalide.");
            return;
        }

        Borne borne = plateau.getBornes().get(indexBorne);

        if (joueurCourant == joueurA) {
            if (borne.getCartesJ1().size() >= 3) {
                vue.afficherMessage("Borne pleine pour le joueur A.");
                return;
            }
        } else {
            if (borne.getCartesJ2().size() >= 3) {
                vue.afficherMessage("Borne pleine pour le joueur B.");
                return;
            }
        }

        Carte carte = joueurCourant.getMain().get(indexCarte);

        if (joueurCourant == joueurA) {
            borne.ajouterCarteJ1(carte);
        } else {
            borne.ajouterCarteJ2(carte);
        }

        joueurCourant.getMain().remove(indexCarte);

        if (!plateau.getPioche().estVide()) {
            joueurCourant.AjouterCarte(plateau.getPioche().piocher());
        }
    }

    private void changerJoueur() {
        if (joueurCourant == joueurA) {
            joueurCourant = joueurB;
        } else {
            joueurCourant = joueurA;
        }
    }

    private boolean partieTerminee() {
        return plateau.getPioche().estVide()
                && joueurA.getMain().isEmpty()
                && joueurB.getMain().isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choisissez la variante :");
        System.out.println("1 - Variante de base");
        System.out.println("2 - Variante tactique");
        int choix = sc.nextInt();

        Edition edition;
        if (choix == 2) {
            edition = new EditionTactique();
        } else {
            edition = new EditionBase();
        }

        Jeu jeu = new Jeu(edition);
        jeu.lancer();
    }
}