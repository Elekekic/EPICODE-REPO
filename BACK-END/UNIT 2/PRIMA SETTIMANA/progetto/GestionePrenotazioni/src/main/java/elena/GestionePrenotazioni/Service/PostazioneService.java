package elena.GestionePrenotazioni.Service;

import elena.GestionePrenotazioni.Bean.Postazione;
import elena.GestionePrenotazioni.Bean.Prenotazione;
import elena.GestionePrenotazioni.Enums.Tipo;
import elena.GestionePrenotazioni.Repository.PostazioneRepository;
import elena.GestionePrenotazioni.Repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;


    public boolean verificaPostazioneLibera(Postazione postazione, LocalDate date) {
        List<Prenotazione> prenotazioni = prenotazioneRepository.findByPostazioneAndData(postazione, date);
        return prenotazioni.isEmpty(); // se la lista è vuota, si può fare la prenotazione (true), altrimenti è già stata fatta (false)
    }


    public void inserisciPostazione(Postazione postazione) {
        postazioneRepository.save(postazione);
    }

    public Postazione getPostazioneById(int id) {
        return postazioneRepository.findById(id).get();
    }

    public void eliminaPrenotazione (int id) {
        postazioneRepository.deleteById(id);
    }

    public List<Postazione> ricercaPostazioniPerTipoECitta(Tipo tipo, String citta){
        return postazioneRepository.cercaPostazioniPerTipoECitta(tipo, citta);
    }


}
