package elena.primogiorno1.bean;

import lombok.Data;

import java.util.List;

@Data
public class Menu {

    private List<Pizzas> pizzas;

    private List<Drinks> drinks;

    private List<Toppings> toppings;

}
