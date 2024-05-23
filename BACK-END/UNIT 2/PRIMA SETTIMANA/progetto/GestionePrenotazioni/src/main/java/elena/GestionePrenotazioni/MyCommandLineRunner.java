package elena.GestionePrenotazioni;

import elena.GestionePrenotazioni.Bean.Edificio;
import elena.GestionePrenotazioni.Bean.Postazione;
import elena.GestionePrenotazioni.Bean.Prenotazione;
import elena.GestionePrenotazioni.Bean.Utente;
import elena.GestionePrenotazioni.Enums.Tipo;
import elena.GestionePrenotazioni.Service.EdificioService;
import elena.GestionePrenotazioni.Service.PostazioneService;
import elena.GestionePrenotazioni.Service.PrenotazioneService;
import elena.GestionePrenotazioni.Service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@PropertySource("application.properties") // messo per togliere il problema dell'url
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private UtenteService utenteService;

    @Override
    public void run(String... args) throws Exception {

//        //ACCEDO AL CONTESTO
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(GestionePrenotazioniApplication.class);
//
//        //INSERISCO EDIFICIO NEL DB
//        Edificio e = ctx.getBean("edificio", Edificio.class);
//        edificioService.inserisciEdificio(e);
//
//        //INSERISCO POSTAZIONE NEL DB
//        Postazione p = ctx.getBean("postazione", Postazione.class);
//        postazioneService.inserisciPostazione(p);
//
//        //INSERISCO UTENTE NEL DB
//        Utente u = ctx.getBean("Elena", Utente.class);
//        utenteService.inserisciUtente(u);

//        ----------------------------------------------


        // INSERISCO PRENOTAZIONE NEL DB (dopo essermi salvata le tre cose prima così da poterle dare alla prenotazione)
//        Prenotazione pre = new Prenotazione();
//        pre.setPostazione(postazioneService.getPostazioneById(1));
//        pre.setUtente(utenteService.getUtenteById(1));
//        pre.setData(LocalDate.of(2024,05,17));
//        prenotazioneService.inserisciPrenotazione(pre);


//        -------------------------------------------------


        // PROVA PER CONFERMARE CHE L'UTENTE HA GIà LA PRENOTAZIONE PER QUESTO GIORNO
//        Prenotazione pre = new Prenotazione();
//        pre.setPostazione(postazioneService.getPostazioneById(1));
//        pre.setUtente(utenteService.getUtenteById(1));
//        pre.setData(LocalDate.of(2024,05,17));
//        prenotazioneService.inserisciPrenotazione(pre);

// nella console si potrà vedere il messaggio stampato di errore con "La postazione non è disponibile per la data selezionata"


//        -------------------------------------------------


        // RICERCA PER TROVARE UNA POSTAZIONE TRAMITE TIPO E CITTà
        postazioneService.ricercaPostazioniPerTipoECitta(Tipo.PRIVATO, "Vancouver").forEach(System.out::println);


    }
}
