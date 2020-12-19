import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LogIn extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LogInUI.fxml"));
<<<<<<< Updated upstream
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
=======
        primaryStage.setTitle("登录");
        primaryStage.setScene(new Scene(root));
>>>>>>> Stashed changes
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
