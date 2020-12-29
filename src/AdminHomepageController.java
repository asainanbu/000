import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AdminHomepageController {

    private Stage oldStage = null;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button notificationButton;

    @FXML
    private Button reservationManagementButton;

    @FXML
    private Button memberOverviewButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Label adminNameLabel;

    @FXML
    void logOutClick(ActionEvent event) {

    }

    @FXML
    void memberOverviewClick(ActionEvent event) {

    }

    @FXML
    void notificationClick(ActionEvent event) {

    }

    @FXML
    void reservationManagementClick(ActionEvent event) {

    }

    public void setOldStage(Stage stage) {
        oldStage = stage;
    }

    @FXML
    void initialize() {
        assert notificationButton != null : "fx:id=\"notificationButton\" was not injected: check your FXML file 'AdminHomepageUI.fxml'.";
        assert reservationManagementButton != null : "fx:id=\"reservationManagementButton\" was not injected: check your FXML file 'AdminHomepageUI.fxml'.";
        assert memberOverviewButton != null : "fx:id=\"memberOverviewButton\" was not injected: check your FXML file 'AdminHomepageUI.fxml'.";
        assert logOutButton != null : "fx:id=\"logOutButton\" was not injected: check your FXML file 'AdminHomepageUI.fxml'.";
        assert adminNameLabel != null : "fx:id=\"adminNameLabel\" was not injected: check your FXML file 'AdminHomepageUI.fxml'.";

    }
}
