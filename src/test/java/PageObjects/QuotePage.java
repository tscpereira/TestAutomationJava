package PageObjects;

import TestTools.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuotePage {

    public Element Email;
    public Element UserName;
    public Element Password;
    public Element PasswordConfirmation;
    public Element SendButton;
    public Element LoadingIcon;
    public Element SuccessMessage;

    public QuotePage(WebDriver driver){
        Email = new Element(driver, By.id("email"), "Email field");
        UserName = new Element(driver, By.id("username"), "User Name field");
        Password = new Element(driver, By.id("password"), "Password field");
        PasswordConfirmation = new Element(driver, By.id("confirmpassword"), "Password Confirmation field");
        SendButton = new Element(driver, By.id("sendemail"), "Send button");
        LoadingIcon = new Element(driver, By.className("isloading-overlay"), "Loading icon");
        SuccessMessage = new Element(driver, By.xpath("//*[text()='Sending e-mail success!']"), "Success message");
    }
}
