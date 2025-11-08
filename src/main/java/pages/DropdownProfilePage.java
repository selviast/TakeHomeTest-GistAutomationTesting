package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropdownProfilePage extends BasePage{
    private static final Logger log = LogManager.getLogger(DropdownProfilePage.class);

    @FindBy (xpath = "//button[contains(@aria-label,'profile')]")
    private WebElement dropdownIcon;

    @FindBy (xpath = "//span[normalize-space()='Your gists']")
    private WebElement yourGistMenu;

    public DropdownProfilePage (WebDriver driver){
        super(driver);
    }

    public void navigateToYourGistPage(){
        waitForClickable(dropdownIcon);
        log.info("Dropdown Icon sudah muncul");
        dropdownIcon.click();
        log.info("Click Dropdown");
        yourGistMenu.click();
        log.info(("Click Menu Your Gist"));
    }

}
