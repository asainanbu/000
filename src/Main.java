import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.util.Optional;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene = new Scene(new LogIn(primaryStage));
        primaryStage.setScene(scene);
        primaryStage.setTitle("登录");
        primaryStage.show();

        // 关闭舞台时，会弹出模态对话框确认是否退出
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
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
                    primaryStage.close();
                    // 否则
                } else {
                    event.consume();
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
