package elena.progetto.repository;

import elena.progetto.model.Dipendente;
import elena.progetto.model.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DipendenteRepository extends JpaRepository<Dipendente, Integer> {
}
