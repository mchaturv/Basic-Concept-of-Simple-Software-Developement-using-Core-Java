import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Mayank
 * @Class providing method for 
 * 1. Reading the Properties file for SQL Config
 * 2. Establishing Connection to the database
 *
 */
public class JDBCConnector {

	private String user;
	private String password;
	private String jdbcURL;
	
	/**
	 * Default Constructor
	 */
	public JDBCConnector() throws UserDefinedSQLException {
		//Reading the properties file  
		readProperties();
	}
	
	
	/**
	 * Method to Establish JDBC Connection to Database
	 */
	public Connection connect() throws UserDefinedSQLException {

		Connection connect = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Throwing User Defined SQL Exception with error message
			throw new UserDefinedSQLException(
					"SQL Connection Error : JDBC Driver not supported. Please verify Driver Details");
		}

		try {
			// Establishing the connection
			connect = DriverManager.getConnection(jdbcURL, user, password);
		} catch (SQLException e) {
			// TODO Throwing User Defined SQL Exception with error message
			throw new UserDefinedSQLException(
					"SQL Connection Error: Please verify the Credentials : \n" + e.getMessage());
		}

		return connect;
	}
	
	/**
	 * Method to Read the Properties File 
	 */
	public void readProperties() throws UserDefinedSQLException {
		try {

			InputStream input = new FileInputStream("database.properties");
			Properties prop = new Properties();

			// load a properties file
			prop.load(input);

			// get the property value and assigning it to variable

			jdbcURL = prop.getProperty("db.url");
			user = prop.getProperty("db.user");
			password = prop.getProperty("db.password");

		} catch (IOException ex) {
			// TODO Throwing User Defined SQL Exception with error message
			throw new UserDefinedSQLException(
					"Error encountered While Reading the properties file : " + ex.getMessage());
		}
	}

}

