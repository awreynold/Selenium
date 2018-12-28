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
