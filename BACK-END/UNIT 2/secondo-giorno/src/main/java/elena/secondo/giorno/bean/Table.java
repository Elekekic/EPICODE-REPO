package elena.secondo.giorno.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@PropertySource("application.properties")
public class Table {

    private int numero;
    private Stato stato;
    private int numMaxCoperti;

    @Value("${coperto.price}")
    private double copertoPrice;

    private boolean occupied;

    @Autowired
    private List<Order> ordini;


   public enum Stato {
       LIBERO,OCCUPATO
   }

    public void print() {
        System.out.println("numero tavolo: " + numero);
        System.out.println("numero massimo coperti: " + numMaxCoperti);
        System.out.println("Free/Occupied: " + (this.occupied ? "Free" : "Occupied"));
        System.out.println("costo coperto: " + this.copertoPrice);
    }
}
