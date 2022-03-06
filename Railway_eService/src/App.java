//import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application{

    public static Stage parentWindow;
    
    @Override
    public void start(Stage stage) throws Exception {
        parentWindow = stage;
        Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));  
        Scene scene = new Scene(root);
        
        //Image icon = new Image("images/logo.png");
        stage.setTitle("Railway e-service");
        //stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    

    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        launch(args);
        /*
        
        String sql = "insert into \"user\"(name, email, mobile, pass) values('Fahmidur Rahman', 'fahmidurrahman07@gmail.com', '01876096648', 'etaami');";
        DBConnector connector = new DBConnector();
        connector.createStatement().executeUpdate(sql);
        */
    }
}
