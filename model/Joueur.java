package model;
import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private String nom;
    private List<Carte> main;

    public Joueur(String nom) {
        this.nom = nom;
        this.main = new ArrayList<>();
    }

    public String getNom(){
        return nom;
    }
    public List<Carte> getMain(){
        return main;
    }

    public void AjouterCarte(Carte c){
        main.add(c);
    }

    public Carte jouerCarte(int indice) {
        if (indice >= 0 && indice < main.size()) {
            return main.remove(indice);
        }
        return null;
    }

    public boolean aDesCartes() {
        return !main.isEmpty();
    }

    public String afficherMain() {
        String res = nom + " : ";
        for (Carte c : main) {
            res += c.afficherCarte() + " ";
        }
        return res;
    }
}
