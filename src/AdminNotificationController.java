import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminNotificationController {

    private Stage oldStage = null;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button returnButton;

    @FXML
    private Button releaseButton;

    @FXML
    private TextField notificationTf;

    @FXML
    private TableView<?> notificationTable;

    @FXML
    void releaseClick(ActionEvent event) {

    }

    @FXML
    void returnClick(ActionEvent event) {

    }

    public void setOldStage(Stage stage) {
        oldStage = stage;
    }

    @FXML
    void initialize() {
        assert returnButton != null : "fx:id=\"returnButton\" was not injected: check your FXML file 'AdminNotificationUI.fxml'.";
        assert releaseButton != null : "fx:id=\"releaseButton\" was not injected: check your FXML file 'AdminNotificationUI.fxml'.";
        assert notificationTf != null : "fx:id=\"notificationTf\" was not injected: check your FXML file 'AdminNotificationUI.fxml'.";
        assert notificationTable != null : "fx:id=\"notificationTable\" was not injected: check your FXML file 'AdminNotificationUI.fxml'.";

    }
}
