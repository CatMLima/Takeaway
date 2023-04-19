package backend;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MenuTest {

    private static Menu menu;
    static Foods [] testFoods;

    @BeforeAll
    public static void setUp(){
        menu = new Menu();
        testFoods = menu.createFoods();
    }

    @Test
    public void firstMenuItemMatches(){
        String foodName = testFoods[0].getDish();
        assertEquals("Cheese and meat roast", foodName);
    }

    @Test
    public void menuOnlyHasTenItems(){
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, ()->{
            String foodname = testFoods[11].getDish();
        });
    }


}
