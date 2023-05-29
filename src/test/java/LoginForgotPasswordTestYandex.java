import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginForgotPasswordTestYandex extends BaseTest {
    @Test
    public void checkLogin() {
        ForgotPasswordPage forgotPasswordPage= new ForgotPasswordPage(driver);
        driver.get(GlobalData.URL_FORGOT_PASSWORD);
        forgotPasswordPage.waitForLoadData();
        forgotPasswordPage.clickEnterLink();
        new WebDriverWait(driver, 10);
        Assert.assertEquals(GlobalData.URL_LOGIN, driver.getCurrentUrl());
    }
}
