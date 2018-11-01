package utilities;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SetDriver {
    DesiredCapabilities capabilities;

    public WebDriver setBrowser(String type) throws MalformedURLException {

        if (type.contains("firefox"))
            capabilities = new DesiredCapabilities(new FirefoxOptions());
        else if (type.contains("internet explorer"))
            capabilities = new DesiredCapabilities(DesiredCapabilities.internetExplorer());
        else if (type.contains("chrome"))
            capabilities = new DesiredCapabilities(new ChromeOptions());
        else
            capabilities=new DesiredCapabilities(DesiredCapabilities.firefox());

        capabilities.setBrowserName(type);
        capabilities.setPlatform(Platform.WINDOWS);
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    }

}
