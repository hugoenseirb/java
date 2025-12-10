package model;

import java.util.ArrayList;
import java.util.List;

public class EditionTactique extends Edition {

    private static final int NB_BORNES_TACTIQUE = 9;
    private static final int NB_CARTES_MAIN_TACTIQUE = 6;
    private static final int TAILLE_MAX_PAR_BORNE_TACTIQUE = 3;
    private static final boolean CARTES_TACTIQUES_TACTIQUE = true;

    public EditionTactique() {
        super("Schotten-Totten - Variante tactique",
              NB_BORNES_TACTIQUE,
              NB_CARTES_MAIN_TACTIQUE,
              TAILLE_MAX_PAR_BORNE_TACTIQUE,
              CARTES_TACTIQUES_TACTIQUE);
    }

    @Override
    public Pioche creerPioche() {
        List<Carte> cartes = new ArrayList<>();

        for (Couleur couleur : Couleur.values()) {
            for (int valeur = 1; valeur <= 9; valeur++) {
                cartes.add(new Carte(valeur, couleur));
            }
        }
        return new Pioche(cartes);
    }

}