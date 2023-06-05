import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoLKTest extends BaseTest{
    public GoLKTest(String browser) {
        super(browser);
    }

    @Test
    public void checkGoLK() {
        createUserHandle(UserData.name, UserData.email, UserData.password);
        //Входит под этим пользователем
        LoginPage  loginPage = new LoginPage(driver);
        driver.get(GlobalData.URL_LOGIN);
        loginPage.fill1Form(UserData.email, UserData.password);
        loginPage.clickLoginButton();
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadDataLkLink();
        mainPage.clickLkLink();
        LKPage lkPage = new LKPage(driver);
        boolean isLK = lkPage.waitForLoadData();
        Assert.assertEquals(true,isLK);

    }
    @Test
    public void checkExitLK() {
        createUserHandle(UserData.name, UserData.email, UserData.password);
        //Входит под этим пользователем
        LoginPage  loginPage = new LoginPage(driver);
        driver.get(GlobalData.URL_LOGIN);
        loginPage.fill1Form(UserData.email, UserData.password);
        loginPage.clickLoginButton();
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadDataLkLink();
        mainPage.clickLkLink();
        LKPage lkPage = new LKPage(driver);
        lkPage.clickExitButton();
        Assert.assertEquals(true, loginPage.waitForLoadData());

    }
}
