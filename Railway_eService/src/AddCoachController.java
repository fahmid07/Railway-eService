/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rakib
 */
public class AddCoachController implements Initializable {

    @FXML
    private TextField coachNameText;
    @FXML
    private TextField ticketFareText;

    
    
    @FXML
    public void BackButton(Event event) throws IOException{
        Parent window;
        window = FXMLLoader.load(getClass().getResource("adminDashboard.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }
    
    
    @FXML
        public void SaveButton(Event event) throws IOException{
        String coachName = coachNameText.getText();
        int cfare = Integer.parseInt(ticketFareText.getText());

        
        String query = "insert into \"coach\"(c_name, c_fare) values('" + coachName + "', '" + cfare + "');";
     
        try {
            DBConnector conn = new DBConnector();
            conn.createStatement().executeUpdate(query);
            Parent window;
            window = FXMLLoader.load(getClass().getResource("adminDashboard.fxml"));

            Stage mainStage;
                mainStage = App.parentWindow;
                mainStage.getScene().setRoot(window);

            } catch (SQLException e) {

            }
        }
 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
