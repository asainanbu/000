import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class UserGymReservationController {

    private Stage oldStage = null;

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
        Stage stage = new Stage();
        Scene scene = new Scene(new UserHomepage(stage), UserHomepage.WIDTH, UserHomepage.HEIGHT);
        stage.setScene(scene);
        stage.setTitle("用户主页");
        stage.show();
        // 关闭舞台时，会弹出模态对话框确认是否退出
        stage.setOnCloseRequest(event1 -> {
            // 对话框 Alert Alert.AlertType.CONFIRMATION
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            // 设置对话框标题
            alert.setTitle("退出");
            // 设置内容
            alert.setHeaderText("确定要退出吗？");
            // 显示对话框
            Optional<ButtonType> result = alert.showAndWait();
            // 如果点击OK
            if (result.get() == ButtonType.OK) {
                // 关闭窗体
                stage.close();
                // 否则
            } else {
                event1.consume();
            }
        });
        // 隐藏之前的窗体
        oldStage.hide();
    }

    @FXML
    void initialize() {
        assert returnButton != null : "fx:id=\"returnButton\" was not injected: check your FXML file 'UserGymReservationUI.fxml'.";
        assert reserveButton != null : "fx:id=\"reserveButton\" was not injected: check your FXML file 'UserGymReservationUI.fxml'.";
        assert reservationTable != null : "fx:id=\"reservationTable\" was not injected: check your FXML file 'UserGymReservationUI.fxml'.";
        assert gymNumComboBox != null : "fx:id=\"gymNumComboBox\" was not injected: check your FXML file 'UserGymReservationUI.fxml'.";
        assert reservationDateComboBox != null : "fx:id=\"reservationDateComboBox\" was not injected: check your FXML file 'UserGymReservationUI.fxml'.";

    }
    public void setOldStage(Stage stage) {
        oldStage = stage;
    }
}
