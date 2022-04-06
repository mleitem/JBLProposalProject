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
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class PaverProposalSummaryController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private Label beddingcostid;

    @FXML
    private Label beddingyardsid;

    @FXML
    private Label concretebagsid;

    @FXML
    private Label concretecostid;

    @FXML
    private Label draincostid;

    @FXML
    private Label dumpcostid;

    @FXML
    private Label dumpyardsid;

    @FXML
    private Label edgingfeetid;

    @FXML
    private Label edgingcostid;

    @FXML
    private Label equipmentcostid;

    @FXML
    private Label fabriccostid;

    @FXML
    private Label fabricsqftid;

    @FXML
    private Label fueldayscostid;

    @FXML
    private Label paverscostid;

    @FXML
    private Label paverssqftid;

    @FXML
    private Label polysandbagsid;

    @FXML
    private Label proposaldateid;

    @FXML
    private Label polysandcostid;

    @FXML
    private Label proposaladdressid;

    @FXML
    private Label laborid;

    @FXML
    private Label roadbasecostid;

    @FXML
    private Label roadbaseyardsid;

    @FXML
    private Label totalcostid;

    @FXML
    private Label totalmaterialssubtotalid;

    Proposal proposal;
    Client client;


    public void setPaverSummaryLabels(Proposal proposal) {
        this.proposal = proposal;

        /** Fixed materials costs **/
        double roadBaseCost = ((Pavers) proposal).getRoadBaseYards() * 49.46;
        double beddingCost = ((Pavers) proposal).getBeddingYards() * 70.99;
        double paverCost = ((Pavers) proposal).getSqft() * 5;
        double sandCost = ((Pavers) proposal).getNumSandBags() * 31.88;
        double fabricCost = ((((((Pavers) proposal).getSqft()) + 99) / 100 ) * 100) * .20;
        double edgingCost = ((Pavers) proposal).getUnsecuredLinearFeet() * 3;
        double dumpCost = ((Pavers) proposal).getDirtYards() * 50;
        double loaderCost = ((Pavers) proposal).getLoaderDays() * 250;
        double excavatorCost = ((Pavers) proposal).getExcavatorDays() * 250;
        double bobcatCost = ((Pavers) proposal).getBobcatDays() * 200;
        double compactorCost = ((Pavers) proposal).getBigCompactorDays() * 200;
        double plateCompactorCost = ((Pavers) proposal).getSmallCompactorDays() * 100;
        double sawCost = ((Pavers) proposal).getCuttingDays() * 100;
        double fuelCost = ((Pavers) proposal).getFuelWeeks() * 150;
        double drainCost = 200;
        double equipmentCost = loaderCost + excavatorCost + bobcatCost + compactorCost + plateCompactorCost + sawCost;
        double totalMaterialsCost = roadBaseCost + beddingCost + paverCost + sandCost + fabricCost + edgingCost + fuelCost + drainCost;
        double profit = ((Pavers) proposal).getTotalDays() * 170;
        double lop = ((Pavers) proposal).getTotalLabor() + profit;
        double totalCost  = totalMaterialsCost + lop;
        LocalDate now = LocalDate.now();
        String proposalDate = now.format(DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy"));



        roadbaseyardsid.setText(String.valueOf(((Pavers) proposal).getRoadBaseYards()));
        roadbasecostid.setText(String.valueOf(roadBaseCost));
        beddingyardsid.setText(String.valueOf(((Pavers) proposal).getBeddingYards()));
        beddingcostid.setText(String.valueOf(beddingCost));
        paverssqftid.setText(String.valueOf(((Pavers) proposal).getSqft()));
        paverscostid.setText(String.valueOf(paverCost));
        polysandbagsid.setText(String.valueOf(((Pavers) proposal).getNumSandBags()));
        polysandcostid.setText(String.valueOf(sandCost));
        fabricsqftid.setText(String.valueOf(((Pavers) proposal).getSqft()));
        fabriccostid.setText(String.valueOf(fabricCost));
        edgingfeetid.setText(String.valueOf(((Pavers) proposal).getUnsecuredLinearFeet()));
        edgingcostid.setText(String.valueOf(edgingCost));
        dumpyardsid.setText(String.valueOf(((Pavers) proposal).getDirtYards()));
        dumpcostid.setText(String.valueOf(dumpCost));
        equipmentcostid.setText(String.valueOf(equipmentCost));
        fueldayscostid.setText(String.valueOf(fuelCost));
        totalmaterialssubtotalid.setText(String.valueOf(totalMaterialsCost));
        laborid.setText(String.valueOf(((Pavers) proposal).getTotalLabor() + profit));
        totalcostid.setText(String.valueOf(totalCost));
        proposaldateid.setText(proposalDate);
    }

    public void setAddress(String address) {
        proposaladdressid.setText(address);
    }

    @FXML
    void onActionHome(ActionEvent event) throws IOException {

        ((Pavers) proposal).setProposalDate(proposaldateid.getText());
        ((Pavers) proposal).setTotalCost(Double.parseDouble(totalcostid.getText()));
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/main_screen.fxml"));
        scene = loader.load();
        Scene root = new Scene(scene);
        stage.setScene(root);
        stage.show();
    }

    @FXML
    void onActionClient(ActionEvent event) throws IOException {
        ((Pavers) proposal).setProposalDate(proposaldateid.getText());
        String clientAddress = proposaladdressid.getText();
        Client client = Inventory.findClientByAddress(clientAddress);

        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
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

    }
}
