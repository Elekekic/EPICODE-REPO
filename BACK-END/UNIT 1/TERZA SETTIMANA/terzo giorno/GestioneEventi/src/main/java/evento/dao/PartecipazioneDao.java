package evento.dao;

import evento.entity.Partecipazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDao {

    private EntityManager em;

    public PartecipazioneDao(EntityManager em) {
        this.em =em;
    }

    public void save(Partecipazione partecipazionea) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(partecipazionea);
        et.commit();
    }

    public Partecipazione getById(int id) {
        Partecipazione e = em.find(Partecipazione.class,id);

        return e;
    }

    public void delete (Partecipazione partecipazione) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(partecipazione);
        et.commit();
    }
}
