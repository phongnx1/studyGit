package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
	public static Connection connection;
	public Statement statement;
	public static Connection connectDatabase()  {
		try {
			// load database driver class
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			System.out.println("load driver succeed");
			// establish connection to database
			connection = DriverManager
					.getConnection(
							"jdbc:jtds:sqlserver://Localhost:1433;DatabaseName=JAVA_FINAL1",
							"sa", "12345678");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
		
	}

}
