import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage {
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    //Ссылка "Войти"
    public By enterLink = By.linkText("Войти");

    public void clickEnterLink() {
        WebElement element = driver.findElement(enterLink);
        if (element.isDisplayed()) {
            element.click();
        }
    }

    public void waitForLoadData() {
        WebElement element = driver.findElement(enterLink);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
}