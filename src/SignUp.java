import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUp extends GridPane {

    public static final double WIDTH = 489, HEIGHT = 408;

    public SignUp(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignUpUI.fxml"));
            this.getChildren().add(fxmlLoader.load());

            // 获得控制器对象,并把数据传给控制器对象
            ((SignUpController)fxmlLoader.getController()).setOldStage(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
