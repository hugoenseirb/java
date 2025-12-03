package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pioche {
    private List<Carte> cartes;
    public Pioche(List<Carte> cartesInitiales) {
        this.cartes = new ArrayList<>(cartesInitiales);
        melanger();
    }
    public void melanger(){
        Collections.shuffle(cartes);
    }
    public Carte piocher() {
        if (cartes.isEmpty()) return null;
        return cartes.remove(0);
    }
    public int taille() {
        return cartes.size();
    }
    public boolean estVide() {
        return cartes.isEmpty();
    }
}
 