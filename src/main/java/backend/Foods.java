package backend;

import javafx.beans.property.*;

public class Foods {
    /**
     * By creating properties I was able to create later on bindings that correspond to this class. Here are two major components, the dish and its price.
     */
    private StringProperty dish = new SimpleStringProperty();
    public String getDish() {
        return dish.get();
    }
    public StringProperty dishProperty() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish.set(dish);
    }
    private IntegerProperty price = new SimpleIntegerProperty();
    public int getPrice() {
        return price.get();
    }
    public IntegerProperty priceProperty() {
        return price;
    }
    public void setPrice(int price) {
        this.price.set(price);
    }
    public Foods (String name, int price){
       setDish(name);
       setPrice(price);

    }
    public String toString(){
        return getDish() + " " + getPrice();
    }
}
