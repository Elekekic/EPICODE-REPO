package elena.progetto.repository;

import elena.progetto.model.Dispositivo;
import elena.progetto.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Integer> {
}
