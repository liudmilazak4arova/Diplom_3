import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LKPage {
    public LKPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    By exitButton = By.xpath(".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']");

    public void waitForLoadData() {
        WebElement element = driver.findElement(exitButton);
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
    }

    public  void clickExitButton(){
        driver.findElement(exitButton).click();
    }
}
