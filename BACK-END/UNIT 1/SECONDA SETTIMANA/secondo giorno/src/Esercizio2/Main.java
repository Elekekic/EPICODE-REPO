package Esercizio2;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Benvenuto/a! Avvio della prima funzione.. ");
        System.out.println("Inserisci un numero");
        int n = scanner.nextInt();

        System.out.println("----------------------");
        System.out.println("Ecco il risultato: ");
        System.out.println(primaFunzione(n));
    }

    public static List<Integer> primaFunzione(int n) {
        List<Integer> random = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            random.add(new Random().nextInt(0, 101));
        }
        return random;
    }
}
