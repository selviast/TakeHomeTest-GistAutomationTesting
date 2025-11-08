package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.DriverManager;

public class DetailCreatedGistPage extends BasePage{
    private static final Logger log = LogManager.getLogger(DetailCreatedGistPage.class);

    @FindBy (xpath = "//a[@class='js-selected-navigation-item selected UnderlineNav-item']")
    private WebElement subMenuCode;

    @FindBy (xpath = "//span[@class='Button-label'][normalize-space()='Edit']")
    private WebElement editButton;

    @FindBy (xpath = "//span[@class='Button-label'][normalize-space()='Delete']")
    private WebElement deleteButton;


    public DetailCreatedGistPage (WebDriver driver){
        super(driver);
    }

    public boolean isSubMenuCodeVisible(){
        waitForVisibility(subMenuCode);
        log.info("Sub heading menu terlihat..");
        return subMenuCode.isDisplayed();
    }
    public void navigateToEditGistPage(){
        editButton.click();
        log.info("Click Edit Button");
    }

    public void deleteGist(){
        // Klik tombol delete
        waitForVisibility(deleteButton);
        deleteButton.click();

        Alert confirm = driver.switchTo().alert();
        System.out.println("Popup message: " + confirm.getText());
        confirm.accept();
    }


}
