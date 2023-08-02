import Database.DBConnect;
import Database.DBAccess;
import java.sql.Connection;
public class Main {
    public static void main(String[] args) {
        try {
            //DBAccess.createAccount("userTest", "passTest", "fTest", "lTest", "164 Test St.", "cTest", "sTest", 94000);
            //DBAccess.createReview(4, "Review Text Test", "NULL", 1, 1);
            //DBAccess.createHelpful(1, 1, true);
            //DBAccess.addToCart(1, 4, 5);
            DBAccess.placeOrder(1);
           //System.out.println(DBAccess.verifyLogin("userTest", "passTest"));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}