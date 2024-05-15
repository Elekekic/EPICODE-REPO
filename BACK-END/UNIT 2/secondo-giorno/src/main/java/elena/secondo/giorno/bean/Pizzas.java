package elena.secondo.giorno.bean;

import lombok.Data;

import java.util.List;

@Data
public class Pizzas extends Item {

    private String name;
    private String primoIngredienteBase = "tomato";
    private String secondoIngredienteBase = "mozarella";
    private boolean Xl = true;

    private List<Toppings> toppings;


}
