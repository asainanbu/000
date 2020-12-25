import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Optional;

public class LogInController {

    private Stage oldStage = null;

    @FXML
    private Button SignUpButton;

    @FXML
    private Button logInButton;

    @FXML
    private Button clearButton;

    @FXML
    private TextField usernameTf;

    @FXML
    private PasswordField passwordField;

    @FXML
    void clearClick(ActionEvent event) {
        usernameTf.setText("");
        passwordField.setText("");
    }

    @FXML
    void logInClick(ActionEvent event) {

    }

    @FXML
    void signUpClick(ActionEvent event) {

        // 创建新的窗体
        Stage stage = new Stage();
        Scene scene = new Scene(new SignUp(stage));
        stage.setScene(scene);
        stage.setTitle("注册");
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

    public void setOldStage(Stage stage) {
        oldStage = stage;
    }

}
