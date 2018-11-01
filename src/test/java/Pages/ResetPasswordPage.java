package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage {
    WebDriver driver;
    String TITLE = "Reset Password";

    public ResetPasswordPage(WebDriver driver){
        if (!driver.getTitle().contains(TITLE)){
            throw new IllegalStateException("Reset password page not found!");
        }

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    WebElement emailInput;

    @FindBy(name = "reset_password")
    WebElement resetBtn;

    public ResetPasswordPage resetPasswordClick(String email){
        assert emailInput.isEnabled();
        emailInput.click();
        emailInput.sendKeys(email);
        resetBtn.click();
        return new ResetPasswordPage(driver);
    }

    @FindBy(xpath = "#notices > div")
    WebElement alertErr;

    public boolean checkErrorMsg() {
        return alertErr.getText().contains("The email address does not exist");
    }


    public void isInitialized(){
        emailInput.isDisplayed();
    }
}
