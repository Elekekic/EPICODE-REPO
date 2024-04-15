package it.epicode;

public class Variabili {
    public static void main(String[] args) {
        int x;
        x = 7; // da questo momento x sarà 7
        x = 6; // da questo momento x sarà 6 sovrascrivendo il 7

        boolean b = true;

        char c = 'd'; // può assumere solo un carattere, non posso scrivere 'dd'

        double d = 6; // questo avrà 6.0
        double e = 3.3;

        String y = "lala"; // sempre con i doppi apici
        String p = ""; // può essere anche vuota

//        y.toUpperCase(); (così si usano i metodi per le stringe)

        String fraseConcatenata = y + " " + x + 4; // non somma i due numeri perchè c'è una stringa
        String fraseConcatenata2 = y + " " + (x + 6); // in questo modo somma i due numeri (6 +6)

        System.out.println(fraseConcatenata);
        System.out.println(fraseConcatenata2);

        final int f = 3; // valore che rimmarà costante

        byte b2 = 100;

        x = b2; // non posso fare l'inverso
        System.out.println(x);

        x = 300;

        b2 = (byte)x;

        System.out.println(b2);

        int[] numeri = new int[6]; // il 6 sta per dimensione dell'array

        numeri[0]= 3;
        numeri[1]= 4;
        System.out.println(numeri[1]); // mi stampa il numero fissato al posto che ho dato io
        System.out.println(numeri[2]); // mi darà 0


        String[] parole = new String[3];

        parole[0] = "parole";

        System.out.println(parole[0]);
        System.out.println(parole[1]);

        System.out.println(parole.length);


    }
}
