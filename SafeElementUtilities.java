/**
*checks to see if the passed in WebElement is displayed or not. if the element itself is null false is returned.
*@param element -> WebElement
*@return -> boolean
*/
public static boolean safeElementIsDisplayed(WebElement element){
  if(!element == null){
    try{
      return element.isDisplayed();
    }catch(Exception ex){
      return false;
    }
  }
  return false;
}

/**
*checks to see if the passed in WebElement is selected or not. if the element itself is null false is returned.
*@param element -> WebElement
*@return -> boolean
*/
public static boolean safeElementIsSelected(WebElement element){
  if(!element == null){
    try{
      return element.isSelected();
    }catch(Exception ex){
      return false;
    }
  }
  return false;
}

/**
*checks to see if the passed in WebElement is enabled or not. if the element itself is null false is returned.
*@param element -> WebElement
*@return -> boolean
*/
public static boolean safeElementIsEnabled(WebElement element){
  if(!element == null){
    try{
      return element.isEnabled();
    }catch(Exception ex){
      return false;
    }
  }
  return false;
}

/**
*safely attempts to simulate a mouse courser moving to the passed in Webelement. if the element or the driver are null then false is
*returned
*@param driver -> WebDriver
*@param element -> WebElement
*/
public static boolean safeMoveTo(WebDriver driver, WebElement element){
  if(!element == null || driver == null){
    try{
      Actions action = new Actions(driver);
      action.moveToElement(element).build().perform();
      return true;
    }catch(Exception ex){
      return false;
    }
  }
  return false;
}

/**
*safely attempts to simulate a mouse click on the passed in WebElement. if the element is null then false is returned
*@param element -> WebElement
*/
public static boolean safeClick(WebElement element){
  if(!element == null){
    try{
      element.click();
      return true;
    }catch(Exception ex){
      return false;
    }
  }
  return false;
}
  
