package elena.GestionePrenotazioni.Service;

import elena.GestionePrenotazioni.Bean.Edificio;
import elena.GestionePrenotazioni.Repository.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public void inserisciEdificio(Edificio edificio) {
        edificioRepository.save(edificio);
    }

    public void eliminaEdificio(int id) {
        edificioRepository.deleteById(id);
    }
}
