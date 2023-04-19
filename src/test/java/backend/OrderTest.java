package backend;

import javafx.beans.property.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class OrderTest {
    public static int getTotal() {
        return total.get();
    }

    public static IntegerProperty totalProperty() {
        return total;
    }

    public static void setTotal(int total) {
        OrderTest.total.set(total);
    }

    private static IntegerProperty total = new SimpleIntegerProperty();

    private static Foods [] foods;

    private static Menu menu;

    List<String> orderedFoodNames = new ArrayList<>();
    @BeforeAll
    public static void setUp(){
        menu = new Menu();
        foods = menu.createFoods();
    }
    @Test
    public void twoFoodPricesAddedUpReturnCorrectTotal(){
        int amount1 = foods[0].getPrice();
        int amount2 = foods[1].getPrice();
        int result = amount1 + amount2;
        assertEquals(4700, result);
    }

    @Test
    public void removedFoodIsDeleted(){
        orderedFoodNames.add(foods[0].getDish());
        orderedFoodNames.add(foods[1].getDish());
        String lastIn = orderedFoodNames.remove(0);
        String nextIn = orderedFoodNames.remove(0);
        assertNotEquals("Cheese and meat roast", nextIn);
    }

}
