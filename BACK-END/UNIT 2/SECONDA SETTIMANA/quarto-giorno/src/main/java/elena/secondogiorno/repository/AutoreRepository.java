package elena.secondogiorno.repository;


import elena.secondogiorno.model.Autore;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AutoreRepository extends JpaRepository<Autore, Integer> {
}
