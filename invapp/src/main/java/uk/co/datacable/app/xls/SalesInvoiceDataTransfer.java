package uk.co.datacable.app.xls;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Part;

import uk.co.datacable.app.db.DBUtill;
import au.com.bytecode.opencsv.CSVReader;

public class SalesInvoiceDataTransfer {

	public static void transfer(String path) {

		Connection connection = null;
	
		CSVReader reader = null;

		try {

			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into salesinvoice(invNumber, date, customerAccNum, ffor, deptNo, deptName, amount) values (?, ?, ?, ?, ?, ?, ?) on duplicate key update  date=values(date), customerAccNum=values(customerAccNum) ,ffor=values(ffor) ,deptNo=values(deptNo), deptName=values(deptName), amount=values(amount)");

		
			reader = new CSVReader(new FileReader(path), ',');

			String[] nextLine;

			while ((nextLine = reader.readNext()) != null) {
				if (nextLine != null) {

					preparedStatement.setInt(1,Integer.parseInt(nextLine[0]));
					preparedStatement.setDate(2, java.sql.Date.valueOf(LoadFileHelper.convertStringToMySQLDate(nextLine[1])));
					preparedStatement.setString(3, nextLine[2]);
					preparedStatement.setString(4, nextLine[3]);
					preparedStatement.setInt(5, Integer.parseInt(nextLine[4]));
					preparedStatement.setString(6, nextLine[5]);
					preparedStatement.setDouble(7, Double.parseDouble(nextLine[6]));

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
				
				e.printStackTrace();
			}

		}
	}

	

	

}
