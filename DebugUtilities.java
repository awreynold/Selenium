package debugTools;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DebugUtilities {

	public static WebDriver driver;
	
	/**
	 * draws a border around the passed in WebElement. the border here would be 3 pixels in thickness, solid, and the color red
	 * @param driver currently being used Webdriver
	 * @param element_node WebElement that you wish to draw the border around
	 */
	public void drawBorder(WebDriver driver, WebElement element_node) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='3px solid red'", element_node);
	}
	
	/**
	 * draws a border around the passed element with the passed in xpath. the border here would be 3 pixels in thickness, solid, and the color red
	 * @param driver currently being used Webdriver
	 * @param xpath String representation of the xpath for the element that you want the border draw around
	 */
	public void drawBorder(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	/**
	 * draws a border around the passed in Webelement. the borders thickness and color will be specified in the parameters
	 * @param driver currently being used WebDriver
	 * @param element_node WebElement that you wish to draw the border around
	 * @param borderThickness thickness of the border to be drawn
	 * @param borderColor color of the border to be drawn
	 */
	public void drawBorder(WebDriver driver, WebElement element_node, String borderThickness, String borderColor) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='" + borderThickness + "px solid " + borderColor + "'", element_node);
	}
}
