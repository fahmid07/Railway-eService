import java.io.IOException;
import java.sql.SQLException;

//import javax.sound.sampled.SourceDataLine;

//import com.microsoft.sqlserver.jdbc.dataclassification.Label;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class SignInController {
    
    public TextField mobiletxt;
    public Label errortxt; 
    public PasswordField passtxt;

    public static String usermobile = null;
    public static User userObj;
    public static int uid = 0;

    public void SignInButton(Event event) throws IOException{
        String mobile = mobiletxt.getText();
        String pass = passtxt.getText();

        try {
            User user = User.get_info(mobile);
            if(user.get_pass().equals(pass)){
                System.out.println("Hoye gese");
                usermobile = mobile;
                userObj = user;
                uid = user.get_id();
                Parent window;
                window = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

                Stage mainStage;
                mainStage = App.parentWindow;
                mainStage.getScene().setRoot(window);

            }
            else{
                errortxt.setText("Wrong username or password");
            }
        } catch (SQLException e) {
            errortxt.setText(e.getMessage());
        }
    }

    public void SignUpButton(Event event) throws IOException{
        Parent window;
        window = FXMLLoader.load(getClass().getResource("createAccount.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }

    public void adminLoginButton(Event event) throws IOException{
        Parent window;
        window = FXMLLoader.load(getClass().getResource("adminLogin.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }
}
