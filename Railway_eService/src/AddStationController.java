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
public class AddStationController implements Initializable {

    @FXML
    private TextField stationNameText;
    @FXML
    private TextField stationMasterNameText;
    @FXML
    private TextField smasterNoText;

    
    @FXML
    public void BackButton(Event event) throws IOException{
        Parent window;
        window = FXMLLoader.load(getClass().getResource("adminDashboard.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }
    
    

        public void SaveButton(Event event) throws IOException{
        String stationName = stationNameText.getText();
        String sMasterName = stationMasterNameText.getText();
        String sMasterNo = smasterNoText.getText();

        
        String query = "insert into \"station\"(s_name, s_master, sm_number) values('" + stationName + "', '" + sMasterName + "', '" + sMasterNo + "');";
     
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
    
    
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
}
