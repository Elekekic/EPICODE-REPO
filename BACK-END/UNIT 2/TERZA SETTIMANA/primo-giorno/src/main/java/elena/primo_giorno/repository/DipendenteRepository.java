package elena.primo_giorno.repository;


import elena.primo_giorno.model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DipendenteRepository extends JpaRepository<Dipendente, Integer> {

    public Optional<Dipendente> findByEmail(String email);
}
