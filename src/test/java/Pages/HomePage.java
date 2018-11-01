package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

public class HomePage {
    WebDriver driver;
    String TITLE = "My Store | Online Store";

    public HomePage(WebDriver driver){
        if (!driver.getTitle().contains(TITLE)){
            throw new IllegalStateException("Home page not found!");
        }

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

    public void clickSignIn(){
        signIn.click();
    }

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

    public HomePage loginSuccessfullyWithNameAndPassword(String email, String password){
        loginWithNameAndPass(email, password);
        loggedInSuccessfully();
        return new HomePage(driver);
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

    @FindBy(how = How.XPATH, using = "//*[@id=\"default-menu\"]/ul[2]/li/ul/li[2]/a")
    WebElement newCustomerLink;


    public CreateAccountPage openCreateNewAccount(){
        signIn.click();
        newCustomerLink.click();
        return new CreateAccountPage(driver);
    }

    @FindBys({
            @FindBy(name = "email"),
            @FindBy(className = "form-control")
    })
    private List<WebElement> account;

    @FindAll({
            @FindBy(name = "name"),
            @FindBy(name = "password")
    })
    private List<WebElement> account2;

    @FindBy(className = "input-group")
    private List<WebElement> inputList;

}
