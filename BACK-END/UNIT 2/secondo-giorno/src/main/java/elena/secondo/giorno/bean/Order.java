package elena.secondo.giorno.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Data
@Component
public class Order {


    private Table table;
    private List<Item> listaOrdine;
    private LocalTime oraAcquisizione;
    private int numCoperti;
    private Stato stato;
    private int numeroOrdine;
    private int importoTotale;

    public enum Stato {
        IN_CORSO, PRONTO, SERVITO
    }

    public double getTotal() {
        return this.listaOrdine.stream().mapToDouble(Item::getPrice).sum() + (this.table.getCopertoPrice() * this.numCoperti);
    }


    public void print() {
        System.out.println("numero ordine: " + this.numeroOrdine);
        System.out.println("Dettagli lista: ");
        this.listaOrdine.forEach(System.out::println);
        System.out.println("stato attuale: " + this.stato);
        System.out.println("numero coperti: " + this.numCoperti);
        System.out.println("ora acquisizione: " + this.oraAcquisizione);
        System.out.println("numero tavolo: " + this.table.getNumero());
        System.out.println("TOTALE: " + this.getTotal());

    }

}
