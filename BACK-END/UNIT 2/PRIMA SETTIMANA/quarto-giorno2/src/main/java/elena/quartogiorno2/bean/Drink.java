package elena.quartogiorno2.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;


@Data
@Entity
@ToString(callSuper = true)
public class Drink extends Item {

    private String name;

    @ManyToOne
    private Menu menu;
}
