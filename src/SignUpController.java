import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Optional;

public class SignUpController {

    Stage oldStage = null;

    @FXML
    private TextField usernameTf;

    @FXML
    private Button affirmButton;

    @FXML
    private Button returnButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField passwordAgainField;

    @FXML
    private TextField trueNameTf;

    @FXML
    void affirmClick(ActionEvent event) {

    }

    @FXML
    void returnClick(ActionEvent event) {

        // 创建新的窗体
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

    public void setOldStage(Stage stage) {
        oldStage = stage;
    }

}
