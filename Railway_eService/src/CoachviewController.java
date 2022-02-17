import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CoachviewController implements Initializable{
    
    public ImageView image1, image2;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String imageSource = "https://media.istockphoto.com/photos/train-picture-id903338678?k=20&m=903338678&s=612x612&w=0&h=16f7fAXKQY3WUK0hiaRFweBM8Dpv7XznA8vZgWgcnas=";
        Image img1 = new Image(imageSource);
        image1.setImage(img1);

        /*String imageSource2 = "";
        Image img2 = new Image(imageSource2);
        image2.setImage(img2);*/
    }

    public void BackButton(Event event) throws IOException {
        Parent window;
        window = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }

}
