package uk.co.datacable.app.xls;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.Part;

import uk.co.datacable.app.db.DBUtill;
import au.com.bytecode.opencsv.CSVReader;

public class CustomerDataTransfer {

	public static void transfer(String path) {

		Connection connection = null;
		// BufferedReader reader = null;
		CSVReader reader = null;

		try {

			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into customer(accNumber, name, address1, address2, address3, address4, postcode) values (?, ?, ?, ?, ?, ?, ?) on duplicate key update  name=values(name), address1=values(address1), address2=values(address2) ,address3=values(address3) ,address4=values(address4), postcode=values(postcode)");

			// reader = new CSVReader(new FileReader(path), ',', '"', -1);
			reader = new CSVReader(new FileReader(path), ',');

			String[] nextLine;

			while ((nextLine = reader.readNext()) != null) {
				if (nextLine != null) {

					preparedStatement.setString(1, nextLine[0]);
					preparedStatement.setString(2, nextLine[1]);
					preparedStatement.setString(3, nextLine[2]);
					preparedStatement.setString(4, nextLine[3]);
					preparedStatement.setString(5, nextLine[4]);
					preparedStatement.setString(6, nextLine[5]);
					preparedStatement.setString(7, nextLine[6]);

					preparedStatement.executeUpdate();

				}
			}

			/*
			 * reader = new BufferedReader(new FileReader(path));
			 * 
			 * String line = null; Scanner scanner = null; reader.readLine();
			 * 
			 * while ((line = reader.readLine()) != null) { scanner = new
			 * Scanner(line); scanner.useDelimiter(","); while
			 * (scanner.hasNext()) {
			 */

			/*
			 * } }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtill.closeConnection(connection);
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	/*
	 * public static void transfer2(String path) {
	 * 
	 * Connection connection = null;
	 * 
	 * BufferedReader br = null; String line = ""; String cvsSplitBy = ",";
	 * 
	 * try {
	 * 
	 * connection = DBUtill.getConnection(); PreparedStatement preparedStatement
	 * = connection.prepareStatement(
	 * "insert into customer(accNumber, name, address1, address2, address3, address4, postcode) values (?, ?, ?, ?, ?, ?, ?)"
	 * );
	 * 
	 * br = new BufferedReader(new FileReader(path));
	 * 
	 * while ((line = br.readLine()) != null) {
	 * 
	 * String[] row = line.split(cvsSplitBy);
	 * 
	 * preparedStatement.setString(1, row[0]); preparedStatement.setString(2,
	 * row[1]); preparedStatement.setString(3, row[2]);
	 * preparedStatement.setString(4, row[3]); preparedStatement.setString(5,
	 * row[4]); preparedStatement.setString(6, row[5]);
	 * preparedStatement.setString(7, row[6]);
	 * preparedStatement.executeUpdate();
	 * 
	 * }
	 * 
	 * } catch (Exception e) { // TODO: handle exception } finally {
	 * DBUtill.closeConnection(connection); try { if (br != null) br.close(); }
	 * catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 * 
	 * }
	 */



}
