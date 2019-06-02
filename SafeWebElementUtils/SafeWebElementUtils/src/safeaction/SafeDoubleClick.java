package safeaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import safegetwebelement.SafeGetByCSSSelector;
import safegetwebelement.SafeGetByClassName;
import safegetwebelement.SafeGetByID;
import safegetwebelement.SafeGetByXPath;

/**
 * 
 * @author Arthur Reynolds
 * created: 06/01/2019
 * updated: 06/01/2019
 *
 * Contains methods that provide a safe way to handle double clicking a WebElement.
 * 
 * All methods in this class are static.
 */
public final class SafeDoubleClick {

	/**
	 * Attempts to double click the passed in WebElement. If the WebDriver object or if the WebElement object
	 * is null then false is returned. If an exception occurs during the process then false is returned. If
	 * the double click action is successful then true is returned indicating that the right click was successful.
	 * @param driver -> WebDriver
	 * @param element -> WebElement
	 * @return -> boolean
	 */
	public static boolean safeDoubleClickWebElement(WebDriver driver, WebElement element) {
		try {
			if(driver==null || element==null)
				return false;
			Actions action = new Actions(driver);
			action.doubleClick(element);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to double click the WebElement that matches the xpath String value that is passed in. If the
	 * WebDriver object is blank or if the xpath String object is null or blank then false is returned. If an
	 * exception occurs during the process then false is returned. If the double click action is successful then
	 * true is returned indicating that the right click was successful.
	 * @param driver -> WebDriver
	 * @param xpath -> String
	 * @return -> boolean
	 */
	public static boolean safeDoubleClickByXPath(WebDriver driver, String xpath) {
		try {
			if(driver==null || xpath.isEmpty())
				return false;
			WebElement element = SafeGetByXPath.safeGetByXPath(driver, xpath);
			return safeDoubleClickWebElement(driver, element);
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to double click the WebElement that matches the className String value that is passed in. If the
	 * WebDriver object is blank or if the className String object is null or blank then false is returned. If an
	 * exception occurs during the process then false is returned. If the double click action is successful then
	 * true is returned indicating that the right click was successful.
	 * @param driver -> WebDriver
	 * @param className -> String
	 * @return -> boolean
	 */
	public static boolean safeDoubleClickByClassName(WebDriver driver, String className) {
		try {
			if(driver==null || className.isEmpty())
				return false;
			WebElement element = SafeGetByClassName.safeGetByClassName(driver, className);
			return safeDoubleClickWebElement(driver, element);
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to double click the WebElement that matches the id String value that is passed in. If the
	 * WebDriver object is blank or if the id String object is null or blank then false is returned. If an
	 * exception occurs during the process then false is returned. If the double click action is successful then
	 * true is returned indicating that the right click was successful.
	 * @param driver -> WebDriver
	 * @param className -> String
	 * @return -> boolean
	 */
	public static boolean safeDoubleClickByID(WebDriver driver, String id) {
		try {
			if(driver==null || id.isEmpty())
				return false;
			WebElement element = SafeGetByID.safeGetByID(driver, id);
			return safeDoubleClickWebElement(driver, element);
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to double click the WebElement that matches the cssSelector String value that is passed in. If the
	 * WebDriver object is blank or if the cssSelector String object is null or blank then false is returned. If an
	 * exception occurs during the process then false is returned. If the double click action is successful then
	 * true is returned indicating that the right click was successful.
	 * @param driver -> WebDriver
	 * @param className -> String
	 * @return -> boolean
	 */
	public static boolean safeDoubleClickByCssSelector(WebDriver driver, String cssSelector) {
		try {
			if(driver==null || cssSelector.isEmpty())
				return false;
			WebElement element = SafeGetByCSSSelector.safeGetByCssSelector(driver, cssSelector);
			return safeDoubleClickWebElement(driver, element);
		}catch(Exception ex) {
			return false;
		}
	}
}