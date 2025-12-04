package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pioche {

    private List<Carte> cartes;

    public Pioche() {
        cartes = new ArrayList<>();
        initialiserCartes();
        melanger();
    }

    private void initialiserCartes() {
        for (Couleur couleur : Couleur.values()) {
            for (int valeur = 1; valeur <= 9; valeur++) {
                cartes.add(new Carte(valeur, couleur));
            }
        }
    }

    public void melanger() {
        Collections.shuffle(cartes);
    }

    public Carte piocher() {
        if (cartes.isEmpty()) {
            return null;
        }
        return cartes.remove(0);
    }

    public boolean estVide() {
        return cartes.isEmpty();
    }

    public int taille() {
        return cartes.size();
    }
}