import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MemberOverviewController {

    private Stage oldStage = null;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button returnButton;

    @FXML
    private Button approveButton;

    @FXML
    private Button disableButton;

    @FXML
    private Button enableButton;

    @FXML
    private Button resetButton;

    @FXML
    private TableView<?> memberTable;

    @FXML
    void approveClick(ActionEvent event) {

    }

    @FXML
    void disableClick(ActionEvent event) {

    }

    @FXML
    void enableClick(ActionEvent event) {

    }

    @FXML
    void resetClick(ActionEvent event) {

    }

    @FXML
    void returnClick(ActionEvent event) {
        Stage stage = new Stage();
        Scene scene = new Scene(new AdminHomepage(stage), AdminHomepage.WIDTH, AdminHomepage.HEIGHT);
        stage.setScene(scene);
        stage.setTitle("管理员主页");
        stage.show();

        // 关闭舞台时，会弹出模态对话框确认是否退出
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
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
            }
        });
        // 隐藏之前的窗体
        oldStage.hide();
    }

    public void setOldStage(Stage stage) {
        oldStage = stage;
    }

    @FXML
    void initialize() {
        assert returnButton != null : "fx:id=\"returnButton\" was not injected: check your FXML file 'MemberOverviewUI.fxml'.";
        assert approveButton != null : "fx:id=\"approveButton\" was not injected: check your FXML file 'MemberOverviewUI.fxml'.";
        assert disableButton != null : "fx:id=\"disableButton\" was not injected: check your FXML file 'MemberOverviewUI.fxml'.";
        assert enableButton != null : "fx:id=\"enableButton\" was not injected: check your FXML file 'MemberOverviewUI.fxml'.";
        assert resetButton != null : "fx:id=\"resetButton\" was not injected: check your FXML file 'MemberOverviewUI.fxml'.";
        assert memberTable != null : "fx:id=\"memberTable\" was not injected: check your FXML file 'MemberOverviewUI.fxml'.";

    }
}
