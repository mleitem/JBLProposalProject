package Controller;

import Model.Client;
import Model.Inventory;
import Model.Pavers;
import Model.Proposal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Model.Client.addProposal;


public class NewPaverProposalController implements Initializable {

    @FXML
    private TextField addtllinearfeetid;

    @FXML
    private TextField securedlinearfeetid;

    @FXML
    private TextField sqftid;

    @FXML
    private TextField unsecuredlinearfeetid;

    @FXML
    private TextField projecttypeid;

    @FXML
    private CheckBox easyaccessid;

    @FXML
    private Label clientaddressid;


    Stage stage;
    Parent scene;
    Proposal proposal;

    public void setAddress(String address) {
        clientaddressid.setText(address);
    }

    @FXML
    void onActionNextPage(ActionEvent event) throws IOException {

        String projectType = projecttypeid.getText();
        double securedLinearFeet = Double.parseDouble(securedlinearfeetid.getText());
        double unsecuredLinearFeet = Double.parseDouble(unsecuredlinearfeetid.getText());
        double sqft = Double.parseDouble(sqftid.getText());
        double additionalCuttingFeet = Double.parseDouble(addtllinearfeetid.getText());
        boolean easyAccess;
        String address = clientaddressid.getText();

        if(easyaccessid.isSelected()) {
            easyAccess = true;
        }
        else easyAccess = false;


        Proposal proposal = (new Pavers(projectType, sqft, securedLinearFeet, unsecuredLinearFeet, additionalCuttingFeet, easyAccess));
        addProposal(proposal);

        System.out.println("proposal added!");


        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/paver_info.fxml"));
        scene = loader.load();
        Scene root = new Scene(scene);
        stage.setScene(root);
        stage.show();


        PaverInfoController controller = loader.getController();
        controller.setPaverInfoLabels(proposal);
        controller.setAddress(address);





    }

    @FXML
    void onActionCancel(ActionEvent event) throws IOException {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
