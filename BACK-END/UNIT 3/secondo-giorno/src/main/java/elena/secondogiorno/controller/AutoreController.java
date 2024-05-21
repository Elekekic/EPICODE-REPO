package elena.secondogiorno.controller;

import elena.secondogiorno.exception.AutoreNonTrovatoException;
import elena.secondogiorno.model.Autore;
import elena.secondogiorno.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @PostMapping("/api/autori")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveAutore(@RequestBody Autore autore) {
        String avatar = "https://ui-avatars.com/api/?name=" + autore.getNome() + "+" + autore.getCognome();
        autore.setAvatar(avatar);
        return autoreService.saveAutore(autore);
    }

    @GetMapping("/api/autori")
    public List<Autore> getAllAutori() {
        return autoreService.getAllAutori();
    }

    @GetMapping("/api/autori/{id}")
    public Autore getAutoreById(@PathVariable int id) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOpt = autoreService.getAutoreById(id);
        if (autoreOpt.isPresent()) {
            return autoreOpt.get();
        } else {
            throw new AutoreNonTrovatoException("Autore con ID " + id + " non è stato trovato");
        }
    }

    @PutMapping(path = "/api/autori/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Autore updateAutore(@PathVariable int id, @RequestBody Autore autore) throws AutoreNonTrovatoException {
        String avatar = "https://ui-avatars.com/api/?name=" + autore.getNome() + "+" + autore.getCognome();
        autore.setAvatar(avatar);
        return autoreService.updateAutore(id, autore);
    }

    @DeleteMapping("/api/autori/{id}")
    public String deleteAutori(@PathVariable int id) throws AutoreNonTrovatoException{
        return autoreService.deleteStudente(id);
    }
}
