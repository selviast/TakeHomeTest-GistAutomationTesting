package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    @FindBy (id = "login_field")
    WebElement inputEmail;

    @FindBy (id = "password")
    WebElement inputPassword;

    @FindBy (xpath = "//input[@value=\"Sign in\"]")
    WebElement submitSignInButton;

    @FindBy (xpath = "//h1[@class='float-none flex-auto pl-0 width-fit']")
    WebElement titleDiscoverGist;

    @FindBy (xpath = "//div[@role='alert' and contains(text(), 'Incorrect')]")
    WebElement errorMessage;


    public LoginPage (WebDriver driver){
        super(driver);
    }

    public void login(String email, String password) {
        waitForVisibility(inputEmail);
        inputEmail.sendKeys(email);
        log.info("input email: " + email);
        inputPassword.sendKeys(password);
        log.info("input password: " + password);
        submitSignInButton.click();
        log.info("sign in button clicked");
    }

    public boolean isTitleDiscoverGistsVisible(){
        waitForVisibility(titleDiscoverGist);
        log.info(titleDiscoverGist + " sudah tertampil");
        return titleDiscoverGist.isDisplayed();
    }

    public boolean isErrorMessageVisible(){
        waitForVisibility((errorMessage));
        log.info(errorMessage + " sudah tertampil");
        return errorMessage.isDisplayed();
    }



}
