import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class UserHomepageController {
    private Stage oldStage = null;
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
        Stage stage = new Stage();
        Scene scene = new Scene(new UserGymReservation(stage));
        stage.setScene(scene);
        stage.setTitle("球馆预约");
        stage.show();
    }

    @FXML
    void logOutClick(ActionEvent event) {
        oldStage.hide();
    }

    @FXML
    void myReservationClick(ActionEvent event) {
        Stage stage = new Stage();
        Scene scene = new Scene(new UserMyReservation(stage));
        stage.setScene(scene);
        stage.setTitle("我的预约");
        stage.show();
    }

    @FXML
    void notificationClick(ActionEvent event) {
        Stage stage = new Stage();
        Scene scene = new Scene(new UserNotification(stage));
        stage.setScene(scene);
        stage.setTitle("消息通知");
        stage.show();
    }
    public void setOldStage(Stage stage) {
        oldStage = stage;
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
