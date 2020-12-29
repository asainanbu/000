import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

//public class AdminHomepage extends Application {
//
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("AdminHomepageUI.fxml"));
//        primaryStage.setTitle("主页");
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}

public class AdminHomepage extends BorderPane {

    public AdminHomepage(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminHomepageUI.fxml"));
            this.getChildren().add(fxmlLoader.load());

            // 获得控制器对象,并把数据传给控制器对象
            ((AdminHomepageController)fxmlLoader.getController()).setOldStage(stage);;

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
