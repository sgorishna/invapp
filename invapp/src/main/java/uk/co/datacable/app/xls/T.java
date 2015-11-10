package uk.co.datacable.app.xls;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import uk.co.datacable.app.db.DBUtill;

public class T {

	public static void transfer2(String path) {

		Connection connection = null;

		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("insert into customer(accNumber, name, address1, address2, address3, address4, postcode) values (?, ?, ?, ?, ?, ?, ?)");

			br = new BufferedReader(new FileReader(path));

			while ((line = br.readLine()) != null) {

				String[] row = line.split(cvsSplitBy);

				preparedStatement.setString(1, row[0]);
				preparedStatement.setString(2, row[1]);
				preparedStatement.setString(3, row[2]);
				preparedStatement.setString(4, row[3]);
				preparedStatement.setString(5, row[4]);
				preparedStatement.setString(6, row[5]);
				preparedStatement.setString(7, row[6]);
				preparedStatement.executeUpdate();

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtill.closeConnection(connection);
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void transfer3(String path) {
		System.out.println("Empty");
	}

}
