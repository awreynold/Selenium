import org.apache.commons.io.FileUtils;

// Get entire page screenshot
File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
BufferedImage  fullImg = ImageIO.read(screenshot);

WebElement element = new WebElement();

// Get the location of element on the page
Point point = element.getLocation();

// Get width and height of the element
int eleWidth = element.getSize().getWidth();
int eleHeight = element.getSize().getHeight();

// Crop the entire page screenshot to get only element screenshot
BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
    eleWidth, eleHeight);
ImageIO.write(eleScreenshot, "png", screenshot);

// Copy the element screenshot to disk
File screenshotLocation = new File("C:\\images\\screenshot.png");
FileUtils.copyFile(screenshot, screenshotLocation);
