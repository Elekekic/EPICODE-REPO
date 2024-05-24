package elena.secondogiorno.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AutoreDto {


    @Size(max = 30)
    @NotBlank(message = "Il nome non può essere null o vuoto o solo spazi")
    private String nome;

    @Size(max = 30)
    @NotBlank(message = "Il cognome non può essere null o vuoto o solo spazi")
    private String cognome;


    @Email
    @NotBlank(message = "L'email non può essere null o vuoto o solo spazi")
    private String email;


    private LocalDate dataDiNascita;
}
