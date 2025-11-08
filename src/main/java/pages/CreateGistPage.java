package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateGistPage extends BasePage {
    private static final Logger log = LogManager.getLogger(CreateGistPage.class);

    @FindBy(xpath = "//h1[normalize-space()='Instantly share code, notes, and snippets.']")
    private WebElement getCreateNewGistPageHeading;

    @FindBy(xpath = "//input[@placeholder='Gist description…']")
    private WebElement inputDescription;

    @FindBy(xpath = "//input[@placeholder='Filename including extension…']")
    private WebElement inputFileName;

    @FindBy (xpath = "//div[@class='CodeMirror-code']")
//    @FindBy (xpath = "//*[@id=\"code-editor\"]/div/pre/span")
        private WebElement inputPresentation;

    @FindBy(xpath = "//summary[@aria-label='Select a type of Gist']")
    private WebElement dropdownSelectTypeofGist;

    @FindBy(xpath = "//span[@class='select-menu-item-heading'][normalize-space()='Create public gist']")
    private WebElement optionCreatePublicGist;

    @FindBy(xpath = "//span[@class='select-menu-item-heading'][normalize-space()='Create secret gist']")
    private WebElement optionCreateSecretGist;

    @FindBy(xpath = "//button[normalize-space()='Create secret gist']")
    private WebElement submitCreateSecretGistButton;

    @FindBy(xpath = "//button[normalize-space()='Create public gist']")
    private WebElement getSubmitCreatePublicGistButton;

    @FindBy(xpath = "//div[@itemprop='about']")
    private WebElement getTitleNewGist;

    public CreateGistPage(WebDriver driver) {
        super(driver);
    }

    public void createNewGist() {
        String titleDescription = "TitleDescription " + System.currentTimeMillis();
        String fileName = "file_name_" + System.currentTimeMillis();
        String presentationContent = "Lorem ipsum dolor sit amet, \n" +
                "consectetur adipiscing elit, sed do eiusmod tempor \n" +
                "incididunt ut labore et dolore magna aliqua. Ut enim ad \n" +
                "minim veniam, quis nostrud exercitation ullamco laboris \n" +
                "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor \n" +
                "in reprehenderit in voluptate velit esse cillum dolore eu fugiat \n" +
                "nulla pariatur. Excepteur sint occaecat cupidatat non proident, \n" +
                "sunt in culpa qui officia deserunt mollit anim id est laborum.";

        waitForVisibility(inputDescription);

        inputDescription.sendKeys(titleDescription);
        log.info("input title desc: " + titleDescription);
        inputFileName.sendKeys(fileName);
        log.info("input file name: " + fileName);
        waitForVisibility(inputPresentation);
        inputPresentation.sendKeys(presentationContent);
        log.info("input code: " + presentationContent);
        dropdownSelectTypeofGist.click();
        optionCreatePublicGist.click();
        getSubmitCreatePublicGistButton.click();

    }

    public boolean isDetailCreatedGistVisible(){
        waitForVisibility(getTitleNewGist);
        return getTitleNewGist.isDisplayed();
    }

}
