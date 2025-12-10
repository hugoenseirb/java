
package model;

public abstract class Edition {

    private final String nom;
    private final int nbBornes;
    private final int nbCartesEnMain;
    private final int tailleMaxParBorne;
    private final boolean cartesTactiques;

    protected Edition(String nom, int nbBornes, int nbCartesEnMain, int tailleMaxParBorne, boolean cartesTactiques) {
        this.nom = nom;
        this.nbBornes = nbBornes;
        this.nbCartesEnMain = nbCartesEnMain;
        this.tailleMaxParBorne = tailleMaxParBorne;
        this.cartesTactiques = cartesTactiques;
    }

    public String getNom() {
        return nom;
    }

    public int getNbBornes() {
        return nbBornes;
    }

    public int getNbCartesEnMain() {
        return nbCartesEnMain;
    }

    public int getTailleMaxParBorne() {
        return tailleMaxParBorne;
    }

    public boolean hasCartesTactiques() {
        return cartesTactiques;
    }

    public String toString() {
        return nom;
    }

    public abstract Pioche creerPioche();

    public boolean peutJouerCarteTactique(Joueur jActif, Joueur jAdverse) {
        return false; 
    }

    public void appliquerEffet(Carte carteTactique, Borne borne, Joueur jActif, Plateau plateau) {
    }
}