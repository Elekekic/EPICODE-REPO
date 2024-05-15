package elena.secondo.giorno.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class Menu {

    private List<Pizzas> pizzas;

    private List<Drinks> drinks;

    private List<Toppings> toppings;

    public void printMenu() {
        System.out.println("MENU ------");
        System.out.println("PIZZAS: ");
        this.pizzas.forEach(System.out::println);
        System.out.println();

        System.out.println("TOPPINGS: ");
        this.toppings.forEach(System.out::println);
        System.out.println();

        System.out.println("DRINKS: ");
        this.drinks.forEach(System.out::println);
        System.out.println();

    }
}
