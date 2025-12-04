package view;

import model.Plateau;
import model.Borne;

public class VuePlateau {

    private VueBorne vueBorne;

    public VuePlateau() {
        this.vueBorne = new VueBorne();
    }

    public void afficherPlateau(Plateau plateau) {
        System.out.println("--------- PLATEAU -------");
        for (Borne b : plateau.getBornes()) {
            vueBorne.afficherBorne(b);
        }
    }
}