package backend;

import javafx.beans.property.*;

public class Client {

    /**
     * Creates the Client object which has name, address and status with getters and setters and properties used in other classes for binding.
     * @param name
     * @param address
     * @param status
     * By adding the status part of the Client Object, I was able to bind both the Login Button and PayForOrder Button to the
     * status of the client being first registered and then logged in to be able to pay.
     */

    // to store the name of the client
    private static StringProperty username = new SimpleStringProperty();
    // to store the password for the client's account (not enabled in this project)
    private static StringProperty address = new SimpleStringProperty();

    public static String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        Client.status.set(status);
    }

    private static StringProperty status = new SimpleStringProperty();

    public String getAddress() {
        return address.get();
    }

    public static StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        Client.address.set(address);
    }
    public String getUsername() {
        return username.get();
    }

    public static StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

}
