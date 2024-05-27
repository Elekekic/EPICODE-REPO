package elena.primo_giorno.controller;

import elena.primo_giorno.DTO.DipendenteDto;
import elena.primo_giorno.exception.BadRequestException;
import elena.primo_giorno.exception.DipendenteNonTrovatoException;
import elena.primo_giorno.model.Dipendente;
import elena.primo_giorno.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @GetMapping("/dipendente")
    public List<Dipendente> getAllUSers () {
        return dipendenteService.getAllDipendenti();
    }

    @GetMapping("/dipendente/{id}")
    public Dipendente getUserById (@PathVariable int id) {
        Optional<Dipendente> userOptional = dipendenteService.getDipendenteeById(id);

        if(userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new DipendenteNonTrovatoException("Dipendente with ID:" + id+ " hasn't been found");
        }
    }

    @PutMapping("/dipendente/{id}")
    public Dipendente updateUser (@PathVariable int id, @RequestBody @Validated DipendenteDto dipendenteDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage()).reduce("", (s, s2) -> s + s2));
        }
        return dipendenteService.updateDipendente(id, dipendenteDto);
    }


    @DeleteMapping("/dipendente/{id}")
    public String deleteUser (@PathVariable int id) {
        return dipendenteService.deleteDipendente(id);

    }
}
