package model;
 
public class Carte {
    private int valeur;
    private String couleur;

    public Carte(int valeur, String couleur){
        this.valeur = valeur;
        this.couleur = couleur;
    }

    public int getValeur() {
        return valeur;
    }

    public String getCouleur() {
        return couleur;
    }

    public String afficherCarte() {
        return valeur + couleur;
    }
}