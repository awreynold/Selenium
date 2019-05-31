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
 * Contains methods that provide a safe way to get WebElement's Attribute's values.
 * A list of usual attribute value names are stored in the constants folder of this library.
 * 
 * All methods in this class are static.
 */

public final class SafeGetAttributes {

	/**
	 * Attempts to retrieve the String value of the passed in attribute name for the passed in WebElement
	 * object. If the WebElement object is null or if the attr String object is null or blank then
	 * null is returned. If an exception occurs during the process then null will be returned. If
	 * the attribute is found successfully the String value of that attribute will be returned.
	 * @param element -> WebElement
	 * @param attr -> String
	 * @return -> String
	 */
	public static String safeGetAttribute(WebElement element, String attr) {
		if(element==null || attr.isEmpty())
			return null;
		try {
			return element.getAttribute(attr);
		}catch(Exception ex) {
			return null;
		}
	}
	/**
	 * Attempts to retrieve the String value of the passed in attribute name for the WebElement that
	 * matches the passed in xpath String value. If the WebDriver object is null or if the xpath or attri
	 * String objects are null or blank, then null is returned. If an exception occurs during the process
	 * then null is returned. If the attribute is found successfully the String value of that attribute
	 * will be returned.
	 * @param driver -> WebDiver
	 * @param xpath -> String
	 * @param attr -> String
	 * @return -> String
	 */
	public static String safeGetAttributeByXPath(WebDriver driver, String xpath, String attr) {
		if(driver==null || xpath.isEmpty() || attr.isEmpty())
			return null;
		try {
			WebElement element = SafeGetByXPath.safeGetByXPath(driver, xpath);
			return safeGetAttribute(element, attr);
		}catch(Exception ex) {
			return null;
		}
	}
	
	/**
	 * Attempts to retrieve the String value of the passed in attribute name for the WebElement that
	 * matches the passed in className String value. If the WebDriver object is null or if the className
	 * or attri String objects are null or blank, then null is returned. If an exception occurs 
	 * during the process then null is returned. If the attribute is found successfully
	 * the String value of that attribute will be returned.
	 * @param driver -> WebDriver
	 * @param className -> String
	 * @param attr -> String
	 * @return -> String
	 */
	public static String safeGetAttributeByClassName(WebDriver driver, String className, String attr) {
		if(driver==null || className.isEmpty() || attr.isEmpty())
			return null;
		try {
			WebElement element = SafeGetByClassName.safeGetByClassName(driver, className);
			return safeGetAttribute(element, attr);
		}catch(Exception ex) {
			return null;
		}
	}
	
	/**
	 * Attempts to retrieve the String value of the passed in attribute name for the WebElement that
	 * matches the passed in id String value. If the WebDriver object is null or if the id
	 * or attri String objects are null or blank, then null is returned. If an exception occurs 
	 * during the process then null is returned. If the attribute is found successfully
	 * the String value of that attribute will be returned.
	 * @param driver -> WebDriver
	 * @param id -> String
	 * @param attr -> String
	 * @return -> String
	 */
	public static String safeGetAttributeByID(WebDriver driver, String id, String attr) {
		if(driver==null || id.isEmpty() || attr.isEmpty())
			return null;
		try {
			WebElement element = SafeGetByID.safeGetByID(driver, id);
			return safeGetAttribute(element, attr);
		}catch(Exception ex) {
			return null;
		}
	}
	
	/**
	 * Attempts to retrieve the String value of the passed in attribute name for the WebElement that
	 * matches the passed in cssSelector String value. If the WebDriver object is null or if the 
	 * cssSelector or attri String objects are null or blank, then null is returned. If 
	 * an exception occurs during the process then null is returned. If the attribute is 
	 * found successfully the String value of that attribute will be returned.
	 * @param driver -> WebDriver
	 * @param cssSelector -> String
	 * @param attr -> String
	 * @return -> String
	 */
	public static String safeGetAttributeByCssSelector(WebDriver driver, String cssSelector, String attr) {
		if(driver==null || cssSelector.isEmpty() || attr.isEmpty())
			return null;
		try {
			WebElement element = SafeGetByCSSSelector.safeGetByCssSelector(driver, cssSelector);
			return safeGetAttribute(element, attr);
		}catch(Exception ex) {
			return null;
		}
	}
}