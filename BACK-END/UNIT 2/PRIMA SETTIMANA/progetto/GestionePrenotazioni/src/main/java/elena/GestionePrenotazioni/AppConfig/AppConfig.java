package elena.GestionePrenotazioni.AppConfig;

import elena.GestionePrenotazioni.Bean.Edificio;
import elena.GestionePrenotazioni.Bean.Postazione;
import elena.GestionePrenotazioni.Bean.Prenotazione;
import elena.GestionePrenotazioni.Bean.Utente;
import elena.GestionePrenotazioni.Enums.Tipo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDate;
import java.util.List;

@Configuration
@PropertySource("application.properties")
public class AppConfig {

    @Bean(name = "edificio")
    public Edificio getEdificio() {
        Edificio edificio = new Edificio();
        edificio.setNome("Edificio Principale");
        edificio.setCitta("Vancouver");
        edificio.setIndirizzo("Via lala");
        return edificio;
    }

    @Bean(name = "postazione")
   public Postazione getPostazione() {
        Postazione postazione = new Postazione();
        postazione.setTipo(Tipo.PRIVATO);
        postazione.setDescrizione("Tipo di evento privato");
        postazione.setEdificio(getEdificio());
        postazione.setNumMaxOccupantiEdificio(5);
        return postazione;
    }

    @Bean(name = "Elena")
    public Utente getUtente1() {
        Utente utente = new Utente();
        utente.setUsername("EleKekic");
        utente.setEmail("kekic@gmail.com");
        utente.setNomeCompleto("Elena Kekic");
        return utente;
    }
}
