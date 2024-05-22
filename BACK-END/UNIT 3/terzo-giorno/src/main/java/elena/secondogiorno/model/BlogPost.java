package elena.secondogiorno.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;

    @ManyToOne
    @JoinColumn(name = "autore_id")
    @JsonIgnore
    private Autore autore;

}
