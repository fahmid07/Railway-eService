import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CoachviewController implements Initializable{
    
    public ImageView test;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String imageSource = "https://media.istockphoto.com/photos/train-picture-id903338678?k=20&m=903338678&s=612x612&w=0&h=16f7fAXKQY3WUK0hiaRFweBM8Dpv7XznA8vZgWgcnas=";
        Image image = new Image(imageSource);
        test.setImage(image);
    }


}
