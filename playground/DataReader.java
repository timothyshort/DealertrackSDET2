package playground;

import java.util.ArrayList;

import utilities.Data;

public class DataReader {

	public static void main(String[] args) {
		String testData = "C:\\DealerTrackTraining\\2018\\TestData\\";
		
		// ArrayList<String[]> data = Data.getCSV(testData + "LoginData.txt");
		String[][] data = Data.getExcel(testData + "NewAccountData.xlsx");
		
		for (String[] record : data) {
			for (String field : record) {
				System.out.println(field);
			}
		}
		
	}

}
