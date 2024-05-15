package elena.secondo.giorno.bean;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Data
@Component
public class Order {
    Logger logger = LoggerFactory.getLogger(Order.class);

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
        logger.info("numero ordine: " + this.numeroOrdine);
        logger.info("Dettagli lista: ");
        this.listaOrdine.forEach(System.out::println);
        logger.info("stato attuale: " + this.stato);
        logger.info("numero coperti: " + this.numCoperti);
        logger.info("ora acquisizione: " + this.oraAcquisizione);
        logger.info("numero tavolo: " + this.table.getNumero());
        logger.info("TOTALE: " + this.getTotal());

    }

}
