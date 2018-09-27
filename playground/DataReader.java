package playground;

import java.util.ArrayList;
import java.util.Iterator;

import utilities.Data;

public class DataReader {

	public static void main(String[] args) {
		String testData = "C:\\DealerTrackTraining\\2018\\TestData\\";
		
		Iterator<String[]> data = Data.getCSV(testData + "LoginData.txt");
		while (data.hasNext()) {
			for (String field : data.next()) {
				System.out.println(field);
			}
		}
		
		/*
		String[][] data = Data.getExcel(testData + "NewAccountData.xlsx");
		for (String[] record : data) {
			for (String field : record) {
				System.out.println(field);
			}
		}
		*/
	}

}
