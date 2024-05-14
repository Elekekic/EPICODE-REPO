package elena.secondo.giorno.bean;

import lombok.Data;

import java.util.List;

@Data
public class Pizzas {

    private String name;
    private String tomato = "tomato";
    private String mozarella = "mozarella";
    private double price;
    private int calories;

    private List<Toppings> toppings;


}
