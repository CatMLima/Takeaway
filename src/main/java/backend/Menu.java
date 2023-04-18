package backend;

import javafx.collections.*;

public class Menu{
    /**
     * This class is where the Menu is created. This class is only used by MenuView. I created ten meals, a short but delicious menu
     * full of foods you may or may not recognize as per the tweaked names.
     */
    private Foods [] meals = new Foods[10];
    public Menu(){
        createFoods();
        getFoods(meals);
    }
    /**
     * Made into an observable list so it could then be applied to the List View Item which is MenuView.
     *
     * @param meals being created
     */
    public void getFoods(Foods [] meals){
        FXCollections.observableArrayList(meals);
    }
    // has to be called so that the menu is created
    public Foods[] createFoods() {
        meals[0] = new Foods("Cheese and meat roast", 3000);
        meals[1] = new Foods("Margareta", 1700);
        meals[2] = new Foods("Mushuroni", 2000);
        meals[3] = new Foods("Anna-ham", 1800);
        meals[4] = new Foods("Hak-end-Olive", 2100);
        meals[5] = new Foods("All In One", 3500);
        meals[6] = new Foods("Zola-zola", 500);
        meals[7] = new Foods("Zrite", 450);
        meals[8] = new Foods("Tanta", 300);
        meals[9] = new Foods("Cheesy Sticks of Bread", 1000);
        return meals;
    }
}
