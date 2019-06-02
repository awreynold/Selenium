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
 * Contains methods that provide a safe way to handle right clicking on a WebElement.
 * 
 * All methods in this class are static.
 */

public final class SafeRightClick {

	/**
	 * Attempts to right click the passed in WebElement. If the WebDriver or WebElement objects are
	 * null then false is returned. If an exception occurs during the process then false is returned.
	 * If the right click action is successful then true is returned indicating that the right click was
	 * successful.
	 * @param driver -> WebDriver
	 * @param element -> WebElement
	 * @return -> boolean
	 */
	public static boolean safeRightClickWebElement(WebDriver driver, WebElement element) {
		try {
			if(driver==null || element==null)
				return false;
			Actions action = new Actions(driver);
			action.contextClick(element);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to right click the WebElement that matches the passed in xpath String value. If the
	 * WebDriver object is null or if the xpath String object is null or blank then false is returned.
	 * If an exception occurs during the process then false is also returned. If the right click action
	 * is successful then true is returned indicating that the right click was successful.
	 * @param driver -> WebDriver
	 * @param xpath -> String
	 * @return -> boolean
	 */
	public static boolean safeRightClickByXPath(WebDriver driver, String xpath) {
		try {
			if(driver==null || xpath.isEmpty())
				return false;
			WebElement element = SafeGetByXPath.safeGetByXPath(driver, xpath);
			return safeRightClickWebElement(driver, element);
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to right click the WebElement that matches the passed in className String value. If the
	 * WebDriver object is null or if the className String object is null or blank then false is returned.
	 * If an exception occurs during the process then false is also returned. If the right click action 
	 * is successful then true is returned indicating that the right click was successful.
	 * @param driver -> WebDriver
	 * @param className -> String
	 * @return -> boolean
	 */
	public static boolean safeRightClickByClassName(WebDriver driver, String className) {
		try {
			if(driver==null || className.isEmpty())
				return false;
			WebElement element = SafeGetByClassName.safeGetByClassName(driver, className);
			return safeRightClickWebElement(driver, element);
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to right click the WebElement that matches the passed in id String value. If the
	 * WebDriver object is null or if the id String object is null or blank then false is returned.
	 * If an exception occurs during the process then false is also returned. If the right click action
	 * is successful then true is returned indicating that the right click was successful.
	 * @param driver -> WebDriver
	 * @param id -> String
	 * @return -> boolean
	 */
	public static boolean safeRightClickByID(WebDriver driver, String id) {
		try {
			if(driver==null || id.isEmpty())
				return false;
			WebElement element = SafeGetByID.safeGetByID(driver, id);
			return safeRightClickWebElement(driver, element);
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to right click the WebElement that matches the passed in cssSelector String value. If the
	 * WebDriver object is null or if the cssSelector String object is null or blank then false is returned.
	 * If an exception occurs during the process then false is also returned. If the right click action
	 * is successful then true is returned indicating that the right click was successful.
	 * @param driver -> WebDriver
	 * @param cssSelector -> String
	 * @return -> boolean
	 */
	public static boolean safeRightClickByCssSelector(WebDriver driver, String cssSelector) {
		try {
			if(driver==null || cssSelector.isEmpty())
				return false;
			WebElement element = SafeGetByCSSSelector.safeGetByCssSelector(driver, cssSelector);
			return safeRightClickWebElement(driver, element);
		}catch(Exception ex) {
			return false;
		}
	}
}