package elena.quartogiorno2.bean;


import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numeroOrdine;

    @OneToOne
    private Table table;

    @OneToMany(mappedBy = "order")
    private List<Item> listaOrdine;

    private LocalTime oraAcquisizione;
    private int numCoperti;
    private Stato stato;
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
