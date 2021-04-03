package PageObjects;

import TestTools.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    public Element StartDate;
    public Element InsuranceSum;
    public Element MeritRating;
    public Element DamageInsurance;
    public Element EuroProtection;
    public Element CourtesyCar;
    public Element NextButton;

    public ProductPage(WebDriver driver){
        StartDate = new Element(driver, By.id("startdate"), "Start Date field");
        InsuranceSum = new Element(driver, By.id("insurancesum"), "Insurance Sum option");
        MeritRating = new Element(driver, By.id("meritrating"), "Merit Rating option");
        DamageInsurance = new Element(driver, By.id("damageinsurance"), "Damage Insurance option");
        EuroProtection = new Element(driver, By.xpath("//*[@id='EuroProtection']/following-sibling::span"), "Euro Protection checkbox");
        CourtesyCar = new Element(driver, By.id("courtesycar"), "Courtesy Car option");
        NextButton = new Element(driver, By.id("nextselectpriceoption"), "Next button");
    }
}
