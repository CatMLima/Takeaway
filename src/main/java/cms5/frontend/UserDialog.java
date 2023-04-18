package cms5.frontend;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import backend.*;

import java.io.*;

public class UserDialog extends Dialog<Client> {
    @FXML
    ButtonType fxSignIn;
    @FXML
    TextField fxPassword;
    @FXML
    Label fxOldUser;
    /**
     * The dialog has a button log in which only works if a password is set in. If that happens then the user can order.
     *
     * @param name    the name of the client which is being passed to be able to have their name as the main name
     */
    public UserDialog(String name){
        setDialogPane(readClientDialog());
        fxOldUser.setText(name);
        buttonRule();
        setResultConverter(b -> {
            if (b.getButtonData() == ButtonBar.ButtonData.OK_DONE){
                ViewSwitcher.switchTo(View.MAIN);
                Client client = new Client();
                client.setStatus("Logged In");
                return client;
            } else{
                return null;
            }
        });
    }
    /**
     * Load in the fxml file for the DialogPane
     * @return loaded fxml
     */
    private DialogPane readClientDialog(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("oldClient-view.fxml"));
        try{
            fxmlLoader.setController(this);
            return fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    /**
     * If the customer does not write in a password, they cannot proceed, only cancel.
     */
    private void buttonRule(){
        Node OK = getDialogPane().lookupButton(fxSignIn);
        OK.disableProperty().bind(fxPassword.textProperty().isEmpty());
    }
}
