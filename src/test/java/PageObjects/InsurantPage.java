package PageObjects;

import TestTools.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InsurantPage {

    public Element FirstName;
    public Element LastName;
    public Element DOB;
    public Element StreetAddress;
    public Element Country;
    public Element ZipCode;
    public Element City;
    public Element Occupation;
    public Element HobbiesSpeeding;
    public Element NextButton;

    public InsurantPage(WebDriver driver){
        FirstName = new Element(driver, By.id("firstname"), "First Name field");
        LastName = new Element(driver, By.id("lastname"), "Last Name field");
        DOB = new Element(driver, By.id("birthdate"), "Date of Birth field");
        StreetAddress = new Element(driver, By.id("streetaddress"), "Street Address field");
        Country = new Element(driver, By.id("country"), "Country option");
        ZipCode = new Element(driver, By.id("zipcode"), "Zip Code field");
        City = new Element(driver, By.id("city"), "City field");
        Occupation = new Element(driver, By.id("occupation"), "Occupation option");
        HobbiesSpeeding = new Element(driver, By.xpath("//*[@id='speeding']/following-sibling::span"), "Speeding checkbox");
        NextButton = new Element(driver, By.id("nextenterproductdata"), "Next button");
    }
}
