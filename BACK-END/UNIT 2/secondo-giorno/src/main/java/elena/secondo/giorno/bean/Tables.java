package elena.secondo.giorno.bean;

import lombok.Data;
import lombok.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component("tavolo1")
@PropertySource("application.properties")
public class Tavolo {

    @Value("${tavolo.numero}")
    private String numero;
}
