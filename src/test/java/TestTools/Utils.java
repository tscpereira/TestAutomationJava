package TestTools;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;


public class Utils {

    WebDriver driver;

    public Utils(WebDriver driver){
        this.driver = driver;
    }

    public void TakeScreenShot(String filepath) throws IOException {
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SourceFile=scrShot.getScreenshotAs(OutputType.FILE);
        File TargetFile=new File(filepath);
        FileUtils.copyFile(SourceFile, TargetFile);
    }
}
