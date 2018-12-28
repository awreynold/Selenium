package testDataUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * In order to use this class the JAR files located at the following URL must be added to your project:
 * http://poi.apache.org/download.html#POI-3.17
 * contains methods that interact with an excel file. excel files can be used to house test data  to use in the tests
 * or to house test results by setting values to the excel file itself.
 */
public class ExcelUtilities {

	/**
	 * opens the workbook and returns the XSSFWorkbook object representation of the workbook located at excelTestDataEnvVariable
	 * @param excelTestDataEnvVariable String representation of the environment variable holding the file path to the excel file
	 * @return XSSFWorkbook object representing the workbook specified in the environment variable
	 * @throws FileNotFoundException if the excel file wasn't found at the specified file path then an exception is thrown
	 */
	public  XSSFWorkbook getWorkBook(String excelTestDataEnvVariable) throws FileNotFoundException {
		try {
			//Specify file path for the Excel test data file. The file path should either be set to an environment variable or
			//the new File() parameter below should be replaced with the file path if no environment variable is used
			File src = new File(System.getenv(excelTestDataEnvVariable));
			//File src = new File("C:\\testData.xlsx");
			//load file
			FileInputStream fis = new FileInputStream(src);
			//load workbook
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			return wb;
		}catch(Exception e) {
			throw new FileNotFoundException();
		}
	}
	/**
	 * opens the specified excel file and returns the value stored in the specific row/column of the excel file
	 * @param row int representation of the row you wish to pull the value from
	 * @param col int representation of the column you wish to pull the value from
	 * @return String representation of the value stored in the specified cell. if an error occurs it returns "" instead.
	 */
	public String getCellValue(int row, int col) {
		String cellValue = "";
		
		//Excel rows and column numbers start at 0. To make things a little easier while programming we decrease the numbers
		//passed in by 1 on row and col both. If this causes issues feel free to comment/remove the following two lines.
		row = row - 1;
		col = col - 1;
		
		try {
			//load workbook
			XSSFWorkbook wb = getWorkBook("excelTestDataFilePathEnvironmentVariable");
			
			//Load sheet - Here we are loading first sheet only
			XSSFSheet sh1 = wb.getSheetAt(0);
			//the above code can be writen as follow to make it more dynamic
			//XSSFSheet sh1 = wb.getSheetAt(findSheetNumber(wb, "Test Sheet");
			
			//getRow() specify which row we want to read.
			//getCell() speicfy which column to read.
			//getStringCellValue() specify what we are reading String data.
			cellValue = sh1.getRow(row).getCell(col).getStringCellValue();
		}catch(Exception e) {
			return "";
		}
		return cellValue;
	}
	
	/**
	 * opens a specified workbook and sets the cell in a specified sheet to the passed in value
	 * @param excelFilePathEnvVar String representation of the environment variable holding the file path to the excel file
	 * @param sheetName String representation of the sheet name that is requested
	 * @param value String representation of the value that should be stored in that cell
	 * @param row int representation of the row that should be used
	 * @param col int represenation of the col to be used
	 * @throws FileNotFoundException if the excel file cannot be found at the given file path then a filenotfound exception is thrown
	 */
	public void setCellValue(String excelFilePathEnvVar, String sheetName, String value, int row, int col) throws FileNotFoundException {
		//loads the workbook
		XSSFWorkbook wb = getWorkBook(excelFilePathEnvVar);
		//load sheet
		XSSFSheet sh = wb.getSheetAt(findSheetNumber(wb, sheetName));
		XSSFCell cell = sh.getRow(row).getCell(col);
		cell.setCellValue(value);
	}
	
	/**
	 * searches thru the workbook to find which sheet is one that is being passed in
	 * @param wb XSSFWork that contains the desired sheet
	 * @param sheetName String representation of the sheet name that is being searched for
	 * @return the number of the sheet that was requested or null if the sheet was not found in the workbook
	 */
	public Integer findSheetNumber(XSSFWorkbook wb, String sheetName) {
		int sheetNum = 0;
		Boolean found = false;
		
		while(sheetNum != wb.getNumberOfSheets()) { //loops thru all the sheets in the workbook
			XSSFSheet sh = wb.getSheetAt(sheetNum); 
			if(sheetName.equals(sh.getSheetName())){ //checks if the sheet name matches the passed in sheetName
				found = true;
				break;
			}else {
				sheetNum++; //increase sheet number by 1
			}
		}
		if(!found) {
			return null; //if the sheet wasn't located then return null for the calling method to decide how to handle that
		}else {
			return sheetNum;
		}
	}
}
