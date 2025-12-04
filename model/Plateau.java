package model;

import java.util.ArrayList;
import java.util.List;

public class Plateau {

    private Edition edition;
    private List<Borne> bornes;
    private Pioche pioche;
    private Pioche piocheTactique;
    private Joueur joueurA;
    private Joueur joueurB;

    public Plateau(Edition edition, Joueur joueurA, Joueur joueurB) {
        this.edition = edition;
        this.joueurA = joueurA;
        this.joueurB = joueurB;

        initialiserBornes();
        initialiserPioches();
        distribuerCartesInitiales();
    }

    private void initialiserBornes() {
        bornes = new ArrayList<>();
        for (int i = 0; i < edition.getNbBornes(); i++) {
            bornes.add(new Borne(i));
        }
    }

    private void initialiserPioches() {
        pioche = new Pioche();

        if (edition.hasCartesTactiques()) {
            piocheTactique = new Pioche();
        }
    }

    private void distribuerCartesInitiales() {
        for (int i = 0; i < edition.getNbCartesEnMain(); i++) {
            joueurA.AjouterCarte(pioche.piocher());
            joueurB.AjouterCarte(pioche.piocher());
        }
    }

    public List<Borne> getBornes() {
        return bornes;
    }

    public Edition getEdition() {
        return edition;
    }

    public Joueur getJoueurA() {
        return joueurA;
    }

    public Joueur getJoueurB() {
        return joueurB;
    }

    public Pioche getPioche() {
        return pioche;
    }

    public Pioche getPiocheTactique() {
        return piocheTactique;
    }
}