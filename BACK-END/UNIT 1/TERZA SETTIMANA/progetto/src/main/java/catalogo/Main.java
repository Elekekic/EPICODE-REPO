package catalogo;

import catalogo.dao.ElementoDao;
import catalogo.dao.PrestitoDao;
import catalogo.dao.UtenteDao;
import catalogo.entity.Libri;
import catalogo.entity.Prestito;
import catalogo.entity.Riviste;
import catalogo.entity.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("progetto");
        EntityManager em = emf.createEntityManager();

        ElementoDao elementoDao = new ElementoDao(em);
        UtenteDao utenteDao = new UtenteDao(em);
        PrestitoDao prestitoDao = new PrestitoDao(em);

        // CREO UN LIBRO
        Libri libri = new Libri();
        libri.setAutore("Franz Kafka");
        libri.setGenere("Letteratura");
        libri.setAnnoPubblicazione(1923);
        libri.setTitolo("Lettere al padre");
        libri.setNumeroPagine(90);

//        lo salvo
        elementoDao.save(libri);

        // CREO UNA RIVISTA
//        Riviste riviste = new Riviste();
//        riviste.setPeriodicita(Riviste.Periodicita.MENSILE);
//        riviste.setAnnoPubblicazione(2024);
//        riviste.setTitolo("National Geographic");
//        riviste.setNumeroPagine(80);

        //la salvo
//        elementoDao.save(riviste);

        //elimino un elemento dal db usando il suo ISBN
//        elementoDao.delete(UUID.fromString("fcd9a5ad-35f5-4495-88b7-bec6421a46f8"));


        System.out.println("ricerca tramite ISBN, trovando il libro creato sopra");
        System.out.println(elementoDao.getISBNElemento(UUID.fromString("27586178-b633-4b8a-8a70-a11ef991f98b")));
        System.out.println("----------------------");


        System.out.println("ricerca per anno pubblicazione");
        System.out.println(elementoDao.getAnnoElemento(2024));
        System.out.println("----------------------");

        System.out.println("ricerca per autore");
        System.out.println(elementoDao.getAutoreElemento("Franz Kafka"));
        System.out.println("----------------------");

        System.out.println("ricerca per titolo");
        System.out.println(elementoDao.getTitoloElemento("Lettere"));
        System.out.println("----------------------");

        // CREO UN UTENTE
//        Utente utente = new Utente();
//        utente.setDataDiNascita(LocalDate.of(2024, 12, 30));
//        utente.setNome("Elena");
//        utente.setCognome("Kekic");
//        utenteDao.save(utente);

        //CREO UN PRESTITO
//        Prestito prestito = new Prestito();
//        prestito.setUtente(utente);
//        prestito.setElementoPrestato(libri);
//        prestito.setDataInizioPrestito(LocalDate.of(2024, 01, 04));
//        prestito.setDataRestituzioneEffettiva(LocalDate.of(2024, 05, 04));
//        prestitoDao.save(prestito);

        System.out.println("ricerca elementi prestati tramite il numero tessera utente");
        prestitoDao.getByNumeroTesseraUtente(4).forEach(System.out::println);
        System.out.println("----------------------");

        System.out.println("ricerca di tutti i prestiti scaduti");
        prestitoDao.getPrestitiScaduti().forEach(System.out::println);
        System.out.println("----------------------");
    }
}
