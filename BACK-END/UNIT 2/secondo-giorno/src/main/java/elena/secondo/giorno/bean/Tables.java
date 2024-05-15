package elena.secondo.giorno.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class Tables {

    private int numero;
    private Stato stato;
    private int numMaxCoperti;
    private double priceCoperto;
    private boolean occupied;

    @Autowired
    private List<Orders> ordini;


   public enum Stato {
       LIBERO,OCCUPATO
   }

    public void print() {
        System.out.println("numero tavolo--> " + numero);
        System.out.println("numero massimo coperti--> " + numMaxCoperti);
        System.out.println("Free/Occupied--> " + (this.occupied ? "Free" : "Occupied"));
    }
}
