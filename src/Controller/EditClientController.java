package Controller;

import Model.Client;
import Model.Inventory;
import Model.Proposal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class EditClientController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private TextField clientaddressid;

    @FXML
    private TextField clientemailid;

    @FXML
    private TextField clientnameid;

    @FXML
    private TextField clientphoneid;

    @FXML
    private TableView<Proposal> clientproposalstableview;

    @FXML
    private TableColumn<Proposal, Date> datecol;

    @FXML
    private TableColumn<Client, Double> durationcol;

    @FXML
    private TableColumn<Client, String> projecttypecol;

    @FXML
    private TableColumn<Client, Double> sizecol;

    @FXML
    private TableColumn<Client, Double> totalcol;

    @FXML
    void onActionHome(ActionEvent event) throws IOException {

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/main_screen.fxml"));
        scene = loader.load();
        Scene root = new Scene(scene);
        stage.setScene(root);
        stage.show();
    }

    public void setClientInfo(Client client) {
        clientaddressid.setText(client.getAddress());
        clientnameid.setText(client.getName());
        clientemailid.setText(client.getEmailAddress());
        clientphoneid.setText(client.getPhoneNumber());

    }

    /** This function saves the data from the text boxes. The function will check to see if there is any match for a client based
     * on the input values. If there is no match, a new client will be created (basically as a clone of the old). The
     * old client will still remain in the database until manually removed.
     */

    @FXML
    void onActionSave(ActionEvent event) throws IOException {

        String address = clientaddressid.getText();
        String name = clientnameid.getText();
        String email = clientemailid.getText();
        String phone = clientphoneid.getText();


        Client client = Inventory.findClientByAddress(address);

        if(client == null) {
            client = Inventory.findClientByName(name);
        }

        if(client == null) {
            client = Inventory.findClientByEmail(email);
        }

        if(client == null) {
            client = Inventory.findClientByPhone(name);
        }

        if(client != null) {
            client.setAddress(address);
            client.setName(name);
            client.setEmailAddress(email);
            client.setPhoneNumber(phone);
        }
        else {
            client = new Client(name, address, phone, email);
            Inventory.addClient(client);
        }



        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/view_client.fxml"));
        scene = loader.load();
        Scene root = new Scene(scene);
        stage.setScene(root);
        stage.show();

        ViewClientController controller = loader.getController();
        controller.setClientInfoLabels(client);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        clientproposalstableview.setItems(Client.getAllProposals());
        datecol.setCellValueFactory(new PropertyValueFactory<>("proposalDate"));
        projecttypecol.setCellValueFactory(new PropertyValueFactory<>("projectType"));
        sizecol.setCellValueFactory(new PropertyValueFactory<>("sqft"));
        durationcol.setCellValueFactory(new PropertyValueFactory<>("fuelWeeks"));
        totalcol.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
    }

}
