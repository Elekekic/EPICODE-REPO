package elena.secondo.giorno;

import elena.secondo.giorno.bean.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class SecondoGiornoApplicationTests {

	@Autowired
	static ApplicationContext ctx;

	@BeforeAll
	public static void apriContesto(){
		ctx = new AnnotationConfigApplicationContext(SecondoGiornoApplication.class);
		System.out.println("Accesso al contesto avvenuto");
	}

	@Test
	void verificaNumeroCopertiDallOrdine1() {
		Order order = ctx.getBean("Order-1", Order.class);
		Assertions.assertEquals(4, order.getNumCoperti());
	}

	@Test
	void verificaTavoloLibero() {
		Table table = ctx.getBean("Table-1", Table.class);
		Assertions.assertEquals(false, table.isOccupied());
	}

	@Test
	public void verificaListaOrdiniIsNotNull(){
		Order order = ctx.getBean( "Order-1", Order.class);
		assertThat(order.getListaOrdine()).isNotNull();
	}

	@ParameterizedTest
	@ValueSource(strings = {"H"})
	public void verificaPizzeConHInizialedentroMenu(String inizio) {
		Menu menu = ctx.getBean("menu", Menu.class);
		menu.getPizzas().stream().filter(pizza -> pizza.getName().startsWith(inizio)).forEach(System.out::println);
		long numero = menu.getPizzas().stream().filter(pizza -> pizza.getName().startsWith(inizio)).count();
		Assertions.assertEquals(2, numero);
	}

	@ParameterizedTest
	@CsvSource({"W,2", "L,1"})
	public void verificaNumeroDrinksConNomeCheIniziaCon(String inizio, Long conteggio){
		Menu menu = ctx.getBean("menu",Menu.class);
		menu.getDrinks().stream().filter(drinks -> drinks.getName().startsWith(inizio)).forEach(System.out::println);
		long numero =menu.getDrinks().stream().filter(drinks -> drinks.getName().startsWith(inizio)).count();
		Assertions.assertEquals(conteggio,numero);
	}

	@AfterAll
	public static void chiudiContesto(){
		ctx = null;
		System.out.println("Contesto chiuso");
	}

}
