package model;

import java.util.List;

public class Combinaison {
    private List<Carte> cartes;
    private TypeCombinaison type;
    private int valeur;

    public Combinaison(List<Carte> cartes, TypeCombinaison type, int valeur) {
        this.cartes = cartes;
        this.type = type;
        this.valeur = valeur;
    }

    public TypeCombinaison getType() {
        return type;
    }

    public int getValeur() {
        return valeur;
    }

    public List<Carte> getCartes() {
        return cartes;
    }
}