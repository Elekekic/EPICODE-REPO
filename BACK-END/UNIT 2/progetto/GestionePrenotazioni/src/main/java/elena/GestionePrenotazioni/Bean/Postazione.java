package elena.GestionePrenotazioni.Bean;

import elena.GestionePrenotazioni.Enums.Tipo;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "postazioni")
public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    private int numMaxOccupantiEdificio;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;

    @Override // sennò andava in stackOverflow
    public String toString() {
        return "Postazione{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", tipo=" + tipo +
                ", numMaxOccupantiEdificio=" + numMaxOccupantiEdificio +
                ", edificio=" + edificio +
                '}';
    }
}
