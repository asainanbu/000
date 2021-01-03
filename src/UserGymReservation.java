import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserGymReservation extends BorderPane {

    public static final double WIDTH = 446, HEIGHT = 403;


    public UserGymReservation(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserGymReservationUI.fxml"));
            this.getChildren().add(fxmlLoader.load());

            // 获得控制器对象,并把数据传给控制器对象
            ((UserGymReservationController) fxmlLoader.getController()).setOldStage(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

