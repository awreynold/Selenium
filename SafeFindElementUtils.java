/**
  Contains methods for safely finding webelements using Java and Selenium. If the webelement isn't found then the method will return null
  instead of throwing an exception.
*/

/**
  safely tries to find and return the webelement that matches the xpath value passed in using the passed in driver variable.
  @param driver -> WebDriver
  @param xpath -> String
  @return -> WebElement
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

/**
  safely tries to find and return the webelement that matches the xpath value passed in using the passed in parent webelement.
  @param parent -> WebElement
  @param xpath -> String
  @return -> WebElement
*/
public static WebElement safeFindElementByXpathWithParent(WebElement parent, Stirng xpath){
 if(xpath.isEmpty() || driver == null)
   return null;
  try{
    return parent.findElement(By.xpath(xpath));
  }catch(Exception ex){
    return null;
  }
}
