/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rakib
 */
public class AdminDashboardController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    public void LogOutButton(Event event) throws IOException{
        Parent window;
        window = FXMLLoader.load(getClass().getResource("SignIn.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }
    
    
    
    @FXML
    public void addTrainButton(Event event) throws IOException{
        Parent window;
        window = FXMLLoader.load(getClass().getResource("insertTrain.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }
    
    
    @FXML
    public void addStationButton(Event event) throws IOException{
        Parent window;
        window = FXMLLoader.load(getClass().getResource("addStation.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }
    
    
    @FXML
    public void addJourneyButton(Event event) throws IOException{
        Parent window;
        window = FXMLLoader.load(getClass().getResource("addJourney.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }
    
    
    
    @FXML
    public void addCoachButton(Event event) throws IOException{
        Parent window;
        window = FXMLLoader.load(getClass().getResource("addCoach.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        
        
        
    }    
    
}
