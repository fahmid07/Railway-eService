import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class trainsController implements Initializable{

    private TableColumn<JourneyInfo, String> trainFX;
    private TableColumn<JourneyInfo, String> classFX;
    private TableColumn<JourneyInfo, String> startFX;
    private TableColumn<JourneyInfo, String> endFX;
    private TableColumn<JourneyInfo, String> fareFX;

    private TableView<JourneyInfo> TrainTable;

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
        DBConnector con = new DBConnector();
        ResultSet resultSet = con.createStatement().executeQuery(query1);
        int station1 = resultSet.getInt("s_id");
        resultSet = con.createStatement().executeQuery(query2);
        int station2 = resultSet.getInt("s_id");

        String query = "select * from journey join train on journey.j_train=train.t_id join coach on coach.c_id=journey.j_coach where from_st=" + String.valueOf(station1) + " and to_st=" + String.valueOf(station2) + " and j_date='" + purchaseController.formattedDate + "'";
        resultSet = con.createStatement().executeQuery(query);
    }
}
