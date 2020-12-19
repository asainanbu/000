import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class ReservationManagementController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button returnButton;

    @FXML
    private Button approveButton;

    @FXML
    private Button pauseButton;

    @FXML
    private Button resumeButton;

    @FXML
    private Button reserveButton;

    @FXML
    private TableView<?> myReservationTable;

    @FXML
    void approveClick(ActionEvent event) {

    }

    @FXML
    void reserveClick(ActionEvent event) {

    }

    @FXML
    void resumeClick(ActionEvent event) {

    }

    @FXML
    void returnClick(ActionEvent event) {

    }

    @FXML
    void revokeClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert returnButton != null : "fx:id=\"returnButton\" was not injected: check your FXML file 'ReservationManagementUI.fxml'.";
        assert approveButton != null : "fx:id=\"approveButton\" was not injected: check your FXML file 'ReservationManagementUI.fxml'.";
        assert pauseButton != null : "fx:id=\"pauseButton\" was not injected: check your FXML file 'ReservationManagementUI.fxml'.";
        assert resumeButton != null : "fx:id=\"resumeButton\" was not injected: check your FXML file 'ReservationManagementUI.fxml'.";
        assert reserveButton != null : "fx:id=\"reserveButton\" was not injected: check your FXML file 'ReservationManagementUI.fxml'.";
        assert myReservationTable != null : "fx:id=\"myReservationTable\" was not injected: check your FXML file 'ReservationManagementUI.fxml'.";

    }
}
