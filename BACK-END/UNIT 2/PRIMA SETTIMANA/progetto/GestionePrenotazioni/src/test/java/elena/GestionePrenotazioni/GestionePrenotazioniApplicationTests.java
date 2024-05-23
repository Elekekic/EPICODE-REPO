package elena.GestionePrenotazioni;

import elena.GestionePrenotazioni.Bean.Postazione;
import elena.GestionePrenotazioni.Enums.Tipo;
import elena.GestionePrenotazioni.Repository.PostazioneRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class GestionePrenotazioniApplicationTests {


	@Autowired
	private PostazioneRepository postazioneRepository;

	@Test
	public void verificaMetodoCercaPostazioniPerTipoECitta() {
		Tipo tipo = Tipo.PRIVATO;
		String citta = "Vancouver";

		List<Postazione> result = postazioneRepository.cercaPostazioniPerTipoECitta(tipo, citta);

		assertNotNull(result); // il test non da errori!
	}
	

}
