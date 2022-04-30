import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FinalPurchaseController implements Initializable{

    public Label fromtxt, totxt, datetxt, classtxt, departuretxt, errortxt, tfaretxt, traintxt;
    public ComboBox<String> seats;
    public AnchorPane myPane;
    ObservableList<String> noOfSeats = FXCollections.observableArrayList("1", "2", "3", "4");
    public static int no_seats, total_fare, t_id;
    

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
        errortxt.setText("");
        
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

    public void PurchaseButton(Event event) throws IOException, SQLException {

        if(seats.getValue() == null) {
            errortxt.setText("Please select a seat");
        }
        else if(Integer.parseInt(seats.getValue())>TrainsController.selected.j_vacancy) {
            errortxt.setText("Number of seats available");
        }
        else {
            no_seats = Integer.parseInt(seats.getValue());
            total_fare = no_seats * TrainsController.selected.c_fare;

            String query = "insert into ticket(tk_j_id, tk_u_id, tk_seats, tk_fare) values(" + TrainsController.selected.j_id + ", " + SignInController.uid + ", " + no_seats + ", " + total_fare + ");";
            DBConnector conn = new DBConnector();
            conn.createStatement().executeUpdate(query); 

            String query2 = "update journey set j_vacancy = j_vacancy - " + no_seats + " where j_id = " + TrainsController.selected.j_id + ";";
            conn.createStatement().executeUpdate(query2);

            String query3 = "select tk_id from ticket where tk_u_id=" + SignInController.uid + " Order by tk_id DESC";
            ResultSet resultSet = conn.createStatement().executeQuery(query3);
            resultSet.next();
            t_id = resultSet.getInt("tk_id");

            Parent window;
            window = FXMLLoader.load(getClass().getResource("printTicket.fxml"));

            Stage mainStage;
            mainStage = App.parentWindow;
            mainStage.getScene().setRoot(window);
        }
        
    }
}
