package cms5.frontend;

public enum View {
    /**
     * Enumeration of the different views being loaded by different fxml files to make it easier to grab and load when
     * the appropriate methods are called.
     */
    MAIN("order-view.fxml"),
    PAY("pay-view.fxml");

    private String fileName;

    View(String fileName){ this.fileName = fileName;}

    public String getFileName(){return fileName;}
}


