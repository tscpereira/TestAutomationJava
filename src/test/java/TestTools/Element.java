package TestTools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Element {

    private final By locator;
    private final WebDriver driver;
    private final String elementName;

    public Element(WebDriver driver, By locator, String elementName){
        this.driver = driver;
        this.locator = locator;
        this.elementName = elementName;
    }

    private WebElement GetElement(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public void Click(){
        WebElement element = GetElement();
        System.out.println("Clicking at '" + elementName + "'");
        element.click();
    }

    public void SendKeys(String keys){
        WebElement element = GetElement();
        System.out.println("Typing '" + keys + "' at element '" + elementName + "'");
        element.sendKeys(keys);
    }

    public void Select(String value){
        WebElement element = GetElement();
        Select selectElement = new Select(element);
        System.out.println("Selecting '" + value + "' at element '" + elementName + "'");
        selectElement.selectByValue(value);
    }

    public void Check(){
        WebElement element = GetElement();
        if(!element.isSelected()){
            System.out.println("Checking '" + elementName + "'");
            element.click();
        }
    }

    public void WaitForElement(long timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        System.out.println("Waiting for element '" + elementName + "' be visible in " + Long.toString(timeout) + " seconds");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean IsVisible(){
        WebElement element = GetElement();
        return element.isDisplayed();
    }

    public boolean WaitUntilInvisible(int attempts) throws InterruptedException {
        WebElement element = GetElement();
        WebDriverWait wait = new WebDriverWait(driver, attempts);
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
