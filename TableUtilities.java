package tableInteractions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableUtilities {

	/**
	 * returns a list of WebElements that represent the table rows inside of the tableElement
	 * @param driver current WebDriver being used
	 * @param tableElement WebElement that represent the table that you want to get the rows from
	 * @return List<WebElement> list of WebElement representing the rows
	 */
	public List<WebElement> getRowsInTable(WebDriver driver, WebElement tableElement) {
		return tableElement.findElements(By.tagName("tr"));
	}
	
	/**
	 * returns a list of WebElements that represent the table cells inside of the rowElement
	 * @param driver current WebDriver being used
	 * @param rowElement WebElement that represents the row that you want to get the cells from
	 * @return List<WebElements> list of WebElement representing the cells
	 */
	public List<WebElement> getCellsInTable(WebDriver driver, WebElement rowElement){
		return rowElement.findElements(By.tagName("td"));
	}
	
	/**
	 * acquires and returns a specific row from the tableElement
	 * @param driver current WebDriver being used
	 * @param tableElement WebElement that represents the table that you want to get the row from
	 * @param row number of the row that you want to have returned
	 * @return WebElement representation of the row that was requested
	 */
	public WebElement getSpecificRowFromTable(WebDriver driver, WebElement tableElement, int row) {
		List<WebElement> rowList = getRowsInTable(driver, tableElement);
		
		return rowList.get(row);
	}
	
	/**
	 * acquires and returns a specific cell from the rowElement
	 * @param driver current WebDriver being used
	 * @param rowElement WebElement that represents the row that you want to get the cell from
	 * @param cell number of the cell that you want to have returned from the row
	 * @return WebElement representation of the cell that was requested
	 */
	public WebElement getSpecificCellFromRow(WebDriver driver, WebElement rowElement, int cell) {
		List<WebElement> cellList = getCellsInTable(driver, rowElement);
		
		return cellList.get(cell);
	}
	
	/**
	 * checks the table for the text value of each cell and sees if it is a match for the passed in value
	 * @param driver current WebDriver being used
	 * @param tableElement WebElement that represents the table you want to get the values for
	 * @param value String value to be compared to each cells text 
	 * @return boolean if the value is found in the table true if not then false
	 */
	public boolean findValueInTable(WebDriver driver, WebElement tableElement, String value) {
		boolean found = false;
		
		List<WebElement> rowList = getRowsInTable(driver, tableElement);
		
		for(WebElement e : rowList) {
			List<WebElement> cellList = getCellsInTable(driver, e);
			for(WebElement d : cellList) {
				if(d.getText().equals(value)) {
					found = true;
					break;
				}
			}
			if(found) {
				break;
			}
		}
		return found;
