import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class BaseTest {
    protected WebDriver driver;
    protected ChromeOptions chromeOptions;

    public void createUserHandle(String name, String email, String password){
        RestAssured.baseURI = GlobalData.URL;
        String jsonString ="{\"name\":\""+name+"\",\"email\":\""+email+"\",\"password\":\""+password+"\"}";
   //     System.out.println(jsonString);
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(jsonString)
                .when()
                .post(GlobalData.SERVICE_USER_REGISTER);
    }
    public void loginAndDeleteHandle(String email, String password){
        RestAssured.baseURI = GlobalData.URL;
        String jsonString ="{\"email\":\""+email+"\",\"password\":\""+password+"\"}";
        System.out.println(jsonString);
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(jsonString)
                .when()
                .post(GlobalData.SERVICE_USER_LOGIN);
        String    token = response.then().extract().path("accessToken");
        System.out.println(token);
        if (token!=null){
            given()
                .header("Authorization", token)
                .when()
                .delete(GlobalData.SERVICE_USER_DELETE);}
    }

    @Before
    public void setUP() {
        ChromeOptions chromeOptions = new ChromeOptions();
      //  chromeOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(chromeOptions);
    }

    public void enterRegisteredUser(){
        //Создаем пользователя вручную
        createUserHandle(UserData.name, UserData.email, UserData.password);
        //Входит под этим пользователем
        LoginPage  loginPage = new LoginPage(driver);
        driver.get(GlobalData.URL_LOGIN);
        loginPage.fill1Form(UserData.email, UserData.password);
        loginPage.clickLoginButton();
    }

    @After
    public void teardown() {
  //      driver.quit();
    }

}
