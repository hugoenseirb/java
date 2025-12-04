package controller;

import model.*;
import view.*;

public class Jeu {

    private VueConsole vue;
    private Plateau plateau;
    private Joueur joueurA;
    private Joueur joueurB;
    private Joueur joueurCourant;

    public Jeu() {
        vue = new VueConsole();
        joueurA = new Joueur("Joueur 1");
        joueurB = new Joueur("Joueur 2");
        Edition edition = new EditionBase();
        plateau = new Plateau(edition, joueurA, joueurB);
        joueurCourant = joueurA;
    }

    public void lancer() {
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
        Jeu jeu = new Jeu();
        jeu.lancer();
    }
}