package PageObjects;

import TestTools.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PricePage {

    public Element SilverOption;
    public Element NextButton;

    public PricePage(WebDriver driver){
        SilverOption = new Element(driver, By.xpath("//*[@id='selectsilver']/following-sibling::span"), "Silver Option checkbox");
        NextButton = new Element(driver, By.id("nextsendquote"), "Next button");
    }
}
