import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;

    }

    //Кнопка войти в аккаунт
    public By enterButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");

    //Кнопка Оформить заказ
    public By addOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    //Кнопка Зарегистрироваться
    public By registerLink = By.linkText("Зарегистрироваться");
    //Кнопка "Личный кабинет"
    public By lkLink = By.linkText("Личный Кабинет");
    public By ingrientsLink = By.xpath(".//span[@class='text text_type_main-default']");

    public void waitForLoadDataEnterButton() {
        WebElement element = driver.findElement(enterButton);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForLoadDataLkLink() {
        WebElement element = driver.findElement(lkLink);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
// Появление кнопки Оформить заказ
    public boolean waitForAddOrderLink() {
        WebElement element = driver.findElement(lkLink);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    //кнопка "Войти в аккаунт"
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }


    //кнопка "Зарегистрироваться"
    public void clickLkLink() {
        WebElement element = driver.findElement(lkLink);
        if (element.isDisplayed()) {
            element.click();
        }
    }

    public void clickRegisterLink() {
        WebElement element = driver.findElement(registerLink);
        if (element.isDisplayed()) {
            element.click();
        }
    }
    public boolean checkInridients(){
        boolean isIngridientsEnable = true;
        List<WebElement> ingridientsElem= driver.findElements(ingrientsLink);
        for (WebElement i:ingridientsElem){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", i);
            if (!i.isEnabled()) {isIngridientsEnable = false;}
        }
        return  isIngridientsEnable;
    }
}
