import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
public class DBWork {
    public Statement getCon() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/javaend";
            Properties authorization = new Properties();
            authorization.put("user", "postgres");
            authorization.put("password", "123123");
            Connection conn = DriverManager.getConnection(url, authorization);
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            //System.out.println("asdasdasd");
            return statement;

        }
        catch(Exception e){
            //System.out.println("Connection lost");
        }
        return null;
    }
    public void InsertUser(User user){
        Statement statement = getCon();
        try{
            String query = "INSERT INTO users VALUES(DEFAULT, '" + user.getName() + "', '" + user.getName() + "'," + user.getSum() + ")";
            ResultSet table = statement.executeQuery(query);
            //System.out.println("djbh");
        }catch(Exception e){

        }
    }
    public User CurrUser(String name, String phone){
        Statement statement = getCon();
        try{
            String query = "SELECT * FROM users WHERE name = '" + name + "' AND phone = '" + phone + "'";
            ResultSet table = statement.executeQuery(query);
            User currUser = new User();
            table.beforeFirst();
            while(table.next()){
                currUser.setId(Integer.parseInt(table.getString(1)));
                currUser.setName(table.getString(2));
                currUser.setPhone(table.getString(3));
                currUser.setSum(Integer.parseInt(table.getString(4)));
                return currUser;
            }
        }catch(Exception e){
            //System.out.println(e);
        }
        return null;
    }
    public void AddSum(User user, int SumIt){
        Statement statement = getCon();
        try{
            user.setSum((int) (user.getSum() + 0.1 * SumIt));
            String query = "UPDATE users SET sum = " + user.getSum() + " WHERE id = " + user.getId();
            ResultSet a = statement.executeQuery(query);
        }catch(Exception e){

        }
    }
    public void InsertItem(Items item){
        Statement statement = getCon();
        try{
            String query = "INSERT INTO items VALUES(DEFAULT, '" + item.getName()  + "', " + item.getSum() + ")";
            ResultSet table = statement.executeQuery(query);
            //System.out.println("djbh");
        }catch(Exception e){
            //System.out.println(e);
        }
    }
    public int GetCost(int id){
        Statement statement = getCon();
        try{
            String query = "SELECT sum FROM items WHERE id = " + id;
            ResultSet table = statement.executeQuery(query);
            while(table.next()) {
                return Integer.parseInt(table.getString(1));
            }
        }catch(Exception e){

        }
        return 0;
    }


}