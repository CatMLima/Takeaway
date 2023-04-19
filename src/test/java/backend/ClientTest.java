package backend;

import javafx.beans.property.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    private StringProperty username;

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    private StringProperty address;

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    private StringProperty status;
    public void ClientTest(){
        username = new SimpleStringProperty();
        address = new SimpleStringProperty();
        status = new SimpleStringProperty();
    }

    @BeforeEach
    public void setUp(){
        ClientTest();
    }

    @Test
    public void testSetNameIsReturned (){
        setUsername("Jacob");
        String name = getUsername();
        assertEquals("Jacob", name);
    }

    @Test
    public void testSetAddressIsReturned(){
        setAddress("Home");
        String addr = getAddress();
        assertEquals("Home", addr);
    }

    @Test
    public void testSetStatusIsReturned(){
        setStatus("Active");
        String stat = getStatus();
        assertEquals("Active", stat);
    }

    @Test
    public void emptyNameReturnsNullPointerException(){
        setUsername(null);
        String name = getUsername();
        assertNotEquals("Jessica", name);
    }
}
