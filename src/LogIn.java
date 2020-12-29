
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LogIn extends BorderPane {

    public LogIn(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LogInUI.fxml"));
            this.getChildren().add(fxmlLoader.load());

            // 获得控制器对象,并把数据传给控制器对象
            ((LogInController)fxmlLoader.getController()).setOldStage(stage);;

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
