package uk.co.datacable.app.xls;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Part;

public class LoadFileHelper {
	
	
	public static void deleteFile(String path) {

		try {

			File fileTemp = new File(path);
			if (fileTemp.exists()) {
				fileTemp.delete();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static String getFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		System.out.println("content-disposition header= " + contentDisp);
		String[] tokens = contentDisp.split(";");
		for (String token : tokens) {
			if (token.trim().startsWith("filename")) {
				return token.substring(token.indexOf("=") + 2, token.length() - 1);
			}
		}
		return "";
	}
	
	
	public static String convertStringToMySQLDate(String date) throws ParseException{
		
		SimpleDateFormat from = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat to = new SimpleDateFormat("yyyy-MM-dd");
		Date d = from.parse(date);
			String mysqlString = to.format(d); 
			
			return mysqlString;
		
	}


}
