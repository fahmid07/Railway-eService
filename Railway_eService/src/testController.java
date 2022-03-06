import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class testController implements Initializable{


    public TableColumn<test, String> oneFX;
    public TableColumn<test, String> twoFX;

    public TableView<test> TestTable;

    ObservableList<test> obs1;
    ArrayList<test> obs = new ArrayList<test>();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        try {
            load();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void load() throws SQLException{
        
        if(obs.size() > 0) obs.clear();
        int t = 2;
        while(t>0){
            String one = "hi";
            String two = "hi";
            test tf = new test(one, two);
            obs.add(tf);
            t--;
        }
        obs1 = FXCollections.observableArrayList(obs);

        oneFX.setCellValueFactory(new PropertyValueFactory<test, String>("one"));
        twoFX.setCellValueFactory(new PropertyValueFactory<test, String>("two"));

        TestTable.setItems(obs1);
    }
}
