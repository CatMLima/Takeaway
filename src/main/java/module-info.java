module cms5.takeaway {
    requires javafx.controls;
    requires javafx.fxml;


    opens cms5.frontend to javafx.fxml;
    exports cms5.frontend;
}