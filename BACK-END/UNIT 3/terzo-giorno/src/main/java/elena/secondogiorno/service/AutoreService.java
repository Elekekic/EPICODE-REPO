package elena.secondogiorno.service;

import elena.secondogiorno.DTO.AutoreDto;
import elena.secondogiorno.exception.AutoreNonTrovatoException;
import elena.secondogiorno.model.Autore;
import elena.secondogiorno.model.BlogPost;
import elena.secondogiorno.repository.AutoreRepository;
import elena.secondogiorno.repository.BlogPostrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {

   @Autowired
   private AutoreRepository autoreRepository;

   @Autowired
   private BlogPostrepository blogPostrepository;

    public Optional<Autore> getAutoreById(int id) {
        return autoreRepository.findById(id);
    }

    public Page<Autore> getAllAutori (int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));
        return autoreRepository.findAll(pageable);
    }

    public String saveAutore(AutoreDto autoreDto) {
        Autore autore = new Autore();
        autore.setNome(autoreDto.getNome());
        autore.setEmail(autoreDto.getEmail());
        autore.setCognome(autoreDto.getCognome());
        autore.setDataDiNascita(autoreDto.getDataDiNascita());
        String avatar = "https://ui-avatars.com/api/?name=" + autoreDto.getNome() + "+" + autoreDto.getCognome();
        autore.setAvatar(avatar);
        autoreRepository.save(autore);
        return "Autore con id: " + autore.getId() + "aggiunto/a con successo";
    }

    public Autore updateAutore (int id, AutoreDto autoreDto) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOptional = getAutoreById(id);

        if(autoreOptional.isPresent()) {
            Autore autore = autoreOptional.get();
            autore.setNome(autoreDto.getNome());
            autore.setCognome(autoreDto.getCognome());
            autore.setEmail(autoreDto.getEmail());
            autore.setDataDiNascita(autoreDto.getDataDiNascita());
            String avatar = "https://ui-avatars.com/api/?name=" + autoreDto.getNome() + "+" + autoreDto.getCognome();
            autore.setAvatar(avatar);
            return autoreRepository.save(autore);
        }
        else {
            throw new AutoreNonTrovatoException("Autore con id:" + id + " non trovata");
        }
    }

    public String deleteAutore(int id) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOpt = autoreRepository.findById(id);

        if (autoreOpt.isPresent()) {
            autoreRepository.delete(autoreOpt.get());
            return "Autore con ID: " + id + "cancellato con successo";
        } else {
            throw new AutoreNonTrovatoException("Autore non trovato");
        }
    }
}
