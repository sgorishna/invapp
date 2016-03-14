package uk.co.datacable.app.xls;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.Part;

import uk.co.datacable.app.db.DBUtill;
import au.com.bytecode.opencsv.CSVReader;

public class SalesInvoiceDetailDataTransfer {

	public static void transfer(String path) {

		Connection connection = null;

		CSVReader reader = null;

		try {

			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert ignore into salesinvoicedetail(salesInvoiceNum, item, count, priceEach, lineTotal, deptNo, deptName) values (?, ?, ?, ?, ?, ?, ?)");

			reader = new CSVReader(new FileReader(path), ',');

			String[] nextLine;

			while ((nextLine = reader.readNext()) != null) {
				if (nextLine != null) {

					preparedStatement.setInt(1, Integer.parseInt(nextLine[0]));
					preparedStatement.setString(2, nextLine[1]);
					preparedStatement.setInt(3, Integer.parseInt(nextLine[2]));
					preparedStatement.setDouble(4,
							Double.parseDouble(nextLine[3]));
					preparedStatement.setDouble(5,
							Double.parseDouble(nextLine[4]));
					preparedStatement.setInt(6, Integer.parseInt(nextLine[5]));
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

				e.printStackTrace();
			}

		}
	}

	public static void preprocessInvoice(String pathFrom, String PathTo) {

		ArrayList<String> result = new ArrayList<String>();

		String line = null;

		String[] lineAsArray;

		try {
			FileReader fileReader = new FileReader(new File(pathFrom));

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			PrintWriter writer = new PrintWriter(new File(PathTo));

			while ((line = bufferedReader.readLine()) != null) {
				
				result.clear();

				lineAsArray = line.split("");

				int firstQuoteIndex = PreprocessInvoice
						.findIndexOfQuotesFromTheTop(lineAsArray, 1);

				int thirdtQuoteIndexFromTheEnd = PreprocessInvoice
						.findIndexOfQuotesFromTheEnd(lineAsArray, 3);

				for (int i = 0; i < firstQuoteIndex + 1; i++) {

					result.add(lineAsArray[i]);

				}

				String description = line.substring(firstQuoteIndex + 1,
						thirdtQuoteIndexFromTheEnd);

				String[] descriptionAsArray = description.split("");

				for (int i = 0; i < descriptionAsArray.length; i++) {

					result.add(descriptionAsArray[i]);

					if (descriptionAsArray[i].equals("\"")) {

						result.add("\" ");
					}

				}

				for (int i = thirdtQuoteIndexFromTheEnd; i < lineAsArray.length; i++) {

					result.add(lineAsArray[i]);

				}

				StringBuilder builder = new StringBuilder();

				for (String s : result) {
					builder.append(s);
				}

				writer.println(builder);

				
			}
			
			
			
			bufferedReader.close();
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
