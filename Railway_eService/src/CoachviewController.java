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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CoachviewController implements Initializable{
    
    public ImageView test;
    @FXML
    private ImageView image1;
    @FXML
    private ImageView image2;
    @FXML
    private ComboBox<String> choice_box;
    
    ObservableList<String> coaches = FXCollections.observableArrayList();
    String imageSource1;
    String imageSource2;
    
    
    @FXML
    public void BackButton(Event event) throws IOException{
        Parent window;
        window = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }
    

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        
        String query1 = "select c_name from \"coach\"";
        
        
        DBConnector con;
        try {
            con = new DBConnector();
            ResultSet rs1 = con.createStatement().executeQuery(query1);
       
            while(rs1.next()){
                String stationName = rs1.getString("c_name").trim();
                coaches.add(stationName);
            
        }
        }
        catch (SQLException ex) {
            Logger.getLogger(ContactController.class.getName()).log(Level.SEVERE, null, ex);
        }             
        
        choice_box.setItems(coaches);
        
  
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                System.out.println(choice_box.getValue());
                if(choice_box.getValue().equals("SHOVAN")) {
                    imageSource1 = "images/shovan1.jpg";
                    imageSource2 = "images/shovan2.jpg";
                    Image img1 = new Image(imageSource1);
                    Image img2 = new Image(imageSource2);
                    image1.setImage(img1);
                    image2.setImage(img2);
                }
                else if(choice_box.getValue().equals("S_CHAIR")) {
                    imageSource1 = "../images/schair1.jpg";
                    imageSource2 = "../images/schair2.jpg";
                    Image img1 = new Image(imageSource1);
                    Image img2 = new Image(imageSource2);
                    image1.setImage(img1);
                    image2.setImage(img2);
                }
                else if(choice_box.getValue().equals("F_CHAIR")) {
                    imageSource1 = "../images/fchair1.jpg";
                    imageSource2 = "../images/fchair2.jpg";
                    Image img1 = new Image(imageSource1);
                    Image img2 = new Image(imageSource2);
                    image1.setImage(img1);
                    image2.setImage(img2);
                }
                else if(choice_box.getValue().equals("SNIGDHA")) {
                    imageSource1 = "../images/snigdha1.jpeg";
                    imageSource2 = "../images/snigdha2.jpg";
                    Image img1 = new Image(imageSource1);
                    Image img2 = new Image(imageSource2);
                    image1.setImage(img1);
                    image2.setImage(img2);
                }
                
                else if(choice_box.getValue().equals("AC_S")) {
                    imageSource1 = "../images/acs1.jpg";
                    imageSource2 = "../images/acs2.jpg";
                    Image img1 = new Image(imageSource1);
                    Image img2 = new Image(imageSource2);
                    image1.setImage(img1);
                    image2.setImage(img2);
                }
                
                else if(choice_box.getValue().equals("F_SEAT")) {
                    imageSource1 = "@../images/fseat1.jpg";
                    imageSource2 = "@../images/fseat2.jpg";
                    Image img1 = new Image(imageSource1);
                    Image img2 = new Image(imageSource2);
                    image1.setImage(img1);
                    image2.setImage(img2);
                }
            }
        };
        
        //Set on action
        choice_box.setOnAction(event);
    
    }


}
