import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    DBConnector connector;

    private int id;
    public String name, email, mobile, nid;
    private String pass;

    public User(){
        id = 0;
        name = null;
        email = null;
        mobile = null;
        pass = null;
        nid = null;
    }

    public User(String name, String email, String mobile, String pass, String nid){
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.pass = pass; 
        this.nid = nid;
    }

    public int get_id(){
        return this.id;
    }

    public User(int id) throws SQLException {
        this.id = id;
    }
    
    public static User get_id(int id) throws SQLException{
        return new User(id);
    }

    public String get_pass(){
        return this.pass;
    } 

    public void set_pass(String pass){
        this.pass = pass;
    }

    public void insert() throws SQLException{
        String query = "insert into \"user\"(name, email, mobile, pass, nid) values('" + name + "', '" + email + "', '" + mobile + "', '" + pass + "', '" + nid + "');";
        DBConnector conn = new DBConnector();
        conn.createStatement().executeUpdate(query);
    }
   
    public void update() throws SQLException{
        String new_id = String.valueOf(SignInController.uid);

        String query= "update \"user\" set name='" + name + "', email='" + email + "', mobile='" + mobile + "', pass='" + pass + "', nid='" + nid + "' where id=" + new_id + ";";
        System.out.println(query);
        DBConnector conn = new DBConnector();
        conn.createStatement().executeUpdate(query);
    }

    public void delete() throws SQLException{
        String query = "delete from \"user\" where id=" + id;
        DBConnector conn = new DBConnector();
        conn.createStatement().execute(query);
    }

    private void convert_User(ResultSet resultSet) throws SQLException{
        id = resultSet.getInt("id");
        name = resultSet.getString("name");
        email = resultSet.getString("email");
        mobile = resultSet.getString("mobile");
        pass = resultSet.getString("pass");
        nid = resultSet.getString("nid");
    }

    public static User get_info(String mobile) throws SQLException{
        String query = "select * from \"user\" where mobile='" + mobile + "'";
        DBConnector con = new DBConnector();
        ResultSet resultSet = con.createStatement().executeQuery(query);
        resultSet.next();
        User user = new User();
        user.convert_User(resultSet);
        return user;
    }
}
