import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LKPage {
    public LKPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    public By exitButton = By.xpath(".//button[text()='Выход']");

    public By notes = By.xpath(".//p[text()='В этом разделе вы можете изменить свои персональные данные']");
      public boolean waitForLoadData() {
        WebElement element = driver.findElement(notes);
          new WebDriverWait(driver, 10).until(driver -> (element.getText() != null
                  && !element.getText().isEmpty()
          ));
        return element.isDisplayed();
    }

    public  void clickExitButton(){
        driver.findElement(exitButton).click();
    }
}
