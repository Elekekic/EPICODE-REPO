package elena.primogiorno1;

import elena.primogiorno1.appConfig.AppConfig;
import elena.primogiorno1.bean.Drinks;
import elena.primogiorno1.bean.Menu;
import elena.primogiorno1.bean.Pizzas;
import elena.primogiorno1.bean.Toppings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class PrimoGiorno1Application {

    public static void main(String[] args) {
        SpringApplication.run(PrimoGiorno1Application.class, args);

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Menu menu = ctx.getBean("Menù", Menu.class);
		System.out.println("--------------------");
        System.out.println("Pizzas:");
        for (Pizzas pizza : menu.getPizzas()) {
            System.out.println(pizza);
        }

		System.out.println("--------------------");
        System.out.println("Drinks:");
        for (Drinks drink : menu.getDrinks()) {
            System.out.println(drink);
        }

		System.out.println("--------------------");
        System.out.println("Toppings:");
        for (Toppings topping : menu.getToppings()) {
            System.out.println(topping);
        }
    }
}


