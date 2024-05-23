package elena.GestionePrenotazioni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "elena.GestionePrenotazioni")
@EnableJpaRepositories(basePackages = "elena.GestionePrenotazioni.Repository")
@EntityScan(basePackages = "elena.GestionePrenotazioni.Bean") //
//ho dovuto mettere queste annotation perché dava un errore nel trovarmi i beans
public class GestionePrenotazioniApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionePrenotazioniApplication.class, args);
	}

}
