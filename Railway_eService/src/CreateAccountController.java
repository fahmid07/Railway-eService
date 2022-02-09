import java.io.IOException;
import java.sql.SQLException;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class CreateAccountController {
    
    public TextField nametxt, emailtxt, mobiletxt, nidtxt;
    public Label errortxt; 
    public PasswordField passtxt, conpasstxt;

    public void BackButton(Event event) throws IOException{
        Parent window;
        window = FXMLLoader.load(getClass().getResource("SignIn.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }

    public void CreateButton(Event event) throws IOException{
        String name = nametxt.getText();
        String email = emailtxt.getText();
        String mobile = mobiletxt.getText();
        String pass = passtxt.getText();
        String conpass = conpasstxt.getText();
        String nid = nidtxt.getText();

        if(pass.equals(conpass)){
            User user = new User(name, email, mobile, pass, nid);
            try {
                user.insert();
                errortxt.setText("Successfully signed up!");
                Parent window;
                window = FXMLLoader.load(getClass().getResource("SignIn.fxml"));

                Stage mainStage;
                mainStage = App.parentWindow;
                mainStage.getScene().setRoot(window);

            } catch (SQLException e) {
                errortxt.setText(e.getMessage());
            }
        }
        else{
            errortxt.setText("Passwords do not match");
        }

        
    }
}
