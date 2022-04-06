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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ViewClientController implements Initializable {

    Stage stage;
    Parent scene;
    Client client;

    @FXML
    private Button viewbuttonid;

    @FXML
    private Button summarybuttonid;

    @FXML
    private Button editbuttonid;

    @FXML
    private Button homebuttonid;

    @FXML
    private Button newbuttonid;

    @FXML
    private Label clientaddressid;

    @FXML
    private Label clientemailid;

    @FXML
    private Label clientnameid;

    @FXML
    private Label clientphoneid;

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

    public void setClientInfoLabels(Client client) {
        this.client = client;
        clientaddressid.setText(client.getAddress());
        clientnameid.setText(client.getName());
        clientemailid.setText(client.getEmailAddress());
        clientphoneid.setText(client.getPhoneNumber());

    }

    @FXML
    void onActionNew(ActionEvent event) throws IOException {

        String clientAddress = clientaddressid.getText();
        Client client = Inventory.findClientByAddress(clientAddress);

        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/create_proposal_page1.fxml"));
        scene = loader.load();
        Scene root = new Scene(scene);
        stage.setScene(root);
        stage.show();

        CreateProposalPage1Controller controller = loader.getController();
        controller.setClientInfoLabels(client);

    }


    @FXML
    void onActionEdit(ActionEvent event) throws IOException {

        String address = clientaddressid.getText();
        Client client = Inventory.findClientByAddress(address);

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/edit_client.fxml"));
        scene = loader.load();
        Scene root = new Scene(scene);
        stage.setScene(root);
        stage.show();


        EditClientController controller = loader.getController();
        controller.setClientInfo(client);


    }


    @FXML
    void onActionView(ActionEvent event) throws IOException{

        Proposal proposal = clientproposalstableview.getSelectionModel().getSelectedItem();
        String address = clientaddressid.getText();

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/paver_proposal_summary.fxml"));
        scene = loader.load();
        Scene root = new Scene(scene);
        stage.setScene(root);
        stage.show();


        PaverProposalSummaryController controller = loader.getController();
        controller.setPaverSummaryLabels(proposal);
        controller.setAddress(address);

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
