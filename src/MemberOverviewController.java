
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MemberOverviewController {

    private Stage oldStage = null;

    private MemberAdmin mouseSelectMember = null;

    ResultSet memberRS = null;

    ObservableList<MemberAdmin> memberObservableList = FXCollections.observableArrayList();

    @FXML
    private TableView<MemberAdmin> memberTable;

    @FXML
    private TableColumn<MemberAdmin, String> usernameTableColumn;

    @FXML
    private TableColumn<MemberAdmin, String> trueNameTableColumn;

    @FXML
    private TableColumn<MemberAdmin, String> statusTableColumn;

    @FXML
    void memberTableClick(MouseEvent event) {

        mouseSelectMember = memberObservableList.get(memberTable.getSelectionModel().getSelectedIndex());

    }

    @FXML
    void approveClick(ActionEvent event) {
        if (Objects.equals(mouseSelectMember.getStatus(), "待审核")) {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = Main.connection.prepareStatement("UPDATE member SET status = 'enabled' WHERE member_name = ?");
                preparedStatement.setString(1, mouseSelectMember.getUsername());
                preparedStatement.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

        updateMemberTable();
    }

    @FXML
    void disableClick(ActionEvent event) {
        if (Objects.equals(mouseSelectMember.getStatus(), "已启用")) {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = Main.connection.prepareStatement("UPDATE member SET status = 'disabled' WHERE member_name = ?");
                preparedStatement.setString(1, mouseSelectMember.getUsername());
                preparedStatement.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

        updateMemberTable();
    }

    @FXML
    void enableClick(ActionEvent event) {
        if (Objects.equals(mouseSelectMember.getStatus(), "已禁用")) {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = Main.connection.prepareStatement("UPDATE member SET status = 'enabled' WHERE member_name = ?");
                preparedStatement.setString(1, mouseSelectMember.getUsername());
                preparedStatement.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

        updateMemberTable();
    }

    @FXML
    void resetClick(ActionEvent event) {
        Stage stage = new Stage();
        Scene scene = new Scene(new ResetPassword(mouseSelectMember.getUsername()), ResetPassword.WIDTH, ResetPassword.HEIGHT);
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
                if (Objects.equals(memberRS.getString("identity"), "user")) {
                    memberObservableList.add(new MemberAdmin(memberRS.getString("member_name"), memberRS.getString("real_name"), memberRS.getString("status")));
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        memberTable.setItems(memberObservableList);
        usernameTableColumn.setCellValueFactory(new PropertyValueFactory<MemberAdmin, String>("username"));
        trueNameTableColumn.setCellValueFactory(new PropertyValueFactory<MemberAdmin, String>("trueName"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<MemberAdmin, String>("status"));
    }

    @FXML
    void initialize() {
        assert memberTable != null : "fx:id=\"memberTable\" was not injected: check your FXML file 'MemberOverviewUI.fxml'.";
        assert usernameTableColumn != null : "fx:id=\"usernameTableColumn\" was not injected: check your FXML file 'MemberOverviewUI.fxml'.";
        assert trueNameTableColumn != null : "fx:id=\"trueNameTableColumn\" was not injected: check your FXML file 'MemberOverviewUI.fxml'.";
        assert statusTableColumn != null : "fx:id=\"statusTableColumn\" was not injected: check your FXML file 'MemberOverviewUI.fxml'.";

        updateMemberTable();
    }
}
