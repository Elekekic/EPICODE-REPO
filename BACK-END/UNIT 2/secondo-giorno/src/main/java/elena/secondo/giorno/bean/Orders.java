package elena.secondo.giorno.bean;

import lombok.Data;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

@Data
@Component("orders")
public class Orders {

    private int numeroOrdine;

    private Stato stato;

    public enum Stato {
        IN_CORSO, PRONTO, SERVITO
    }

    public int numCoperti;

    public Duration oraDiAcwuistazione;

    List<Menu> listaOrdine;

    private int importoTotale;
}
