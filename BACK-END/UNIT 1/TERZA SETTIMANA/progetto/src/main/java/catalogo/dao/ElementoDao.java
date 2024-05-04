package catalogo.dao;

import catalogo.entity.Elemento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

public class ElementoDao {
    private EntityManager em;

    public ElementoDao(EntityManager em) {
        this.em = em;
    }

    // 1. metodo per SALVARE un elemento nel database
    public void save(Elemento elemento) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(elemento);
        et.commit();
    }


    public Elemento getByISBN(UUID ISBN) {
        return em.find(Elemento.class, ISBN);
    }


    //2. metodo per ELIMINARE un elemento dal database dato un codice ISBN
    public void delete(UUID ISBN) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Elemento elemento = getByISBN(ISBN);

        if (elemento != null) {
            em.remove(elemento);
        } else {
            System.out.println("L'elemento che si vuole eliminare non è presente");
        }

        et.commit();
    }

    //3. ricerca per ISBN
    public Elemento getISBNElemento(UUID ISBN) {
        Query query = em.createQuery(
                "SELECT e FROM Elemento e WHERE e.ISBN = :ISBN");
        query.setParameter("ISBN", ISBN);
        return (Elemento)query.getSingleResult();
    }

    //4. Ricerca per ANNO
    public List getAnnoElemento(int annoPubblicazione) {
        Query query = em.createQuery(
                "SELECT e FROM Elemento e WHERE e.annoPubblicazione = :anno");
        query.setParameter("anno", annoPubblicazione);
        return query.getResultList();
    }

    // 5. Ricerca per AUTORE
    public List getAutoreElemento(String autore) {
        Query query = em.createQuery(
                "SELECT e FROM Elemento e WHERE e.autore = :autore");
        query.setParameter("autore",autore);
        return query.getResultList();
    }

    // 6. Ricerca per TITOLO o parte di esso
    public List getTitoloElemento(String titolo) {
        Query query = em.createQuery(
                "SELECT e FROM Elemento e WHERE e.titolo LIKE :titolo");
        query.setParameter("titolo", "%" + titolo + "%");
        return query.getResultList();
    }



}

