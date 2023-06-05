import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginMainPageTest extends BaseTest {
    public LoginMainPageTest(String browser) {
        super(browser);
    }

    @Test
    public void checkLoginMainPage() {
        MainPage mainPage = new MainPage(driver);
        driver.get(GlobalData.URL);
        mainPage.waitForLoadDataEnterButton();
        mainPage.clickEnterButton();
        Assert.assertEquals(true, mainPage.waitForAddOrderLink());
    }
    @Test
    public void checkLoginLK() {
        MainPage mainPage = new MainPage(driver);
         driver.get(GlobalData.URL);
        mainPage.waitForLoadDataEnterButton();
        mainPage.clickLkLink();
        new WebDriverWait(driver, 10);
        Assert.assertEquals(GlobalData.URL_LOGIN, driver.getCurrentUrl());
    }
}
