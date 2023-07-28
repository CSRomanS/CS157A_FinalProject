package Database;
import java.sql.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class DBConnect {
    // connection URL
    final static String host = "localhost";
    final static String port = "3306";
    final static String dbName = "AEB";
    final static String mysqlURL = "jdbc:mysql://"+host+":"+port+"/"+dbName;

    // connection login
    final static String username = "jdbcUser";
    final static String password = "cs157a";

    /**
     * Returns a connection to the database. (Must be closed manually)
     * @return a connection to the database.
     */
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

    public static void createAccount(Connection con) throws java.sql.SQLException{
        // Logins
        String userName = "UserNameTest";
        String passWord = "pass";
        String salt = "rand"; // replace with random string generator

        // User Info
        String FirstName = "FirstName";
        String LastName = "LastName";
        String ALineOne = "1234 Test St";
        String City = "tCity";
        String State = "CA";
        int ZipCode = 94000;

        // SQL Statements
        Statement statement = con.createStatement();
        statement.executeUpdate("INSERT INTO Users(FirstName, LastName, AddressLineOne, City, State, ZipCode)" +
                                    "VALUES ('"+FirstName+"','"+LastName+"','"+ALineOne+"','"+City+"','"+State+"','"+ZipCode+"')",
                                    Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys();
        rs.next();
        int userID=rs.getInt(1);
        statement.executeUpdate("INSERT INTO Logins(UserName, PassWord, Salt, UserID)"+
                                "VALUES ('"+userName+"','"+passWord+"','"+salt+"','"+userID+"')");
        statement.close();
    }


    /**
     * Creates the database for the first time
     */
    public static void CreateDatabase(){
        // ensures the class is loaded
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading driver: " + cnfe);
        }
        // Attempt connection and run script
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://"+host+":"+port, username, password);
            Statement statement = connection.createStatement();

            // Runs each statement individually seperated by ';'
            String script = loadSQL("DatabaseCreation.sql");
            if(script != null) {
                for (String i : script.split(";")){
                    statement.executeUpdate(i);
                }
            }

            // close
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }
    }

    /**
     * Loads an SQL statement from the SQL folder in the working directory
     * @param sqlFile Name of the file to load
     * @return String containing the SQL file contents
     */
    public static String loadSQL(String sqlFile){
        // get path
        Path filePath = Paths.get(System.getProperty("user.dir"),"SQL",sqlFile);
        try {
            return Files.readString(filePath);
        } catch(java.io.IOException e){
            System.out.println(e.getMessage());
            return null; // file not found
        }
    }
}
