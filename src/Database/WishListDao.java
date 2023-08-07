package Database;

import entity.CartItem;
import entity.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WishListDao {
    private UserDao uDao = new UserDao();

    /**
     * get all the wishlist items by userID
     *
     * @param userID
     * @return
     */
    public List<entity.CartItem> getWishListByUserID(Integer userID) {
        List<CartItem> cItems = new ArrayList<CartItem>();

        Connection con = DBConnect.Connect();

        try {
            Statement statement = con.createStatement();
            statement.executeQuery(
                    "SELECT w.UserID, w.ItemID, i.ItemName, i.CategoryDescription, i.CoverPicture FROM wishlistitems w, items i WHERE i.ItemID = w.ItemID AND w.UserID = "
                            + userID + ";");
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                CartItem c = new CartItem();
                Item i = new Item();
                c.setUserID(rs.getInt(1));
                i.setItemID(rs.getInt(2));
                i.setItemName(rs.getString(3));
                i.setCategoryDescription(rs.getString(4));
                i.setCoverPicture(rs.getString(5));
                c.setItem(i);
                cItems.add(c);
            }

            DBConnect.close(con, statement, rs);

            return cItems;
        } catch (java.sql.SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public boolean addWishListById(int userID, int itemID){
        Connection con = DBConnect.Connect();
        if(con == null) return false;
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO WishListItems(UserID, itemID)" +
                    "VALUES ('" + userID + "','" + itemID + "')");
            statement.close();
            con.close();
            return true;
        } catch (java.sql.SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean removeWishListById(int userID, int itemID){
        Connection con = DBConnect.Connect();
        if(con == null) return false;
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate("DELETE FROM WishListItems " +
                    "WHERE UserID='" + userID + "' AND ItemID='" + itemID + "';");
            statement.close();
            con.close();
            return true;
        } catch (java.sql.SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
    }
}
