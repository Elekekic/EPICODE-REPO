package elena.secondo.giorno.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component("drinks")
public class Drinks {

    private String name;
    private double litres;
    private double price;
    private int calories;
}
