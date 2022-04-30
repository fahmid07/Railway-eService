/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rakib
 */
public class InsertTrainController implements Initializable {

    @FXML
    private TextField trainNameText;
    @FXML
    private ComboBox<String> fromStationBox;
    @FXML
    private ComboBox<String> toStationBox;
    
    String fromStation, toStation;
    int fromsid, tosid;
    
    
    ObservableList<String> stationList = FXCollections.observableArrayList();
    @FXML
    private TextField startTimeText;
    @FXML
    private TextField endTimeText;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        String query1 = "select s_id, s_name from \"station\"";
        
        
        DBConnector con;
        try {
            con = new DBConnector();
            ResultSet rs1 = con.createStatement().executeQuery(query1);
       
            while(rs1.next()){
                String stationName = rs1.getString("s_name"); 
                stationList.add(stationName);
            
        }
        }
        catch (SQLException ex) {
            Logger.getLogger(ContactController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        fromStationBox.setItems(stationList);
        toStationBox.setItems(stationList);
        
        
        
        
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                fromStation = fromStationBox.getValue();
                toStation = toStationBox.getValue();
                
        
                String query1 = "select * from \"station\" where s_name='"+fromStation+"'";
                String query2 = "select * from \"station\" where s_name='"+toStation+"'";
                
                try {
                    DBConnector con = new DBConnector();
                    ResultSet rs1 = con.createStatement().executeQuery(query1);
                    ResultSet rs2 = con.createStatement().executeQuery(query2);
                    

                    while(rs1.next()){
                        
                        fromsid = rs1.getInt("s_id");
           
                    }
                    
                    while(rs2.next()){
                        
                        tosid = rs2.getInt("s_id");
           
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(ContactController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
         
            }
        };
        fromStationBox.setOnAction(event);
        toStationBox.setOnAction(event);   
         
    } 

    
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

        String trainName = trainNameText.getText();
        LocalTime startTime = LocalTime.parse(startTimeText.getText());
        LocalTime endTime = LocalTime.parse(endTimeText.getText());
        
        String query = "insert into \"train\"(t_name, from_st, to_st, startTime, endTime) values('" + trainName + "', '" + fromsid + "', '" + tosid + "', '" + startTime + "', '" + endTime + "');";
     
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
   
       
    
}
