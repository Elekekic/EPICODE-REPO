package elena.secondogiorno.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AutoreDto {


    @Size(max = 30)
    @NotEmpty(message = "Il campo nome non può essere vuoto")
    private String nome;

    @Size(max = 30)
    @NotEmpty(message = "Il campo cognome non può essere vuoto")
    private String cognome;

    @NotEmpty(message = "Il campo email non può essere vuoto")
    @Email
    private String email;

    @NotEmpty(message = "Il campo data di nascita non può essere vuoto")
    private LocalDate dataDiNascita;

    @NotEmpty(message = "Il campo avatar non può essere vuoto")
    private String avatar;
}
