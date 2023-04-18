package cms5.frontend;

import javafx.beans.property.*;
import javafx.beans.value.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import backend.*;

import java.net.*;
import java.util.*;

public class PayController implements Initializable{
    /**
     * All relevant UI items are stated below.
     */

    @FXML
    Button fxFinish;
    @FXML
    Button fxBackToPontun;
    @FXML
    Label fxDeliveryMinutes;
    @FXML
    Label fxTotalDisplay;
    @FXML
    Label fxCustomerName;
    @FXML
    Label fxAddress;
    /**
     * When the button is pressed, all the information in the static objects gets reset to their initial stage.
     */
    public void fxFinishHandler(ActionEvent actionEvent) {
        order.setTotal(0);
        client.setUsername("No User");
        client.setAddress("empty");
        client.setStatus("Not Registered");
        int index = Order.count;
        for (int i = 0; i < index; i++){
            Order.orderedFoodNames.remove(0);
            Order.orderedPrices.remove(0);
        }
        Order.count =0;
        ViewSwitcher.switchTo(View.MAIN);
    }
    /**
     * If the customer wants to go back and edit their order. ViewSwitcher just takes them back.
     */
    public void fxBackToPontunHandler(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.MAIN);
    }
    IntegerProperty finalPrice = new SimpleIntegerProperty();
    Order order;
    Client client;
    /**
     * Appropriate binding created for the totalDisplay Label as well as address and customer name based on Client information.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        order = new Order();
        client = new Client();
        double minutes = ((int) (Math.random()*100));
        fxDeliveryMinutes.setText(String.valueOf(minutes));
        finalPriceProperty().bind(Order.totalProperty());
        fxTotalDisplay.setText(String.valueOf(finalPrice.get()));
        fxCustomerName.setText(client.getUsername());
        fxAddress.setText(client.getAddress());
        Order.totalProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                fxTotalDisplay.setText(String.valueOf(t1));
            }
        });
    }
    public IntegerProperty finalPriceProperty() {
        return finalPrice;
    }
}
