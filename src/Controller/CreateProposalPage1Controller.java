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
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateProposalPage1Controller implements Initializable {

    Stage stage;
    Parent scene;
    Client client;

    @FXML
    private TextField addressid;

    @FXML
    private TextField nameid;

    @FXML
    private TextField phoneid;

    @FXML
    private RadioButton cleaningsealingid;

    @FXML
    private RadioButton checkpaversid;

    @FXML
    private RadioButton checkretaingingwallid;

    @FXML
    private RadioButton checktimematerialsid;

    @FXML
    private ToggleGroup proposalTypeGroup;

    @FXML
    private TextField emailaddressid;


    @FXML
    void onActionCancel(ActionEvent event) throws IOException {

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/main_screen.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionNextPage(ActionEvent event) throws IOException {

        /**
         * Adds client to allClients
         */
        String address  = addressid.getText();
        String name = nameid.getText();
        String phoneNumber = phoneid.getText();
        String emailAddress = emailaddressid.getText();

        Client client = new Client(name, address, phoneNumber, emailAddress);
        Inventory.addClient(client);

        /**
         * If pavers is checked "Next" directs to new paver proposal
         */

        if (checkpaversid.isSelected()) {
            System.out.println("Pavers!");
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/new_paver_proposal.fxml"));
            scene = loader.load();
            Scene root = new Scene(scene);
            stage.setScene(root);
            stage.show();

            NewPaverProposalController controller = loader.getController();
            controller.setAddress(address);
        }

        /**
         * If retaining wall is checked, "Next" directs to new retaining wall proposal
         */

        if (checkretaingingwallid.isSelected()) {
            System.out.println("Retaining Wall!");
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/new_retaining_wall_proposal.fxml"));
            scene = loader.load();
            Scene root = new Scene(scene);
            stage.setScene(root);
            stage.show();

            NewRetainingWallProposalController controller = loader.getController();
            controller.setAddress(address);
        }

        /**
         * If cleaning & sealing is checked, "Next" directs to the new cleaning & sealing proposal
         */

        if (cleaningsealingid.isSelected()) {
            System.out.println("Deck!");
        }


        /**
         * If time & materials is checked, "Next" directs to new time & materaials proposal
         */

        if (checktimematerialsid.isSelected()) {
            System.out.println("Time & Materials!");
        }


    }

    public void setClientInfoLabels(Client client) {
        this.client = client;
        addressid.setText(client.getAddress());
        addressid.setEditable(false);
        nameid.setText(client.getName());
        nameid.setEditable(false);
        emailaddressid.setText(client.getEmailAddress());
        emailaddressid.setEditable(false);
        phoneid.setText(client.getPhoneNumber());
        phoneid.setEditable(false);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
