package uk.co.datacable.app.xls;

public class PreprocessInvoice {

	public static int findIndexOfQuotesFromTheEnd(String[] line, int numOfquote) {

		int count = 0;

		int res = 0;

		for (int i = line.length - 1; i > 0; i--) {

			if (line[i].equals("\"")) {

				count++;
				res = i;

				if (count == numOfquote) {

					break;
				}

			}

		}

		return res;
	}
	
	
	public static int findIndexOfQuotesFromTheTop(String[] line, int numOfquote) {

		int count = 0;

		int res = 0;

		for (int i = 0; i <line.length ; i++) {

			if (line[i].equals("\"")) {

				count++;
				res = i;

				if (count == numOfquote) {

					break;
				}

			}

		}

		return res;
	}
	


}
