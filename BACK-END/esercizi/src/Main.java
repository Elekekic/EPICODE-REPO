import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ESERCIZIO MOLTIPLICA");
        System.out.println("scegli il tuo primo numero");
        int x = scanner.nextInt();
        System.out.println("scegli il tuo secondo numero");
        int y = scanner.nextInt();
        int moltiplica = moltiplica(x, y);
        System.out.println("Il risultato della moltiplicazione è: " + moltiplica);

        System.out.println("ESERCIZIO CONCATENA");
        System.out.println("scegli un numero");
        int a = scanner.nextInt();
        scanner.nextLine();
        System.out.println("scegli una parola ");
        String s = scanner.nextLine();
        String concatena = concatena(a, s);
        System.out.println("Il risultato della concatenazione è: " + concatena);

        System.out.println("ESERCIZIO ORDINE STRINGHE");
        System.out.println("scegli la tua prima parola ");
        String s1 = scanner.nextLine();
        System.out.println("scegli la tua seconda parola ");
        String s2 = scanner.nextLine();
        System.out.println("scegli la tua terza parola ");
        String s3 = scanner.nextLine();
        String ordineGiusto = ordineGiusto(s1,s2,s3);
        String ordineInverso = ordineInverso(s1,s2,s3);
        System.out.println("Il risultato della prima stringa è: " + ordineGiusto);
        System.out.println("Il risultato della stringa invertita è: " + ordineInverso);

        System.out.println("ESERCIZI PER CALCOLARE IL PERIMETRO DEL RETTANGOLO");
        System.out.println("scegli il tuo primo numero ");
        double n1 = scanner.nextDouble();
        System.out.println("scegli il tuo secondo numero ");
        double n2 = scanner.nextDouble();
        double perimetro = perimetro(n1,n2);
        System.out.println("Il perimetro è di: " + perimetro);


        System.out.println("ESERCIZI PER CALCOLARE SE UN NUMERO E PARI O DISPARI");
        System.out.println("scegli il tuo primo numero ");
        int n9 = scanner.nextInt();
        String parioDispari = pariODispari(n9);
        System.out.println("Il risultato è: " + parioDispari);

        System.out.println("ESERCIZI PER CALCOLARE L'AREA");
        System.out.println("scegli il tuo primo numero ");
        double n3 = scanner.nextDouble();
        System.out.println("scegli il tuo secondo numero ");
        double n4 = scanner.nextDouble();
        System.out.println("scegli il tuo terzo numero ");
        double n5 = scanner.nextDouble();
        double area = area(n3,n4,n5);
        System.out.println("L'area è di: " + area);

        scanner.close();

    }

    public static int moltiplica(int n1, int n2) {
        return n1 * n2;
    }

    public static String concatena(int n1, String s) {
        return s + " " + n1;
    }

    public static String ordineGiusto( String s1, String s2, String s3) {
        return s1 + " " + s2 + " " + s3;
    }

    public static String ordineInverso ( String s1, String s2, String s3) {
        return s3 + " " + s2 + " " + s1;
    }

    public static double perimetro(double n1, double n2) {
        return (n1 + n2) * 2;
    }

    public static String pariODispari(int num) {
        return num % 2 == 0 ? "pari" : "dispari";
    }

    public static double area(double l1, double l2, double l3) {
        double semiPerimeter = (l1 + l2 + l3) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - l1) * (semiPerimeter - l2) * (semiPerimeter - l3));
    }

}