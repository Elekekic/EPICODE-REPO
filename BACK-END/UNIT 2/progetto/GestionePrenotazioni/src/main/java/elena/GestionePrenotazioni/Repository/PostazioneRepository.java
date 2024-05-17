package elena.GestionePrenotazioni.Repository;

import elena.GestionePrenotazioni.Bean.Postazione;
import elena.GestionePrenotazioni.Enums.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione,Integer> {

    // QUERY un utente può ricercare le postazioni indicando il tipo di postazione desiderato and città
    @Query("SELECT p from Postazione p WHERE p.tipo = :tipo AND p.edificio.citta = :citta")
    List<Postazione> cercaPostazioniPerTipoECitta(Tipo tipo, String citta);

}
