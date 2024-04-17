package esercizio1;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Creazione primo rettangolo");
        System.out.println("Mettere una larghezza");
        double larghezza = scanner.nextDouble();
        System.out.println("Mettere una altezza");
        double altezza = scanner.nextDouble();
        Esercizio1 r1 = new Esercizio1(larghezza,altezza);
        System.out.println(" Ecco il primo rettangolo:"); stampaRettangolo1(r1);

        System.out.println("----------------");

        System.out.println("Creazione secondo rettangolo");
        System.out.println("Mettere una larghezza");
        double larghezza2 = scanner.nextDouble();
        System.out.println("Mettere una altezza");
        double altezza2 = scanner.nextDouble();
        Esercizio1 r2 = new Esercizio1(larghezza2,altezza2);
        System.out.println(" Ecco il secondo rettangolo:"); stampaRettangolo2(r2);
        System.out.println("----------------");
        System.out.println("Stampa riassuntiva dei rettangolo + i perimetri e aree sommate tra di loro: ");
        stampaDuerettangoli(r1,r2);
    }


    public static void stampaRettangolo1(Esercizio1 r1) {
        System.out.println("Perimetro rettangolo: " + r1.getPerimetro());
        System.out.println("Area rettangolo: " + r1.getArea());
    }

    public static void stampaRettangolo2(Esercizio1 r2) {
        System.out.println("Perimetro rettangolo: " + r2.getPerimetro());
        System.out.println("Area rettangolo: " + r2.getArea());
    }

    public static void stampaDuerettangoli(Esercizio1 r1, Esercizio1 r2) {

        System.out.println("Stampa primo rettangolo:");stampaRettangolo1(r1);

        System.out.println("Stampa secondo rettangolo:");stampaRettangolo2(r2);

        double sommaPerimetroRettangoli = r1.getPerimetro() + r2.getPerimetro();
        double sommaAreerettangoli = r1.getArea() + r2.getArea();


        System.out.println("Stampa dei perimetri: " + sommaPerimetroRettangoli );
        System.out.println("Stampa delle aree: " + sommaAreerettangoli);


    }
}
