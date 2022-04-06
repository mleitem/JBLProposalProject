package Main;

import Model.Client;
import Model.Inventory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/View/main_screen.fxml"));
        primaryStage.setTitle("All Clients");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {

        Client client1 = new Client("Megan Leitem", "2043 Stonybrook Drive", "530-351-4872", "mleitem@emaill.com");
        Client client2 = new Client("Derrick Barrie", "1064 Burton Drive", "530-526-7566", "dbarrie@email.com");
        Client client3 = new Client("John Barrie", "19750 Evergreen Road", "707-444-7777", "jbarrie@email.com");
        Client client4 = new Client("Sherri Leitem", "18705 Olinda Road", "530-351-2434", "sleitem@email.com");

        Inventory.addClient(client1);
        Inventory.addClient(client2);
        Inventory.addClient(client3);
        Inventory.addClient(client4);

        launch(args);
    }
}
