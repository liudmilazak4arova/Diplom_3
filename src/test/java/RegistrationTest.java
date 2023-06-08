import org.junit.Assert;
import org.junit.Test;

public class RegistrationTest  extends BaseTest{
    public RegistrationTest(String browser) {
        super(browser);
    }

    @Test
    public void checkRegistration() {
        MainPage mainPage = new MainPage(driver);
        Registration registration = new Registration(driver);
        driver.get(GlobalData.URL);
        mainPage.waitForLoadDataEnterButton();
        mainPage.clickEnterButton();
        mainPage.clickRegisterLink();
        registration.fill1Form(UserData.name, UserData.email, UserData.password);
        registration.clickRegisterButton();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.waitForLoadData());
    }

    @Test
    public void checkRegistrationShortPassword() {
        MainPage mainPage = new MainPage(driver);
        Registration registration = new Registration(driver);
        driver.get(GlobalData.URL);
        mainPage.waitForLoadDataEnterButton();
        mainPage.clickEnterButton();
        mainPage.clickRegisterLink();
        registration.fill1Form("name", "email", "pass");
        registration.clickRegisterButton();
        Assert.assertTrue(registration.isVisibleRegisterButton());
    }

}
