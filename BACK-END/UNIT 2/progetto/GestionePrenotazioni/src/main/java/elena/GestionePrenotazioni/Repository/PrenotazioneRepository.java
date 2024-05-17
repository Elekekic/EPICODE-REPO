package elena.GestionePrenotazioni.Repository;

import elena.GestionePrenotazioni.Bean.Postazione;
import elena.GestionePrenotazioni.Bean.Prenotazione;
import elena.GestionePrenotazioni.Bean.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Integer> {

    List<Prenotazione> findByPostazioneAndData(Postazione postazione, LocalDate data);

    List<Prenotazione> findByUtenteAndData(Utente utente, LocalDate data);

}
