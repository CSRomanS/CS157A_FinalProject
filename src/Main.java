import Database.DBConnect;
import java.sql.Connection;
public class Main {
    public static void main(String[] args) {
        Connection con = DBConnect.Connect();
        try {
            //DBConnect.createAccount(con, "userTest", "passTest", "fTest", "lTest", "164 Test St.", "cTest", "sTest", 94000);
            //DBConnect.createReview(con, 4, "Review Text Test", "NULL", 1, 1);
            //DBConnect.createHelpful(con, 1, 3, true);
            //DBConnect.addToCart(con, 1, 4, 5);
            DBConnect.placeOrder(con, 1);
            con.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}