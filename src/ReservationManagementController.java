import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
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

public class ReservationManagementController {

    private Stage oldStage = null;

    private ReservationAdmin mouseSelectReservation = null;

    ResultSet reservationRS = null;

    ObservableList<ReservationAdmin> reservationObservableList = FXCollections.observableArrayList();

    @FXML
    private Button approveButton;

    @FXML
    private Button revokeButton;

    @FXML
    private Button resumeButton;

    @FXML
    private Button reserveButton;

    @FXML
    private TableView<ReservationAdmin> reservationTable;

    @FXML
    private TableColumn<ReservationAdmin, Integer> gymNumTableColumn;

    @FXML
    private TableColumn<ReservationAdmin, Date> reservationDateTableColumn;

    @FXML
    private TableColumn<ReservationAdmin, String> reservationTimeTableColumn;

    @FXML
    private TableColumn<ReservationAdmin, String> reservationMemberNameTableColumn;

    @FXML
    private TableColumn<ReservationAdmin, String> statusTableColumn;

    @FXML
    private ComboBox<String> gymNumComboBox;

    @FXML
    private ComboBox<String> reservationDateComboBox;

    @FXML
    private ComboBox<String> startTimeComboBox;

    @FXML
    private ComboBox<String> endTimeComboBox;

    @FXML
    void reservationTableClick(MouseEvent event) {
        if (reservationTable.getSelectionModel().getSelectedIndex() > -1) {
            mouseSelectReservation = reservationObservableList.get(reservationTable.getSelectionModel().getSelectedIndex());
            approveButton.setDisable(false);
            revokeButton.setDisable(false);
            resumeButton.setDisable(false);
            reserveButton.setDisable(false);
        }
    }

