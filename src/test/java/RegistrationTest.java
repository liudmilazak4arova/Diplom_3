import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

//@RunWith(value= Parameterized.class)
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
        Assert.assertEquals(true, loginPage.waitForLoadData());
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
        Assert.assertEquals(true,registration.isVisibleRegisterButton());
    }

}
