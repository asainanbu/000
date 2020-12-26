import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserMyReservation extends GridPane {

    public UserMyReservation(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserMyReservationUI.fxml"));
            this.getChildren().add(fxmlLoader.load());

            // 获得控制器对象,并把数据传给控制器对象
            ((UserMyReservationController) fxmlLoader.getController()).setOldStage(stage);;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}