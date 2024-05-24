package elena.secondogiorno.service;

import com.cloudinary.Cloudinary;
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
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public Optional<Autore> getAutoreById(int id) {
        return autoreRepository.findById(id);
    }

    public Page<Autore> getAllAutori(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return autoreRepository.findAll(pageable);
    }

    public String saveAutore(AutoreDto autoreDto) {
        Autore autore = new Autore();
        autore.setNome(autoreDto.getNome());
        autore.setEmail(autoreDto.getEmail());
        autore.setCognome(autoreDto.getCognome());
        autore.setDataDiNascita(autoreDto.getDataDiNascita());
        autore.setAvatar("https://ui-avatars.com/api/?name=" + autore.getNome() + "+" + autore.getCognome());
        autoreRepository.save(autore);
        sendMail(autore.getEmail()); // in modo da poter mandare le email di conferma
        return "Autore con id: " + autore.getId() + " aggiunto/a con successo";
    }

    public Autore updateAutore(int id, AutoreDto autoreDto) {
        Optional<Autore> autoreOptional = getAutoreById(id);

        if (autoreOptional.isPresent()) {
            Autore autore = autoreOptional.get();
            autore.setNome(autoreDto.getNome());
            autore.setCognome(autoreDto.getCognome());
            autore.setEmail(autoreDto.getEmail());
            autore.setDataDiNascita(autoreDto.getDataDiNascita());
            autore.setAvatar("https://ui-avatars.com/api/?name=" + autore.getNome() + "+" + autore.getCognome());

            return autoreRepository.save(autore);

        } else {
            throw new AutoreNonTrovatoException("Autore con id:" + id + " non trovato/a");
        }
    }

    public String deleteAutore(int id) {
        Optional<Autore> autoreOpt = getAutoreById(id);

        if (autoreOpt.isPresent()) {
            autoreRepository.delete(autoreOpt.get());
            return "Autore con ID: " + id + "cancellato/a con successo";
        } else {
            throw new AutoreNonTrovatoException("Autore con id:" + id + " non trovato/a");
        }
    }

    public String patchFoto(int id, MultipartFile foto) throws IOException {
        Optional<Autore> studenteOptional = autoreRepository.findById(id);

        if (studenteOptional.isPresent()) {
            String url = (String) cloudinary.uploader().upload(foto.getBytes(), Collections.emptyMap()).get("url");
            Autore autore = studenteOptional.get();

            autore.setAvatar(url);
            autoreRepository.save(autore);
            return "Autore con ID: " + id + " aggiornato correttamente con successo";
        } else {
            throw new AutoreNonTrovatoException("Autore non trovato/a");
        }
    }

    private void sendMail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Registrazione App BlogPost");
        message.setText("Registrazione all'app BlogPost avvenuta con successo! :)");

        javaMailSender.send(message);
    }


}
