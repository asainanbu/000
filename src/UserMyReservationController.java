import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class UserMyReservationController {
    private Stage oldStage = null;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button returnButton;

    @FXML
    private Button revokeButton;

    @FXML
    private TableView<?> myReservationTable;

    @FXML
    void returnClick(ActionEvent event) {
        oldStage.hide();
    }

    @FXML
    void revokeClick(ActionEvent event) {

    }
    public void setOldStage(Stage stage) {
        oldStage = stage;
    }
    @FXML
    void initialize() {
        assert returnButton != null : "fx:id=\"returnButton\" was not injected: check your FXML file 'UserMyReservationUI.fxml'.";
        assert revokeButton != null : "fx:id=\"revokeButton\" was not injected: check your FXML file 'UserMyReservationUI.fxml'.";
        assert myReservationTable != null : "fx:id=\"myReservationTable\" was not injected: check your FXML file 'UserMyReservationUI.fxml'.";

    }
}
