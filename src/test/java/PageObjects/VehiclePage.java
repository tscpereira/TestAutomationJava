package PageObjects;

import TestTools.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VehiclePage {

    public Element Make;
    public Element Model;
    public Element CylinderCapacity;
    public Element EnginePerformance;
    public Element DateOfManufacture;
    public Element NumberOfSeats;
    public Element NumberOfSeatsMotorCycle;
    public Element FuelType;
    public Element Payload;
    public Element TotalWeight;
    public Element ListPrice;
    public Element LicensePlateNumber;
    public Element AnnualMileage;
    public Element NextButton;

    public VehiclePage(WebDriver driver){
        Make = new Element(driver, By.id("make"), "Make options");
        Model = new Element(driver, By.id("model"), "Model options");
        CylinderCapacity = new Element(driver, By.id("cylindercapacity"), "Cylinder Capacity options");
        EnginePerformance = new Element(driver, By.id("engineperformance"), "Engine Performance options");
        DateOfManufacture = new Element(driver, By.id("dateofmanufacture"), "Date Of Manufacture date field");
        NumberOfSeats = new Element(driver, By.id("numberofseats"), "Number Of Seats options options");
        NumberOfSeatsMotorCycle = new Element(driver, By.id("numberofseatsmotorcycle"), "Number Of Seats Motor Cycle options");
        FuelType = new Element(driver, By.id("fuel"), "Fuel Type options");
        Payload = new Element(driver, By.id("payload"), "Payload field");
        TotalWeight = new Element(driver, By.id("totalweight"), "Total Weight field");
        ListPrice = new Element(driver, By.id("listprice"), "List Price field");
        LicensePlateNumber = new Element(driver, By.id("licenseplatenumber"), "License Plate Number field");
        AnnualMileage = new Element(driver, By.id("annualmileage"), "Annual Mileage field");
        NextButton = new Element(driver, By.id("nextenterinsurantdata"), "Next button");
    }
}
