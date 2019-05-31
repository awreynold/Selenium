package safeaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import safegetwebelement.SafeGetByCSSSelector;
import safegetwebelement.SafeGetByClassName;
import safegetwebelement.SafeGetByID;
import safegetwebelement.SafeGetByXPath;

/**
 * 
 * @author Arthur Reynolds
 * created: 05/31/2019
 * updated: 05/31/2019
 * 
 * Contains methods that provide a safe way to handle clicking a WebElement.
 * 
 * All methods in this class are static.
 */

public final class SafeClick {

	/**
	 * Attempts to perform a click action upon the WebElement that is passed into the method. If an
	 * exception is thrown during this action then false is returned to indicate that the click didn't
	 * occur. If the WebElement passed in is null then false is also returned. If the click action
	 * completes successfully then true is returned indicating the click was successful.
	 * @param element -> WebElement
	 * @return -> boolean
	 */
	public static boolean safeClickWebElement(WebElement element) {
		try {
			if(element==null)
				return false;
			element.click();
			return true;
		}catch(Exception ex){
			return false;
		}
	}
	
	/**
	 * Attempts to perform a click action upon the WebElement found using the passed in driver and matching
	 * the xpath String value that is passed in. If the click action throws an exception or if the 
	 * WebElement is not found then false is returned. If the passed in xpath String value is null
	 * or blank then false is returned. If the click action is successful then true is returned
	 * indicating that the click was successful.
	 * @param driver -> WebDriver
	 * @param xpath -> String
	 * @return -> boolean
	 */
	public static boolean safeClickByXPath(WebDriver driver, String xpath) {
		try {
			if(xpath.isEmpty())
				return false;
			return safeClickWebElement(SafeGetByXPath.safeGetByXPath(driver, xpath));
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to perform a click action upon the WebElement found using the passed in driver and matching
	 * the ClassName String value that is passed in. If the click action throws an exception or if the 
	 * WebElement is not found then false is returned. If the passed in ClassName String value is null
	 * or blank then false is returned. If the click action is successful then true is returned
	 * indicating that the click was successful.
	 * @param driver -> WebDriver
	 * @param className -> String
	 * @return -> boolean
	 */
	public static boolean safeClickByClassName(WebDriver driver, String className) {
		try {
			if(className.isEmpty())
				return false;
			return safeClickWebElement(SafeGetByClassName.safeGetByClassName(driver, className));
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to perform a click action upon the WebElement found using the passed in driver and matching
	 * the ID String value that is passed in. If the click action throws an exception or if the 
	 * WebElement is not found then false is returned. If the passed in ID String value is null
	 * or blank then false is returned. If the click action is successful then true is returned
	 * indicating that the click was successful.
	 * @param driver -> WebDriver
	 * @param id -> String
	 * @return -> boolean
	 */
	public static boolean safeClickByID(WebDriver driver, String id) {
		try {
			if(id.isEmpty())
				return false;
			return safeClickWebElement(SafeGetByID.safeGetByID(driver, id));
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to perform a click action upon the WebElement found using the passed in driver and matching
	 * the CssSelector String value that is passed in. If the click action throws an exception or if the 
	 * WebElement is not found then false is returned. If the passed in CssSelector String value is null
	 * or blank then false is returned. If the click action is successful then true is returned
	 * indicating that the click was successful.
	 * @param driver -> WebDriver
	 * @param cssSelector -> String
	 * @return -> boolean
	 */
	public static boolean safeClickByCSSSelector(WebDriver driver, String cssSelector) {
		try {
			if(cssSelector.isEmpty())
				return false;
			return safeClickWebElement(SafeGetByCSSSelector.safeGetByCssSelector(driver, cssSelector));
		}catch(Exception ex) {
			return false;
		}
	}
}