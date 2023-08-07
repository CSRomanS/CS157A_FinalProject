import Database.WishListDao;

public class Main {
    public static void main(String[] args) {
        try {
            //DBAccess.createAccount("userTest", "passTest", "fTest", "lTest", "164 Test St.", "cTest", "sTest", 94000);
            //DBAccess.createReview(4, "Review Text Test", "NULL", 1, 1);
            //DBAccess.createHelpful(1, 1, true);
            //DBAccess.addToCart(1, 4, 5);
            //DBAccess.placeOrder(1);
            //System.out.println(DBAccess.verifyLogin("userTest", "passTest"));
            //DBAccess.scheduleItem(1, 5, 1);
            //DBAccess.removeFromCart(1, 2);
            //DBAccess.addToWishList(1, 4);
            //DBAccess.removeFromWishList(1, 4);
            /*
            WishListDao wl = new WishListDao();
            wl.removeWishListById(1, 3);
            System.out.println(wl.getWishListByUserID(1));
            */

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}