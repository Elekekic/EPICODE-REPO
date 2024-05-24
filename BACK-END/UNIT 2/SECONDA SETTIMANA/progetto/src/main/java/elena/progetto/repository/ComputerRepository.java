package elena.progetto.repository;

import elena.progetto.model.Computer;
import elena.progetto.model.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {
}
