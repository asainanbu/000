import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class UserNotificationController {

    private Stage oldStage = null;

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

        oldStage.hide();


    }
    public void setOldStage(Stage stage) {
        oldStage = stage;
    }
    @FXML
    void initialize() {
        assert returnButton != null : "fx:id=\"returnButton\" was not injected: check your FXML file 'UserNotificationUI.fxml'.";
        assert notificationTable != null : "fx:id=\"notificationTable\" was not injected: check your FXML file 'UserNotificationUI.fxml'.";

    }
}
