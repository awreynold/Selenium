/**
 * 
 */
package browserInteractions;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * @author Arthur William Reynolds
 * 11/22/2017
 * simple function that opens a Internet Explorer web browser and navigates it to the specified URL
 */
public class DyanmicOpenBrowser {

	public static WebDriver driver;
	
	@Test
	public void executeTest() {
		System.out.println("Enter the browser that you wish to open:");
		Scanner scan1 = new Scanner(System.in);
		String browser = scan1.nextLine();
		scan1.close();
		
		openSpecifiedBrowser(browser, "https://www.google.com");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	/**
	 * opens the passed in browser and navigates to the passed in url
	 * @param browser string representation of the browser type that you want to use
	 * @param url string representation of the url that you want the browser to navigate to
	 */
	public void openSpecifiedBrowser(String browser, String url) {
		//convert the browser String to uppercase to help minimize the variance in user entered input
		browser = browser.toUpperCase();
		//property sets the driver with the value of the file path to the driver exe file on your local system for the specified browser
		/*usually its best to set the location of the drvier exe file to an environment variable so that it can be pulled at any time
		  and doesn't require changing code if this is transfered to another PC.*/
		switch(browser) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", "./../browser_drivers/chromedriver.exe");
			//below is how the above line should be written if you're accessing the driver path from an environment variable
			//System.setProperty("webdriver.chrome.driver", System.getenv("chromeDriverPath");
			driver=new ChromeDriver(); //Instantiates the driver as a new ChromeDriver object
			break;
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver", "./../browser_drivers/geckodriver.exe");
			//below is how the above line should be written if you're accessing the driver path from an environment variable
			//System.setProperty("webdriver.gecko.driver", System.getenv("geckoDriverPath");
			driver=new FirefoxDriver(); //Instantiates the driver as a new FirefoxDriver object
			break;
		case "INTERNET EXPLORER":
			System.setProperty("webdriver.ie.driver", "./../browser_drivers/IEDriverServer.exe");
			//below is how the above line should be written if you're accessing the driver path from an environment variable
			//System.setProperty("webdriver.ie.driver", System.getenv("IEDriverPath");
			driver=new InternetExplorerDriver(); //Instantiates the driver as a new InternetExplorerDriver object
			break;
		default:
			//if none of the above cases matched the value then throw an exception with the below message to say the passed in browser was invalid
			throw new IllegalArgumentException("Invalid browser specified.");
		}
		
		driver.get(url); //makes the driver navigate to the specified url
	}
}
