import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUp extends GridPane {

    public SignUp() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignUpUI.fxml"));
            this.getChildren().add(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
