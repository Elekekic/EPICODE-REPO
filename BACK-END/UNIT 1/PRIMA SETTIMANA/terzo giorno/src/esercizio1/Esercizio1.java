package esercizio1;

public class Esercizio1 {
    double altezza;
    double larghezza;

    //costruttore
    public Esercizio1(double alt, double larg) {
        this.altezza = alt;
        this.larghezza = larg;
    }
    //metodo per prendermi l'area
    public double getArea() {
        return altezza * larghezza;
    }

    //metodo per prendermi il perimetro
    public double getPerimetro() {
        return (altezza + larghezza) * 2;
    }

}
