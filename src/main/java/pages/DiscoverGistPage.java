package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiscoverGistPage extends BasePage {
    private static final Logger log = LogManager.getLogger(DiscoverGistPage.class);

    @FindBy(xpath = "//a[@class='Header-link no-underline mr-3']")
    private WebElement signInButton;

    @FindBy (id = "gists-header-new-gist")
    private WebElement createNewGistButton;


    public DiscoverGistPage(WebDriver driver) {
        super(driver);
    }


    public void navigateToLoginPage() {
        log.info("Click Sign in button");
        waitForClickable(signInButton);
        signInButton.click();
    }

    public boolean isNavigatedToLoginPage() {
        waitForUrlContains("/login");
        log.info("URL mengarah ke login....");
        return driver.getCurrentUrl().contains("/login");
    }

    public void navigateToCreateGist(){
        createNewGistButton.click();
        log.info("Click Create Gist Baru");

    }


}
