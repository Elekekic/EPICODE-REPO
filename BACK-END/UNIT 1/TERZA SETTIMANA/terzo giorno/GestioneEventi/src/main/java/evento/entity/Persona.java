package evento.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "persone")
public class Persona {

    @Id
    @GeneratedValue
    private long id;

    private String nome;

    private String cognome;

    private String email;

    private LocalDate data_di_nascita;

    @Enumerated(EnumType.STRING)
    private Sesso sesso;

    @OneToMany(mappedBy = "persona")
    private List<Partecipazione> partecipazioni;

    public enum Sesso {
        M,F
    }

    public Persona(long id, String nome, String cognome, String email, LocalDate data_di_nascita, Sesso sesso, List<Partecipazione> partecipazioni) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.data_di_nascita = data_di_nascita;
        this.sesso = sesso;
        this.partecipazioni = partecipazioni;
    }
    public Persona() {}

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getData_di_nascita() {
        return data_di_nascita;
    }

    public void setData_di_nascita(LocalDate data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", data_di_nascita=" + data_di_nascita +
                ", sesso=" + sesso +
                '}';
    }

}
