package elena.secondogiorno.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BlogPostDto {

    private int id;

    @NotBlank(message = "La categoria non può essere null o vuoto o solo spazi")
    private String categoria;

    @NotBlank(message = "Il titolo non può essere null o vuoto o solo spazi")
    private String titolo;

    private String cover;

    @NotBlank(message = "Il nome non può essere null o vuoto o solo spazi")
    private String contenuto;

    private int tempoDiLettura;


    @NotNull(message = "L'autore non può essere null ")
    private int autoreId;

}
