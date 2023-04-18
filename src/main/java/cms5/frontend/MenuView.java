package cms5.frontend;

import javafx.beans.value.*;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import backend.*;
import backend.Menu;

import java.io.*;

public class MenuView extends ListView<Foods>{
    Order order;
    /**
     * Created as its own controller, this is the custom class requested by the professor. I made it connect to Order directly because I could
     * not connect its values to PontunController any other way.
     */
    public MenuView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        Menu menu = new Menu();
        Foods[] menuItems = menu.createFoods();
        ObservableList<Foods> observableFoodList = FXCollections.observableArrayList(menuItems);
        setItems(observableFoodList);
        order = new Order();
        getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Foods>() {
            @Override
            public void changed(ObservableValue<? extends Foods> observableValue, Foods foods, Foods t1) {
                Order.orderedFoodNames.add(t1.getDish());
                Order.orderedPrices.add(t1.getPrice());
                Order.calculatePlusPrices(t1.getPrice());
                // test to see that it runs System.out.println(t1.getPrice());
            }
        });
    }
}

