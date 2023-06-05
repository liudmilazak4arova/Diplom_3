import org.junit.Assert;
import org.junit.Test;

public class ConstructorTest extends BaseTest {
    public ConstructorTest(String browser) {
        super(browser);
    }


    @Test
    public void checkIngridientsAvailable() {
        MainPage mainPage = new MainPage(driver);
        driver.get(GlobalData.URL);

        Assert.assertEquals(true, mainPage.checkInridients());
    }
}