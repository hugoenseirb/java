package model;

import java.util.ArrayList;
import java.util.List;

public class EditionBase extends Edition {

    private static final int NB_BORNES_BASE = 9;
    private static final int NB_CARTES_MAIN_BASE = 6;
    private static final int TAILLE_MAX_PAR_BORNE_BASE = 3;
    private static final boolean CARTES_TACTIQUES_BASE = false;

    public EditionBase() {
        super("Schotten-Totten - Variante de base",
              NB_BORNES_BASE,
              NB_CARTES_MAIN_BASE,
              TAILLE_MAX_PAR_BORNE_BASE,
              CARTES_TACTIQUES_BASE);
    }
    @Override
    public Pioche creerPioche() {
        List<Carte> cartes = new ArrayList<>();

        for (Couleur c : Couleur.values()) {
            for (int v = 1; v <= 9; v++) {
                cartes.add(new Carte(v, c));
            }
        }

        return new Pioche(cartes);
    }
}