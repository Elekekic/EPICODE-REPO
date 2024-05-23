package elena.secondo.giorno.bean;

import lombok.Data;

import java.util.List;

@Data
public class Pizza extends Item {

    private String name;
    private String primoIngredienteBase = "tomato";
    private String secondoIngredienteBase = "mozarella";
    private boolean Xl = true;

    private List<Topping> toppings;


}
