package elena.secondogiorno.controller;

import elena.secondogiorno.DTO.AutoreDto;
import elena.secondogiorno.exception.AutoreNonTrovatoException;
import elena.secondogiorno.exception.BadRequestException;
import elena.secondogiorno.model.Autore;
import elena.secondogiorno.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public String saveAutore(@RequestBody @Validated AutoreDto autoreDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s + s2)));
        }
        return autoreService.saveAutore(autoreDto);
    }

    @GetMapping("/api/autori")
    public Page<Autore> getAllAutori(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "1") int size,
                                     @RequestParam(defaultValue = "id") String sortBy) {
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
    public Autore updateAutore(@PathVariable int id,
                               @RequestBody @Validated AutoreDto autoreDto,
                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage()).reduce("", (s, s2) -> s + s2));
        }
        return autoreService.updateAutore(id, autoreDto);
    }

    @DeleteMapping("/api/autori/{id}")
    public String deleteAutori(@PathVariable int id) {
        return autoreService.deleteAutore(id);
    }

    @PatchMapping("/api/autori/{id}")
    public String patchFoto(@PathVariable int id, @RequestBody MultipartFile foto) throws IOException {
        return autoreService.patchFoto(id, foto);
    }
}
