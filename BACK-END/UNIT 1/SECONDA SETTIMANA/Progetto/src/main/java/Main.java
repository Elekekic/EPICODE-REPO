import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Object> archivio = new HashMap<>();

        // AGGIUNGO IO DEI LIBRI
        archivio.put(389012312, new Libri(389012312, "Java Programming", 2022, 400, "John Doe", "Programming", Periodicita.SETTIMANALE));
        archivio.put(839291232, new Libri(839291232, "Data Structures and Algorithms", 2020, 400, "Jane Doe", "Computer Science", Periodicita.SEMESTRALE));
        archivio.put(783238128, new Libri(783238128, "Introduction to Java", 2019, 300, "John Smith", "Programming", Periodicita.SETTIMANALE));
        archivio.put(293847104, new Libri(293847104, "To Kill a Mockingbird", 1960, 281, "Harper Lee", "Fiction", Periodicita.MENSILE));
        archivio.put(938272112, new Libri(938272112, "The Great Gatsby", 1925, 180, "F. Scott Fitzgerald", "Fiction", Periodicita.MENSILE));

        // AGGIUNGO IO DELLE RIVISTE
        archivio.put(987654321, new Riviste(987654321, "National Geographic", 2024, 100, "National Geographic Society", "Science and Nature", Periodicita.MENSILE));
        archivio.put(472847772, new Riviste(472847772, "Time", 2024, 80, "Time Magazine", "Current Affairs", Periodicita.SETTIMANALE));
        archivio.put(647283024, new Riviste(647283024, "Scientific American", 2023, 70, "Scientific American", "Science", Periodicita.MENSILE));
        archivio.put(847729102, new Riviste(847729102, "National Geographic Kids", 2024, 90, "National Geographic Society", "Science and Nature", Periodicita.MENSILE));
        archivio.put(112038281, new Riviste(112038281, "Sports Illustrated", 2023, 60, "Sports Illustrated", "Sports", Periodicita.SEMESTRALE));


        Scanner scanner = new Scanner(System.in);
        System.out.println("Current items in the catalogue:");
        archivio.forEach((isbn, item) -> System.out.println("ISBN: " + isbn + ", Item: " + item));
        System.out.println("--------------");

        // AGGIUNTA BOOK
        System.out.println("Welcome to your catalogue!");
        System.out.println("Add a book!");
        Libri book = addBook();
        archivio.put(book.getCodiceISBN(), book);

        // AGGUNTA MAGAZINE
        System.out.println("Now, add a magazine!");
        Riviste magazine = addMagazine();
        archivio.put(magazine.getCodiceISBN(), magazine);

        // RIMOZIONE ITEM TRAMITE ISBN
        System.out.println("Enter the ISBN of the item you want to REMOVE: ");
        int ISBN = scanner.nextInt();
        removeByISBN(ISBN, archivio);

        // RICERCA ITEMS TRAMITE ISBN
        System.out.println("Enter the ISBN of the item you want to FIND: ");
        int ISBN2 = scanner.nextInt();
        searchByISBN(ISBN2, archivio);

        // RICERCA ITEMS TRAMITE ANNO DI PUBBLICAZIONE
        System.out.println("Enter the year of publication of the items you want to find: ");
        int annoPubblicazione = scanner.nextInt();
        searchByAnnoPubblicazione(annoPubblicazione, archivio);

        // RICERCA ITEMS TRAMITE AUTORE
        scanner.nextLine(); // Consuma il carattere newline rimanente
        System.out.println("Enter the author of the items you want to find: ");
        String autore = scanner.nextLine();
        searchByAutore(autore, archivio);

        String oggettiInString = archivio.values().stream()
                .map(Object::toString)
                .collect(Collectors.joining("#"));

        System.out.println(oggettiInString);

        File file = new File("./../ProgettoTXT/progetto.txt");

        try {
            FileUtils.writeStringToFile(file, oggettiInString, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String str = FileUtils.readFileToString(file, Charset.defaultCharset());

            String[] oggettiInStr = str.split("#");

            Arrays.stream(oggettiInStr).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    private static Libri addBook() {
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("ISBN (max 9 numbers): ");
        int isbn = scanner2.nextInt();
        scanner2.nextLine();

        System.out.print("Title: ");
        String title = scanner2.nextLine();

        System.out.print("Year of Publication: ");
        int year = scanner2.nextInt();
        scanner2.nextLine();

        System.out.print("Number of Pages: ");
        int pages = scanner2.nextInt();
        scanner2.nextLine();

        System.out.print("Author: ");
        String author = scanner2.nextLine();

        System.out.print("Genre: ");
        String genre = scanner2.nextLine();

        System.out.print("Periodicity (SETTIMANALE, MENSILE, SEMESTRALE): ");
        Periodicita periodicita = Periodicita.valueOf(scanner2.nextLine().toUpperCase());


        return new Libri(isbn, title, year, pages, author, genre, periodicita);
    }

    private static Riviste addMagazine() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("ISBN (max 9 numbers): ");
        int isbn = scanner1.nextInt();
        scanner1.nextLine();

        System.out.print("Title: ");
        String title = scanner1.nextLine();

        System.out.print("Year of Publication: ");
        int year = scanner1.nextInt();
        scanner1.nextLine();

        System.out.print("Number of Pages: ");
        int pages = scanner1.nextInt();
        scanner1.nextLine();

        System.out.print("Author: ");
        String author = scanner1.nextLine();

        System.out.print("Genre: ");
        String genre = scanner1.nextLine();

        System.out.print("Periodicity (SETTIMANALE, MENSILE, SEMESTRALE): ");
        Periodicita periodicita = Periodicita.valueOf(scanner1.nextLine().toUpperCase());

        return new Riviste(isbn, title, year, pages, author, genre, periodicita);
    }

    private static void removeByISBN(int ISBN, Map<Integer, Object> oggettiMap) {
        if (oggettiMap.containsKey(ISBN)) {
            oggettiMap.remove(ISBN);
            System.out.println("Item with ISBN " + ISBN + " removed.");
        } else {
            System.out.println("Item with ISBN " + ISBN + " not found.");
        }
    }

    private static void searchByISBN(int ISBN, Map<Integer, Object> oggettiMap) {
        Object item = oggettiMap.get(ISBN);
        if (item != null) {
            System.out.println("Item found: " + item);
        } else {
            System.out.println("Item with ISBN " + ISBN + " not found.");
        }
    }

    private static void searchByAnnoPubblicazione(int anno, Map<Integer, Object> oggettiMap) {
        oggettiMap.values().stream()
                .filter(obj -> {
                    if (obj instanceof Libri) {
                        return ((Libri) obj).getAnnoPubblicazione() == anno;
                    } else if (obj instanceof Riviste) {
                        return ((Riviste) obj).getAnnoPubblicazione() == anno;
                    }
                    return false;
                })
                .forEach(System.out::println);
    }

    private static void searchByAutore(String autore, Map<Integer, Object> oggettiMap) {
        oggettiMap.values().stream()
                .filter(obj -> {
                    if (obj instanceof Libri) {
                        return ((Libri) obj).getAutore().equals(autore);
                    } else if (obj instanceof Riviste) {
                        return ((Riviste) obj).getAutore().equals(autore);
                    }
                    return false;
                })
                .forEach(System.out::println);
    }
}

