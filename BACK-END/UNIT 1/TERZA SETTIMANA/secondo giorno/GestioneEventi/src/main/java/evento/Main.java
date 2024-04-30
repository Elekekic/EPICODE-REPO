package evento;

import evento.dao.EventoDao;
import evento.entity.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();

        EventoDao dao = new EventoDao(em);

        Evento evento1 = new Evento();
        evento1.setTipoEvento(Evento.TipoEvento.PUBBLICO);
        evento1.setTitolo("Concerto Frank Ocean");
        evento1.setDataEvento(LocalDate.of(2024,05,23));
        dao.save(evento1);

        Evento GetEventoID = dao.getById(1);
        System.out.println(GetEventoID);

        // dao.delete(GetEventoID);



    }
}
