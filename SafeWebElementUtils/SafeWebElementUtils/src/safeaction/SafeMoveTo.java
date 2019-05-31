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
 * created: 05/31/2019
 * updated: 05/31/2019
 * 
 * Contains methods that provide a safe way to perform a move to action on a WebElement.
 * 
 * All methods in this class are static.
 */

public final class SafeMoveTo {

	/**
	 * Attempts to perform a safe move to action, moving the mouse pointer to the passed in WebElement
	 * object. If the WebDriver or WebElement object is null then false is returned. If an exception
	 * occurs during the move to process then false is returned. If the mouse pointer is moved to 
	 * the WebElement successfully then true is returned to indicate that the action was successful.
	 * @param driver -> WebDriver
	 * @param element -> WebElement
	 * @return -> boolean
	 */
	public static boolean safeMoveToWebElement(WebDriver driver, WebElement element) {
		try {
			if(driver==null || element==null)
				return false;
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to perform a safe move to action, moving the mouse points to the WebElement that matches
	 * the xpath String value that is passed in. If the WebDriver object is null or if the xpath String
	 * is null or blank then false is returned. If an exception occurs during the move to process 
	 * then false is returned. If the mouse pointer is moved to the WebElement successfully then 
	 * true is returned to indicate that the action was successful.
	 * @param driver -> WebDriver
	 * @param xpath -> String
	 * @return -> boolean
	 */
	public static boolean safeMoveToByXPath(WebDriver driver, String xpath) {
		try {
			Actions action = new Actions(driver);
			WebElement element = SafeGetByXPath.safeGetByXPath(driver, xpath);
			action.moveToElement(element).build().perform();
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to perform a safe move to action, moving the mouse points to the WebElement that matches
	 * the className String value that is passed in. If the WebDriver object is null or if the 
	 * className String is null or blank then false is returned. If an exception occurs during
	 * the move to process then false is returned. If the mouse pointer is moved to the
	 * WebElement successfully then true is returned to indicate that the action was successful.
	 * @param driver -> WebDriver
	 * @param className -> String
	 * @return -> boolean
	 */
	public static boolean safeMoveToByClassName(WebDriver driver, String className) {
		try {
			Actions action = new Actions(driver);
			WebElement element = SafeGetByClassName.safeGetByClassName(driver, className);
			action.moveToElement(element).build().perform();
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to perform a safe move to action, moving the mouse points to the WebElement that matches
	 * the id String value that is passed in. If the WebDriver object is null or if the id String
	 * is null or blank then false is returned. If an exception occurs during the move to process 
	 * then false is returned. If the mouse pointer is moved to the WebElement successfully then 
	 * true is returned to indicate that the action was successful.
	 * @param driver -> WebDriver
	 * @param id -> String
	 * @return -> boolean
	 */
	public static boolean safeMoveToByID(WebDriver driver, String id) {
		try {
			Actions action = new Actions(driver);
			WebElement element = SafeGetByID.safeGetByID(driver, id);
			action.moveToElement(element).build().perform();
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to perform a safe move to action, moving the mouse points to the WebElement that matches
	 * the cssSelector String value that is passed in. If the WebDriver object is null or if the 
	 * cssSelector String is null or blank then false is returned. If an exception occurs during
	 * the move to process then false is returned. If the mouse pointer is moved to the
	 * WebElement successfully then true is returned to indicate that the action was successful.
	 * @param driver -> WebDriver
	 * @param cssSelector -> String
	 * @return -> boolean
	 */
	public static boolean safeMoveToByCSSSelector(WebDriver driver, String cssSelector) {
		try {
			Actions action = new Actions(driver);
			WebElement element = SafeGetByCSSSelector.safeGetByCssSelector(driver, cssSelector);
			action.moveToElement(element).build().perform();
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
}
