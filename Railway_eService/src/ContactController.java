import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rakib
 */
public class ContactController implements Initializable {

    @FXML
    private ComboBox<String> choice_box;
    
    //ObservableList<String> stationList = FXCollections.observableArrayList("Chittagong", "Dhaka", "Kishoreganj");
    ObservableList<String> stationList = FXCollections.observableArrayList();

    
    String station;
    @FXML
    private Text snametext;
    @FXML
    private Text smastertest;
    @FXML
    private Text smnotext;
    
    
    @FXML
    public void BackButton(Event event) throws IOException{
        Parent window;
        window = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }
    
    
    String sname, smaster, smnumber;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {     
        
        
        String query1 = "select s_name from \"station\"";
        
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
        
        choice_box.setItems(stationList);
      

        
    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                station = choice_box.getValue();
                
                String query = "select * from \"station\" where s_name='"+station+"'";
                
                try {
                    DBConnector con = new DBConnector();
                    ResultSet rs = con.createStatement().executeQuery(query);

                    while(rs.next()){
                        snametext.setText("Station Name: "+rs.getString("s_name"));
                        smastertest.setText("Station Master Name: "+rs.getString("s_master"));
                        smnotext.setText("Station Master Number: "+rs.getString("sm_number"));
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(ContactController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
         
            }
        };
        choice_box.setOnAction(event);
       
    }
 
}
