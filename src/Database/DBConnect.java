package Database;
import java.sql.*;

public class DBConnect {
    // connection URL
    final static String host = "localhost";
    final static String port = "3306";
    final static String dbName = "test";
    final static String mysqlURL = "jdbc:mysql://"+host+":"+port+"/"+dbName;

    // connection login
    final static String username = "jdbcUser";
    final static String password = "cs157a";
    public static Connection Connect() {
        // ensures the class is loaded
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading driver: " + cnfe);
        }

        // Attempt connection
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(mysqlURL, username, password);
        } catch (SQLException e){
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }
        return connection;
    }
}
