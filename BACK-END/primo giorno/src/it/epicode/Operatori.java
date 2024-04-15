package it.epicode;

import org.ietf.jgss.GSSName;

import java.util.Scanner;

public class Operatori {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("metti il primo numero");
        int x = scanner.nextInt();
        System.out.println("metti il secondo numero");
        int y = scanner.nextInt();

        scanner.nextLine();

        System.out.println("metti una parola");
        String s = scanner.nextLine();

        System.out.println(s);

        int z = x%y;

        System.out.println(z); // si poteva fare l'operazione anche dentro al sout

        x++; // x = x+1 quindi incrementa

        System.out.println(x);

        boolean b1 = true;
        boolean b2 = false;


    }
}
