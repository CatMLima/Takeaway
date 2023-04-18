package cms5.frontend;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class TakeawayApplication extends Application {
    /**
     * The start method was changed to resemble that of the example shown for the project
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        var scene = new Scene(new Pane());

        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.MAIN);
        stage.setScene(scene);
        stage.setTitle("TakeAwayApplication");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}