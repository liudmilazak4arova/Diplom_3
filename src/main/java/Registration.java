import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Registration {
    public Registration(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    //Name
    private By name_email = By.xpath(".//div[@class='input pr-6 pl-6 input_type_text input_size_default']/input");

    // password
    private By passwordBy = By.xpath(".//input[@name='Пароль']");

    //Кнопка "Зарегистрироваться
    private By registerButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    //Ссылка "Войти"
    public By enterLink = By.linkText("Войти");
    public void changeInput(WebElement element, String newText){
        if (element.isEnabled() ) {
            element.click();
            element.clear();
            element.sendKeys(newText);
        }
    }

    public void fill1Form(String name, String email, String password) {
        List<WebElement> elements = driver.findElements(name_email);
        WebElement element = elements.get(0);
        changeInput(element, name);
        element = elements.get(1);
        changeInput(element, email);
        element = driver.findElement(passwordBy);
        changeInput(element, password);
    }
    public void waitForLoadData() {
        WebElement element = driver.findElement(registerButton);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
    public  void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }

    public void clickEnterLink() {
        WebElement element = driver.findElement(enterLink);
        if (element.isDisplayed()) {
            element.click();
        }
    }
}
