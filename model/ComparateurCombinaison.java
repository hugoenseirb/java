package model;

public class ComparateurCombinaison {

    public int compare(Combinaison c1, Combinaison c2) {

        // on compare le type de combinaison
        int ordreType = c1.getType().compareTo(c2.getType()); // renvoie un nb negatif si c1 > c2 positif si c1 < c2 et 0 si égalité.
        if (ordreType != 0) {
            return ordreType;
        }
        // Si les types sont les mêmes alors on compare la valeur interne
        return Integer.compare(c1.getValeur(), c2.getValeur());
    }
}