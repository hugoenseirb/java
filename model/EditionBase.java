package model;

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
}