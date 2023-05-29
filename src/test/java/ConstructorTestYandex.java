import org.junit.Test;

public class ConstructorTestYandex extends BaseTestYandex {
    @Test
    public void checkIngridientsAvailable() {
        MainPage mainPage = new MainPage(driver);
        driver.get(GlobalData.URL);
        mainPage.waitForLoadData();
        mainPage.clickInridients();
    }
}