import java.sql.SQLException;

public class Station {
    public int id;
    public String name, master, number;

    public Station(int id, String name, String master, String number) {
        this.id = id;
        this.name = name;
        this.master = master;
        this.number = number;
    }

    public int get_id() {
        return this.id;
    }

    public String get_name() {
        return this.name;
    }

    public String get_master() {
        return this.master;
    }

    public String get_number() {
        return this.number;
    }

    public void insert() throws SQLException {
        String query = "insert into \"station\"(name, master, number) values('" + name + "', '" + master + "', '" + number + "');";
        DBConnector conn = new DBConnector();
        conn.createStatement().executeUpdate(query);
    }

    
}
