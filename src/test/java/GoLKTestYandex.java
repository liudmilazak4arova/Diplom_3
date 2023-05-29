import org.junit.Assert;
import org.junit.Test;


public class GoLKTestYandex extends BaseTest {
    @Test
    public void checkGoLK() {
        enterRegisteredUser();
        MainPage mainPage = new MainPage(driver);

        // переход на страницу тестового приложения
        driver.get(GlobalData.URL);
        mainPage.waitForLoadData();
        mainPage.clickLkLink();
        LKPage lkPage = new LKPage(driver);
        lkPage.waitForLoadData();
        Assert.assertEquals(GlobalData.URL_ACCOUNT_PROFILE, driver.getCurrentUrl());
        loginAndDeleteHandle(UserData.email, UserData.password);
    }
    @Test
    public void chectExitLK() {
        enterRegisteredUser();
        MainPage mainPage = new MainPage(driver);
        driver.get(GlobalData.URL);
        mainPage.waitForLoadData();
        mainPage.clickLkLink();
        LKPage lkPage = new LKPage(driver);
        lkPage.waitForLoadData();
        lkPage.clickExitButton();
        loginAndDeleteHandle(UserData.email, UserData.password);
    }
}
