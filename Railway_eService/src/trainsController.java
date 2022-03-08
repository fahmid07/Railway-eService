import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TrainsController implements Initializable {

    public TableView<JourneyInfo> table;
    public TableColumn<JourneyInfo, String> t_name_col, d_time_col, a_time_col, class_col, vacancy_col, fare_col;
    public Label fromtxt, totxt, datetxt;

    ObservableList<JourneyInfo> rows;
    public static JourneyInfo selected;

    public void BackButton(Event event) throws IOException {
        Parent window;
        window = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

        Stage mainStage;
        mainStage = App.parentWindow;
        mainStage.getScene().setRoot(window);
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        fromtxt.setText("From: " + purchaseController.from);
        totxt.setText("To: " + purchaseController.to);
        datetxt.setText("Date: " + purchaseController.formattedDate);
        // TODO Auto-generated method stub
        try {
            load();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        table.getItems().clear();
        table.getItems().addAll(rows);

        t_name_col.setCellValueFactory(new PropertyValueFactory<JourneyInfo, String>("train_name"));
        d_time_col.setCellValueFactory(new PropertyValueFactory<JourneyInfo, String>("departure_time"));
        a_time_col.setCellValueFactory(new PropertyValueFactory<JourneyInfo, String>("arrival_time"));
        class_col.setCellValueFactory(new PropertyValueFactory<JourneyInfo, String>("coach_class"));
        vacancy_col.setCellValueFactory(new PropertyValueFactory<JourneyInfo, String>("vacancy"));
        fare_col.setCellValueFactory(new PropertyValueFactory<JourneyInfo, String>("fare"));
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
        rows = JourneyInfo.getJourneysFromResultSet(resultSet);
    }

    public void mouseOnClick(MouseEvent event){
        if(event.getClickCount() == 1){
            selected = table.getSelectionModel().getSelectedItem();
            //System.out.println("**************************************** " + selected.getTrain_name());
             try {
                 Parent window;
                 window = FXMLLoader.load(getClass().getResource("FinalPurchase.fxml"));

                 Stage mainStage;
                 mainStage = App.parentWindow;
                 mainStage.getScene().setRoot(window);
             } catch (IOException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             }
        }
    }
}
