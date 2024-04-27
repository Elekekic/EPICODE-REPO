import java.util.Random;

public class Customer {

    private long id;
    private String name;
    private int tier;

    public Customer(String name, int tier) {
        this.name = name;
        this.tier = tier;
        Random rndm = new Random();
        this.id = rndm.nextLong();
    }
}
