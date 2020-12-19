import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;

public class UserController {

    @FXML
    private Tab reserveGymTab;

    @FXML
    private Tab myReservationTab;

    @FXML
    void myReservationSelect(ActionEvent event) {
        System.out.println("selected myReservationTab");
    }

    @FXML
    void reserveGymSelect(ActionEvent event) {
        System.out.println("selected reserveGymTab");
    }

}
