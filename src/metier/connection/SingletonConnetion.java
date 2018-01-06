package metier.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnetion {

	private static Connection connection;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_catalogue", "root", "");			
		} catch (Exception e) {
		}
	}

	public static Connection getConnecxion() {
		return connection;
	}

}