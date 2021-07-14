package Steps;

import java.io.IOException;
import java.util.Collection;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;

public class CommonSteps {

    private WebDriver driver;

    @Before
    public void testSetup(Scenario scenario) throws ParserConfigurationException, SAXException, IOException {
        Collection<String> tags = scenario.getSourceTagNames();

        if (tags.contains("@selenium")) {
            driver = new ChromeDriver();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
