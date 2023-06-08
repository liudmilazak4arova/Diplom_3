import org.junit.Assert;
import org.junit.Test;

public class LoginRegistrationPageTest extends BaseTest {
    public LoginRegistrationPageTest(String browser) {
        super(browser);
    }

    @Test
    public void checkLogin() {
        Registration registration = new Registration(driver);
        driver.get(GlobalData.URL_REGISTER);
        registration.waitForLoadData();
        registration.clickEnterLink();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue( mainPage.waitForAddOrderLink());
    }
}
