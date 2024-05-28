package elena.primo_giorno.service;

import elena.primo_giorno.DTO.DipendenteLoginDto;
import elena.primo_giorno.exception.UnathorizedException;
import elena.primo_giorno.model.Dipendente;
import elena.primo_giorno.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private DipendenteService dipendenteService;

    @Autowired
    private JwtTool jwtTool;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticateUserandCreateToken(DipendenteLoginDto dipendenteLoginDto) {
        Dipendente dipendente = dipendenteService.getDipendenteByEmail(dipendenteLoginDto.getEmail());

        if(passwordEncoder.matches(dipendenteLoginDto.getPassword(), dipendente.getPassword())) {
            return jwtTool.createToken(dipendente);
        } else {
            throw new UnathorizedException("Error in authorization, relogin!");
        }
    }
}
