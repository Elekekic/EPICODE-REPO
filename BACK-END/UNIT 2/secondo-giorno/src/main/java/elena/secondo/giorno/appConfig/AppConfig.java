package elena.secondo.giorno.appConfig;

import elena.secondo.giorno.bean.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean("Lemonade")
    @Scope("prototype")
    public Drink getLemonade() {
        Drink drink = new Drink();
        drink.setName("Lemonade");
        drink.setLitres(0.5);
        drink.setPrice(1.29);
        drink.setCalories(128);
        return drink;
    }

    @Bean("Water")
    @Scope("prototype")
    public Drink getWater() {
        Drink drink = new Drink();
        drink.setName("Water");
        drink.setLitres(0.5);
        drink.setPrice(1.29);
        drink.setCalories(0);
        return drink;
    }

    @Bean("Wine")
    @Scope("prototype")
    public Drink getWine() {
        Drink drink = new Drink();
        drink.setName("Wine");
        drink.setLitres(0.75);
        drink.setPrice(7.49);
        drink.setCalories(607);
        return drink;
    }

    @Bean("Cheese")
    @Scope("prototype")
    public Topping getCheese() {
        Topping topping = new Topping();
        topping.setNome("Cheese");
        topping.setCalories(92);
        topping.setPrice(0.69);
        return topping;
    }

    @Bean("Ham")
    @Scope("prototype")
    public Topping getHam() {
        Topping topping = new Topping();
        topping.setNome("Ham");
        topping.setCalories(35);
        topping.setPrice(0.89);
        return topping;
    }

    @Bean("Onions")
    @Scope("prototype")
    public Topping getOnions() {
        Topping topping = new Topping();
        topping.setNome("Onions");
        topping.setCalories(22);
        topping.setPrice(0.69);
        return topping;
    }

    @Bean("Pineapple")
    @Scope("prototype")
    public Topping getPineapple() {
        Topping topping = new Topping();
        topping.setNome("Pineapple");
        topping.setCalories(24);
        topping.setPrice(0.79);
        return topping;
    }

    @Bean("Salami")
    @Scope("prototype")
    public Topping getSalami() {
        Topping topping = new Topping();
        topping.setNome("Salami");
        topping.setCalories(86);
        topping.setPrice(0.99);
        return topping;
    }

    @Bean("Margherita Pizza")
    @Scope("prototype")
    public Pizza getMargheritaPizza() {
        Pizza pizza = new Pizza();
        pizza.setName("Margherita Pizza");
        pizza.getPrimoIngredienteBase();
        pizza.getSecondoIngredienteBase();
        pizza.setCalories(1104);
        pizza.setPrice(5.50);
        pizza.isXl();
        return pizza;
    }

    @Bean("Salami Pizza")
    @Scope("prototype")
    public Pizza getSalamiPizza() {
        Pizza pizza = new Pizza();
        pizza.setName("Salami Pizza");
        pizza.getPrimoIngredienteBase();
        pizza.getSecondoIngredienteBase();
        pizza.setToppings(List.of(getSalami()));
        pizza.setCalories(1160);
        pizza.setPrice(6.50);
        pizza.isXl();
        return pizza;
    }

    @Bean("Ham Pizza")
    @Scope("prototype")
    public Pizza getHamPizza() {
        Pizza pizza = new Pizza();
        pizza.setName("Ham Pizza");
        pizza.getPrimoIngredienteBase();
        pizza.getSecondoIngredienteBase();
        pizza.setToppings(List.of(getHam()));
        pizza.setCalories(1160);
        pizza.setPrice(5.50);
        pizza.isXl();
        return pizza;
    }

    @Bean("Hawaiian Pizza")
    @Scope("prototype")
    public Pizza getHawaiianizza() {
        Pizza pizza = new Pizza();
        pizza.setName("Hawaiian Pizza");
        pizza.getPrimoIngredienteBase();
        pizza.getSecondoIngredienteBase();
        pizza.setToppings(List.of(getHam(),getPineapple()));
        pizza.setCalories(1024);
        pizza.setPrice(7.50);
        pizza.isXl();
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

    @Bean("Table-1")
    Table getTable (@Value("${coperto.price}") double priceCoperto, @Value("${table-1.copertiMax}") int copertiMax) {
       Table table = new Table();
       table.setNumero(1);
       table.setNumMaxCoperti(copertiMax);
       table.setStato(Table.Stato.LIBERO);
       table.setOccupied(false);
       table.setCopertoPrice(priceCoperto);
        return table;
    }

    @Bean("Order-1")
    Order getOrder (@Qualifier("Table-1") Table table) {
        Order order = new Order();
        order.setStato(Order.Stato.IN_CORSO);
        order.setNumeroOrdine(1);
        order.setOraAcquisizione(LocalTime.of(12,23));
        order.setNumCoperti(4);
        order.setTable(table);
        List<Item> items = new ArrayList<>();
        items.add(getWine());
        items.add(getHamPizza());
        items.add(getWater());
        items.add(getMargheritaPizza());
        order.setListaOrdine(items);
        return order;
    }


}
