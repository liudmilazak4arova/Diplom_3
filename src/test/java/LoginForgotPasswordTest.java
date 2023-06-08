import org.junit.Assert;
import org.junit.Test;


public class LoginForgotPasswordTest extends  BaseTest{
    public LoginForgotPasswordTest(String browser) {
        super(browser);
    }

    @Test
    public void checkLogin() {
        ForgotPasswordPage forgotPasswordPage= new ForgotPasswordPage(driver);
        driver.get(GlobalData.URL_FORGOT_PASSWORD);
        forgotPasswordPage.waitForLoadData();
        forgotPasswordPage.clickEnterLink();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue( mainPage.waitForAddOrderLink());
    }
}
