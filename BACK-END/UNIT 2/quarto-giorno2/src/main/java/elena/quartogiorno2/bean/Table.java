package elena.quartogiorno2.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import jakarta.persistence.*;


@Data
@Entity
@PropertySource("application.properties")
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;

    private Stato stato;

    private int numMaxCoperti;

    @Value("${coperto.price}")
    private double copertoPrice;

    private boolean occupied;


   public enum Stato {
       LIBERO,OCCUPATO
   }

    public void print() {
        System.out.println("numero tavolo: " + numero);
        System.out.println("numero massimo coperti: " + numMaxCoperti);
        System.out.println("Free/Occupied: " + (this.occupied ? "Occupied" : "Free"));
        System.out.println("costo coperto: " + this.copertoPrice);
    }
}
