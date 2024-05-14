package elena.secondo.giorno;

import elena.secondo.giorno.appConfig.AppConfig;
import elena.secondo.giorno.bean.Drinks;
import elena.secondo.giorno.bean.Menu;
import elena.secondo.giorno.bean.Pizzas;
import elena.secondo.giorno.bean.Toppings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SecondoGiornoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondoGiornoApplication.class, args);

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SecondoGiornoApplication.class);


	}

}
