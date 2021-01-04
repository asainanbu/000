
import java.sql.*;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class AdminNotificationController {

    private Stage oldStage = null;

    @FXML
    private Button returnButton;

    @FXML
    private Button releaseButton;

    @FXML
    private TextField notificationTf;

    @FXML
    private TableView<NotificationAdmin> notificationTable;

    @FXML
    private TableColumn<NotificationAdmin, String> releaseDateTableColumn;

    @FXML
    private TableColumn<NotificationAdmin, String> contentTableColumn;

    @FXML
    void releaseClick(ActionEvent event) {
        if (Objects.equals(notificationTf.getText(), "")) {
            // show alert when notification content is empty
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText("通知内容不能为空，请重新输入！");
            alert.showAndWait();
        }
        else {
            ResultSet notificationRS = null;

            try {
                notificationRS = Main.statement.executeQuery("SELECT * FROM notification");
                notificationRS.moveToInsertRow();
                notificationRS.updateDate(2, new java.sql.Date(new java.util.Date().getTime()));
                notificationRS.updateString(3, notificationTf.getText());
                notificationRS.insertRow();
                notificationRS.moveToCurrentRow();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
            updateNotificationTable();
            notificationTf.setText("");
        }
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

    private void updateNotificationTable() {
        ResultSet notificationRS = null;

        try {
            notificationRS = Main.statement.executeQuery("SELECT * FROM notification");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        ObservableList<NotificationAdmin> notificationObservableList = FXCollections.observableArrayList();
        try {
            if (notificationRS != null) {
                notificationRS.beforeFirst();
            }
            while (notificationRS.next()) {
                notificationObservableList.add(new NotificationAdmin(notificationRS.getDate("release_date"), notificationRS.getString("content")));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        notificationTable.setItems(notificationObservableList);
        releaseDateTableColumn.setCellValueFactory(new PropertyValueFactory<NotificationAdmin, String>("date"));
        contentTableColumn.setCellValueFactory(new PropertyValueFactory<NotificationAdmin, String>("content"));
    }

    @FXML
    void initialize() {
        assert returnButton != null : "fx:id=\"returnButton\" was not injected: check your FXML file 'AdminNotificationUI.fxml'.";
        assert releaseButton != null : "fx:id=\"releaseButton\" was not injected: check your FXML file 'AdminNotificationUI.fxml'.";
        assert notificationTf != null : "fx:id=\"notificationTf\" was not injected: check your FXML file 'AdminNotificationUI.fxml'.";
        assert notificationTable != null : "fx:id=\"notificationTable\" was not injected: check your FXML file 'AdminNotificationUI.fxml'.";
        assert releaseDateTableColumn != null : "fx:id=\"releaseDateTableColumn\" was not injected: check your FXML file 'AdminNotificationUI.fxml'.";
        assert contentTableColumn != null : "fx:id=\"contentTableView\" was not injected: check your FXML file 'AdminNotificationUI.fxml'.";

        updateNotificationTable();
    }

}
