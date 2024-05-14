package elena.primogiorno1.appConfig;


import elena.primogiorno1.bean.Drinks;
import elena.primogiorno1.bean.Menu;
import elena.primogiorno1.bean.Pizzas;
import elena.primogiorno1.bean.Toppings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean("Lemonade")
    @Scope("prototype")
    public Drinks getLemonade() {
        Drinks drink = new Drinks();
        drink.setName("Lemonade");
        drink.setLitres(0.5);
        drink.setPrice(1.29);
        drink.setCalories(128);
        return drink;
    }

    @Bean("Water")
    @Scope("prototype")
    public Drinks getWater() {
        Drinks drink = new Drinks();
        drink.setName("Water");
        drink.setLitres(0.5);
        drink.setPrice(1.29);
        drink.setCalories(0);
        return drink;
    }

    @Bean("Wine")
    @Scope("prototype")
    public Drinks getWine() {
        Drinks drink = new Drinks();
        drink.setName("Wine");
        drink.setLitres(0.75);
        drink.setPrice(7.49);
        drink.setCalories(607);
        return drink;
    }

    @Bean("Cheese")
    @Scope("prototype")
    public Toppings getCheese() {
        Toppings toppings = new Toppings();
        toppings.setNome("Cheese");
        toppings.setCalories(92);
        toppings.setPrice(0.69);
        return toppings;
    }

    @Bean("Ham")
    @Scope("prototype")
    public Toppings getHam() {
        Toppings toppings = new Toppings();
        toppings.setNome("Ham");
        toppings.setCalories(35);
        toppings.setPrice(0.89);
        return toppings;
    }

    @Bean("Onions")
    @Scope("prototype")
    public Toppings getOnions() {
        Toppings toppings = new Toppings();
        toppings.setNome("Onions");
        toppings.setCalories(22);
        toppings.setPrice(0.69);
        return toppings;
    }

    @Bean("Pineapple")
    @Scope("prototype")
    public Toppings getPineapple() {
        Toppings toppings = new Toppings();
        toppings.setNome("Pineapple");
        toppings.setCalories(24);
        toppings.setPrice(0.79);
        return toppings;
    }

    @Bean("Salami")
    @Scope("prototype")
    public Toppings getSalami() {
        Toppings toppings = new Toppings();
        toppings.setNome("Salami");
        toppings.setCalories(86);
        toppings.setPrice(0.99);
        return toppings;
    }

    @Bean("Margherita Pizza")
    @Scope("prototype")
    public Pizzas getMargheritaPizza() {
        Pizzas pizza = new Pizzas();
        pizza.setName("Margherita Pizza");
        pizza.getMozarella();
        pizza.getMozarella();
        pizza.setCalories(1104);
        pizza.setPrice(5.50);
        return pizza;
    }

    @Bean("Salami Pizza")
    @Scope("prototype")
    public Pizzas getSalamiPizza() {
        Pizzas pizza = new Pizzas();
        pizza.setName("Salami Pizza");
        pizza.getMozarella();
        pizza.getMozarella();
        pizza.setToppings(List.of(getSalami()));
        pizza.setCalories(1160);
        pizza.setPrice(6.50);
        return pizza;
    }

    @Bean("Ham Pizza")
    @Scope("prototype")
    public Pizzas getHamPizza() {
        Pizzas pizza = new Pizzas();
        pizza.setName("Ham Pizza");
        pizza.getMozarella();
        pizza.getMozarella();
        pizza.setToppings(List.of(getHam()));
        pizza.setCalories(1160);
        pizza.setPrice(5.50);
        return pizza;
    }

    @Bean("Hawaiian Pizza")
    @Scope("prototype")
    public Pizzas getHawaiianizza() {
        Pizzas pizza = new Pizzas();
        pizza.setName("Hawaiian Pizza");
        pizza.getMozarella();
        pizza.getMozarella();
        pizza.setToppings(List.of(getHam()));
        pizza.setCalories(1024);
        pizza.setPrice(7.50);
        return pizza;
    }

    @Bean("Menù")
    public Menu getMenu() {
        Menu menu = new Menu();
        menu.setDrinks(List.of(getLemonade(),getWater(),getWine()));
        menu.setToppings(List.of(getHam(),getCheese(),getPineapple(),getOnions(),getSalami()));
        menu.setPizzas(List.of(getHamPizza(),getMargheritaPizza(),getHawaiianizza(),getSalamiPizza()));
        return menu;
    }

}
