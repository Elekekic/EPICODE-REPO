package catalogo.dao;


import catalogo.entity.Prestito;
import catalogo.entity.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrestitoDao {

    private EntityManager em;

    public PrestitoDao(EntityManager em) {
        this.em =em;
    }

    //stessi metodi per salvare,getid,eliminare di tutti gli altri dao
    public void save(Prestito prestito) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(prestito);
        et.commit();
    }

    public Prestito getById(int id) {
        Prestito p = em.find(Prestito.class,id);

        return p;
    }

    public void delete (Prestito prestito) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(prestito);
        et.commit();
    }

    //7. Ricerca degli elementi ATTUALMENTE IN PRESTITO dato un numero tessera utente
    public List<Prestito> getByNumeroTesseraUtente(int numeroTessera) {
        Query query = em.createQuery("SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera AND p.dataRestituzioneEffettiva IS NULL");
        query.setParameter("numeroTessera", numeroTessera); // Corretto il nome del parametro
        return query.getResultList();
    }

    //8. Ricerca di tutti i PRESTITI SCADUTI o non ancora restituiti
    public List<Prestito> getPrestitiScaduti() {
        LocalDate oggi = LocalDate.now();

        Query query = em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < :oggi AND p.dataRestituzioneEffettiva IS NULL");
        query.setParameter("oggi", oggi);
        return query.getResultList();
    }

}
