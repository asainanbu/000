import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class UserHomepageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button notificationButton;

    @FXML
    private Button gymReservationButton;

    @FXML
    private Button myReservationButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Label currentUsernameLabel;

    @FXML
    void gymReservationClick(ActionEvent event) {

    }

    @FXML
    void logOutClick(ActionEvent event) {

    }

    @FXML
    void myReservationClick(ActionEvent event) {

    }

    @FXML
    void notificationClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert notificationButton != null : "fx:id=\"notificationButton\" was not injected: check your FXML file 'UserHomepageUI.fxml'.";
        assert gymReservationButton != null : "fx:id=\"gymReservationButton\" was not injected: check your FXML file 'UserHomepageUI.fxml'.";
        assert myReservationButton != null : "fx:id=\"myReservationButton\" was not injected: check your FXML file 'UserHomepageUI.fxml'.";
        assert logOutButton != null : "fx:id=\"logOutButton\" was not injected: check your FXML file 'UserHomepageUI.fxml'.";
        assert currentUsernameLabel != null : "fx:id=\"currentUsernameLabel\" was not injected: check your FXML file 'UserHomepageUI.fxml'.";

    }
}
