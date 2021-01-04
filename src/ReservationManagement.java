import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ReservationManagement extends BorderPane {

    public static final double WIDTH = 590, HEIGHT = 450;

    public ReservationManagement(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReservationManagementUI.fxml"));
            this.getChildren().add(fxmlLoader.load());

            // 获得控制器对象,并把数据传给控制器对象
            ((ReservationManagementController)fxmlLoader.getController()).setOldStage(stage);;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
