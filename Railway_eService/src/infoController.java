import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class infoController implements Initializable{
    
    public DatePicker dateFX;
    public ChoiceBox<String> fromstFX;
    public ChoiceBox<String> tostFX;
    public static ObservableList<String> fromst = FXCollections.observableArrayList();
    public static ObservableList<String> tost = FXCollections.observableArrayList();
    public static ArrayList<String> st1 = new ArrayList<>();
    public static ArrayList<String> st2 = new ArrayList<>();

    public static String from = null;
    public static String to = null;
    public static String date = null;
    public static String formattedDate = null;

    public void BackButton(Event event) throws IOException {
        Parent window;
        window = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        fromstFX.getItems().clear();
        tostFX.getItems().clear();
        fromst.clear();
        tost.clear();

        System.out.println(fromstFX.getItems().size());
        System.out.println(tostFX.getItems().size());
        try {
            getStations();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void getStations() throws SQLException {
        st1.clear();
        st2.clear();
        String query = "Select * from station";
        DBConnector con = new DBConnector();
        ResultSet resultSet = con.createStatement().executeQuery(query);
        while(resultSet.next()){
            int id = resultSet.getInt("s_id");
            String name = resultSet.getString("s_name");
            String master = resultSet.getString("s_master");
            String number = resultSet.getString("sm_number");

            Station station = new Station(id, name, master, number);
            st1.add(name);
            st2.add(name);
        }

        fromst.clear();
        tost.clear();

        for(String ss : st1){
            fromst.add(ss);
        }
        for(String ss : st2){
            tost.add(ss);
        }

        fromstFX.getItems().clear();
        fromstFX.setItems(fromst);
        tostFX.getItems().clear();
        tostFX.setItems(tost);
    }

    public void SearchButton(Event event) throws IOException, ParseException {
        from = fromstFX.getValue();
        to = tostFX.getValue();
        date = dateFX.getValue().toString();

        if(from != null && to != null && date != null){
            //DateFormat originalFormat = new SimpleDateFormat("MM/dd/yyyy");
            //DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
            //Date d = (Date) originalFormat.parse(date);
            //formattedDate = targetFormat.format(d);
            formattedDate = date;
            System.out.println(formattedDate);

            Parent window;
            window = FXMLLoader.load(getClass().getResource("trainsInfo.fxml"));

            Stage mainStage;
            mainStage = App.parentWindow;
            mainStage.getScene().setRoot(window);
        }
    }
}
