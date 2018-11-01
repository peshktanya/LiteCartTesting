package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.ResetPasswordPage;
import org.testng.annotations.Test;

public class LoginExampleTest extends TestBase {

   @Test
    public void testSuccessLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.loginSuccessfullyWithNameAndPassword("john@smith.com", "qwerty")
                .DuckClick();
    }

    @Test
    public void testFailLogin() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage =  homePage.loginFailedWithNameAndPassword("john@smith.com", "1234");
        loginPage.loggedInFailed();
    }

    @Test
    public void openCreateNewAccount() {
        HomePage homePage = new HomePage(driver);
        homePage.openCreateNewAccount();

    }

    @Test
    public void createNewAccountMainMenu() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openCreateNewAccount();
       /* ResetPasswordPage resetPage = mainPage.openResetPasswordPage();
        resetPage.resetPasswordClick("qwerty@qwerty.com")
                .checkErrorMsg();*/
    }
}
