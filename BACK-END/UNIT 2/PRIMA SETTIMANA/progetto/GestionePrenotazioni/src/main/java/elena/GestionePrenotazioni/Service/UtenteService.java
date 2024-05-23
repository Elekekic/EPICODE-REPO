package elena.GestionePrenotazioni.Service;

import elena.GestionePrenotazioni.Bean.Edificio;
import elena.GestionePrenotazioni.Bean.Postazione;
import elena.GestionePrenotazioni.Bean.Utente;
import elena.GestionePrenotazioni.Repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public void inserisciUtente(Utente utente) {
        utenteRepository.save(utente);
    }

    public void eliminaUtente(int id) {
        utenteRepository.deleteById(id);
    }

    public Utente getUtenteById(int id) {
        return utenteRepository.findById(id).get();
    }
}
