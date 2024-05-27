package elena.primo_giorno.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DipendenteLoginDto {

    @Email(message = "L'email inserita non è un indirizzo valido")
    @NotBlank(message = "L'email non può essere null o vuoto o solo spazi")
    private String email;

    @NotBlank(message = "il campo password non può essere vuoto/mancante/con soli spazi")
    private String password;
}
