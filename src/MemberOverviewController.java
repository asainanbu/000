import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MemberOverviewController {

    private Stage oldStage = null;

    private int mouseSelectRow = -1;

    ResultSet memberRS = null;

    ObservableList<Member> memberObservableList = FXCollections.observableArrayList();

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
    private TableView<Member> memberTable;

    @FXML
    private TableColumn<Member, String> usernameTableColumn;

    @FXML
    private TableColumn<Member, String> trueNameTableColumn;

    @FXML
    private TableColumn<Member, String> statusTableColumn;

    @FXML
    void approveClick(ActionEvent event) {
        updateMemberTable();
    }

    @FXML
    void disableClick(ActionEvent event) {
        updateMemberTable();
    }

    @FXML
    void enableClick(ActionEvent event) {
        updateMemberTable();
    }

    @FXML
    void memberTableClick(MouseEvent event) {

        mouseSelectRow = memberTable.getSelectionModel().getSelectedIndex();

    }

    @FXML
    void resetClick(ActionEvent event) {
        Stage stage = new Stage();
        Scene scene = new Scene(new ResetPassword(memberObservableList.get(mouseSelectRow).getUsername()), ResetPassword.WIDTH, ResetPassword.HEIGHT);
        stage.setScene(scene);
        stage.setTitle("重置密码");
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

        updateMemberTable();
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

    private void updateMemberTable() {
        memberObservableList.clear();

        try {
            memberRS = Main.statement.executeQuery("SELECT * FROM member");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        try {
            if (memberRS != null) {
                memberRS.beforeFirst();
            }
            while (memberRS.next()) {
                memberObservableList.add(new Member(memberRS.getString("member_name"), memberRS.getString("real_name"), memberRS.getString("status")));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        memberTable.setItems(memberObservableList);
        usernameTableColumn.setCellValueFactory(new PropertyValueFactory<Member, String>("username"));
        trueNameTableColumn.setCellValueFactory(new PropertyValueFactory<Member, String>("trueName"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<Member, String>("status"));
    }

    @FXML
    void initialize() {
        assert returnButton != null : "fx:id=\"returnButton\" was not injected: check your FXML file 'MemberOverviewUI.fxml'.";
        assert approveButton != null : "fx:id=\"approveButton\" was not injected: check your FXML file 'MemberOverviewUI.fxml'.";
        assert disableButton != null : "fx:id=\"disableButton\" was not injected: check your FXML file 'MemberOverviewUI.fxml'.";
        assert enableButton != null : "fx:id=\"enableButton\" was not injected: check your FXML file 'MemberOverviewUI.fxml'.";
        assert resetButton != null : "fx:id=\"resetButton\" was not injected: check your FXML file 'MemberOverviewUI.fxml'.";
        assert memberTable != null : "fx:id=\"memberTable\" was not injected: check your FXML file 'MemberOverviewUI.fxml'.";
        assert usernameTableColumn != null : "fx:id=\"usernameTableColumn\" was not injected: check your FXML file 'MemberOverviewUI.fxml'.";
        assert trueNameTableColumn != null : "fx:id=\"trueNameTableColumn\" was not injected: check your FXML file 'MemberOverviewUI.fxml'.";
        assert statusTableColumn != null : "fx:id=\"statusTableColumn\" was not injected: check your FXML file 'MemberOverviewUI.fxml'.";

        updateMemberTable();
    }
}
