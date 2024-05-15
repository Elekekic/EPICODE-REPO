package elena.secondo.giorno.bean;

import lombok.Data;

@Data
public abstract class Item {

    private double litres;
    private double price;
    private int calories;


    public Item(double litres, double price, int calories) {
        this.litres = litres;
        this.price = price;
        this.calories = calories;
    }
}
