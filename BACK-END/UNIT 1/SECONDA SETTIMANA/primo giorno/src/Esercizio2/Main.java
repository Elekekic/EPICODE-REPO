package Esercizio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Calcoliamo il numero di km/litri percorsi dalla tua auto!");
        System.out.println("Inserisci il numero di km percorsi: ");
        double km = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Inserisci il numero di litri di carburante consumati: ");
        double litri = scanner.nextDouble();
        scanner.nextLine();

        try {
            double risultato = risultato(km, litri);
            System.out.println("Sono: " + risultato + "km/l");
        } catch (ArithmeticException e) {
            System.out.println("Assicurati di inserire un numero diverso da zero per i litri");
        }

        scanner.close();
    }

    public static double risultato(double km, double litri) throws ArithmeticException {
        if (litri == 0) {
            throw new ArithmeticException("Divisione per zero");
        }
        return km / litri;
    }
}
