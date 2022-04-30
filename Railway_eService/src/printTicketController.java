import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class printTicketController implements Initializable{

    public Label fromtxt, totxt, datetxt, classtxt, departuretxt, errortxt, tfaretxt, traintxt, seats, tickettxt, nametxt;
    public AnchorPane myPane;
    

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        fromtxt.setText("From: " + purchaseController.from);
        totxt.setText("To: " + purchaseController.to);
        datetxt.setText("Date: " + purchaseController.formattedDate);
        classtxt.setText("Class: " + TrainsController.selected.c_name);
        departuretxt.setText("Departure: " + TrainsController.selected.startTime);
        tfaretxt.setText("Total Fare: " + FinalPurchaseController.total_fare);
        traintxt.setText("Train: " + TrainsController.selected.t_name);   
        seats.setText("No. of Seats: " + FinalPurchaseController.no_seats);
        tickettxt.setText("Ticket No: " + FinalPurchaseController.t_id);
        nametxt.setText("Name: " + SignInController.userObj.name);
    }

    public void PrintButton(Event event) throws IOException, SQLException {
            PrinterJob job = PrinterJob.createPrinterJob();
            if(job != null){
                job.showPrintDialog(App.parentWindow);
                myPane.setMinSize(500, 400);
                job.printPage(myPane);
                job.endJob();
            }
            Parent window;
            window = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

            Stage mainStage;
            mainStage = App.parentWindow;
            mainStage.getScene().setRoot(window);      
    }
}
