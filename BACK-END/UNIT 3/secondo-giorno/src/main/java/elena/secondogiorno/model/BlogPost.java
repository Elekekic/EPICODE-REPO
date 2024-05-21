package elena.secondogiorno.model;

import lombok.Data;

import java.time.Duration;
import java.time.LocalTime;

@Data
public class BlogPost {

    private int id;
    private static int cont;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;

    public BlogPost(String categoria, String titolo, String contenuto, int tempoDiLettura) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
        cont++;
        id=cont;
    }
}
