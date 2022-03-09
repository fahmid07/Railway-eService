import java.io.IOException;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class dashboard {
    

    public void LogOutButton(Event event) throws IOException{
        Parent window;
        window = FXMLLoader.load(getClass().getResource("SignIn.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }

    public void AccountButton(Event event) throws IOException{
        Parent window;
        window = FXMLLoader.load(getClass().getResource("updateAccount.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }
    
    public void CoachviewButton(Event event) throws IOException{
        Parent window;
        window = FXMLLoader.load(getClass().getResource("coachview.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }
    
    public void InfoButton(Event event) throws IOException{
        Parent window;
        window = FXMLLoader.load(getClass().getResource("info.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }

    public void PurchaseButton(Event event) throws IOException{
        Parent window;
        window = FXMLLoader.load(getClass().getResource("purchase.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }


    public void ContactsButton(Event event) throws IOException{
        Parent window;
        window = FXMLLoader.load(getClass().getResource("contact.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }

}
