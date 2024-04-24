package Esercizio2;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Benvenuto/a! Avvio della prima funzione.. ");
        System.out.println("Inserisci un numero");
        int n = scanner.nextInt();
        scanner.nextLine();
        System.out.println("True o False?");
        boolean b = scanner.nextBoolean();

        System.out.println("----------------------");
        System.out.println("Ecco il risultato: ");
        List<Integer> primaLista = primaFunzione(n);
        System.out.println(primaLista);

        System.out.println("----------------------");
        System.out.println("Prima lista + Lista invertita: ");
        List<Integer> secondaLista = secondaFunzione(primaLista);
        System.out.println(secondaLista);

        System.out.println("----------------------");
        System.out.println("La scelta del boolean corrisponde a: ");
        terzaFunzione(b, secondaLista);

    }

    public static List<Integer> primaFunzione(int n) {
        List<Integer> primaLista = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            primaLista.add(new Random().nextInt(0, 101));
        }
        return primaLista;
    }

    public static List<Integer> secondaFunzione(List<Integer> primaLista) {
        List<Integer> secondaLista = new ArrayList<>();

        secondaLista.addAll(primaLista);
        List<Integer> listaReversed = primaLista.reversed();
        secondaLista.addAll(listaReversed);

        return secondaLista;

    }

    public static void terzaFunzione(boolean b, List<Integer> lista) {
        int j = b ? 0 : 1;

        for (int i = j; i < lista.size(); i += 2) {
            System.out.println(lista.get(i));
        }
    }
}
