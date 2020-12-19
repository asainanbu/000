import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class UserNotificationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button returnButton;

    @FXML
    private TableView<?> notificationTable;

    @FXML
    void returnClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert returnButton != null : "fx:id=\"returnButton\" was not injected: check your FXML file 'UserNotificationUI.fxml'.";
        assert notificationTable != null : "fx:id=\"notificationTable\" was not injected: check your FXML file 'UserNotificationUI.fxml'.";

    }
}
