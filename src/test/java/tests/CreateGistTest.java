package tests;

import core.BaseTest;
import core.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateGistPage;
import pages.DiscoverGistPage;
import pages.LoginPage;

public class CreateGistTest extends BaseTest {
    @Test(description = "TC004_Verify that the user is able to create a public gist",
            groups = "regression")
    public void tc004_createGistPublic(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DiscoverGistPage discoverGistPage = new DiscoverGistPage(DriverManager.getDriver());
        CreateGistPage createGistPage = new CreateGistPage(DriverManager.getDriver());

        discoverGistPage.navigateToLoginPage();
        Assert.assertTrue(discoverGistPage.isNavigatedToLoginPage(), "Page is not navigated to Login Page");
        loginPage.login(config.getProperty("test.email"), config.getProperty("test.password") );
        Assert.assertTrue(loginPage.isTitleDiscoverGistsVisible());
        discoverGistPage.navigateToCreateGist();
        // assert
        createGistPage.createNewGist();
        Assert.assertTrue(createGistPage.isDetailCreatedGistVisible(), "Page does not navigated to Create Gist Page");

    }
}

//assert kurang? -->