import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginRegistrationPageTestYandex extends BaseTest {
    @Test
    public void checkLogin() {
        Registration registration = new Registration(driver);
        driver.get(GlobalData.URL_REGISTER);
        registration.waitForLoadData();
        registration.clickEnterLink();
        new WebDriverWait(driver, 10);
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(GlobalData.URL_LOGIN, driver.getCurrentUrl());
    }
}
