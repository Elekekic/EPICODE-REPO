package elena.quartogiorno2;

import elena.quartogiorno2.Service.ItemService;
import elena.quartogiorno2.Service.OrderService;
import elena.quartogiorno2.Service.TableService;
import elena.quartogiorno2.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyCommandRunner implements CommandLineRunner {

    @Autowired
    private ItemService itemService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private TableService tableService;

    @Override
    public void run(String... args) throws Exception {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(QuartoGiorno2Application.class);

            Pizza pizza1 = ctx.getBean( "Hawaiian Pizza",Pizza.class);
            itemService.saveItem(pizza1);

            Pizza pizza2 = ctx.getBean( "Ham Pizza",Pizza.class);
            itemService.saveItem(pizza2);

            Pizza pizza3 = ctx.getBean( "Salami Pizza",Pizza.class);
            itemService.saveItem(pizza3);

            Pizza pizza4 = ctx.getBean( "Margherita Pizza",Pizza.class);
            itemService.saveItem(pizza4);

            Drink drink1 = ctx.getBean("Lemonade", Drink.class);
            itemService.saveItem(drink1);

            Drink drink2 = ctx.getBean("Wine", Drink.class);
            itemService.saveItem(drink2);

            Drink drink3 = ctx.getBean("Water",  Drink.class);
            itemService.saveItem(drink3);

            Topping topping1 = ctx.getBean("Cheese", Topping.class);
            itemService.saveItem(topping1);

            Topping topping2 = ctx.getBean("Ham", Topping.class);
            itemService.saveItem(topping2);

            Topping topping3 = ctx.getBean("Onions", Topping.class);
            itemService.saveItem(topping3);

            Topping topping4 = ctx.getBean("Pineapple", Topping.class);
            itemService.saveItem(topping4);

            Topping topping5 = ctx.getBean("Salami", Topping.class);
            itemService.saveItem(topping5);

            Menu menu = ctx.getBean("Menu", Menu.class);
            menu.printMenu();
            System.out.println("-------------");

            System.out.println("Tavolo scelto:");
            Table t1 = ctx.getBean("Table-1", Table.class);
            tableService.saveTable(t1);
            t1.print();
            System.out.println("-------------");

            System.out.println("Ordine scelto:");
            Order order = ctx.getBean("Order-1", Order.class);
            orderService.saveOrder(order);
            order.print();


    }
}
