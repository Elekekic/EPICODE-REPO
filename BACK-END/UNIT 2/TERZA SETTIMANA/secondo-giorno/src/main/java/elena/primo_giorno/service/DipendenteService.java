package elena.primo_giorno.service;


import elena.primo_giorno.DTO.DipendenteDto;
import elena.primo_giorno.enumType.Role;
import elena.primo_giorno.exception.DipendenteNonTrovatoException;
import elena.primo_giorno.model.Dipendente;
import elena.primo_giorno.repository.DipendenteRepository;
import elena.primo_giorno.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private JwtTool jwtTool;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public Optional<Dipendente> getDipendenteeById(int id) {
        return dipendenteRepository.findById(id);
    }

    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepository.findAll();
    }

    public Dipendente getDipendenteByEmail(String email) {
        Optional<Dipendente> dipendenteOptional = dipendenteRepository.findByEmail(email);

        if(dipendenteOptional.isPresent()) {
            return dipendenteOptional.get();
        } else {
            throw new DipendenteNonTrovatoException("Dipendente with EMAIL:" + email + " hasn't been found");
        }
    }

    public String saveDipendente(DipendenteDto dipendenteDto) {
        Dipendente dipendente = new Dipendente();
        dipendente.setNome(dipendenteDto.getNome());
        dipendente.setEmail(dipendenteDto.getEmail());
        dipendente.setCognome(dipendenteDto.getCognome());
        dipendente.setUsername(dipendenteDto.getUsername());
        dipendente.setRole(Role.USER);
        dipendente.setPassword(passwordEncoder.encode(dipendenteDto.getPassword()));
        dipendente.setFotoProfilo("https://ui-avatars.com/api/?name=" + dipendente.getNome() + "+" + dipendente.getCognome());
        dipendenteRepository.save(dipendente);
        return "Dipendente con id: " + dipendente.getId() + " aggiunto/a con successo";
    }

    public Dipendente updateDipendente(int id, DipendenteDto dipendenteDto) {
        Optional<Dipendente> dipendenteOptional = getDipendenteeById(id);

        if (dipendenteOptional.isPresent()) {
            Dipendente dipendente = dipendenteOptional.get();
            dipendente.setNome(dipendenteDto.getNome());
            dipendente.setCognome(dipendenteDto.getCognome());
            dipendente.setEmail(dipendenteDto.getEmail());
            dipendente.setUsername(dipendenteDto.getUsername());
            dipendente.setPassword(passwordEncoder.encode(dipendenteDto.getPassword()));
            dipendente.setFotoProfilo("https://ui-avatars.com/api/?name=" + dipendente.getNome() + "+" + dipendente.getCognome());

            return dipendenteRepository.save(dipendente);

        } else {
            throw new DipendenteNonTrovatoException("Dipendente con id:" + id + " non trovato/a");
        }
    }

    public String deleteDipendente(int id) {
        Optional<Dipendente> dipendenteOptional = getDipendenteeById(id);

        if (dipendenteOptional.isPresent()) {
            dipendenteRepository.delete(dipendenteOptional.get());
            return "Dipendente con ID: " + id + " cancellato/a con successo";
        } else {
            throw new DipendenteNonTrovatoException("Dipendente con id:" + id + " non trovato/a");
        }
    }

}
