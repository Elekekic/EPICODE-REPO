import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {
    private long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;


    public Order(Customer customer) {
        Random rndm = new Random();
        this.id = rndm.nextLong();
        this.customer = customer;
        this.status = "Creating...";
        this.orderDate = LocalDate.now();
        this.deliveryDate = LocalDate.now();
        this.products = new ArrayList<>();
    }

}
