import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginMainPageTest extends BaseTest {
    @Test
    public void checkLoginMainPage() {
        MainPage mainPage = new MainPage(driver);
        driver.get(GlobalData.URL);
        mainPage.waitForLoadData();
        mainPage.clickEnterButton();
        new WebDriverWait(driver, 10);
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(GlobalData.URL_LOGIN, driver.getCurrentUrl());
    }
    @Test
    public void checkLoginLK() {
        MainPage mainPage = new MainPage(driver);
         driver.get(GlobalData.URL);
        mainPage.waitForLoadData();
        mainPage.clickLkLink();
        new WebDriverWait(driver, 10);
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(GlobalData.URL_LOGIN, driver.getCurrentUrl());
    }
}
