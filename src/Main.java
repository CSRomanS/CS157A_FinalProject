import Database.DBConnect;
import java.sql.Connection;
public class Main {
    public static void main(String[] args) {
        Connection con = DBConnect.Connect();
        try {
            DBConnect.createAccount(con);
            con.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}