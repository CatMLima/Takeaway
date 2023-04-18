package backend;

import javafx.beans.property.*;
import javafx.collections.*;

import java.io.*;

public class Order extends Menu {
    private static IntegerProperty total = new SimpleIntegerProperty();
    public static int count = 0;
    public static int getTotal() {
        return total.get();
    }
    public static IntegerProperty totalProperty() {
        return total;
    }
    public void setTotal(int total) {
        Order.total.set(total);
    }
    public static String[] namesOrdered = new String[count];
    public static Integer[] pricesOrdered = new Integer[count];
    public static ObservableList<String> orderedFoodNames = FXCollections.observableArrayList(namesOrdered);
    public static ObservableList<Integer> orderedPrices = FXCollections.observableArrayList(pricesOrdered);
    public Order() {
    }
    /**
     * This method updates the total amount everytime an item is added to the Order
     * @param price of Food item
     */
    public static void calculatePlusPrices(int price){
        count++;
        total.set(getTotal() + price);
    }
    /**
     * Since my calculatePlusPrices method is used by the MenuView when items are added, I had to create a separate method
     * calculateMinusPrices which calculates the new price when a change is made to the order through the PontunController.
     * @param price of item being removed
     */
    public static void calculateMinusPrices(int price){
        int newTotal = getTotal() - price;
        total.set(newTotal);
    }
    /**
     * Delete the topmost item of the list and decrease the count
     */
    public void deleteLast () {
            orderedFoodNames.remove(0);
            int deletePrice = orderedPrices.remove(0);
            calculateMinusPrices(deletePrice);
            count--;
    }
    }