import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.util.Optional;
import java.sql.*;

public class Main extends Application {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/hippo_reservation?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    static Connection connection = null;
    static Statement statement = null;

    @Override
    public void start(Stage stage) throws Exception{
        Scene scene = new Scene(new LogIn(stage));
        stage.setScene(scene);
        stage.setTitle("登录");
        stage.show();

        // 关闭舞台时，会弹出模态对话框确认是否退出
        stage.setOnCloseRequest(event -> {
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
        });
    }

    public static void main(String[] args) {
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,"root","");
            statement = connection.createStatement();
        }catch(SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        }
        launch(args);
    }
}
