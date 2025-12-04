package model;

import java.util.ArrayList;
import java.util.List;

public class Borne {
    private List<Carte> cartesJ1;
    private List<Carte> cartesJ2;
    private boolean revendiquee;
    private int id;

    public Borne(int id) {
        this.id = id;
        this.cartesJ1 = new ArrayList<>();
        this.cartesJ2 = new ArrayList<>();
        this.revendiquee = false;
    }

    public int getId() {
        return id;
    }

    public void ajouterCarteJ1(Carte c) {
        if (cartesJ1.size() < 3) {
            cartesJ1.add(c);
        }
    }

    public void ajouterCarteJ2(Carte c) {
        if (cartesJ2.size() < 3) {
            cartesJ2.add(c);
        }
    }

    public List<Carte> getCartesJ1() {
        return cartesJ1;
    }

    public List<Carte> getCartesJ2() {
        return cartesJ2;
    }

    public boolean estComplete() {
        return cartesJ1.size() == 3 && cartesJ2.size() == 3;
    }

    public boolean estRevendiquee() {
        return revendiquee;
    }

    public void revendiquer() {
        this.revendiquee = true;
    }
}