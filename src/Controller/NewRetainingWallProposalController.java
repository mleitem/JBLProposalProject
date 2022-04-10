package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class NewRetainingWallProposalController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private Label clientaddressid;

    @FXML
    private CheckBox easyaccessid;

    @FXML
    private TextField linearfeetid;

    @FXML
    private TextField projecttypeid;

    @FXML
    private TextField securedlinearfeetid;


    @FXML
    void onActionNextPage(ActionEvent event) {

    }

    @FXML
    void onActionCancel(ActionEvent event) {

    }

    public void setAddress(String address) {

        clientaddressid.setText(address);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
