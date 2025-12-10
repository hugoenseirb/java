package ia;

import model.Borne;
import model.Carte;
import model.Joueur;
import model.Plateau;

import java.util.List;
import java.util.Random;

public class BasicIA { // l'IA est définie comme le Joueur 2

    private Random random = new Random();

    // Choisit une carte aléatoire parmi la main de l'IA
    public Carte choisirCarte(Joueur joueurIA) {
        int taille = joueurIA.getMain().size();
        int index = random.nextInt(taille);
        return joueurIA.getMain().get(index);
    }

    // L'IA choisit une borne aléatoire NON pleine 
    public int choisirBorne(Plateau plateau) {

        List<Borne> bornes = plateau.getBornes();

        while (true) {
            int index = random.nextInt(bornes.size());
            Borne b = bornes.get(index);

            if (b.getCartesJ2().size() < 3) {
                return index;
            }
        }
    }
}