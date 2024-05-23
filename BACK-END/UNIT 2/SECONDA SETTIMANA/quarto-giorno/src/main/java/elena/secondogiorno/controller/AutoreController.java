package elena.secondogiorno.controller;

import elena.secondogiorno.DTO.AutoreDto;
import elena.secondogiorno.exception.AutoreNonTrovatoException;
import elena.secondogiorno.model.Autore;
import elena.secondogiorno.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @PostMapping("/api/autori")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveAutore(@RequestBody AutoreDto autoreDto) {
        return autoreService.saveAutore(autoreDto);
    }

    @GetMapping("/api/autori")
    public Page<Autore> getAllAutori(@RequestParam(defaultValue = "0")int page,
                                     @RequestParam(defaultValue = "1") int size,
                                     @RequestParam(defaultValue = "id")String sortBy) {
        return autoreService.getAllAutori(page, size, sortBy);
    }

    @GetMapping("/api/autori/{id}")
    public Autore getAutoreById(@PathVariable int id) {
        Optional<Autore> autoreOpt = autoreService.getAutoreById(id);
        if (autoreOpt.isPresent()) {
            return autoreOpt.get();
        } else {
            throw new AutoreNonTrovatoException("Autore con ID " + id + " non è stato trovato");
        }
    }

    @PutMapping("/api/autori/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Autore updateAutore(@PathVariable int id, @RequestBody AutoreDto autoreDto) throws AutoreNonTrovatoException {
        String avatar = "https://ui-avatars.com/api/?name=" + autoreDto.getNome() + "+" + autoreDto.getCognome();
        autoreDto.setAvatar(avatar);
        return autoreService.updateAutore(id, autoreDto);
    }

    @DeleteMapping("/api/autori/{id}")
    public String deleteAutori(@PathVariable int id) {
        return autoreService.deleteAutore(id);
    }

    @PatchMapping("/api/studenti/{matricola}")
    public String patchFoto(@PathVariable int matricola, @RequestBody MultipartFile foto) throws IOException {
        return autoreService.patchFoto(matricola, foto);
    }
}
