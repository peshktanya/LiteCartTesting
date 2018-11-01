package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    String TITLE = "Sign In | My Store";

    public LoginPage(WebDriver driver){
        if (!driver.getTitle().contains(TITLE)){
            throw new IllegalStateException("Login/SignIn page not found!");
        }

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"notices\"]/div")
    WebElement loginMess;

    String failedMessage = "Wrong password";

    public boolean loggedInFailed(){
        return loginMess.getText().contains(failedMessage);
    }

}
