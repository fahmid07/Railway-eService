import java.sql.SQLException;

public class Coach {
    
    public int id;
    public String name;

    public Coach(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int get_id() {
        return this.id;
    }

    public String get_name() {
        return this.name;
    }

    public void insert() throws SQLException {
        String query = "insert into \"coach\"(name) values('" + name + "');";
        DBConnector conn = new DBConnector();
        conn.createStatement().executeUpdate(query);
    }
    
}
