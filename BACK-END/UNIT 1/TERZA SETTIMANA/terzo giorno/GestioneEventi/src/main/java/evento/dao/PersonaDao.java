package evento.dao;

import evento.entity.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDao {

    private EntityManager em;

    public PersonaDao(EntityManager em) {
        this.em =em;
    }

    public void save(Persona persona) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(persona);
        et.commit();
    }

    public Persona getById(int id) {
        Persona e = em.find(Persona.class,id);

        return e;
    }

    public void delete (Persona persona) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(persona);
        et.commit();
    }
}
