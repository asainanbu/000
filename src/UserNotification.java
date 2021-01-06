import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserNotification extends BorderPane {

    public static final double WIDTH = 600, HEIGHT = 400;

    public UserNotification(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserNotificationUI.fxml"));
            this.getChildren().add(fxmlLoader.load());

            // 获得控制器对象,并把数据传给控制器对象
            ((UserNotificationController) fxmlLoader.getController()).setOldStage(stage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
