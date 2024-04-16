import java.util.Scanner;

public class esercizio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("Inserisci una stringa (inserisci ':p' per terminare):");
            input = scanner.nextLine();


            if (":p".equals(input)) {
                System.out.println("Programma terminato.");
                break;
            }
            String[] characters = input.split("");
            String result = String.join(",", characters);

            System.out.println(result);

        } while (true);

        scanner.close();
    }
    }
