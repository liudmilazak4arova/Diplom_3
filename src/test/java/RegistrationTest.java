import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

@RunWith(value= Parameterized.class)
public class RegistrationTest  extends BaseTest{

    private String name;
    private String email;

    public RegistrationTest(String name, String email, String password, String url) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.url = url;
    }

    private String password;
    private String url;



    @Parameterized.Parameters
    public static List<Object[]> data() {
        Object[][] data = new Object[][]{
                {UserData.name, UserData.email, UserData.password, GlobalData.URL_LOGIN},
                {"name", "w2@mail.ru", "pass", GlobalData.URL_REGISTER}
        };
        return Arrays.asList(data);
        };

    @Test
    public void checkRegistration() {
        MainPage mainPage = new MainPage(driver);
        Registration registration = new Registration(driver);
        driver.get(GlobalData.URL);
        mainPage.waitForLoadData();
        mainPage.clickEnterButton();
        mainPage.clickRegisterLink();
        registration.fill1Form(name,email,password);
        registration.clickRegisterButton();

        loginAndDeleteHandle(UserData.email, UserData.password);
        new WebDriverWait(driver, 10);
        Assert.assertEquals(url, driver.getCurrentUrl());



    }

}
