import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvenuto nel tuo lettore multimediale! Dovrai inserire 5 elementi, segui le istruzioni");


        ElementoMultimediale[] elementi = new ElementoMultimediale[5];


        for (int i = 1; i < elementi.length; i++) {
            System.out.println("Inserisci dati per l'elemento " + (i) + ": ");
            System.out.print("Scegliere il tipo di file da inserire! (i per Immagine, v per Video): ");
            String risposta = scanner.nextLine();

            if (risposta.equals("i")) {
                System.out.print("Nome immagine: ");
                String nomeImmagine = scanner.nextLine();
                System.out.print("Luminosità (inserisci quanti * vuoi per l'intensità della luminosità, es: ***): ");
                int luminositaImmagine = scanner.nextInt();
                elementi[i] = new Immagine(nomeImmagine, luminositaImmagine);
            } else if (risposta.equals("v")) {
                System.out.print("Nome video: ");
                String nomeVideo = scanner.nextLine();
                System.out.print("Durata (minuti): ");
                int durataMinuti = scanner.nextInt();
                System.out.print("Volume (inserisci quanti ! vuoi per l'intensità del volume, es: !!!): ");
                int volume = scanner.nextInt();
                System.out.print("Luminosità (inserisci quanti * vuoi per l'intensità della luminosità, es: ***): ");
                int luminosita = scanner.nextInt();
                scanner.nextLine(); // Consuma il carattere di ritorno a capo
                elementi[i] = new Video(nomeVideo, durataMinuti, volume, luminosita);
            } else {
                System.out.println("Tipo non valido. Elemento saltato.");
                i--; // Rimani allo stesso indice per far inserire nuovamente i dati
            }
        }

        //semplice boolean che mi serviva per il while
        boolean completatoArray = true;
        while (completatoArray) {
            System.out.println("Ecco tutti gli elementi multimediali inseriti:");
            for (int i = 0; i < elementi.length; i++) {
                System.out.println((i + 1) + ". " + elementi[i]);
            }
            System.out.print("Scegli un elemento da eseguire (1-5, 0 per chiudere): ");
           int elenco = scanner.nextInt();

            if (elenco >= 1 && elenco <= elementi.length) {
                esegui(elementi[elenco - 1]);
            } else if (elenco != 0) {
                System.out.println("Scelta non valida. Riprova.");
            }

            System.out.println("Fine programma.");
            scanner.close();
        }
    }

    public static void esegui(ElementoMultimediale media) {
        if (media instanceof Immagine) {
            ((Immagine) media).show();
        } else if (media instanceof Video) {
            ((Video) media).play();
        } else {
            System.out.println("Media non riconosciuto");
        }
    }
}