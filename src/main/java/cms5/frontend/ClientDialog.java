package cms5.frontend;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import backend.*;

import java.io.*;

public class ClientDialog extends Dialog<Client> {
    @FXML
    private TextField fxClientName;
    @FXML
    private TextField fxClientAddress;
    @FXML
    private ButtonType fxOK;
    /**
     * The dialog appears when the log in button is clicked but no registered User exists
     */
    public ClientDialog(){
        setDialogPane(readClientDialog());
        buttonRule();
        setResultConverter(b -> {
            if (b.getButtonData() == ButtonBar.ButtonData.OK_DONE){
                Client client = new Client();
                client.setUsername(fxClientName.getText());
                client.setAddress(fxClientAddress.getText());
                client.setStatus("Registered");
                return client;
            } else{
                return null;
            }
        });
    }
    /**
     * Used to load in the fxml file of this DialogPane
     * @return fxml file loaded
     */
    private DialogPane readClientDialog(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newClient-view.fxml"));
        try{
            fxmlLoader.setController(this);
            return fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    /**
     * This rule makes sure that while the textfields waiting for the Name and Address are empty, the customer cannot proceed
     */
    private void buttonRule(){
        Node OK = getDialogPane().lookupButton(fxOK);
        OK.disableProperty().bind(fxClientName.textProperty().isEmpty().
                or(fxClientAddress.textProperty().isEmpty()));
    }
}
