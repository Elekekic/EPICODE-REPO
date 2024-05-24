package elena.progetto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import elena.progetto.enumType.StatoDispositivo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private StatoDispositivo stato;

    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    @JsonIgnore
    private Dipendente dipendente;

}
