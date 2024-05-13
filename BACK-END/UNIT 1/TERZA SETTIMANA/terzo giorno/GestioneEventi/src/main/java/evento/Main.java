package evento;

import evento.dao.EventoDao;
import evento.dao.LocationDao;
import evento.dao.PartecipazioneDao;
import evento.dao.PersonaDao;
import evento.entity.Evento;
import evento.entity.Location;
import evento.entity.Partecipazione;
import evento.entity.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();

        EventoDao eventoDao = new EventoDao(em);
        LocationDao locationDao = new LocationDao(em);
        PartecipazioneDao partecipazioneDao = new PartecipazioneDao(em);
        PersonaDao personaDao = new PersonaDao(em);

        Location location = new Location();
        location.setCitta("Marseille");
        location.setNome("Marseille");
        locationDao.save(location);

        Evento evento = new Evento();
        evento.setTipoEvento(Evento.TipoEvento.PUBBLICO);
        evento.setTitolo("Concerto Shakira");
        evento.setDataEvento(LocalDate.of(2024, 05, 23));
        evento.setDescrizione("She's making a comeback");
        evento.setLuogoEvento(location);
        eventoDao.save(evento);

        Persona persona2 = new Persona();
        persona2.setNome("Marco");
        persona2.setCognome("Bianchi");
        persona2.setSesso(Persona.Sesso.M);
        persona2.setData_di_nascita(LocalDate.of(2000, 3, 9));
        persona2.setEmail("marco@gmail.com");
        personaDao.save(persona2);

        Partecipazione partecipazione2 = new Partecipazione();
        partecipazione2.setPersona(persona2);
        partecipazione2.setEvento(evento);
        partecipazione2.setStato(Partecipazione.Stato.CONFERMATA);
        partecipazioneDao.save(partecipazione2);

        evento.getListaPartecipazioni().add(partecipazione2);

    }
}
