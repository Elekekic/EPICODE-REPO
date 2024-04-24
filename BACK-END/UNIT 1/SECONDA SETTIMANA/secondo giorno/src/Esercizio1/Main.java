package Esercizio1;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Esercizio1();
    }

    public static void Esercizio1() {
        HashSet<String> parole = new HashSet<>();
        List<String> listaDuplicati = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Benvenuto/a! Andrò a creare una collezione, quanti elementi vorresti che avesse?");
        int totaleElementi = scanner.nextInt();
        scanner.nextLine();
        System.out.println("--------------------------");
        System.out.println("Creazione...");
        System.out.println("--------------------------");

        //si può usare anche il while, il prof ha usato quello
        for (int i = 0; i < totaleElementi; i++) {
            System.out.println("Inserire una parola");
            String parola = scanner.nextLine();

            if (!parole.add(parola)) {
                listaDuplicati.add(parola);
            }
        }

        System.out.println("--------------------------");
        System.out.println("Collezione creata con successo!");
        System.out.println("Parole duplicate inserite: " + listaDuplicati);
        System.out.println("Numero di parole inserite: " + totaleElementi);
        System.out.println("Elenco delle parole distinte: " + parole.size());


    }
}
