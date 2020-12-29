import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Currency;
import java.util.Objects;
import java.util.Optional;

public class LogInController {

    private Stage oldStage = null;

    @FXML
    private Button SignUpButton;

    @FXML
    private Button logInButton;

    @FXML
    private Button clearButton;

    @FXML
    private TextField usernameTf;

    @FXML
    private PasswordField passwordField;

    @FXML
    void clearClick(ActionEvent event) {
        usernameTf.setText("");
        passwordField.setText("");
    }

    @FXML
    void logInClick(ActionEvent event) {
        ResultSet memberRS = null;

        try {
            memberRS = Main.statement.executeQuery("SELECT * FROM member");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            if (memberRS != null) {
                memberRS.beforeFirst();  //Moves the cursor to the front of this ResultSet object, just before the first row.
            }
            boolean foundMember = false, correctPassword = false;
            while(memberRS.next()) {
                if (Objects.equals(usernameTf.getText(), memberRS.getString("member_name"))) {
                    foundMember = true;
                    if (Objects.equals(Cryptography.encrypt(passwordField.getText()), memberRS.getString("password"))) {
                        correctPassword = true;
                        Main.currentMemberName = memberRS.getString("member_name");
                        break;
                    }
                    else {
                        //  show alert when password is not correct
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("密码错误");
                        alert.setHeaderText("密码错误，请重试！");
                        alert.showAndWait();
                    }
                }
            }
            if (!foundMember) {
                //  show alert when no such member is found
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("查无此人");
                alert.setHeaderText("用户不存在，请重试！");
                alert.showAndWait();
            }
            else if (correctPassword) {
                if (Objects.equals(memberRS.getString("identity"), "user")) {
                    Main.currentMemberName = usernameTf.getText();

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
                else if (Objects.equals(memberRS.getString("identity"), "admin")) {
                    Main.currentMemberName = usernameTf.getText();

                    Stage stage = new Stage();
                    Scene scene = new Scene(new AdminHomepage(stage));
                    stage.setScene(scene);
                    stage.setTitle("管理员主页");
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
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    void signUpClick(ActionEvent event) {

        // 创建新的窗体
        Stage stage = new Stage();
        Scene scene = new Scene(new SignUp(stage));
        stage.setScene(scene);
        stage.setTitle("注册");
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

}
