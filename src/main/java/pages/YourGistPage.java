package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class YourGistPage extends BasePage {
    private static final Logger log = LogManager.getLogger(YourGistPage.class);

    @FindBy(xpath = "(//strong[@class=\"css-truncate-target\"])[1]")
    private WebElement getFirstListCreatedGist;

    @FindBy(xpath = "(//strong[@class=\"css-truncate-target\"])")
    private List<WebElement> gistTitleList;

    @FindBy(xpath = "//span[contains(@itemprop,'additionalName')]")
    private WebElement accountUsername;

    @FindBy(xpath = "//div[contains(normalize-space(), 'Gist deleted successfully')]\n")
    private WebElement alertDeleteSuccessfully;


    public YourGistPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAlertDeleteSuccessVisible() {
        waitForVisibility(alertDeleteSuccessfully);
        return alertDeleteSuccessfully.isDisplayed();
    }

    public void navigateToCreatedGistDetail() {
        waitForVisibility(accountUsername);
        log.info("cek url contains : " + accountUsername.getText());
//        waitForUrlContains(accountUsername.getText());
//        log.info("url : " + accountUsername.getText());
        getFirstListCreatedGist.click();
    }

    //  Ambil semua judul gist yang tampil di halaman
    public List<String> getListOfGistTitles() {
        waitForVisibility(accountUsername);
        List<String> gistTitles = new ArrayList<>();
        for (WebElement title : gistTitleList) {
            gistTitles.add(title.getText().trim());
        }
        return gistTitles;
    }

    // Cek apakah gist dengan title tertentu ada
    public boolean isGistTitlePresent(String titleToCheck) {
        List<String> allTitles = getListOfGistTitles();
        for (String title : allTitles) {
            if (title.startsWith(titleToCheck)) {  // bisa diganti startsWith(titleToCheck) kalau pattern-nya prefix
                return true;
            }
        }
        return false;
        }
}