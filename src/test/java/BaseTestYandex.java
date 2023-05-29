import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTestYandex extends BaseTest {
    @Before
    public void setUP() {
        ChromeOptions chromeOptions = new ChromeOptions();
        //  chromeOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");

       System.setProperty("webdriver.chrome.driver","src/test/resources/yandexdriver.exe");
        ChromeOptions options=new ChromeOptions();
      //  options.setBinary("\"C:\\Program Files (x86)\\Yandex\\YandexBrowser\\Application\\browser.exe\"");
       driver= new ChromeDriver(options);
    }
}
