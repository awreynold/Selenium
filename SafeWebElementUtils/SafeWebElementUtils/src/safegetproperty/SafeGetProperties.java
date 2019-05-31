package safegetproperty;

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
 * Contains methods that provide a safe way to determine different properties of a WebElement
 * (isDisplayed, isEnabled, isSelected, etc).
 * 
 * All methods in this class are static.
 */

public final class SafeGetProperties {

	/**
	 * Attempts to check if the passed in WebElement object is currently displayed in the browser.
	 * If the element is null then false is returned. If an exception occurs during the isDisplay action
	 * then false is returned. If the WebElement is displayed in the browser then this method will
	 * return true.
	 * @param element -> WebElement
	 * @return -> boolean
	 */
	public static boolean safeElementIsDisplayed(WebElement element) {
		if(element==null)
			return false;
		try {
			return element.isDisplayed();
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to check if the WebElement that matches the passed in xpath String value is displayed
	 * currently in the browser. If the driver object is null or if the xpath String is null or blank,
	 * then false is returned. If an exception occurs during the isDisplayed action then false is
	 * returned. If the WebElement is displayed in the browser then this method will return true.
	 * @param driver -> WebDriver
	 * @param xpath -> String
	 * @return -> boolean
	 */
	public static boolean safeIsDisplayedByXPath(WebDriver driver, String xpath) {
		if(driver==null || xpath.isEmpty())
			return false;
		try {
			WebElement element = SafeGetByXPath.safeGetByXPath(driver, xpath);
			return safeElementIsDisplayed(element);
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to check if the WebElement that matches the passed in className String value is displayed
	 * currently in the browser. If the driver object is null or if the className String is null or blank,
	 * then false is returned. If an exception occurs during the isDisplayed action then false is
	 * returned. If the WebElement is displayed in the browser then this method will return true.
	 * @param driver -> WebDriver
	 * @param className -> String
	 * @return -> boolean
	 */
	public static boolean safeIsDisplayedByClassName(WebDriver driver, String className) {
		if(driver==null || className.isEmpty())
			return false;
		try {
			WebElement element = SafeGetByClassName.safeGetByClassName(driver, className);
			return safeElementIsDisplayed(element);
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to check if the WebElement that matches the passed in id String value is displayed
	 * currently in the browser. If the driver object is null or if the id String is null or blank,
	 * then false is returned. If an exception occurs during the isDisplayed action then false is
	 * returned. If the WebElement is displayed in the browser then this method will return true.
	 * @param driver -> WebDriver
	 * @param id -> String
	 * @return -> boolean
	 */
	public static boolean safeIsDisplayedByID(WebDriver driver, String id) {
		if(driver==null || id.isEmpty())
			return false;
		try {
			WebElement element = SafeGetByID.safeGetByID(driver, id);
			return safeElementIsDisplayed(element);
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to check if the WebElement that matches the passed in cssSelector String value is 
	 * displayed currently in the browser. If the driver object is null or if the cssSelector String
	 * is null or blank, then false is returned. If an exception occurs during the isDisplayed
	 * action then false is returned. If the WebElement is displayed in the browser then this
	 * method will return true.
	 * @param driver -> WebDriver
	 * @param cssSelector -> String
	 * @return -> boolean
	 */
	public static boolean safeIsDisplayedCssSelector(WebDriver driver, String cssSelector) {
		if(driver==null || cssSelector.isEmpty())
			return false;
		try {
			WebElement element = SafeGetByCSSSelector.safeGetByCssSelector(driver, cssSelector);
			return safeElementIsDisplayed(element);
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to check if the passed in WebElement object is currently selected.
	 * If the element is null then false is returned. If an exception occurs during the isSelected action
	 * then false is returned. If the WebElement is selected then this method will
	 * return true.
	 * @param element -> WebElement
	 * @return -> boolean
	 */
	public static boolean safeElementIsSelected(WebElement element) {
		if(element==null)
			return false;
		try {
			return element.isSelected();
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to check if the WebElement that matches the passed in xpath String value is selected
	 * currently. If the driver object is null or if the xpath String is null or blank,
	 * then false is returned. If an exception occurs during the isSelected action then false is
	 * returned. If the WebElement is selected then this method will return true.
	 * @param driver -> WebDriver
	 * @param xpath -> String
	 * @return -> boolean
	 */
	public static boolean safeIsSelectedByXPath(WebDriver driver, String xpath) {
		if(driver==null || xpath.isEmpty())
			return false;
		try {
			WebElement element = SafeGetByXPath.safeGetByXPath(driver, xpath);
			return safeElementIsSelected(element);
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to check if the WebElement that matches the passed in className String value is selected
	 * currently. If the driver object is null or if the className String is null or blank,
	 * then false is returned. If an exception occurs during the isSelected action then false is
	 * returned. If the WebElement is selected then this method will return true.
	 * @param driver -> WebDriver
	 * @param className -> String
	 * @return -> boolean
	 */
	public static boolean safeIsSelectedByClassName(WebDriver driver, String className) {
		if(driver==null || className.isEmpty())
			return false;
		try {
			WebElement element = SafeGetByClassName.safeGetByClassName(driver, className);
			return safeElementIsSelected(element);
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to check if the WebElement that matches the passed in id String value is selected
	 * currently. If the driver object is null or if the id String is null or blank,
	 * then false is returned. If an exception occurs during the isSelected action then false is
	 * returned. If the WebElement is selected then this method will return true.
	 * @param driver -> WebDriver
	 * @param id -> String
	 * @return -> boolean
	 */
	public static boolean safeIsSelectedByID(WebDriver driver, String id) {
		if(driver==null || id.isEmpty())
			return false;
		try {
			WebElement element = SafeGetByID.safeGetByID(driver, id);
			return safeElementIsSelected(element);
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to check if the WebElement that matches the passed in cssSelector String value is 
	 * selected currently. If the driver object is null or if the cssSelector String
	 * is null or blank, then false is returned. If an exception occurs during the isSelected
	 * action then false is returned. If the WebElement is selected then this method will return true.
	 * @param driver -> WebDriver
	 * @param cssSelector -> String
	 * @return -> boolean
	 */
	public static boolean safeIsSelectedCssSelector(WebDriver driver, String cssSelector) {
		if(driver==null || cssSelector.isEmpty())
			return false;
		try {
			WebElement element = SafeGetByCSSSelector.safeGetByCssSelector(driver, cssSelector);
			return safeElementIsSelected(element);
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to check if the passed in WebElement object is currently enabled.
	 * If the element is null then false is returned. If an exception occurs during the isEnabled action
	 * then false is returned. If the WebElement is enabled then this method will
	 * return true.
	 * @param element -> WebElement
	 * @return -> boolean
	 */
	public static boolean safeElementIsEnabled(WebElement element) {
		if(element==null)
			return false;
		try {
			return element.isEnabled();
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to check if the WebElement that matches the passed in xpath String value is enabled
	 * currently. If the driver object is null or if the xpath String is null or blank,
	 * then false is returned. If an exception occurs during the isEnabled action then false is
	 * returned. If the WebElement is enabled then this method will return true.
	 * @param driver -> WebDriver
	 * @param xpath -> String
	 * @return -> boolean
	 */
	public static boolean safeIsEnabledByXPath(WebDriver driver, String xpath) {
		if(driver==null || xpath.isEmpty())
			return false;
		try {
			WebElement element = SafeGetByXPath.safeGetByXPath(driver, xpath);
			return safeElementIsEnabled(element);
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to check if the WebElement that matches the passed in className String value is enabled
	 * currently. If the driver object is null or if the className String is null or blank,
	 * then false is returned. If an exception occurs during the isEnabled action then false is
	 * returned. If the WebElement is enabled then this method will return true.
	 * @param driver -> WebDriver
	 * @param className -> String
	 * @return -> boolean
	 */
	public static boolean safeIsEnabledByClassName(WebDriver driver, String className) {
		if(driver==null || className.isEmpty())
			return false;
		try {
			WebElement element = SafeGetByClassName.safeGetByClassName(driver, className);
			return safeElementIsEnabled(element);
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to check if the WebElement that matches the passed in id String value is enabled
	 * currently. If the driver object is null or if the id String is null or blank,
	 * then false is returned. If an exception occurs during the isEnabled action then false is
	 * returned. If the WebElement is enabled then this method will return true.
	 * @param driver -> WebDriver
	 * @param id -> String
	 * @return -> boolean
	 */
	public static boolean safeIsEnabledByID(WebDriver driver, String id) {
		if(driver==null || id.isEmpty())
			return false;
		try {
			WebElement element = SafeGetByID.safeGetByID(driver, id);
			return safeElementIsEnabled(element);
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to check if the WebElement that matches the passed in cssSelector String value is 
	 * enabled currently. If the driver object is null or if the cssSelector String
	 * is null or blank, then false is returned. If an exception occurs during the isEnabled
	 * action then false is returned. If the WebElement is enabled then this method will return true.
	 * @param driver -> WebDriver
	 * @param cssSelector -> String
	 * @return -> boolean
	 */
	public static boolean safeIsEnabledCssSelector(WebDriver driver, String cssSelector) {
		if(driver==null || cssSelector.isEmpty())
			return false;
		try {
			WebElement element = SafeGetByCSSSelector.safeGetByCssSelector(driver, cssSelector);
			return safeElementIsEnabled(element);
		}catch(Exception ex) {
			return false;
		}
	}
}