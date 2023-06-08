import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
@RunWith(Parameterized.class)
public class BaseTest {

    public BaseTest(String browser) {
        this.browser = browser;
    }

    private String browser;

    protected WebDriver driver;
    @Parameterized.Parameters
    public static List<Object[]> data() {
        Object[][] data = new Object[][]{
                {"Chrome"},
                {"Yandex"}
        };
        return Arrays.asList(data);
    }

    public void createUserHandle(String name, String email, String password){
        RestAssured.baseURI = GlobalData.URL;
        String jsonString ="{\"name\":\""+name+"\",\"email\":\""+email+"\",\"password\":\""+password+"\"}";
       given()
                .header("Content-type", "application/json")
                .and()
                .body(jsonString)
                .when()
                .post(GlobalData.SERVICE_USER_REGISTER);
    }
    public void loginAndDeleteHandle(String email, String password){
        RestAssured.baseURI = GlobalData.URL;
        String jsonString ="{\"email\":\""+email+"\",\"password\":\""+password+"\"}";
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(jsonString)
                .when()
                .post(GlobalData.SERVICE_USER_LOGIN);
        String    token = response.then().extract().path("accessToken");
        if (token!=null){
            given()
                .header("Authorization", token)
                .when()
                .delete(GlobalData.SERVICE_USER_DELETE);}
    }

    @Before
    public void setUP() {
        if (browser.equals("Chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
            driver = new ChromeDriver(chromeOptions);
        }
        if (browser.equals("Yandex")){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");

            System.setProperty("webdriver.chrome.driver","src/test/resources/yandexdriver.exe");
            ChromeOptions options=new ChromeOptions();
            driver= new ChromeDriver(options);
        }
    }

    @After
    public void teardown() {
        loginAndDeleteHandle(UserData.email, UserData.password);
        driver.quit();
    }

}
