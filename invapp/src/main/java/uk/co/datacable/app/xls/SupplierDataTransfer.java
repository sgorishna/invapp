package uk.co.datacable.app.xls;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.Part;

import uk.co.datacable.app.db.DBUtill;
import au.com.bytecode.opencsv.CSVReader;

public class SupplierDataTransfer {

	public static void transfer(String path) {

		Connection connection = null;
	
		CSVReader reader = null;

		try {

			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into supplier(accNumber, name, address1, address2, address3, address4, postcode) values (?, ?, ?, ?, ?, ?, ?) on duplicate key update  name=values(name), address1=values(address1), address2=values(address2) ,address3=values(address3) ,address4=values(address4), postcode=values(postcode)");

			
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



	

}
