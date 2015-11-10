package uk.co.datacable.app.xls;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import uk.co.datacable.app.db.DBUtill;

public class XLSUtil {

	private static FileInputStream fis = null;
	private static Sheet sheet;

	public static void dataTransfer(String filename) throws FileNotFoundException {

		connectToXLS(filename);

		transferXLS();
	}

	private static void connectToXLS(String filename) {
		try {

			// fis = new FileInputStream(filename);
			InputStream inp = new FileInputStream(filename);
			POIFSFileSystem fs = new POIFSFileSystem(inp);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			// wb = (XSSFWorkbook) WorkbookFactory.create(fs);

			sheet = wb.getSheetAt(0);
		} catch (Exception e) {
			System.out.println("" + e);
		}
		System.out.println("" + sheet.toString());
		System.out.println("Successfully connected to Excel file!");
		System.out.println();
	}

	public static void closeFis(FileInputStream fis) {
		try {
			fis.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}

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
				System.out.println("Adding to database:");
				connection = DBUtill.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("insert into customer(accNumber, name, address1, address2, address3, address4, postcode) values (?, ?, ?, ?, ?, ?, ?)");

				preparedStatement.setString(1, accNumber);
				preparedStatement.setString(2, name);
				preparedStatement.setString(3, address1);
				preparedStatement.setString(4, address2);
				preparedStatement.setString(5, address3);
				preparedStatement.setString(6, address4);
				preparedStatement.setString(7, postcode);
				preparedStatement.execute();

			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				DBUtill.closeConnection(connection);
			}
		}

	}
}
