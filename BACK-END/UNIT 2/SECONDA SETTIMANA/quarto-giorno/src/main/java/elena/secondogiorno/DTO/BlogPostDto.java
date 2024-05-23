package elena.secondogiorno.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BlogPostDto {

    private int id;

    @NotEmpty(message = "Il campo categoria non può essere vuoto")
    private String categoria;

    @NotEmpty(message = "Il campo titolo non può essere vuoto")
    private String titolo;

    @NotEmpty(message = "Il campo cover non può essere vuoto")
    private String cover;

    @NotEmpty(message = "Il campo cognome non può essere vuoto")
    private String contenuto;

    @NotEmpty(message = "Il campo tempo di lettura non può essere vuoto")
    private int tempoDiLettura;


    private int autoreId;

}
