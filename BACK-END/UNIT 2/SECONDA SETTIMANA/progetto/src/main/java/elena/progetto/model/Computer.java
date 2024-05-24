package elena.progetto.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Computer extends Dispositivo{

    private String modello;
    private int memoria;

}
