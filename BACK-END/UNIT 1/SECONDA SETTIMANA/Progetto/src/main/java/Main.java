import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        List<Object> oggetti = new ArrayList<>();

        oggetti.add(new Libri(389012312, "Java Programming", 2022, 400, "John Doe", "Programming", Periodicita.SETTIMANALE));
        oggetti.add(new Libri(839291232, "Data Structures and Algorithms", 2020, 400, "Jane Doe", "Computer Science", Periodicita.SEMESTRALE));
        oggetti.add(new Libri(783238128, "Introduction to Java", 2019, 300, "John Smith", "Programming", Periodicita.SETTIMANALE));
        oggetti.add(new Libri(293847104, "To Kill a Mockingbird", 1960, 281, "Harper Lee", "Fiction", Periodicita.MENSILE));
        oggetti.add(new Libri(938272112, "The Great Gatsby", 1925, 180, "F. Scott Fitzgerald", "Fiction", Periodicita.MENSILE));


        oggetti.add(new Riviste(987654321, "National Geographic", 2024, 100, "National Geographic Society", "Science and Nature", Periodicita.MENSILE));
        oggetti.add(new Riviste(472847772, "Time", 2024, 80, "Time Magazine", "Current Affairs", Periodicita.SETTIMANALE));
        oggetti.add(new Riviste(647283024, "Scientific American", 2023, 70, "Scientific American", "Science", Periodicita.MENSILE));
        oggetti.add(new Riviste(847729102, "National Geographic Kids", 2024, 90, "National Geographic Society", "Science and Nature", Periodicita.MENSILE));
        oggetti.add(new Riviste(112038281, "Sports Illustrated", 2023, 60, "Sports Illustrated", "Sports", Periodicita.SEMESTRALE));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Current items in the catalogue:");
        for (Object obj : oggetti) {
            System.out.println(obj);
        }
        System.out.println("--------------");
        // AGGIUNTA BOOK
        System.out.println("Welcome to your catalogue!");
        System.out.println("Add a book!");
        Libri book = addBook();
        oggetti.add(book);

        System.out.println();
        // AGGUNTA MAGAZINE
        System.out.println("Now, add a magazine!");
        Riviste magazine = addMagazine();
        oggetti.add(magazine);

        System.out.println("--------------");
        System.out.println("Added items in the catalogue:");
        for (Object obj : oggetti) {
            System.out.println(obj);
        }
        System.out.println("--------------");

        // RIMOZIONE ITEM TRAMITE ISBN
        System.out.println("Inserisci l'ISBN del prodotto che vuoi ELIMINARE: ");
        int ISBN = scanner.nextInt();
        removeByISBN(ISBN, oggetti);
        System.out.println("--------------");


        //RICERCA ITEMS TRAMITE ISBN
        System.out.println("Inserisci l'ISBN del prodotto che vuoi TROVARE: ");
        int ISBN2 = scanner.nextInt();
        searchByISBN(ISBN2, oggetti);

        System.out.println("--------------");

        //RICERCA ITEMS TRAMITE ANNO DI PUBBLICAZIONE
        System.out.println("Inserisci l'anno di pubblicazione dei prodotti che vuoi trovare: ");
        int annoPubblicazione = scanner.nextInt();
        searchByAnnoPubblicazione(annoPubblicazione, oggetti);

        System.out.println("--------------");

        //RICERCA ITEMS TRAMITE AUTORE
        System.out.println("Inserisci l'anno di pubblicazione dei prodotti che vuoi trovare: ");
        String autore = scanner.nextLine();
        searchByAutore(autore, oggetti);

        String oggettiInString = oggetti.stream()
                .map(Object::toString)
                .collect(Collectors.joining("#"));

        System.out.println(oggettiInString);

        File file = new File("./../folder/progetto.txt");

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


    private static void removeByISBN(int ISBN, List<Object> oggetti) {
        oggetti.removeIf(obj -> {
            if (obj instanceof Libri) {
                return ((Libri) obj).getCodiceISBN() == ISBN;
            } else if (obj instanceof Riviste) {
                return ((Riviste) obj).getCodiceISBN() == ISBN;
            }
            return false;
        });

        System.out.println("Item with ISBN " + ISBN + " removed.");
        oggetti.forEach(System.out::println);
    }

    private static void searchByISBN(int ISBN, List<Object> oggetti) {
        List<Object> filteredList = oggetti.stream().filter(obj -> {
                    if (obj instanceof Libri) {
                        return ((Libri) obj).getCodiceISBN() == ISBN;
                    } else if (obj instanceof Riviste) {
                        return ((Riviste) obj).getCodiceISBN() == ISBN;
                    }
                    return false;
                }).toList();

        filteredList.forEach(System.out::println);
    }

    private static void searchByAnnoPubblicazione(int anno, List<Object> oggetti) {
        List<Object> filteredList = oggetti.stream().filter(obj -> {
                    if (obj instanceof Libri) {
                        return ((Libri) obj).getAnnoPubblicazione() == anno;
                    } else if (obj instanceof Riviste) {
                        return ((Riviste) obj).getAnnoPubblicazione() == anno;
                    }
                    return false;
                }).toList();

        filteredList.forEach(System.out::println);
    }

    private static void searchByAutore(String autore, List<Object> oggetti) {
        List<Object> filteredList = oggetti.stream().filter(obj -> {
            if (obj instanceof Libri) {
                return ((Libri) obj).getAutore() == autore;
            } else if (obj instanceof Riviste) {
                return ((Riviste) obj).getAutore() == autore;
            }
            return false;
        }).toList();

        filteredList.forEach(System.out::println);
    }




}

