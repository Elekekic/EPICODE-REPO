package elena.progetto.controller;

import elena.progetto.DTO.ComputerDto;
import elena.progetto.DTO.SmartphoneDto;
import elena.progetto.exception.BadRequestException;
import elena.progetto.exception.DipendenteNonTrovatoException;
import elena.progetto.exception.DispositivoNonTrovatoException;
import elena.progetto.model.Computer;
import elena.progetto.model.Dipendente;
import elena.progetto.model.Dispositivo;
import elena.progetto.model.Smartphone;
import elena.progetto.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;


    @GetMapping("/api/dispositivi")
    public Page<Dispositivo> getAllDispositivi(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "1") int size,
                                             @RequestParam(defaultValue = "id") String sortBy) {
        return dispositivoService.getAllDispositivi(page, size, sortBy);
    }

    @GetMapping("/api/smartphone")
    public Page<Smartphone> getAllSmartphones (@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "1") int size,
                                              @RequestParam(defaultValue = "id") String sortBy) {
        return dispositivoService.getAllSmartphones(page, size, sortBy);
    }

    @GetMapping("/api/computer")
    public Page<Computer> getAllComputers (@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "1") int size,
                                           @RequestParam(defaultValue = "id") String sortBy) {
        return dispositivoService.getAllComputers(page, size, sortBy);
    }

    @GetMapping("/api/smartphone/{id}")
    public Smartphone getSmartphoneById(@PathVariable int id) {
        Optional<Smartphone> smartphoneOptional = dispositivoService.getSmartphoneById(id);

        if (smartphoneOptional.isPresent()) {
            return smartphoneOptional.get();
        } else {
            throw new DispositivoNonTrovatoException("Smartphone con ID " + id + " non è stato trovato");
        }
    }

    @GetMapping("/api/computer/{id}")
    public Computer getComputersById(@PathVariable int id) {
        Optional<Computer> computerOptional = dispositivoService.getComputerById(id);

        if (computerOptional.isPresent()) {
            return computerOptional.get();
        } else {
            throw new DispositivoNonTrovatoException("Computer con ID " + id + " non è stato trovato");
        }
    }

    @PostMapping("/api/smartphone")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveSmartphone(@RequestBody @Validated SmartphoneDto smartphoneDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .reduce("", (s, s2) -> s + s2));
        }
        return dispositivoService.saveSmartphone(smartphoneDto);
    }

    @PostMapping("/api/computer")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveComputers(@RequestBody @Validated ComputerDto computerDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .reduce("", (s, s2) -> s + s2));
        }
        return dispositivoService.saveComputer(computerDto);
    }

    @PutMapping("/api/smartphone/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Smartphone updateSmartphone(@PathVariable int id, @RequestBody @Validated SmartphoneDto smartphoneDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).
                    reduce("", (s, s2) -> s+s2));
        }

        return dispositivoService.updateSmartphone(id, smartphoneDto);
    }

    @PutMapping("/api/computer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Computer updateComputer (@PathVariable int id, @RequestBody @Validated ComputerDto computerDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).
                    reduce("", (s, s2) -> s+s2));
        }

        return dispositivoService.updateComputer(id, computerDto);
    }

    @DeleteMapping("/api/smartphone/{id}")
    public String deleteSmartphone (@PathVariable int id) {
        return dispositivoService.deleteSmartphone(id);
    }

    @DeleteMapping("/api/computer/{id}")
    public String deleteComputer (@PathVariable int id) {
        return dispositivoService.deleteComputer(id);
    }

    @PatchMapping("/api/smartphone/{smartphoneId}/dipendente/{dipendenteId}")
    public String patchSmartphoneDipendente (@PathVariable int dipendenteId, @PathVariable int smartphoneId) {
        return dispositivoService.patchSmartphoneDipendente(dipendenteId, smartphoneId);
    }

    @PatchMapping("/api/computer/{computerId}/dipendente/{dipendenteId}")
    public String patchComputerDipendente (@PathVariable int dipendenteId, @PathVariable int computerId) {
        return dispositivoService.patchSmartphoneDipendente(dipendenteId, computerId);
    }

}
