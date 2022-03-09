/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rakib
 */
public class AdminLoginController implements Initializable {

    
    @FXML
    private PasswordField passtxt;
    @FXML
    private Label errortxt;
    @FXML
    private TextField userNameText;

    
    @FXML
    public void SignInButton(Event event) throws IOException{
        String userName = userNameText.getText();
        String pass = passtxt.getText();
        
        System.out.println(pass);
        System.out.println(userName);
        
        try {
            
            String query = "select * from \"adminn\" where username='" + userName + "'";
            DBConnector con = new DBConnector();
            ResultSet rs = con.createStatement().executeQuery(query);
            
            
            while(rs.next()){
                String password = rs.getString("pass");
                if(password.equals(pass)){
                    
                    Parent window;
                    window = FXMLLoader.load(getClass().getResource("adminDashboard.fxml"));

                    Stage mainStage;
                    mainStage = App.parentWindow;
                    mainStage.getScene().setRoot(window);
                }
                else{
                    errortxt.setText("Wrong username or password");
                }
            }
                
        } catch (SQLException e) {
            errortxt.setText(e.getMessage());
        }
    }
    
    
    
    @FXML
    public void BackButton(Event event) throws IOException{
        Parent window;
        window = FXMLLoader.load(getClass().getResource("signIn.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
}
