import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class ResetPasswordController {

	@FXML
	private PasswordField passwordTf;

	@FXML
	private PasswordField passwordAgainField;

	ResultSet memberRS = null;

	@FXML
	void confirmClick(ActionEvent event) {
		if (passwordTf.getText().length() == 0 || passwordAgainField.getText().length() == 0) {
			//  show alert when input is empty
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("格式错误");
			alert.setHeaderText("存在字段输入为空，请重试！");
			alert.showAndWait();
		}
		else if (!Objects.equals(passwordTf.getText(), passwordAgainField.getText())) {
			//  show alert when password does not coincide
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("密码错误");
			alert.setHeaderText("两次输入的密码不同，请重试！");
			alert.showAndWait();
		}
		else {
			try {
				memberRS = Main.statement.executeQuery("SELECT * FROM member");
				memberRS.beforeFirst();//  Moves the cursor to the end of this ResultSet object, just after the last row.
				while (memberRS.next()) {
					if (Objects.equals(memberRS.getString("member_name"), username)) {
						PreparedStatement preparedStatement = Main.connection.prepareStatement("UPDATE member SET password = ? WHERE member_name = ?");
						preparedStatement.setString(1, Cryptography.encrypt(passwordTf.getText()));
						preparedStatement.setString(2, username);
						preparedStatement.executeUpdate();

						//  show alert when password does not coincide
						Alert alert = new Alert(Alert.AlertType.INFORMATION);
						alert.setTitle("重置成功");
						alert.setHeaderText("密码重置成功！");
						alert.showAndWait();

						returnClick(new ActionEvent());
					}
				}
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
	}

	@FXML
	void returnClick(ActionEvent event) {
		((Stage)passwordTf.getScene().getWindow()).close();
	}

	private String username = null;

	public void setUsername(String username) {
		this.username = username;
	}

	@FXML
	void initialize() {
		assert passwordTf != null : "fx:id=\"passwordTf\" was not injected: check your FXML file 'ResetPasswordUI.fxml'.";
		assert passwordAgainField != null : "fx:id=\"passwordAgainField\" was not injected: check your FXML file 'ResetPasswordUI.fxml'.";
	}
}
