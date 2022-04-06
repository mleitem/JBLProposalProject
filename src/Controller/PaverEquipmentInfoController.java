package Controller;

import Model.Client;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Model.Client.addProposal;

public class PaverEquipmentInfoController implements Initializable {

    Stage stage;
    Parent scene;
    Proposal proposal;
    Client client;

    @FXML
    private TextField bobcatdaysid;

    @FXML
    private TextField compdaysid;

    @FXML
    private TextField excavatordaysid;

    @FXML
    private TextField fuelweeksid;

    @FXML
    private TextField loaderdaysid;

    @FXML
    private TextField platecompdaysid;

    @FXML
    private TextField sawdaysid;

    @FXML
    private Label clientaddressid;



    @FXML
    void onActionBackPage(ActionEvent event) throws IOException {

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/paver_info.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionCancel(ActionEvent event) throws IOException {

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/main_screen.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionFinishProposal(ActionEvent event) throws IOException {

        double loaderDays = Double.parseDouble(loaderdaysid.getText());
        double excavatorDays = Double.parseDouble(excavatordaysid.getText());
        double bobcatDays = Double.parseDouble(bobcatdaysid.getText());
        double compactorDays = Double.parseDouble(compdaysid.getText());
        double plateCompactorDays = Double.parseDouble(platecompdaysid.getText());
        double sawDays = Double.parseDouble(sawdaysid.getText());
        double fuelWeeks = Double.parseDouble(fuelweeksid.getText());
        double totalDays = ((Pavers) proposal).getMoveDays() + ((Pavers) proposal).getDemoDays() + ((Pavers) proposal).getExcDays() + ((Pavers) proposal).getRoadBaseDays() + ((Pavers) proposal).getEdgingDays() + ((Pavers) proposal).getBeddingDays() + ((Pavers) proposal).getLayingPaversDays() + ((Pavers) proposal).getCuttingDays() + ((Pavers) proposal).getSandingDays();
        double totalLabor = totalDays * 500;

        String address = clientaddressid.getText();


        ((Pavers) proposal).setLoaderDays(loaderDays);
        ((Pavers) proposal).setExcavatorDays(excavatorDays);
        ((Pavers) proposal).setBobcatDays(bobcatDays);
        ((Pavers) proposal).setBigCompactorDays(compactorDays);
        ((Pavers) proposal).setSmallCompactorDays(plateCompactorDays);
        ((Pavers) proposal).setCuttingSystemDays(sawDays);
        ((Pavers) proposal).setFuelWeeks(fuelWeeks);
        ((Pavers) proposal).setTotalLabor(totalLabor);
        ((Pavers) proposal).setTotalDays(totalDays);


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

    public void setAddress(String address) {
        clientaddressid.setText(address);
    }

    public void setPaverEquipmentLabels(Proposal proposal) {
        this.proposal = proposal;

        double loaderDays = 0;
        double excavatorDays = 0;
        double bobcatDays = 0 ;
        double smallCompactorDays = 0;
        double bigCompactorDays = 0;
        double cuttingSystemDays = 0;
        double totalDays = 0;
        double totalWeeks = 0;
        double fuelWeeks = 0;

        loaderDays = (((Pavers) proposal).getRoadBaseDays());
        excavatorDays = Math.round(((((Pavers) proposal).getExcDays()) * .5) * 2) / 2.0;
        smallCompactorDays = 1 + ((Pavers) proposal).getSandingDays();

        if ((((Pavers) proposal).getProjectType()).equals("Driveway")) {
            bigCompactorDays = 1;
        }
        cuttingSystemDays = ((Pavers) proposal).getCuttingDays();
        totalDays = ((Pavers) proposal).getMoveDays() + ((Pavers) proposal).getDemoDays() + ((Pavers) proposal).getExcDays() + ((Pavers) proposal).getRoadBaseDays() + ((Pavers) proposal).getEdgingDays() + ((Pavers) proposal).getBeddingDays() + ((Pavers) proposal).getLayingPaversDays() + ((Pavers) proposal).getCuttingDays() + ((Pavers) proposal).getSandingDays();
        fuelWeeks = Math.round((totalDays / 7) * 2) / 2.0;

        loaderdaysid.setText(String.valueOf(loaderDays));
        excavatordaysid.setText(String.valueOf(excavatorDays));
        bobcatdaysid.setText(String.valueOf(bobcatDays));
        compdaysid.setText(String.valueOf(bigCompactorDays));
        platecompdaysid.setText(String.valueOf(smallCompactorDays));
        sawdaysid.setText(String.valueOf(cuttingSystemDays));
        fuelweeksid.setText(String.valueOf(fuelWeeks));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
