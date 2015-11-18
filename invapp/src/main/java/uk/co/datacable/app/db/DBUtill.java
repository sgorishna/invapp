package uk.co.datacable.app.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtill {

	private static Connection conn = null;

	public static Connection getConnection() {

		try {
			String username = "root";
			String passwd = "root";

			// String username = "maziy";
			// String passwd = "qwerty123~";

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sage", username, passwd);
			// conn =
			// DriverManager.getConnection("jdbc:mysql://db.j-on.net/dcuk",
			// username, passwd);
		} catch (Exception e) {
			e.getMessage();
		}

		return conn;
	}

	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
