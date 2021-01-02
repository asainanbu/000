import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class UserNotificationController {


    private Stage oldStage = null;

    @FXML
    private TableColumn<Notification,String> launchDate;

    @FXML
    private TableColumn<Notification,String> contents;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button returnButton;

    @FXML
    private TableView<Notification> notificationTable;

    public UserNotificationController() {
    }


    @FXML
    void returnClick(ActionEvent event) {

        Stage stage = new Stage();
        Scene scene = new Scene(new UserHomepage(stage));
        stage.setScene(scene);
        stage.setTitle("用户主页");
        stage.show();
        // 关闭舞台时，会弹出模态对话框确认是否退出
        stage.setOnCloseRequest(event1 -> {
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
                event1.consume();
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
        assert returnButton != null : "fx:id=\"returnButton\" was not injected: check your FXML file 'UserNotificationUI.fxml'.";
        assert contents != null : "fx:id=\"Contents\" was not injected: check your FXML file 'UserNotificationUI.fxml'.";
        assert launchDate != null : "fx:id=\"LaunchDate\" was not injected: check your FXML file 'UserNotificationUI.fxml'.";
        assert notificationTable != null : "fx:id=\"notificationTable\" was not injected: check your FXML file 'UserNotificationUI.fxml'.";
        String date;
        String content;
        ResultSet notificationRS;
        try {
            notificationRS = Main.statement.executeQuery("SELECT * FROM notification");
            while(notificationRS.next()){
                date=notificationRS.getString("release_date");
                content=notificationRS.getString("content");
                ObservableList<Notification> obsList = FXCollections.observableArrayList();
                obsList.add(new Notification(date,content));
                notificationTable.setItems(obsList);
                launchDate.setCellValueFactory(new PropertyValueFactory<Notification, String>("date"));
                contents.setCellValueFactory(new PropertyValueFactory<Notification, String>("includings"));
            }
            notificationRS.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
