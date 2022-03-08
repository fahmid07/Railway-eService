import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class JourneyInfo {

    int j_id, j_train, j_coach, j_vacancy, t_id, from_st, to_st, c_id, c_fare;
    String j_date, t_name, startTime, endTime, c_name;



    public JourneyInfo(){}
    public JourneyInfo(ResultSet resultSet) throws SQLException{
        j_id = resultSet.getInt("j_id");
        j_train = resultSet.getInt("j_train");
        j_date = resultSet.getString("j_date");
        j_coach = resultSet.getInt("j_coach");
        j_vacancy = resultSet.getInt("j_vacancy");
        t_id = resultSet.getInt("t_id");
        t_name = resultSet.getString("t_name");
        from_st = resultSet.getInt("from_st");
        to_st = resultSet.getInt("to_st");
        startTime = resultSet.getString("startTime");
        endTime = resultSet.getString("endTime");
        c_id = resultSet.getInt("c_id");
        c_name = resultSet.getString("c_name");
        c_fare = resultSet.getInt("c_fare");

        setTrain_name(t_name);
        setDeparture_time(startTime);
        setArrival_time(endTime);
        setCoach_class(c_name);
        setFare(c_fare);
        setVacancy(j_vacancy);
    }

    private StringProperty train_name;
    public void setTrain_name(String train_name) {
        train_nameProperty().set(train_name);
    }
    public StringProperty getTrain_name() {
        return train_name;
    }
    public StringProperty train_nameProperty() {
        if (train_name == null) train_name = new SimpleStringProperty(this, "train_name");
        return train_name;
    }


    private StringProperty departure_time;
    public void setDeparture_time(String departure_time) {
        departure_timeProperty().set(departure_time);
    }
    public StringProperty getDeparture_time() {
        return departure_time;
    }
    public StringProperty departure_timeProperty() {
        if (departure_time == null) departure_time = new SimpleStringProperty(this, "departure_time");
        return departure_time;
    }

    private StringProperty arrival_time;
    public void setArrival_time(String arrival_time) {
        arrival_timeProperty().set(arrival_time);
    }
    public StringProperty getArrival_time() {
        return arrival_time;
    }
    public StringProperty arrival_timeProperty() {
        if (arrival_time == null) arrival_time = new SimpleStringProperty(this, "arrival_time");
        return arrival_time;
    }

    private StringProperty coach_class;
    public void setCoach_class(String coach_class) {
        coach_classProperty().set(coach_class);
    }
    public StringProperty getCoach_class() {
        return coach_class;
    }
    public StringProperty coach_classProperty() {
        if (coach_class == null) coach_class = new SimpleStringProperty(this, "coach_class");
        return coach_class;
    }

    private StringProperty vacancy;
    public void setVacancy(int vacancy) {
        vacancyProperty().set(Integer.toString(vacancy));
    }
    public StringProperty getVacancy() {
        return vacancy;
    }
    public StringProperty vacancyProperty() {
        if (vacancy == null) vacancy = new SimpleStringProperty(this, "vacancy");
        return vacancy;
    }

    private StringProperty fare;
    public void setFare(int fare) {
        fareProperty().set(Integer.toString(fare));
    }
    public StringProperty getFare() {
        return fare;
    }
    public StringProperty fareProperty() {
        if (fare == null) fare = new SimpleStringProperty(this, "fare");
        return fare;
    }


    public static ObservableList<JourneyInfo> getJourneysFromResultSet(ResultSet resultSet) throws SQLException{
        ObservableList<JourneyInfo> journeys = FXCollections.observableArrayList();
        while(resultSet.next()){
            journeys.add(new JourneyInfo(resultSet));
        }
        return journeys;
    }
}
