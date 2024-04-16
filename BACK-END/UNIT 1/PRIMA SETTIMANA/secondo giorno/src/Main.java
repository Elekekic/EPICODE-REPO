import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("ESERCIZIO 1");
        System.out.println("Inserisci la tua parola");
        String s = scanner.next();
        String risultato = stringaPariDispari(s);
        System.out.println("La lunghezza della stringa è: " + risultato);
        System.out.println("------");
        System.out.println("un anno a tua scelta");
        int number = scanner.nextInt();
        boolean annoBisestile = annoBisestile(number);
        System.out.println(number + " è un anno bisestile? " + annoBisestile);
        System.out.println("------");
        System.out.println("ESERCIZIO 2");
        System.out.println("Inserisci un numero");
        int number2 = scanner.nextInt();
        String esercizio2 = programma(number2);
        System.out.println(esercizio2);
        System.out.println("------");
        System.out.println("ESERCIZIO 4");
        System.out.println("Inserisci un numero");
        int number3 = scanner.nextInt();
        esercizio4(number3);
        scanner.close();

    }

    //per questi due il compito chiedeva if / else if , ma il ternario mi è sembrato più efficace
    public static String stringaPariDispari(String s) {
        return s.length() % 2 == 0 ? "pari, cioè true" : "dispari, cioè false";
    }

    public static boolean annoBisestile(int anno) {
        return (anno % 4 == 0 && anno % 100 != 0) || (anno % 400 == 0);
    }

    // switch
    public static String programma(int numero) {
        switch (numero) {
            case 0:
            case 1:
            case 2:
                return "il valore è compreso tra 0 e 3";
            case 3:
                return "Il valore è 3";
            default:
                if (numero > 3) {
                    return "Il valore è più grande";
                } else {
                    return "Il valore è 0 o negativo";
                }
        }
    }

    //for
    public static void esercizio4 (int numero) {
        System.out.println("Partiamo da: " + numero);
        for (int i = numero; i >= 0; i--) {

            System.out.println(i);
        }
        System.out.println("Arrivati alla fine!");
    }
}