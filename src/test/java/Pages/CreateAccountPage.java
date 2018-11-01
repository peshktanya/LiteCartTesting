package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
    WebDriver driver;
    String TITLE = "Create Account | My Store";

    public CreateAccountPage(WebDriver driver){
        if (!driver.getTitle().contains(TITLE)){
            throw new IllegalStateException("Create Account page not found!");
        }

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
