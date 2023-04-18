package cms5.frontend;

import javafx.beans.value.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import backend.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class OrderController implements Initializable {
    /**
     * Relevant UI components are stated here below.
     */
    @FXML
    Label loggedUser;
    @FXML
    Button fxLogin;
    @FXML
    Button fxRegister;
    @FXML
    Button fxDeletePrevious;
    @FXML
    Button fxPayForOrder;
    @FXML
    TextField fxCurrentTotal;
    Client client;
    @FXML
    ListView<String> orderedFoods;
    MenuView menuView;
    Order order;

    /**
     * The vinnsla classes that will be accessed are initialized and important bindings and changeListeners set.
     * The bindings were mostly for the loggedUser display to be able to let the user know if they need to register and log in.
     * I went ahead and made it so that the button for loggin in is bound by the client being registed. The button for finishing the order is
     * bound by the client being logged in (so their address is available). The button for deleting objects of the list only works if you have
     * any objects in your order.
     * @param location
     * @param resources
     */

    public void initialize(URL location, ResourceBundle resources) {
        try {
            menuView = new MenuView();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ListView<Foods> foodsListView = menuView;
        client = new Client();
        order = new Order();
        order.setTotal(0);
        fxCurrentTotal.setText("0");
        ObservableList<String> orderedList = Order.orderedFoodNames;
        orderedFoods.setItems(orderedList);
        order.totalProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                fxCurrentTotal.setText(String.valueOf(t1));
            }
        });
        client.statusProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                loggedUser.textProperty().set(t1);
            }
        });
        fxLogin.disableProperty().bind(client.statusProperty().isEqualTo("Not Registered"));
        fxPayForOrder.disableProperty().bind(client.statusProperty().isNotEqualTo("Logged In"));
        fxDeletePrevious.disableProperty().bind(order.totalProperty().isEqualTo(0));
    }


    /**
     * When this button is clicked, the Client dialog will open up where the customer can write in their name and address
     * @param actionEvent the button being clicked
     * The return value is a new Client value with status set to registered so the Login button will now be enabled.
     */
    public void fxRegisterHandler(ActionEvent actionEvent){
        ClientDialog clientDialog = new ClientDialog();
        Optional<Client> result = clientDialog.showAndWait();
        if (result.isPresent()) {
                    client.setStatus(result.get().getStatus());
                    client.setUsername(result.get().getUsername());
                    client.setAddress(result.get().getAddress());
        }

    }

    /**
     * The dialog will present the user with their username and ask for a password.
     * @param actionEvent the button clicked
     * After this, the Pay for Order button will be enabled
     */
    /*
    This handler was edited to catch a corner case during HBV202GFinalProject
     */
    public void fxLoginHandler(ActionEvent actionEvent){
        if (loggedUser.textProperty().get().equals("Registered")) {
            UserDialog userDialog = new UserDialog(client.getUsername());
            Optional<Client> result = userDialog.showAndWait();
            result.ifPresent(value -> client.setStatus(Client.getStatus()));
            fxLogin.setText("Log Out");
        } else {
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
            fxLogin.setText("Log In");
        }
    }
    /**
     * When this button is clicked, the last item added to the Ordering list will be deleted (popped).
     * @param actionEvent button being clicked
     * I have managed to make button work but cant add items from the list onto it
     */
    public void fxDeletePreviousHandler(ActionEvent actionEvent){
        order.deleteLast();
    }
    /**
     * When this button is pressed, the finishing order dialog will come up
     * @param actionEvent the button being clicked
     */
    public void fxFinishOrderHandler(ActionEvent actionEvent){
        ViewSwitcher.switchTo(View.PAY);
    }
}