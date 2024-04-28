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
        System.out.println("--------------");
        System.out.println(" UPDATED catalogue:");
        archivio.forEach((isbn, item) -> System.out.println("ISBN: " + isbn + ", Item: " + item));
        System.out.println("-------------------------");

        // AGGUNTA MAGAZINE
        System.out.println("Now, add a magazine!");
        Riviste magazine = addMagazine();
        archivio.put(magazine.getCodiceISBN(), magazine);
        System.out.println("--------------");
        System.out.println(" UPDATED catalogue:");
        archivio.forEach((isbn, item) -> System.out.println("ISBN: " + isbn + ", Item: " + item));
        System.out.println("-------------------------");

        // RIMOZIONE ITEM TRAMITE ISBN
        System.out.println("Enter the ISBN of the item you want to REMOVE: ");
        int ISBN = scanner.nextInt();
        removeByISBN(ISBN, archivio);
        System.out.println("-------------------------");

        // RICERCA ITEMS TRAMITE ISBN
        System.out.println("Enter the ISBN of the item you want to FIND: ");
        int ISBN2 = scanner.nextInt();
        searchByISBN(ISBN2, archivio);
        System.out.println("-------------------------");

        // RICERCA ITEMS TRAMITE ANNO DI PUBBLICAZIONE
        System.out.println("Enter the YEAR OF PUBBLICATON of the items you want to FIND: ");
        int annoPubblicazione = scanner.nextInt();
        searchByAnnoPubblicazione(annoPubblicazione, archivio);
        scanner.nextLine();
        System.out.println("-------------------------");

        // RICERCA ITEMS TRAMITE AUTORE
        System.out.println("Enter the AUTHOR of the items you want to FIND (Full name): ");
        String autore = scanner.nextLine();
        searchByAutore(autore, archivio);

        System.out.println("-------------------------");
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
            System.out.println("-------------------------");
            Arrays.stream(oggettiInStr).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();

    }

    // !! MAIN FINISCE, INIZIANO I METODI !!

    private static Libri addBook() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("ISBN (max 9 numbers): ");
            int isbn = scanner.nextInt();
            scanner.nextLine();
            if (String.valueOf(isbn).length() != 9) {
                throw new notValidISBNException("ISBN must be a 9-digit number.");
            }

            System.out.print("Title: ");
            String title = scanner.nextLine();

            System.out.print("Year of Publication: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            if (String.valueOf(year).length()  != 4) {
                throw new notValidYearException("Year must be valid.");
            }

            System.out.print("Number of Pages: ");
            int pages = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Author: ");
            String author = scanner.nextLine();

            System.out.print("Genre: ");
            String genre = scanner.nextLine();

            System.out.print("Periodicity (SETTIMANALE, MENSILE, SEMESTRALE): ");
            Periodicita periodicita = Periodicita.valueOf(scanner.nextLine().toUpperCase().trim());

            return new Libri(isbn, title, year, pages, author, genre, periodicita);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid input.");
            scanner.nextLine();
            //l'utente riprova a rifare il libro dopo l'errore
            return addBook();
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid periodicity. Please enter SETTIMANALE, MENSILE, or SEMESTRALE.");
            // l'utente riprova a rifare il libro dopo l'errore
            return addBook();
        } catch (notValidISBNException | notValidYearException e) {
            System.out.println(e.getMessage());
            // l'utente riprova a rifare il libro dopo l'errore
            return addBook();
        }
    }

    private static Riviste addMagazine() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("ISBN (max 9 numbers): ");
            int isbn = scanner.nextInt();
            scanner.nextLine();
            if (String.valueOf(isbn).length() != 9) {
                throw new notValidISBNException("ISBN must be a 9-digit number.");
            }

            System.out.print("Title: ");
            String title = scanner.nextLine();

            System.out.print("Year of Publication: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            if (String.valueOf(year).length() != 4) {
                throw new notValidYearException("Year must be valid.");
            }

            System.out.print("Number of Pages: ");
            int pages = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Author: ");
            String author = scanner.nextLine();

            System.out.print("Genre: ");
            String genre = scanner.nextLine();

            System.out.print("Periodicity (SETTIMANALE, MENSILE, SEMESTRALE): ");
            Periodicita periodicita = Periodicita.valueOf(scanner.nextLine().toUpperCase().trim());

            return new Riviste(isbn, title, year, pages, author, genre, periodicita);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid input.");
            scanner.nextLine();
            // l'utente riprova a rifare il libro dopo l'errore
            return addMagazine();
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid periodicity. Please enter SETTIMANALE, MENSILE, or SEMESTRALE.");
            // l'utente riprova a rifare il libro dopo l'errore
            return addMagazine();
        } catch (notValidISBNException | notValidYearException e) {
            System.out.println(e.getMessage());
            // l'utente riprova a rifare il libro dopo l'errore
            return addMagazine();
        }
    }

    private static void removeByISBN(int ISBN, Map<Integer, Object> archivio) {
        if (archivio.containsKey(ISBN)) {
            archivio.remove(ISBN);
            System.out.println("Item with ISBN " + ISBN + " removed.");
        } else {
            System.out.println("Item with ISBN " + ISBN + " not found.");
        }
    }

    private static void searchByISBN(int ISBN, Map<Integer, Object> archivio) {
        Object item = archivio.get(ISBN);
        if (item != null) {
            System.out.println("Item found: " + item);
        } else {
            System.out.println("Item with ISBN " + ISBN + " not found.");
        }
    }

    private static void searchByAnnoPubblicazione(int anno, Map<Integer, Object> archivio) {
        archivio.values().stream()
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

    private static void searchByAutore(String autore, Map<Integer, Object> archivio) {
        archivio.values().stream()
                .filter(obj -> {
                    if (obj instanceof Libri) {
                        return ((Libri) obj).getAutore().equalsIgnoreCase(autore); // ho messo ignore Case in modo da non guardare anche le maiuscole o minuscole di un nome/cognome
                    } else if (obj instanceof Riviste) {
                        return ((Riviste) obj).getAutore().equalsIgnoreCase(autore);
                    }
                    return false;
                })
                .forEach(System.out::println);
    }
}

