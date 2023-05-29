import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    By loginButton = By.xpath(".//button[@class ='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    //Ввод email
    By emailInput = By.xpath(".//div[@class='input pr-6 pl-6 input_type_text input_size_default']/input");
    //Ввод пароля
    By passwordInput =  By.xpath(".//div[@class='input pr-6 pl-6 input_type_password input_size_default']/input");

    public void waitForLoadData() {
        WebElement element = driver.findElement(loginButton);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }

    public  void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
    public void changeInput(WebElement element, String newText){
        if (element.isEnabled() ) {
            element.click();
            element.clear();
            element.sendKeys(newText);
        }
    }
    public void fill1Form(String email, String password) {
        WebElement element  = driver.findElement(emailInput);
        changeInput(element, email);
        element  = driver.findElement(passwordInput);
        changeInput(element, password);
    }
}
