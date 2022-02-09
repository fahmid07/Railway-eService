import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class UpdateAccountController  implements Initializable {
    public TextField nametxt, emailtxt, mobiletxt, nidtxt;
    public Label errortxt; 
    public PasswordField passtxt, conpasstxt;

    public void BackButton(Event event) throws IOException{
        Parent window;
        window = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

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

        if(pass.equals(conpass) && !name.equals("") && !email.equals("") && !mobile.equals("") && !pass.equals("") && !conpass.equals("") && !nid.equals("")){
            User user = new User(name, email, mobile, pass, nid);
            try {
                user.update();
                SignInController.userObj = user;
                errortxt.setText("Done!");
                Parent window;
                window = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

                Stage mainStage;
                mainStage = App.parentWindow;
                mainStage.getScene().setRoot(window);

            } catch (SQLException e) {
                errortxt.setText(e.getMessage());
            }
        }
        else{
            errortxt.setText("Passwords do not match or a field may be empty");
        }    
    }

    public void DeleteButton(Event event) throws IOException, SQLException{
        SignInController.userObj.delete();

        Parent window;
        window = FXMLLoader.load(getClass().getResource("SignIn.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        nametxt.setText(SignInController.userObj.name);
        emailtxt.setText(SignInController.userObj.email);
        mobiletxt.setText(SignInController.userObj.mobile);
        passtxt.setText(SignInController.userObj.get_pass());
        nidtxt.setText(SignInController.userObj.nid);
    }
}
