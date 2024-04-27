import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Product {
    private long id;
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
        Random rndm = new Random();
        this.id = rndm.nextLong();
    }
}
