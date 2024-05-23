package elena.secondogiorno.service;

import elena.secondogiorno.exception.AutoreNonTrovatoException;
import elena.secondogiorno.model.Autore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {

    private List<Autore> autori = new ArrayList<>();

    public Optional<Autore> getAutoreById(int id){
        return autori.stream().filter(autore -> autore.getId()==id).findFirst();
    }

    public List<Autore> getAllAutori(){
        return autori;
    }

    public String saveAutore(Autore autore){
        autori.add(autore);
        return "L'autore " + autore.getNome() + " " + autore.getCognome() + " è stato aggiunto con l'ID: " + autore.getId();
    }

    public Autore updateAutore(int id, Autore autoreUpd) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOpt = getAutoreById(id);
        if(autoreOpt.isPresent()){
            Autore autore = autoreOpt.get();
            autore.setNome(autoreUpd.getNome());
            autore.setCognome(autoreUpd.getCognome());
            autore.setEmail(autoreUpd.getEmail());
            autore.setDataDiNascita(autoreUpd.getDataDiNascita());
            String avatar = "https://ui-avatars.com/api/?name=" + autore.getNome() + "+" + autore.getCognome();
            autore.setAvatar(avatar);
            return autore;
        }
        else{
            throw new AutoreNonTrovatoException("Autore non trovato");
        }
    }

    public String deleteStudente(int id) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOpt = getAutoreById(id);

        if (autoreOpt.isPresent()) {
            autori.remove(autoreOpt.get());
            return "Autore eliminato";
        } else {
            throw new AutoreNonTrovatoException("Autore non trovato");
        }
    }
}
