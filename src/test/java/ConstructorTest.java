import org.junit.Assert;
import org.junit.Test;

public class ConstructorTest extends BaseTest {
    public ConstructorTest(String browser) {
        super(browser);
    }

    @Test
    public void checkBunsAvailable() {
        MainPage mainPage = new MainPage(driver);
        driver.get(GlobalData.URL);
        mainPage.ingridientClick(0);
        Assert.assertTrue(mainPage.isActiveMenu(0, 1, 2));
    }

    @Test
    public void checkSausesAvailable() {
        MainPage mainPage = new MainPage(driver);
        driver.get(GlobalData.URL);
        mainPage.ingridientClick(1);
        Assert.assertTrue(mainPage.isActiveMenu(1, 0, 2));
    }

    @Test
    public void checkFillingAvailable() {
        MainPage mainPage = new MainPage(driver);
        driver.get(GlobalData.URL);
        mainPage.ingridientClick(2);
        Assert.assertTrue(mainPage.isActiveMenu(2, 1, 0));
    }
}