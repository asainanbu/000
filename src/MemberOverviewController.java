import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

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
