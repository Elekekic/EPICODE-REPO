package elena.quartogiorno2.bean;

import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
public class Menu {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy = "menu")
    private List<Pizza> pizzas;

    @OneToMany(mappedBy = "menu")
    private List<Drink> drinks;

    @OneToMany(mappedBy = "menu")
    private List<Topping> toppings;

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