    @FXML
    void approveClick(ActionEvent event) {
        if (Objects.equals(mouseSelectReservation.getStatus(), "待审核")) {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = Main.connection.prepareStatement("UPDATE reservation SET status = 'reserved' WHERE member = ?");
                preparedStatement.setString(1, mouseSelectReservation.getMemberName());
                preparedStatement.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

        updateReservationTable();
    }

    @FXML
    void resumeClick(ActionEvent event) {
        if (Objects.equals(mouseSelectReservation.getStatus(), "已禁用")) {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = Main.connection.prepareStatement("UPDATE reservation SET status = 'available' WHERE member = ?");
                preparedStatement.setString(1, mouseSelectReservation.getMemberName());
                preparedStatement.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

        updateReservationTable();
    }

    @FXML
    void revokeClick(ActionEvent event) {
        if (Objects.equals(mouseSelectReservation.getStatus(), "可预约")) {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = Main.connection.prepareStatement("UPDATE reservation SET status = 'disabled' WHERE member = ?");
                preparedStatement.setString(1, mouseSelectReservation.getMemberName());
                preparedStatement.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

        updateReservationTable();
    }

    @FXML
    void reserveClick(ActionEvent event) {
        if (Objects.equals(mouseSelectReservation.getStatus(), "可预约")) {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = Main.connection.prepareStatement("UPDATE reservation SET status = 'reserved', member = ? WHERE gym_number = ? AND date = ? AND time = ?");
                preparedStatement.setString(1, Main.currentMemberName);
                preparedStatement.setInt(2, mouseSelectReservation.getGymNum());
                preparedStatement.setDate(3, new java.sql.Date(mouseSelectReservation.getDate().getTime()));
                preparedStatement.setTime(4, (new java.sql.Time(Integer.parseInt(mouseSelectReservation.getTime().substring(0, 2)) + 1, -30, 0)));
//                Calendar calendar = Calendar.getInstance();
//                calendar.setTime((new java.sql.Time(Integer.parseInt(mouseSelectReservation.getTime().substring(0, 2)) + 1, -30, 0)));
//                preparedStatement.setTime(4, (java.sql.Time)(new java.sql.Time(Integer.parseInt(mouseSelectReservation.getTime().substring(0, 2)) + 1, -30, 0)), calendar);
                preparedStatement.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

        updateReservationTable();
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

    @FXML
    void gymNumClick(ActionEvent event) {
        updateReservationTable();
    }

    @FXML
    void reservationDateClick(ActionEvent event) {
        updateReservationTable();
    }

    @FXML
    void startTimeClick(ActionEvent event) {
        updateReservationTable();
    }

    @FXML
    void endTimeClick(ActionEvent event) {
        updateReservationTable();
    }

    public void setOldStage(Stage stage) {
        oldStage = stage;
    }

    private void updateReservationTable() {
        reservationObservableList.clear();

        int gymNumSelected = gymNumComboBox.getSelectionModel().getSelectedIndex();
        int reservationDateSelected = reservationDateComboBox.getSelectionModel().getSelectedIndex();
        int startTimeSelected = startTimeComboBox.getSelectionModel().getSelectedIndex();
        int endTimeSelected = endTimeComboBox.getSelectionModel().getSelectedIndex();

        try {
            reservationRS = Main.statement.executeQuery("SELECT * FROM reservation");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        try {
            if (reservationRS != null) {
                reservationRS.beforeFirst();
            }
            while (reservationRS.next()) {

                ReservationAdmin currentReservation = new ReservationAdmin(reservationRS.getInt("gym_number"), reservationRS.getDate("date"), reservationRS.getTime("time"), reservationRS.getString("status"), reservationRS.getString("member"));

                boolean gymNumFlag = false, dateFlag = false, timeFlag = false;

                if (gymNumSelected == -1 || gymNumSelected == 0 || gymNumSelected == currentReservation.getGymNum()) {
                    gymNumFlag = true;
                }
                if (reservationDateSelected == -1 || reservationDateSelected == 0) {
                    dateFlag = true;
                } else {
                    Date date = new Date((new Date()).getTime() + (long) (reservationDateSelected - 1) * 24 * 60 * 60 * 1000);
                    if (currentReservation.getDate().getMonth() == date.getMonth() && currentReservation.getDate().getDate() == date.getDate()) {
                        dateFlag = true;
                    }
                }
                if (startTimeSelected == -1 && endTimeSelected == -1) {
                    timeFlag = true;
                }
                else if (startTimeSelected == -1 && currentReservation.getDate().getHours() <= 10 + endTimeSelected) {
                    timeFlag = true;
                }
                else if (9 + startTimeSelected <= currentReservation.getDate().getHours() && endTimeSelected == -1) {
                    timeFlag = true;
                }
                else if (9 + startTimeSelected <= currentReservation.getDate().getHours() && currentReservation.getDate().getHours() <= 10 + endTimeSelected) {
                    timeFlag = true;
                }
                if (gymNumFlag && dateFlag && timeFlag) {
                    reservationObservableList.add(currentReservation);
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        reservationTable.setItems(reservationObservableList);
        gymNumTableColumn.setCellValueFactory(new PropertyValueFactory<ReservationAdmin, Integer>("gymNum"));
        reservationDateTableColumn.setCellValueFactory(new PropertyValueFactory<ReservationAdmin, Date>("date"));
        reservationTimeTableColumn.setCellValueFactory(new PropertyValueFactory<ReservationAdmin, String>("time"));
        reservationMemberNameTableColumn.setCellValueFactory(new PropertyValueFactory<ReservationAdmin, String>("memberName"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<ReservationAdmin, String>("status"));
    }

    @FXML
    void initialize() {
        assert approveButton != null : "fx:id=\"approveButton\" was not injected: check your FXML file 'ReservationManagementUI.fxml'.";
        assert revokeButton != null : "fx:id=\"revokeButton\" was not injected: check your FXML file 'ReservationManagementUI.fxml'.";
        assert resumeButton != null : "fx:id=\"resumeButton\" was not injected: check your FXML file 'ReservationManagementUI.fxml'.";
        assert reserveButton != null : "fx:id=\"reserveButton\" was not injected: check your FXML file 'ReservationManagementUI.fxml'.";
        assert reservationTable != null : "fx:id=\"myReservationTable\" was not injected: check your FXML file 'ReservationManagementUI.fxml'.";
        assert gymNumTableColumn != null : "fx:id=\"gymNumTableColumn\" was not injected: check your FXML file 'ReservationManagementUI.fxml'.";
        assert reservationDateTableColumn != null : "fx:id=\"reservationDateTableColumn\" was not injected: check your FXML file 'ReservationManagementUI.fxml'.";
        assert reservationTimeTableColumn != null : "fx:id=\"reservationTimeTableColumn\" was not injected: check your FXML file 'ReservationManagementUI.fxml'.";
        assert reservationMemberNameTableColumn != null : "fx:id=\"reservationUsernameTableColumn\" was not injected: check your FXML file 'ReservationManagementUI.fxml'.";
        assert statusTableColumn != null : "fx:id=\"statusTableColumn\" was not injected: check your FXML file 'ReservationManagementUI.fxml'.";
        assert gymNumComboBox != null : "fx:id=\"gymNumComboBox\" was not injected: check your FXML file 'ReservationManagementUI.fxml'.";
        assert reservationDateComboBox != null : "fx:id=\"reservationDateComboBox\" was not injected: check your FXML file 'ReservationManagementUI.fxml'.";
        assert startTimeComboBox != null : "fx:id=\"startTimeComboBox\" was not injected: check your FXML file 'ReservationManagementUI.fxml'.";
        assert endTimeComboBox != null : "fx:id=\"endTimeComboBox\" was not injected: check your FXML file 'ReservationManagementUI.fxml'.";

        //add items to combo boxes
        gymNumComboBox.getItems().addAll("全部");
        for (int i = 1; i <= 8; i++) {
            gymNumComboBox.getItems().add(Integer.toString(i));
        }
        reservationDateComboBox.getItems().addAll("全部");
        Calendar c = Calendar.getInstance();
        for (int i = 0; i < 7; i++) {
            reservationDateComboBox.getItems().add(c.get(Calendar.MONTH) + 1 + "月" + c.get(Calendar.DAY_OF_MONTH) + "日");
            c.add(Calendar.DAY_OF_YEAR, 1);
        }
        for (int i = 9; i <= 21; i++) {
            startTimeComboBox.getItems().add(String.format("%02d:00", i));
        }
        for (int i = 10; i <= 22; i++) {
            endTimeComboBox.getItems().add(String.format("%02d:00", i));
        }

        //TODO
        //write a function which checks if in the database there is Reservations in the next 7 days, and then add them if not
        try {
            reservationRS = Main.statement.executeQuery("SELECT * FROM reservation");
            for (int i = 0; i < 7; i++) {
                Date date = new Date((new Date()).getTime() + (long) i * 24 * 60 * 60 * 1000);
                reservationRS.beforeFirst();
                boolean found = false;
                while (reservationRS.next()) {
                    if (reservationRS.getDate("date").getMonth() == date.getMonth() && reservationRS.getDate("date").getDate() == date.getDate()) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    for (int j = 1; j <= 8; j++) {
                        for (int k = 9; k <= 21; k++) {
                            reservationRS.moveToInsertRow();
                            reservationRS.updateInt(1, j);
                            reservationRS.updateDate(2, new java.sql.Date(date.getTime()));
                            reservationRS.updateTime(3, new java.sql.Time(k + 1, -30, 0));
                            reservationRS.updateString(4, "available");
                            reservationRS.updateString(5, "");
                            reservationRS.insertRow();
                            reservationRS.moveToCurrentRow();
                        }
                    }
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        updateReservationTable();
    }
}
