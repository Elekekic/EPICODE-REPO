package elena.quartogiorno2.bean;

import lombok.Data;
import lombok.ToString;
import jakarta.persistence.*;

@Data
@Entity
@ToString(callSuper = true)
public class Topping extends Item {

    private String nome;

    @ManyToOne
    @JoinColumn(name = "pizza_fk")
    private Pizza pizza;

    @ManyToOne
    @JoinColumn(name = "menu_fk")
    private Menu menu;
}
