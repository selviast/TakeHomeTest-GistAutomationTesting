package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import core.BaseTest;
import core.DriverManager;
import core.TestUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DiscoverGistPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(description = "TC002_Verify that the user can log in successfully with valid credentials",
            groups = "regression")
    public void tc002_testLogin() {
        DiscoverGistPage discoverGistPage = new DiscoverGistPage(DriverManager.getDriver());
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());

        discoverGistPage.navigateToLoginPage();
        loginPage.login(config.getProperty("test.email"), config.getProperty("test.password"));
        Assert.assertTrue(loginPage.isTitleDiscoverGistsVisible(), "Login is not navigated to Discover Gists Page");
    }

    @DataProvider(name = "wrongLoginData")
    public Object[][] wrongLoginData() {
        return TestUtils.getTestData("src/test/resources/testdata/testdata.xlsx", "wrong-login-data");
    }

    @Test(description = "TC003_Verify that the user can not login with invalid credentials",
            groups = {"regression", "negative"}, dataProvider = "wrongLoginData")
    public void tc003_testFailedLogin(String email, String password) {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DiscoverGistPage discoverGistPage = new DiscoverGistPage(DriverManager.getDriver());

        discoverGistPage.navigateToLoginPage();
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.isErrorMessageVisible(), "Error message does not appear.");
    }
}

