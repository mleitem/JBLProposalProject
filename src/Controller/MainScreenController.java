package Controller;

import Model.Client;
import Model.Inventory;
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
import java.util.Optional;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    Stage stage;
    Parent scene;


    @FXML
    private TableColumn<Client, String> addresscol;

    @FXML
    private TableColumn<Client, String> namecol;

    @FXML
    private TableColumn<Client, String> emailcol;

    @FXML
    private TableView<Client> clientstableview;

    @FXML
    private TableColumn<Client, String> phonecol;

    @FXML
    void onActionNewProposal(ActionEvent event) throws IOException {

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/create_proposal_page1.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionViewClient(ActionEvent event) throws IOException {


        Client client = clientstableview.getSelectionModel().getSelectedItem();

        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/view_client.fxml"));
        scene = loader.load();
        Scene root = new Scene(scene);
        stage.setScene(root);
        stage.show();

        ViewClientController controller = loader.getController();
        controller.setClientInfoLabels(client);
    }

    @FXML
    void onActionEdit(ActionEvent event) throws IOException {

        Client client = clientstableview.getSelectionModel().getSelectedItem();


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
    void onActionDelete(ActionEvent event) throws IOException {

        if (clientstableview.getSelectionModel().isEmpty()) {
            Alert noSelectionAlert = new Alert(Alert.AlertType.ERROR);
            noSelectionAlert.setTitle("Error");
            noSelectionAlert.setContentText("Please choose a client to delete.");
            noSelectionAlert.showAndWait();
        } else {
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you wand to delete this client?");
            confirmation.setTitle("Delete Confirmation");
            Optional<ButtonType> result = confirmation.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                Client client = clientstableview.getSelectionModel().getSelectedItem();
                Inventory.deleteClient(client);
            }

            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view/main_screen.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        clientstableview.setItems(Inventory.getAllClients());
        addresscol.setCellValueFactory(new PropertyValueFactory<>("address"));
        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        phonecol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        emailcol.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));

    }
}
