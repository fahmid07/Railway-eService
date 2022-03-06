import java.sql.SQLException;

public class Train {
    
    public int id;
    public String name, start, end;
    public int from, to;

    public Train(int id, String name, int from, int to, String start, String end) {
        this.id = id;
        this.name = name;
        this.from = from;
        this.to = to;
        this.start = start;
        this.end = end;
    }

    public int get_id() {
        return this.id;
    }

    public String get_name() {
        return this.name;
    }

    public int get_from() {
        return this.from;
    }

    public int get_to() {
        return this.to;
    }

    public String get_start() {
        return this.start;
    }

    public String get_end() {
        return this.end;
    }

    public void insert() throws SQLException {
        String query = "insert into \"train\"(name, from, to, start, end) values('" + name + "', '" + from + "', '" + to + "', '" + start + "', '" + end + "');";
        DBConnector conn = new DBConnector();
        conn.createStatement().executeUpdate(query);
    }
}
