package Tests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;
import utilities.SetDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    SetDriver settings;

    @Parameters({"grid"})
    @BeforeMethod
    public void SetUp(String grid) throws MalformedURLException {
        if (grid.contains("true")){
            settings = new SetDriver();
            driver = settings.setBrowser(BrowserType.FIREFOX);
        }
        else {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/en/");
    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
        driver = null;
    }



}
