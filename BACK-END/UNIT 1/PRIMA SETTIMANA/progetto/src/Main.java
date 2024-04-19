import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvenuto nel tuo lettore multimediale! Dovrai inserire 5 elementi, segui le istruzioni");

        ElementoMultimediale[] elementi = new ElementoMultimediale[5];

        for (int i = 0; i < elementi.length; i++) {
            System.out.println("-----------------");
            System.out.println("Inserisci dati per l'elemento " + (i + 1));
            System.out.print("Scegliere il tipo di file da inserire! (i per Immagine, v per Video, r per Registrazioni Audio): ");
            String risposta = scanner.nextLine();

            if (risposta.equals("i")) {
                System.out.print("Nome immagine: ");
                String nomeImmagine = scanner.nextLine();

                System.out.print("Luminosità (inserisci quanti * vuoi per l'intensità della luminosità, es: 4): ");
                int luminositaImmagine = scanner.nextInt();
                scanner.nextLine();

                elementi[i] = new Immagine(nomeImmagine, luminositaImmagine);
            } else if (risposta.equals("v")) {
                System.out.print("Nome video: ");
                String nomeVideo = scanner.nextLine();

                System.out.print("Durata: ");
                int durata = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Volume (inserisci quanti ! vuoi per l'intensità del volume, es: 3): ");
                int volume = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Luminosità (inserisci quanti * vuoi per l'intensità della luminosità, es: 4): ");
                int luminosita = scanner.nextInt();
                scanner.nextLine();

                elementi[i] = new Video(nomeVideo, durata, volume, luminosita);
            } else if (risposta.equals("r")) {
                System.out.print("Nome Registrazione: ");
                String titoloRegistrazione = scanner.nextLine();

                System.out.print("Durata: ");
                int durata = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Volume (inserisci quanti ! vuoi per l'intensità del volume, es: 3): ");
                int volume = scanner.nextInt();
                scanner.nextLine();


                elementi[i] = new RegistrazioneAudio(titoloRegistrazione, durata, volume);
            }
        }

        boolean completatoArray = true;
        while (completatoArray) {
            System.out.println("Ecco tutti gli elementi multimediali inseriti:");
            for (int i = 0; i < elementi.length; i++) {
                System.out.println((i + 1) + ". " + elementi[i].titolo);
            }
            System.out.print("Scegli un elemento da eseguire (1-5, 0 per chiudere): ");
            int elenco = scanner.nextInt();
            scanner.nextLine();

            if (elenco >= 1) {
                esegui(elementi[elenco - 1]);
            } else if (elenco != 0) {
                System.out.println("Scelta non valida. Riprova.");
                System.out.println("-----------------");
            } else {
                completatoArray = false;
            }
        }

        System.out.println("Chiusura del programma in corso...");
        System.out.println("-----------------");
        scanner.close();
    }

    public static void esegui(ElementoMultimediale media) {
        Scanner scanner = new Scanner(System.in);

        if (media instanceof RegistrazioneAudio) {
            RegistrazioneAudio registrazioneAudio = (RegistrazioneAudio) media;
            registrazioneAudio.play();

            boolean volumeModificato = false;

            while (!volumeModificato) {
                System.out.print("Vuoi alzare (a) o abbassare (b) il volume? (a/b): ");
                String scelta = scanner.nextLine();

                if (scelta.equals("a")) {
                    registrazioneAudio.alzaVolume();
                    System.out.println("Volume alzato.");
                    System.out.println("-----------------");
                    volumeModificato = true;
                } else if (scelta.equals("b")) {
                    registrazioneAudio.abbassaVolume();
                    System.out.println("Volume abbassato.");
                    System.out.println("-----------------");
                    volumeModificato = true;
                } else {
                    System.out.println("Scelta non valida. Riprova.");
                }
            }
        } else if (media instanceof Video) {
            Video video = (Video) media;
            video.play();

            boolean volumeModificato = false;

            while (!volumeModificato) {
                System.out.print("Vuoi alzare (a) o abbassare (b) la luminosità? (a/b): ");
                String scelta = scanner.nextLine();

                if (scelta.equalsIgnoreCase("a")) {
                    video.aumentaLuminosita();
                    System.out.println("Luminosità alzata");
                    System.out.println("-----------------");
                    volumeModificato = true;
                } else if (scelta.equalsIgnoreCase("b")) {
                    video.diminuisciLuminosita();
                    System.out.println("Luminosità abbassata");
                    System.out.println("-----------------");
                    volumeModificato = true;
                } else {
                    System.out.println("Scelta non valida. Riprova.");
                    System.out.println("-----------------");
                }
            }
        } else if (media instanceof Immagine) {
            Immagine immagine = (Immagine) media;
            immagine.show();

            boolean luminositaModificata = false;

            while (!luminositaModificata) {
                System.out.print("Vuoi aumentare (a) o diminuire (b) la luminosità? (a/b): ");
                String scelta = scanner.nextLine();

                if (scelta.equalsIgnoreCase("a")) {
                    immagine.aumentaLuminosita();
                    System.out.println("Luminosità aumentata.");
                    luminositaModificata = true;
                } else if (scelta.equalsIgnoreCase("b")) {
                    immagine.diminuisciLuminosita();
                    System.out.println("Luminosità diminuita.");
                    luminositaModificata = true;
                } else {
                    System.out.println("Scelta non valida. Riprova.");
                }
            }
        } else {
            media.play();
        }
    }
}
