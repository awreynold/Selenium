package selectInteractions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtilities {

	/**
	 * selects an option from a listbox select element
	 * @param listBox Select object that represents the listBox on the page
	 * @param optionToSelect String representation of the text value of the option to select
	 */
	public void selectOptionFromListBox(Select listBox, String optionToSelect) {
		List<WebElement> options = listBox.getOptions();
		boolean found = false;
		
		for(WebElement e : options) {
			if(e.getText().equals(optionToSelect)) {
				e.click();
				found = true;
				break;
			}
		}
		if(!found) {
			throw new IllegalArgumentException("Option to select value was not found.");
		}
	}
	
	/**
	 * gets all the visible text values of all options in the listbox
	 * @param listBox List box to pull the values from
	 * @return List of string values representing the options of the listbox
	 */
	public List<String> getVisibleTextOptionsFromListBox(Select listBox){
		List<String> optionTextValues = new ArrayList<String>();
		
		List<WebElement> options = listBox.getOptions();
		
		for(WebElement e : options) {
			optionTextValues.add(e.getText());
		}
		
		return optionTextValues;
	}
}
