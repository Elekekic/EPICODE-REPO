package elena.quartogiorno2.bean;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Item {

    @Id
    @GeneratedValue
    private int id;

    private double litres;
    private double price;
    private int calories;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", litres=" + litres +
                ", price=" + price +
                ", calories=" + calories +
                '}';
    }
}
