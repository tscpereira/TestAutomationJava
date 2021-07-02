package Steps;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import PageObjects.*;
import TestTools.ReadFiles;
import TestTools.Utils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;


public class SendQuoteSteps {

    private WebDriver driver;
    private Customer testCustomer;
    private VehiclePage vehicle;
    private InsurantPage insurant;
    private ProductPage product;
    private PricePage price;
    private QuotePage quote;
    private Utils utils;
    private String resultPath;
    private String url;

    @Before
    public void testSetup(Scenario scenario) throws ParserConfigurationException, SAXException, IOException {
        Collection<String> tags = scenario.getSourceTagNames();
        ReadFiles read = new ReadFiles();
        resultPath = read.ReadConfigFile("testResultPath");
        String driverPath = read.ReadConfigFile("chromdeDriverPath");

        if (tags.contains("selenium")){
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
            utils = new Utils(driver);
            vehicle = new VehiclePage(driver);
            insurant = new InsurantPage(driver);
            product = new ProductPage(driver);
            price = new PricePage(driver);
            quote = new QuotePage(driver);
            driver.manage().window().maximize();
        }
    }

    @After
    public void cleanup(){
        if (driver != null){
            driver.quit();
        }
        System.out.println("Test evidences saved at '" + resultPath + "'");
    }

    @Given("I'm in the Vehicle Data page")
    public void im_in_the_vehicle_page(){
        driver.get(url);
    }

    @And("I have the following customer information")
    public void i_have_the_following_customer_information(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        testCustomer = new Customer();
        for (List<String> columns : rows) {
            testCustomer.setFirstName(columns.get(0));
            testCustomer.setLastName(columns.get(1));
            testCustomer.setDateOfBirth(columns.get(2));
            testCustomer.setAddress(columns.get(3));
            testCustomer.setCountry(columns.get(4));
            testCustomer.setZipCode(columns.get(5));
            testCustomer.setCity(columns.get(6));
            testCustomer.setOccupation(columns.get(7));
        }
    }

    @Then("I fill all the vehicle required fields")
    public void i_fill_all_the_vehicle_required_fields() throws IOException {
        vehicle.Make.Select("BMW");
        vehicle.Model.Select("Scooter");
        vehicle.CylinderCapacity.SendKeys("1000");
        vehicle.EnginePerformance.SendKeys("1000");
        vehicle.DateOfManufacture.SendKeys("10/10/1980");
        vehicle.NumberOfSeats.Select("3");
        vehicle.NumberOfSeatsMotorCycle.Select("3");
        vehicle.FuelType.Select("Gas");
        vehicle.Payload.SendKeys("300");
        vehicle.TotalWeight.SendKeys("450");
        vehicle.ListPrice.SendKeys("10000");
        vehicle.LicensePlateNumber.SendKeys("100AA");
        vehicle.AnnualMileage.SendKeys("1000");
        utils.TakeScreenShot(resultPath + "VehicleData.png");
    }

    @And("Move to Insurant Data page")
    public void move_to_insurant_data_page(){
        vehicle.NextButton.Click();
    }

    @Then("I fill all the insurant required fields")
    public void i_fill_all_the_insurant_required_fields() throws IOException {
        insurant.FirstName.SendKeys(testCustomer.getFirstName());
        insurant.LastName.SendKeys(testCustomer.getLastName());
        insurant.DOB.SendKeys(testCustomer.getDateOfBirth());
        insurant.StreetAddress.SendKeys(testCustomer.getAddress());
        insurant.Country.Select(testCustomer.getCountry());
        insurant.ZipCode.SendKeys(testCustomer.getZipCode());
        insurant.City.SendKeys(testCustomer.getCity());
        insurant.Occupation.Select(testCustomer.getOccupation());
        insurant.HobbiesSpeeding.Check();
        utils.TakeScreenShot(resultPath + "InsurantData.png");
    }

    @And("Move to Product Data page")
    public void move_to_product_data_page(){
        insurant.NextButton.Click();
    }

    @Then("I fill all the product required fields")
    public void i_fill_all_the_product_required_fields() throws IOException {
        product.StartDate.SendKeys("01/01/2022");
        product.InsuranceSum.Select("3000000");
        product.MeritRating.Select("Bonus 1");
        product.DamageInsurance.Select("No Coverage");
        product.EuroProtection.Check();
        product.CourtesyCar.Select("No");
        utils.TakeScreenShot(resultPath + "ProductData.png");
    }

    @And("Move to Price page")
    public void move_to_price_page() {
        product.NextButton.Click();
    }

    @Then("I select a price option")
    public void i_select_a_price_option() throws IOException {
        price.SilverOption.Check();
        utils.TakeScreenShot(resultPath + "PriceOption.png");
    }

    @And("Move to Send Quote page")
    public void move_to_send_quote_page(){
        price.NextButton.Click();
    }

    @Then("I fill all the quote required fields")
    public void i_fill_all_the_quote_required_fields() throws IOException {
        quote.Email.SendKeys(testCustomer.getFirstName() + "@" + testCustomer.getLastName()+ ".com");
        quote.UserName.SendKeys(testCustomer.getFirstName() + "User01");
        quote.Password.SendKeys("Password01!");
        quote.PasswordConfirmation.SendKeys("Password01!");
        utils.TakeScreenShot(resultPath + "QuoteData.png");
    }

    @And("I send the quote request")
    public void i_send_the_quote_request(){
        quote.SendButton.Click();
    }

    @Then("I receive a success message")
    public void i_receive_a_success_message() throws InterruptedException, IOException {
        Assert.assertTrue(quote.LoadingIcon.WaitUntilInvisible(20));
        Assert.assertTrue("Unable to find the success message", quote.SuccessMessage.IsVisible());
        utils.TakeScreenShot(resultPath + "SuccessMessage.png");
    }
}
