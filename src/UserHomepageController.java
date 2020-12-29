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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
    void logOutClick(ActionEvent event) {
        Stage stage = new Stage();
        Scene scene = new Scene(new LogIn(stage));
        stage.setScene(scene);
        stage.setTitle("登录");
        stage.show();

        // 关闭舞台时，会弹出模态对话框确认是否退出
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
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
                    event.consume();
                }
            }
        });
        // 隐藏之前的窗体
        oldStage.hide();
    }

    @FXML
    void myReservationClick(ActionEvent event) {
        Stage stage = new Stage();
        Scene scene = new Scene(new UserMyReservation(stage));
        stage.setScene(scene);
        stage.setTitle("我的预约");
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
    void notificationClick(ActionEvent event) {
        // 创建新的窗体
        Stage stage = new Stage();
        Scene scene = new Scene(new SignUp(stage));
        stage.setScene(scene);
        stage.setTitle("消息通知");
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

        //display current username
        currentUsernameLabel.setText(Main.currentMemberName);

    }
}
