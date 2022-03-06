import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class trainsController implements Initializable{

    /*public TableColumn<JourneyInfo, String> trainFX;
    public TableColumn<JourneyInfo, String> classFX;
    public TableColumn<JourneyInfo, String> startFX;
    public TableColumn<JourneyInfo, String> endFX;
    public TableColumn<JourneyInfo, String> fareFX;

    public TableView<JourneyInfo> TrainTable;*/
    @FXML
    private TableColumn<TestJourneyInfo, String> trainFX;
    @FXML
    private TableColumn<TestJourneyInfo, String> classFX;
    @FXML
    private TableColumn<TestJourneyInfo, String> startFX;
    @FXML
    private TableColumn<TestJourneyInfo, String> endFX;
    @FXML
    private TableColumn<TestJourneyInfo, String> fareFX;
    @FXML
    private TableView<TestJourneyInfo> TrainTable;

    ObservableList<JourneyInfo> obs1;
    ArrayList<JourneyInfo> obs = new ArrayList<JourneyInfo>();

    ObservableList<TestJourneyInfo> Tobs1;
    ArrayList<TestJourneyInfo> Tobs = new ArrayList<TestJourneyInfo>();

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
        String query1 = "select s_id from station where s_name='"+ purchaseController.from + "'";
        String query2 = "select s_id from station where s_name='"+ purchaseController.to + "'";
        //System.out.println(query1);
        //System.out.println(query2);
        DBConnector con = new DBConnector();
        ResultSet resultSet = con.createStatement().executeQuery(query1);
        resultSet.next();
        int station1 = resultSet.getInt("s_id");
        resultSet = con.createStatement().executeQuery(query2);
        resultSet.next();
        int station2 = resultSet.getInt("s_id");

        String query = "select * from journey join train on journey.j_train=train.t_id join coach on coach.c_id=journey.j_coach where from_st=" + String.valueOf(station1) + " and to_st=" + String.valueOf(station2) + " and j_date='" + purchaseController.formattedDate + "'";
        resultSet = con.createStatement().executeQuery(query);
        System.out.println(query);
        //TrainTable.getItems().clear();
        if(obs.size() > 0) obs.clear();
        while(resultSet.next()){
            int j_id = resultSet.getInt("j_id");
            int j_train = resultSet.getInt("j_train");
            String j_date = resultSet.getString("j_date");
            int j_coach = resultSet.getInt("j_coach");
            int j_vacancy = resultSet.getInt("j_vacancy");
            int t_id = resultSet.getInt("t_id");
            String t_name = resultSet.getString("t_name");
            int from_st = resultSet.getInt("from_st");
            int to_st = resultSet.getInt("to_st");
            String startTime = resultSet.getString("startTime");
            String endTime = resultSet.getString("endTime");
            int c_id = resultSet.getInt("c_id");
            String c_name = resultSet.getString("c_name");
            int c_fare = resultSet.getInt("c_fare");
            String fare = String.valueOf(c_fare);

            JourneyInfo journeyInfo = new JourneyInfo(j_id, j_train, j_coach, j_vacancy, j_date, t_name, startTime, endTime, c_name, t_id, from_st, to_st, c_id, c_fare, fare);
            System.out.println(t_name + " " + c_name);
            obs.add(journeyInfo);

            TestJourneyInfo tf = new TestJourneyInfo(t_name, c_name, startTime, endTime, c_fare);
            Tobs.add(tf);
        }
        obs1 = FXCollections.observableArrayList(obs);
        Tobs1 = FXCollections.observableArrayList(Tobs);

        /*trainFX.setCellValueFactory(new PropertyValueFactory<JourneyInfo, String>("t_name"));
        classFX.setCellValueFactory(new PropertyValueFactory<JourneyInfo, String>("c_name"));
        startFX.setCellValueFactory(new PropertyValueFactory<JourneyInfo, String>("startTime"));
        endFX.setCellValueFactory(new PropertyValueFactory<JourneyInfo, String>("endTime"));
        fareFX.setCellValueFactory(new PropertyValueFactory<JourneyInfo, String>("fare"));*/

        trainFX.setCellValueFactory(new PropertyValueFactory<>("t_name"));
        classFX.setCellValueFactory(new PropertyValueFactory<>("c_name"));
        startFX.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        endFX.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        fareFX.setCellValueFactory(new PropertyValueFactory<>("c_fare"));

        TrainTable.setItems(Tobs1);
    }

    public void CancelButton(Event event) throws IOException {
        Parent window;
        window = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }
}
