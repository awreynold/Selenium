/**
  Contains methods for safely finding webelements using Java and Selenium. If the webelement isn't found then the method will return null
  instead of throwing an exception.
*/

public static WebElement safeFindElementByXpath(WebDriver driver, String xpath){
  if(xpath.isEmpty() || driver == null)
      return null;
  try{
     return driver.findElement(By.xpath(xpath));
  }catch(Exception ex){
     return null;
  }
}
