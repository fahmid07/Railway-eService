import java.sql.SQLException;

public class Journey {
    
    public int id, train, coach, vacancy;
    public String date;

    public Journey(int id, int train, int coach, int vacancy, String date) {
        this.id = id;
        this.train = train;
        this.coach = coach;
        this.vacancy = vacancy;
        this.date = date;
    }

    public int get_id() {
        return this.id;
    }

    public int get_train() {
        return this.train;
    }

    public int get_coach() {
        return this.coach;
    }

    public int get_vacancy() {
        return this.vacancy;
    }

    public String get_date() {
        return this.date;
    }

    public void insert() throws SQLException {
        String query = "insert into \"journey\"(train, coach, vacancy, date) values('" + train + "', '" + coach + "', '" + vacancy + "', '" + date + "');";
        DBConnector conn = new DBConnector();
        conn.createStatement().executeUpdate(query);
    }

    
}
