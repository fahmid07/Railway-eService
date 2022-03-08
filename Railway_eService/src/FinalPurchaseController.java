import java.beans.EventHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FinalPurchaseController implements Initializable{

    public Label fromtxt, totxt, datetxt, classtxt, departuretxt, errortxt, tfaretxt, traintxt;
    public ComboBox<String> seats;

    ObservableList<String> noOfSeats = FXCollections.observableArrayList("1", "2", "3", "4");

    

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        fromtxt.setText("From: " + purchaseController.from);
        totxt.setText("To: " + purchaseController.to);
        datetxt.setText("Date: " + purchaseController.formattedDate);
        classtxt.setText("Class: " + TrainsController.selected.c_name);
        departuretxt.setText("Departure: " + TrainsController.selected.startTime);
        tfaretxt.setText("Fare: " + TrainsController.selected.c_fare);
        traintxt.setText("Train: " + TrainsController.selected.t_name);
        seats.setItems(noOfSeats);

        
    }
    
    public void handle(ActionEvent e){
            if(seats.getValue() == "1" ) {
                tfaretxt.setText("Fare: " + (TrainsController.selected.c_fare * 1));
            }
            else if(seats.getValue() == "2" ) {
                tfaretxt.setText("Fare: " + (TrainsController.selected.c_fare * 2));
            }
            else if(seats.getValue() == "3" ) {
                tfaretxt.setText("Fare: " + (TrainsController.selected.c_fare * 3));
            }
            else if(seats.getValue() == "4" ) {
                tfaretxt.setText("Fare: " + (TrainsController.selected.c_fare * 4));
            }
    }

    public void BackButton(Event event) throws IOException {
        Parent window;
        window = FXMLLoader.load(getClass().getResource("trains.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }

    public void PurchaseButton(Event event) throws IOException {
        Parent window;
        window = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }
}
