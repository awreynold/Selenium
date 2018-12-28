/**
 * 
 */
package browserInteractions;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserUtilities {

	/**
	 * gets the browser name associated with the driver to show what browser is currently being used
	 * @param driver WebDriver currently being used
	 * @return String representation of the browser name being used
	 */
	public String getBrowserName(WebDriver driver) {
		String browserName = "";
		
		Capabilities driverCaps = ((RemoteWebDriver)driver).getCapabilities(); //retrieves all the capabilities set to this driver
		browserName = driverCaps.getBrowserName(); //gets the browser name of the current browser the driver is using
		
		return browserName;
	}
	
	/**
	 * verifies that the browser's window title matches the windowTitle value passed in
	 * @param driver WebDriver currently being used
	 * @param windowTitle String representation of the browser's title
	 * @return Boolean result for if the browser's title matches the windowTitle value passed in
	 */
	public Boolean verifyWindowTitle(WebDriver driver, String windowTitle) {
		Boolean verified = false;
		
		if(windowTitle.equals(driver.getTitle())){ //checks if the driver's title equals the windowTitle passed into the method
			verified = true;
		}
		
		return verified;
	}
	
	/**
	 * verifies that the browser of the driver matches the passed in browser for this method
	 * @param driver WebDriver currently being used
	 * @param browser String representation of what browser is expected
	 * @return Boolean result for if the browser matches the driver's browser
	 */
	public Boolean verifyBrowser(WebDriver driver, String browser) {
		Boolean verified = false;
		
		if(browser.equals(getBrowserName(driver))) { //checks if the browser name passed in matches the browser of the driver
			verified = true;
		}
		
		return verified;
	}
	
	/**
	 * verifies that the URL of the driver matches the URL that is passed into the method
	 * @param driver Webdriver currently being used
	 * @param url String representation of the URL that is used for comparison
	 * @return Boolean result for if the URL matches the driver's URL
	 */
	public Boolean verifyURL(WebDriver driver, String url) {
		Boolean verified = false;
		
		if(url.equals(driver.getCurrentUrl())) { //checks if the URL passed in matches the URL of the driver
			verified = true;
		}
		
		return verified;
	}
	
		/**
	 * handles switching to a different browser window or tab. 
	 * only works when there are 2 windows and you want to switch from the current one to the other one
	 * @param driver WebDriver currently being used
	 * @param winHandle String representation of the window handle of the currently being used window
	 * @throws Exception 
	 */
	public void switchWindowToNewWindow(WebDriver driver, String winHandle) throws Exception {
		Set<String> windows = driver.getWindowHandles();
		Boolean found = false;
		
		for(String window : windows) {
			if(!window.equals(winHandle)) {
				driver.switchTo().window(window);
				found = true;
				break;
			}
		}
		
		if(!found) {
			throw new Exception("Window handle not found.");
		}
	}
	
	/**
	 * handles switching to a different browser window or tab based on the windowTitle value being passed in.
	 * @param driver WebDriver currently being used
	 * @param windowTitle String representation of the driver's title value to be compared against
	 * @throws Exception if the windowTitle value was not found in the list of window titles then this exception is thrown
	 */
	public void switchWindowBasedOnWindowTitle(WebDriver driver, String windowTitle) throws Exception {
		Set<String> windows = driver.getWindowHandles();
		Boolean found = false;
		
		for(String window : windows) {
			driver.switchTo().window(window);
			if(windowTitle.equals(driver.getTitle())) {
				found = true;
				break;
			}
		}
		
		if(!found) {
			throw new Exception("Window title not found.");
		}
	}
}
