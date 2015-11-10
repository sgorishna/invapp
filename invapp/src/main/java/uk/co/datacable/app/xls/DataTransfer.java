package uk.co.datacable.app.xls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import uk.co.datacable.app.db.DBUtill;

public class DataTransfer {

	public static Sheet sheet;

	private static void transferXLS() {

		Connection connection = null;

		Iterator<Row> rowIterator = sheet.iterator();

		while (rowIterator.hasNext()) {

			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			String accNumber = cellIterator.next().getStringCellValue();
			String name = cellIterator.next().getStringCellValue();
			String address1 = cellIterator.next().getStringCellValue();
			String address2 = cellIterator.next().getStringCellValue();
			String address3 = cellIterator.next().getStringCellValue();
			String address4 = cellIterator.next().getStringCellValue();
			String postcode = cellIterator.next().getStringCellValue();

			try {

				connection = DBUtill.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("insert into customer(accNumber, name, address1, address2, address3, address4, postcode) values (?, ?, ?, ?, ?, ?, ?)");

				preparedStatement.setString(1, accNumber);
				preparedStatement.setString(2, name);
				preparedStatement.setString(3, address1);
				preparedStatement.setString(4, address2);
				preparedStatement.setString(5, address3);
				preparedStatement.setString(6, address4);
				preparedStatement.setString(7, postcode);
				preparedStatement.executeUpdate();

			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				DBUtill.closeConnection(connection);

			}
		}
	}

}
