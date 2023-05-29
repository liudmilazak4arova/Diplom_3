import org.junit.Test;

public class ConstructorTest extends BaseTest {
    @Test
    public void checkIngridientsAvailable() {
        MainPage mainPage = new MainPage(driver);
        driver.get(GlobalData.URL);
        mainPage.waitForLoadData();
        mainPage.clickInridients();
    }
}