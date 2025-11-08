package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver; // ke anak2nya jg (beda folder bisa)
    protected WebDriverWait wait; // kalo private cmn di class ini aja --> harus bikin function.

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForUrlContains(String text) {
        wait.until(ExpectedConditions.urlContains(text));
    }
}
