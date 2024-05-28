package elena.primo_giorno.controller;

import elena.primo_giorno.DTO.DipendenteDto;
import elena.primo_giorno.DTO.DipendenteLoginDto;
import elena.primo_giorno.exception.BadRequestException;
import elena.primo_giorno.service.AuthService;
import elena.primo_giorno.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private DipendenteService dipendenteService;

    @PostMapping("/register")
    public String register(@RequestBody @Validated DipendenteDto dipendenteDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s + s2)));
        }
        dipendenteService.saveDipendente(dipendenteDto);
        return "User has been saved succefully";
    }

    @PostMapping("/login")
    public String login(@RequestBody @Validated DipendenteLoginDto dipendenteLoginDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s + s2)));
        }

        return authService.authenticateUserandCreateToken(dipendenteLoginDto);
    }

}
