package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(partialLinkText = "Sign In")
    private WebElement signIn;

    @FindBy(name = "email")
    WebElement emailTxt;

    @FindBy(name =  "password")
    WebElement passTxt;

    @FindBy(name =  "login")
    WebElement loginBtn;

    @FindBy(css =  "div.alert.alert-success")
    WebElement loginMess;



    private void loginWithNameAndPass(String email, String password) {
        signIn.click();
        emailTxt.sendKeys(email);
        passTxt.sendKeys(password);
        loginBtn.click();
    }

    String successMessage = "You are now logged in as";
    private boolean loggedInSuccessfully(){
        return loginMess.getText().contains(successMessage);
    }

    public MainPage loginSuccessfullyWithNameAndPassword(String email, String password){
        loginWithNameAndPass(email, password);
        loggedInSuccessfully();
        return new MainPage(driver);
    }

    public LoginPage loginFailedWithNameAndPassword(String email, String password){
        loginWithNameAndPass(email, password);

        return new LoginPage(driver);
    }

    @FindBy(xpath = "//*[@id=\"box-category-tree\"]/ul/li/a")
    WebElement duckLink;

    public void DuckClick()
    {
        duckLink.click();
    }

    @FindBy(xpath = "//*[@id=\"default-menu\"]/ul[2]/li/ul/li[2]/a")
    @CacheLookup
    WebElement newCustomerLink;

    public CreateAccountPage openCreateNewAccount(){
        signIn.click();
        newCustomerLink.click();
        return new CreateAccountPage(driver);
    }

    @FindBy(css = "#default-menu > ul.nav.navbar-nav.navbar-right > li > ul > li:nth-child(3) > a")
    WebElement resetPasswordLink;

    public ResetPasswordPage openResetPasswordPage(){
        signIn.click();
        resetPasswordLink.click();
        return new ResetPasswordPage(driver);
    }
}
