package elena.secondo.giorno.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component("table1")
@PropertySource("application.properties")
public class Tables {

    private String numero;

    private Stato stato;

    @Value("${table1.copertiMax}")
    private int copertiMax;

    private List<Orders> ordini;

    @Autowired
    public void setOrdini(List<Orders> ordini) {
        this.ordini = ordini;
   }

   public enum Stato {
       LIBERO,OCCUPATO
   }
}
