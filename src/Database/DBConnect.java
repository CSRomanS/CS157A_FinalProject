package Database;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnect {
	
	// connection URL
	private static String url;
	private static String username;
	private static String password;
	private static Properties pro = new Properties();
	
    static {
        try{

            pro.load(DBConnect.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            url = pro.getProperty("m_url");
            username = pro.getProperty("m_username");
            password = pro.getProperty("m_password");
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

	/**
	 * Returns a connection to the database. (Must be closed manually)
	 * 
	 * @return a connection to the database.
	 */
	public static Connection Connect() {

		// Attempt connection
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Error connecting to database");
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * Creates the database for the first time
	 */
	public static void CreateDatabase() {
		// ensures the class is loaded
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error loading driver: " + cnfe);
		}
		// Attempt connection and run script
		try {
			Connection connection = DriverManager.getConnection(url, username,
					password);
			Statement statement = connection.createStatement();

			// Runs each statement individually seperated by ';'
			String script = loadSQL("DatabaseCreation.sql");
			if (script != null) {
				for (String i : script.split(";")) {
					statement.executeUpdate(i);
				}
			}

			// close
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error connecting to database");
			e.printStackTrace();
		}
	}

	/**
	 * Loads an SQL statement from the SQL folder in the working directory
	 * 
	 * @param sqlFile Name of the file to load
	 * @return String containing the SQL file contents
	 */
	public static String loadSQL(String sqlFile) {
		// get path
		Path filePath = Paths.get(System.getProperty("user.dir"), "SQL", sqlFile);
		try {
			return Files.readString(filePath);
		} catch (java.io.IOException e) {
			System.out.println(e.getMessage());
			return null; // file not found
		}
	}

	/**
	 * Close JDBC connection, includes Connection, Statement and Result set
	 * 
	 * @param con Connection
	 * @param st  Statement
	 * @param rs  ResultSet
	 */
	public static void close(Connection con, Statement st, ResultSet rs) {

		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
