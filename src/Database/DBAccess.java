package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Holds an item in a cart
 */
class CartItem{
    int itemID;
    int itemCount;
    String itemName;
    float normalPrice;
    Float salePrice;

    CartItem(int inItemID, int inItemCount, String inItemName, float inNormalPrice, Float inSalePrice){
        this.itemID = inItemID;
        this.itemCount = inItemCount;
        this.itemName = inItemName;
        this.normalPrice = inNormalPrice;
        this.salePrice = inSalePrice;
    }

    CartItem(){}

    public String toString(){
        return itemID +" - "+ itemCount +" - "+ itemName +" - "+ normalPrice +" - "+ salePrice;
    }
}

public class DBAccess {
    /**
     * Puts an item into scheduled orders for the user
     * @param userID the user ID of the user scheduling an order
     * @param itemID the item ID the user wants to order
     * @param itemQuantity the amount of items to buy each time
     * @return true if succesfully inserted, false otherwise
     */
    public static boolean scheduleItem(int userID, int itemID, int itemQuantity){
        Connection con = DBConnect.Connect();
        if(con == null) return false;
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO ScheduledOrders(UserID, ItemID, ItemQuantity) " +
                                        "VALUES ('" + userID + "','" + itemID + "','" + itemQuantity + "')");
            statement.close();
            con.close();
            return true;
        } catch (java.sql.SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
    }

    /**
     * Verifies a username/password combo
     * @param username string containing the username
     * @param password string containing the password
     * @return -1 on failure (incorrect password/username, sqlerror), the userID on success
     */
    public static int verifyLogin(String username, String password){
        Connection con = DBConnect.Connect();
        if(con == null) return -1;
        try {
            Statement statement = con.createStatement();
            statement.executeQuery("SELECT UserID FROM logins " +
                                        "WHERE username='"+username+"' AND PassWord='"+ password+"';");
            ResultSet rs = statement.getResultSet();
            if(!rs.next()) return -1; // return -1 if no match found
            int userID = rs.getInt(1); // get userID
            statement.close();
            con.close();
            return userID;
        } catch (java.sql.SQLException e){
            System.err.println(e.getMessage());
            return -1;
        }
    }

    /**
     * Creates a new account by inserting into accounts and login
     * @param username
     * @param pass
     * @param fName firstname
     * @param lName lastName
     * @param aLine Address Line one
     * @param city
     * @param state
     * @param zip
     * @return
     */
    public static boolean createAccount(String username, String pass, String fName, String lName, String phoneNum, String email, String aLine, String city, String state, int zip){
        // SQL Statements
        Connection con = DBConnect.Connect();
        if(con == null) return false;
        try {
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO Users(FirstName, LastName, PhoneNum, Email, AddressLineOne, City, State, ZipCode)" +
                            "VALUES ('" + fName + "','" + lName + "','" + phoneNum + "','" + email + "','" + aLine + "','" + city + "','" + state + "','" + zip + "')",
                    Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            int userID = rs.getInt(1);
            statement.executeUpdate("INSERT INTO Logins(UserName, PassWord, UserID)" +
                    "VALUES ('" + username + "','" + pass + "','" + userID + "')");

            // close and return
            rs.close();
            statement.close();
            con.commit();
            return true;
        } catch (java.sql.SQLException e){
            System.err.println(e.getMessage());
            try{
                con.rollback();
            } catch (SQLException sqle){
                System.err.println(e.getMessage());
            } finally {
                try{
                    con.commit();
                    con.close();
                } catch (SQLException sqle) {
                    System.err.println(e.getMessage());
                }
            }
            return false;
        }
    }

    /**
     * Create a review between a user and item
     * @param sRating The star rating 1-5
     * @param rText Review text (optional)
     * @param picture Picture Link (optional)
     * @param authID userID of the author
     * @param itemID itemID the user is reviewing
     * @return true if successful, false otherwise
     */
    public static boolean createReview(int sRating, String rText, String picture, int authID, int itemID){
        Connection con = DBConnect.Connect();
        if(con == null) return false;
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO Reviews(StarRating, ReviewText, Picture, AuthorID, ItemID)" +
                    "VALUES ('" + sRating + "','" + rText + "','" + picture + "','" + authID + "','" + itemID + "')");
            statement.close();
            con.close();
            return true;
        } catch (java.sql.SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
    }

    /**
     * Votes on a review as helpful or not
     * @param userID user ID of the user doing the voting
     * @param reviewID the review the user is voting on
     * @param helpful wether to vote helpful or not
     * @return true if succesful, false on sql failure
     */
    public static boolean createHelpful(int userID, int reviewID, boolean helpful){
        Connection con = DBConnect.Connect();
        if(con == null) return false;
        int hInt;
        if(helpful) hInt = 1;
        else hInt = 0;
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO HelpfulVotes(UserID, ReviewID, Helpful)" +
                    "VALUES ('" + userID + "','" + reviewID + "','" + hInt + "')");
            statement.close();
            con.close();
            return true;
        } catch (java.sql.SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
    }

    /**
     * Adds an item to the user's cart
     * @param userID the ID of the user
     * @param itemID the ID of the item
     * @param itemCount the amount of items to add to cart
     * @return true if successful, false otherwise
     */
    public static boolean addToCart(int userID, int itemID, int itemCount){
        Connection con = DBConnect.Connect();
        if(con == null) return false;
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO shoppingcarts(UserID, itemID, itemCount)" +
                                        "VALUES ('" + userID + "','" + itemID + "','" + itemCount + "')");
            statement.close();
            con.close();
            return true;
        } catch (java.sql.SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
    }

    public static boolean removeFromCart(int userID, int itemID){
        Connection con = DBConnect.Connect();
        if(con == null) return false;
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate("DELETE FROM shoppingcarts " +
                                        "WHERE UserID='" + userID + "' AND ItemID='" + itemID + "';");
            statement.close();
            con.close();
            return true;
        } catch (java.sql.SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
    }

    public static boolean addToWishList(int userID, int itemID){
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

    public static boolean removeFromWishList(int userID, int itemID){
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

    /**
     * Places an order based on a user's shopping cart
     * @param userID the user ID of the user that is ordering
     * @return true if successful, false on error
     */
    public static boolean placeOrder(int userID){
        Connection con = DBConnect.Connect();
        try {
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            ResultSet reSet = statement.executeQuery("SELECT S.ItemID, S.ItemCount, I.ItemName, I.Price, I.SalePrice "+
                    "FROM ShoppingCarts S, Items I "+
                    "WHERE S.ItemID=I.ItemID AND S.UserID='" + userID + "';");
            ArrayList<CartItem> cartContents = new ArrayList<CartItem>(); // holds a list of items in the shopping art
            double cartSum = 0.0; // holds the order total
            while(reSet.next()){ // add on items to the list
                CartItem temp = new CartItem();
                temp.itemID = reSet.getInt(1);
                temp.itemCount = reSet.getInt(2);
                temp.itemName = reSet.getString(3);
                temp.normalPrice = reSet.getFloat(4);
                java.math.BigDecimal saleTemp = (java.math.BigDecimal) reSet.getObject(5);
                //System.out.println(temp.normalPrice);
                // handles sale price, necessary to avoid returning 0.0 when sale is NULL
                if(saleTemp == null){
                    temp.salePrice = null;
                    cartSum += temp.itemCount * temp.normalPrice;
                } else {
                    temp.salePrice = saleTemp.floatValue();
                    cartSum += temp.itemCount * temp.salePrice;
                }
                cartContents.add(temp); // add items to the list
            }
            // return false if shopping cart is empty
            if(cartContents.isEmpty()) return false;

            // Get user address info
            reSet = statement.executeQuery("SELECT AddressLineOne, City, `State`, ZipCode "+
                    "FROM Users "+
                    "WHERE UserID='" + userID + "';");
            reSet.next();
            String addressOne = (String) reSet.getObject(1);
            String city = (String) reSet.getObject(2);
            String state = (String) reSet.getObject(3);
            Integer zip = (Integer) reSet.getObject(4);

            // get tax rate from the state info
            reSet = statement.executeQuery("SELECT Tax "+
                    "FROM Taxes "+
                    "WHERE State='" + state + "';");
            if(!reSet.next()) { // rollback, close, and return false if result is empty
                con.rollback();
                statement.close();
                reSet.close();
                con.close();
                return false;
            }
            float taxRate = reSet.getFloat(1);

            // insert info into Orders
            statement.executeUpdate("INSERT INTO Orders(Cost, Taxes, AddressLineOne, City, State, ZipCode, UserID)" +
                            "VALUES ('" + cartSum + "','" + cartSum*taxRate + "','" + addressOne + "','" + city + "','" + state + "','" + zip + "','" + userID + "')",
                    Statement.RETURN_GENERATED_KEYS);

            // Get generated orderID
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            int orderID = rs.getInt(1);

            // add items to the orderItems table
            StringBuilder itemsString = new StringBuilder();
            CartItem firstItem = cartContents.get(0);
            cartContents.remove(0);
            itemsString.append(String.format("(%d, %d, %.2f, %d)", firstItem.itemID, firstItem.itemCount, (firstItem.salePrice!=null)?firstItem.salePrice:firstItem.normalPrice, orderID)); // insert first item
            for(CartItem c:cartContents){ // insert the rest of the items if there are any
                itemsString.append(String.format(", (%d, %d, %.2f, %d)", c.itemID, c.itemCount, (c.salePrice!=null)?c.salePrice:c.normalPrice, orderID));
            }
            itemsString.append(";");
            //System.out.println(itemsString.toString());
            statement.executeUpdate("INSERT INTO OrderItems(ItemID, ItemCount, ItemCost, OrderID)" +
                    "VALUES " + itemsString.toString());

            // Clear the user's shopping cart
            statement.executeUpdate("DELETE FROM ShoppingCarts " +
                                        "WHERE UserID='" + userID + "';");

            con.commit(); // commits the statements

            // close stuff
            reSet.close();
            statement.close();
            return true;
        } catch (java.sql.SQLException e){
            System.err.println(e.getMessage());
            try{
                con.rollback();
            } catch (SQLException sqle){
                System.err.println(e.getMessage());
            } finally {
                try{
                    con.commit();
                    con.close();
                } catch (SQLException sqle) {
                    System.err.println(e.getMessage());
                }
            }
            return false;
        }
    }
}
