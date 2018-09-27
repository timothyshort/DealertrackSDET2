package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data {
	
	// Read and return CSV data
	public static Iterator<String[]> getCSV(String csvFile) {
		ArrayList<String[]> data = new ArrayList<String[]>();
		System.out.println("Reading file ...");
		
		// 1. Create the file in Java
		File file = new File(csvFile);
		
		try {
			// 2. Open the file
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			// 3. Read the file (add to data set)
			String line;
			while ((line = br.readLine()) != null) {
				String[] record = line.split(",");
				data.add(record);
			}
			
			// 4. Close the file
			br.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND!");
		} catch (IOException e) {
			System.out.println("ERROR READING FILE!");
		}
		
		return data.iterator();
	}
	
	// Read and return Excel data (XLSX)
	// Dependencies: POI (XSS* Workbook/Sheet/Row/Cell)
	public static String[][] getExcel(String filename) {
		String[][] dataTable = null;
		File file = new File(filename);
		try {
			// Create a file input stream to read Excel workbook and worksheet
			FileInputStream xlfile = new FileInputStream(file);
			XSSFWorkbook xlwb = new XSSFWorkbook(xlfile);
			XSSFSheet xlSheet = xlwb.getSheetAt(0);

			// Get the number of rows and columns
			int numRows = xlSheet.getLastRowNum() + 1;
			int numCols = xlSheet.getRow(0).getLastCellNum();

			// Create double array data table - rows x cols
			// We will return this data table
			dataTable = new String[numRows][numCols];

			// For each row, create a HSSFRow, then iterate through the "columns"
			// For each "column" create an HSSFCell to grab the value at the specified cell (i,j)
			for (int i = 0; i < numRows; i++) {
				XSSFRow xlRow = xlSheet.getRow(i);
				for (int j = 0; j < numCols; j++) {
					XSSFCell xlCell = xlRow.getCell(j);
					dataTable[i][j] = xlCell.toString();
				}
			}
		} catch (IOException e) {
			System.out.println("ERROR FILE HANDLING " + e.toString());
		}
		return dataTable;
	}

}
