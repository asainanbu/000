import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

public class SignUpController {

    Stage oldStage = null;

    @FXML
    private TextField usernameTf;

    @FXML
    private Button affirmButton;

    @FXML
    private Button returnButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField passwordAgainField;

    @FXML
    private TextField trueNameTf;

    @FXML
    void affirmClick(ActionEvent event) {

        ResultSet memberRS = null;

        try {
            memberRS = Main.statement.executeQuery("SELECT * FROM member");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            memberRS.beforeFirst();//  Moves the cursor to the end of this ResultSet object, just after the last row.
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (usernameTf.getText().length() == 0 || passwordField.getText().length() == 0 || passwordField.getText().length() == 0 || trueNameTf.getText().length() == 0) {
            //  show alert when input is empty
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("格式错误");
            alert.setHeaderText("存在字段输入为空，请重试！");
            alert.showAndWait();
        }
        else if (usernameTf.getText().length() > 128 ||  trueNameTf.getText().length() > 128) {
            //  show alert when input is too long
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("格式错误");
            alert.setHeaderText("存在字段输入过长，请重试！");
            alert.showAndWait();
        }
        else if (!Objects.equals(passwordField.getText(), passwordAgainField.getText())) {
            //  show alert when password does not coincide
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("密码错误");
            alert.setHeaderText("两次输入的密码不同，请重试！");
            alert.showAndWait();
        }
        else {
            //  determine if the member already exists
            boolean foundMember = false;
            while (true) {
                try {
                    if (!memberRS.next()) break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    if (Objects.equals(usernameTf.getText(), memberRS.getString("member_name"))) {
                        foundMember = true;
                        //  show alert when member already exists
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("用户已存在");
                        alert.setHeaderText("此用户已存在，请勿重复注册！");
                        alert.showAndWait();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if (!foundMember) {
                try {
                    //  insert a new row into the database 'member'
                    memberRS.moveToInsertRow();
                    memberRS.updateString(1, usernameTf.getText());
                    memberRS.updateString(2, Cryptography.encrypt(passwordField.getText()));
                    memberRS.updateString(3, trueNameTf.getText());
                    memberRS.updateString(4, "user");
                    memberRS.updateString(5, "pending");
                    memberRS.insertRow();
                    memberRS.moveToCurrentRow();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                //  show alert when signing up is successful
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("注册成功");
                alert.setHeaderText("注册成功，请等待管理员审批！");
                alert.showAndWait();
            }
        }

    }

    @FXML
    void returnClick(ActionEvent event) {

        // 创建新的窗体
        Stage stage = new Stage();
        Scene scene = new Scene(new LogIn(stage));
        stage.setScene(scene);
        stage.setTitle("登录");
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
