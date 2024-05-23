package elena.quartogiorno2.bean;


import lombok.Data;
import lombok.ToString;
import jakarta.persistence.*;
import java.util.List;

@Data
@ToString(callSuper = true)
@Entity
public class Pizza extends Item {

    private String name;
    private String primoIngredienteBase = "tomato";
    private String secondoIngredienteBase = "mozarella";
    private boolean Xl = true;

    @OneToMany(mappedBy = "pizza")
    private List<Topping> toppings;

    @ManyToOne
    private Menu menu;

}
