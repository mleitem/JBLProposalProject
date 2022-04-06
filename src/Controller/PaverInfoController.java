package Controller;


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

public class PaverInfoController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private TextField baseprepdaysid;

    @FXML
    private TextField beddingdaysid;

    @FXML
    private TextField cuttingdaysid;

    @FXML
    private TextField demodaysid;

    @FXML
    private TextField drainagedaysid;

    @FXML
    private TextField edgingdaysid;

    @FXML
    private TextField excdaysid;

    @FXML
    private TextField exctripsid;

    @FXML
    private TextField layingdaysid;

    @FXML
    private TextField movedaysid;

    @FXML
    private TextField sandingdaysid;

    @FXML
    private Label chipyardsid;

    @FXML
    private Label polysandbagsid;

    @FXML
    private Label roadbaseyardsid;

    @FXML
    private Label totallinealfeetid;

    @FXML
    private Label totalsqftid;

    @FXML
    private Label yardsdirtid;

    @FXML
    private Label ulinfeetid;

    @FXML
    private Label clientaddressid;


    Proposal proposal;


    @FXML
    void onActionBackPage(ActionEvent event) throws IOException {

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/new_paver_proposal"));
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
    void onActionNextPage(ActionEvent event) throws IOException {
        this.proposal = proposal;

        double moveDays = Double.parseDouble(movedaysid.getText());
        double demoDays = Double.parseDouble(demodaysid.getText());
        double excavationDays = Double.parseDouble(excdaysid.getText());
        int excavationTrips = Integer.parseInt(exctripsid.getText());
        double drainageDays = Double.parseDouble(drainagedaysid.getText());
        double basePrepDays = Double.parseDouble(baseprepdaysid.getText());
        double edgingDays = Double.parseDouble(edgingdaysid.getText());
        double beddingDays = Double.parseDouble(beddingdaysid.getText());
        double layingDays = Double.parseDouble(layingdaysid.getText());
        double cuttingDays = Double.parseDouble(cuttingdaysid.getText());
        double sandingDays = Double.parseDouble(sandingdaysid.getText());
        double beddingYards1 = Math.round(((((Pavers) proposal).getSqft() * 0.104) / 27) * 2) / 2.0;
        double numSandBags1 = Math.round((((Pavers) proposal).getSqft() / 65) * 2) / 2.0;

        double roadBaseYards1 = 0;
        double dirt11 = 0;
        double dirtYards1;

        /** Yards of road base determined by project. Vehicle projects req. 8.75" of road base
         * and pedestrian projects require 6.25". INSERT LOGIC FOR DAYS
         **/

        if ((((Pavers) proposal).getProjectType()).equals("Driveway")) {
            roadBaseYards1 = Math.round(((((Pavers) proposal).getSqft() * 0.73) / 27) * 2) / 2.0;
            dirt11 = (((Pavers) proposal).getSqft() * 0.833) / 27;
        }
        else {
            roadBaseYards1 = Math.round(((((Pavers) proposal).getSqft() * 0.521) / 27) * 2) / 2.0;
            dirt11 = (((Pavers) proposal).getSqft() * 0.667) / 27;
        }
        dirtYards1 = Math.round((dirt11 + (dirt11 * 0.30)) * 2) / 2.0;

        ((Pavers) proposal).setMoveDays(moveDays);
        ((Pavers) proposal).setDemoDays(demoDays);
        ((Pavers) proposal).setExcDays(excavationDays);
        ((Pavers) proposal).setExcTrips(excavationTrips);
        ((Pavers) proposal).setDrainageDays(drainageDays);
        ((Pavers) proposal).setRoadBaseDays(basePrepDays);
        ((Pavers) proposal).setEdgingDays(edgingDays);
        ((Pavers) proposal).setBeddingDays(beddingDays);
        ((Pavers) proposal).setBeddingYards(beddingYards1);
        ((Pavers) proposal).setLayingPaversDays(layingDays);
        ((Pavers) proposal).setCuttingDays(cuttingDays);
        ((Pavers) proposal).setSandingDays(sandingDays);
        ((Pavers) proposal).setRoadBaseYards(roadBaseYards1);
        ((Pavers) proposal).setDirtYards(dirtYards1);
        ((Pavers) proposal).setNumSandBags(numSandBags1);

        String address = clientaddressid.getText();


        /*s
        tage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/paver_equipment _info.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
        */

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/paver_equipment _info.fxml"));
        scene = loader.load();
        Scene root = new Scene(scene);
        stage.setScene(root);
        stage.show();


        PaverEquipmentInfoController controller = loader.getController();
        controller.setPaverEquipmentLabels(proposal);
        controller.setAddress(address);

    }

    public void setPaverInfoLabels(Proposal proposal) {
        this.proposal = proposal;


        int moveDays = 2;
        double roadBaseYards = 0;
        double roadBaseDays = 0;
        double excDays = 0;
        double edgingFeet = 0;
        double edgingRawDays = 0;
        double edgingDays = 0;
        double beddingYards = 0;
        double beddingDays = 0;
        double totalLinealFeet = 0;
        double layingPaversDays = 0;
        double cuttingDays = 0;
        double numSandBags = 0;
        double sandingDays = 0;
        double dirtYards = 0;
        int excTrips = 0;
        double dirt1 = 0;

        /** Yards of road base determined by project. Vehicle projects req. 8.75" of road base
         * and pedestrian projects require 6.25". INSERT LOGIC FOR DAYS
         **/

        if ((((Pavers) proposal).getProjectType()).equals("Driveway")) {
            roadBaseYards = Math.round(((((Pavers) proposal).getSqft() * 0.73) / 27) * 2) / 2.0;
            dirt1 = (((Pavers) proposal).getSqft() * 0.833) / 27;
        }
        else {
            roadBaseYards = Math.round(((((Pavers) proposal).getSqft() * 0.521) / 27) * 2) / 2.0;
            dirt1 = (((Pavers) proposal).getSqft() * 0.667) / 27;
        }
        dirtYards = Math.round((dirt1 + (dirt1 * 0.30)) * 2) / 2.0;
        // >>>>>((Pavers) proposal).setRoadBaseYards(roadBaseYards);
        System.out.println("Road Base for Pavers: "+roadBaseYards);



        /** If there isn't easy access, add 20% (adds about 1 day per week)
         * @excDays is estimated using 4 yards of digging (unexpanded dirt) per day per Webb proposal **/
        if (((Pavers) proposal).isEasyAccess() == true) {
            roadBaseDays = Math.round((roadBaseYards / 5) * 2) / 2.0;
            excDays = Math.round((dirt1 / 4) * 2) / 2.0;
        // >>>>>>((Pavers) proposal).setRoadBaseDays(roadBaseDays);
        // >>>>>((Pavers) proposal).setExcDays(excDays);
        }
        else {
        roadBaseDays = Math.round(((roadBaseYards / 5) + ((roadBaseYards / 5) * 0.2)) * 2) / 2.0;
        excDays = Math.round(((dirt1 / 4) + ((dirt1 / 4) * 0.2)) * 2) / 2.0; }
        //>>>>>((Pavers) proposal).setRoadBaseDays(roadBaseDays);
        //>>>>>((Pavers) proposal).setExcDays(excDays);




        /** 4 trips/day **/
        excTrips = (int) Math.ceil(dirt1/4);
        //>>>>>((Pavers) proposal).setDirtYards(dirtYards);
        //>>>>>((Pavers) proposal).setExcTrips(excTrips);
        System.out.println("Dirt Removed: "+dirtYards);
        System.out.println("Excavation Trips: "+excTrips);


        /** Edging is done in 25ft/hour and we are assuming 8 hours in a day.
         * Rounding to the nearest half day, which is the * 2 / 2.0. DOES JOHN WANT ANYTHING DIFFERENT?
         **/

        edgingFeet = (((Pavers) proposal).getUnsecuredLinearFeet());
        edgingRawDays = ((edgingFeet/25) / 8);
        edgingDays = Math.round(edgingRawDays * 2) / 2.0;
        //>>>>>((Pavers) proposal).setEdgingFeet(edgingFeet);
        //>>>>>((Pavers) proposal).setEdgingDays(edgingDays);
        System.out.println("Edging: "+edgingFeet);
        System.out.println("Edging Days: "+edgingDays);


        beddingYards = Math.round(((((Pavers) proposal).getSqft() * 0.104) / 27) * 2) / 2.0;

        if(((Pavers) proposal).isEasyAccess() == true) {
            beddingDays = Math.round(((((Pavers) proposal).getSqft() / 300) / 8) * 2) / 2.0;
        }
        else {
            beddingDays = Math.round((((((Pavers) proposal).getSqft() / 300) / 8) + (((((Pavers) proposal).getSqft() / 300) / 8) * 0.20)) * 2) / 2.0;
        }
        //>>>>>((Pavers) proposal).setBeddingYards(beddingYards);
        //>>>>>((Pavers) proposal).setBeddingDays(beddingDays);
        System.out.println("Chip Yards: "+beddingYards);
        System.out.println("Chip Days: " +beddingDays);



        double layingDays = (((Pavers) proposal).getSqft() / 35) / 8;
        if (((Pavers) proposal).isEasyAccess() == true) {
            layingPaversDays = Math.round(layingDays * 2) / 2.0;
        }
        else {
            layingPaversDays = Math.round((layingDays + (layingDays * 0.20)) * 2) / 2.0;
        }
        //>>>>>((Pavers) proposal).setLayingPaversDays(layingPaversDays);
        System.out.println("Laying Days: " +layingPaversDays);

        totalLinealFeet = (((Pavers) proposal).getSecuredLinearFeet()) + (((Pavers) proposal).getUnsecuredLinearFeet()) + (((Pavers) proposal).getAddtlLinearFeet());
        cuttingDays = Math.round(((totalLinealFeet / 10) / 8) * 2) / 2.0;
        //>>>>>((Pavers) proposal).setTotalLinealFeet(totalLinealFeet);
        //>>>>>((Pavers) proposal).setCuttingDays(cuttingDays);
        System.out.println("Cutting Days: " +cuttingDays);


        /** ASK JOHN 65 SQFT PER SAND BAG?? **/


        numSandBags = Math.round((((Pavers) proposal).getSqft() / 65) * 2) / 2.0;
        sandingDays = Math.round((numSandBags / 8) * 2) / 2.0;
        //>>>>>((Pavers) proposal).setNumSandBags(numSandBags);
        //>>>>>((Pavers) proposal).setSandingDays(sandingDays);
        System.out.println("Bags of Sand: "+numSandBags);
        System.out.println("Sanding Days: "+sandingDays);


        //WALL BLOCK INFO
        /*double dirt2 = (proposal.getWallBlockFeet() * 3);
        wallDirtYards = dirt2 + (dirt2 * 0.30);
        System.out.println("Dirt Removed for Wall: "+wallDirtYards);


        double wallSqft = (proposal.getWallBlockFeet() * 3);
        wallRoadBaseYards = (wallSqft * 0.625) / 27;
        System.out.println("Road Base for Wall: "+ wallRoadBaseYards); */


        yardsdirtid.setText(String.valueOf(dirtYards));
        roadbaseyardsid.setText(String.valueOf(roadBaseYards));
        totalsqftid.setText(String.valueOf(((Pavers) proposal).getSqft()));
        ulinfeetid.setText(String.valueOf(((Pavers) proposal).getUnsecuredLinearFeet()));
        chipyardsid.setText(String.valueOf(beddingYards));
        totallinealfeetid.setText(String.valueOf(totalLinealFeet));
        polysandbagsid.setText(String.valueOf(numSandBags));
        /*walldirtid.setText(String.valueOf(wallDirtYards));
        wallroadbaseyardsid.setText(String.valueOf(wallRoadBaseYards));
        linealwallblockid.setText(String.valueOf(proposal.getWallBlockFeet()));*/


        movedaysid.setText(String.valueOf(moveDays));
        excdaysid.setText(String.valueOf(excDays));
        baseprepdaysid.setText(String.valueOf(roadBaseDays));
        exctripsid.setText(String.valueOf(excTrips));
        baseprepdaysid.setText(String.valueOf(roadBaseDays));
        edgingdaysid.setText(String.valueOf(edgingDays));
        beddingdaysid.setText(String.valueOf(beddingDays));
        layingdaysid.setText(String.valueOf(layingPaversDays));
        cuttingdaysid.setText(String.valueOf(cuttingDays));
        sandingdaysid.setText(String.valueOf(sandingDays));
    }

    public void setAddress(String address) {
        clientaddressid.setText(address);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
