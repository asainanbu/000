import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

public class UserGymReservationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button returnButton;

    @FXML
    private Button reserveButton;

    @FXML
    private TableView<?> reservationTable;

    @FXML
    private ComboBox<?> gymNumComboBox;

    @FXML
    private ComboBox<?> reservationDateComboBox;

    @FXML
    void gymNumSelect(ActionEvent event) {

    }

    @FXML
    void reservationDateSelect(ActionEvent event) {

    }

    @FXML
    void reserveClick(ActionEvent event) {

    }

    @FXML
    void returnClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert returnButton != null : "fx:id=\"returnButton\" was not injected: check your FXML file 'UserGymReservationUI.fxml'.";
        assert reserveButton != null : "fx:id=\"reserveButton\" was not injected: check your FXML file 'UserGymReservationUI.fxml'.";
        assert reservationTable != null : "fx:id=\"reservationTable\" was not injected: check your FXML file 'UserGymReservationUI.fxml'.";
        assert gymNumComboBox != null : "fx:id=\"gymNumComboBox\" was not injected: check your FXML file 'UserGymReservationUI.fxml'.";
        assert reservationDateComboBox != null : "fx:id=\"reservationDateComboBox\" was not injected: check your FXML file 'UserGymReservationUI.fxml'.";

    }
}
