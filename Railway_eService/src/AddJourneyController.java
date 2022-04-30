/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rakib
 */
public class AddJourneyController implements Initializable {

    @FXML
    private ImageView trainNameText;
    @FXML
    private ComboBox<String> coachNameText;
    @FXML
    private TextField vacancyText;
    @FXML
    private DatePicker journeyDatePicker;
    @FXML
    private ComboBox<String> trainNameBox;

   
    ObservableList<String> trainList = FXCollections.observableArrayList();
    ObservableList<String> coachList = FXCollections.observableArrayList();
    
    String trainName, coachName;
    int tid, cid;
    
    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        String query1 = "select t_id, t_name from \"train\"";
        String query2 = "select c_id, c_name from \"coach\"";
        
        
        DBConnector con;
        try {
            con = new DBConnector();
            ResultSet rs1 = con.createStatement().executeQuery(query1);
            ResultSet rs2 = con.createStatement().executeQuery(query2);
       
            while(rs1.next()){
                String trainName = rs1.getString("t_name"); 
                trainList.add(trainName);
            
            }
            
            while(rs2.next()){
                String coachName = rs2.getString("c_name"); 
                coachList.add(coachName);
            
            }
            
        }
        catch (SQLException ex) {
            Logger.getLogger(ContactController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        trainNameBox.setItems(trainList);
        coachNameText.setItems(coachList);
        
        
        
        
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                trainName = trainNameBox.getValue();
                coachName = coachNameText.getValue();
                
        
                String query1 = "select * from \"train\" where t_name='"+trainName+"'";
                String query2 = "select * from \"coach\" where c_name='"+coachName+"'";
                
                try {
                    DBConnector con = new DBConnector();
                    ResultSet rs1 = con.createStatement().executeQuery(query1);
                    ResultSet rs2 = con.createStatement().executeQuery(query2);
                    

                    while(rs1.next()){
                        
                        tid = rs1.getInt("t_id");
           
                    }
                    
                    while(rs2.next()){
                        
                        cid = rs2.getInt("c_id");
           
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(ContactController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
         
            }
        };
        trainNameBox.setOnAction(event);
        coachNameText.setOnAction(event); 
    
    
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
    public void SaveButton(ActionEvent event) throws IOException {
        
        LocalDate date = journeyDatePicker.getValue();
        int vacancy = Integer.parseInt(vacancyText.getText());
        
        String query = "insert into \"journey\"(j_train, j_date, j_coach, j_vacancy) values('" + tid + "', '" + date + "', '" + cid + "', '" + vacancy + "');";
     
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
