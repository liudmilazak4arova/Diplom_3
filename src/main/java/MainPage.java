import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

   //Кнопка Зарегистрироваться
    public By registerLink = By.linkText("Зарегистрироваться");
    //Кнопка "Личный кабинет"
    public By lkLink = By.linkText("Личный Кабинет");
    public By ingrientsLink = By.xpath(".//div[@style='display: flex;']/div");

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

    public boolean ingridientClick(int i){
        List<WebElement> ingridientsElem= driver.findElements(ingrientsLink);
        WebElement ingridient =ingridientsElem.get(i);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ingridient);
            if (ingridient.getAttribute("class").equals("tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect")) {
                ingridient.click();
        }
        return  ingridient.isEnabled();
    }

    public  boolean isVisiblePanel(String textPanel){
        String searchStr = ".//h2[text()='" + textPanel + "']";
        System.out.println(searchStr);
        By h2 = By.xpath(searchStr);
        WebElement element = driver.findElement(h2);
        return  element.isDisplayed();
    }
}
