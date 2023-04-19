package backend;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FoodsTest {

    private static Foods food;

    @BeforeAll
    public static void setUp(){
        food = new Foods("Lasagna", 500);
    }

    @Test
    public void getFoodNameReturnsCorrectName(){
        String foodName = food.getDish();
        assertEquals("Lasagna", foodName);
    }

    @Test
    public void getPriceReturnsCorrectPrice(){
        int price = food.getPrice();
        assertEquals(500, price);
    }

    @Test
    public void updatedPriceIsSaved(){
        food.setPrice(1000);
        int price = food.getPrice();
        assertEquals(1000, price);
    }
}
