package tests;

import core.BaseTest;
import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

public class YourGistTest extends BaseTest {
    @Test(description = "TC005_Verify that the user is able to edit the created gist through profile",
            groups = "regression")
    public void tc005_editCreatedGistThroughProfile() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DiscoverGistPage discoverGistPage = new DiscoverGistPage(DriverManager.getDriver());
        DropdownProfilePage dropdownProfilePage = new DropdownProfilePage(DriverManager.getDriver());
        YourGistPage yourGistPage = new YourGistPage(DriverManager.getDriver());
        DetailCreatedGistPage detailCreatedGistPage = new DetailCreatedGistPage(DriverManager.getDriver());
        EditGistPage editGistPage = new EditGistPage(DriverManager.getDriver());


        discoverGistPage.navigateToLoginPage();
        loginPage.login(config.getProperty("test.email"), config.getProperty("test.password"));
        Assert.assertTrue(loginPage.isTitleDiscoverGistsVisible(), "Login is not navigated to Discover Gists Page");

        dropdownProfilePage.navigateToYourGistPage();

        yourGistPage.navigateToCreatedGistDetail();

        Assert.assertTrue(detailCreatedGistPage.isSubMenuCodeVisible(), "Sub Heading Code is not visible.");

        detailCreatedGistPage.navigateToEditGistPage();

        editGistPage.editContentPresentation();

        Assert.assertTrue(detailCreatedGistPage.isSubMenuCodeVisible(), "Sub Heading Code is not visible.");

    }

    @Test(description = "TC006_Verify that the user is able to edit the created gist right after created a gist",
            groups = "regression")
    public void tc006_editCreatedGist() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DiscoverGistPage discoverGistPage = new DiscoverGistPage(DriverManager.getDriver());
        CreateGistPage createGistPage = new CreateGistPage(DriverManager.getDriver());
        DetailCreatedGistPage detailCreatedGistPage = new DetailCreatedGistPage(DriverManager.getDriver());
        EditGistPage editGistPage = new EditGistPage(DriverManager.getDriver());

        discoverGistPage.navigateToLoginPage();
        Assert.assertTrue(discoverGistPage.isNavigatedToLoginPage(), "Page is not navigated to Login Page");
        loginPage.login(config.getProperty("test.email"), config.getProperty("test.password"));
        Assert.assertTrue(loginPage.isTitleDiscoverGistsVisible());
        discoverGistPage.navigateToCreateGist();
        createGistPage.createNewGist();
        Assert.assertTrue(createGistPage.isDetailCreatedGistVisible(), "Page does not navigated to Create Gist Page");
        detailCreatedGistPage.navigateToEditGistPage();

        editGistPage.editContentPresentation();

        Assert.assertTrue(detailCreatedGistPage.isSubMenuCodeVisible(), "Sub Heading Code is not visible.");

    }

    @Test(description = "tc007_Verify that the user is able to delete the created gist through profile",
            groups = "regression")
    public void tc007_deleteGistTestThroughProfile() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DiscoverGistPage discoverGistPage = new DiscoverGistPage(DriverManager.getDriver());
        DropdownProfilePage dropdownProfilePage = new DropdownProfilePage(DriverManager.getDriver());
        YourGistPage yourGistPage = new YourGistPage(DriverManager.getDriver());
        DetailCreatedGistPage detailCreatedGistPage = new DetailCreatedGistPage(DriverManager.getDriver());
        EditGistPage editGistPage = new EditGistPage(DriverManager.getDriver());


        discoverGistPage.navigateToLoginPage();
        loginPage.login(config.getProperty("test.email"), config.getProperty("test.password"));
        Assert.assertTrue(loginPage.isTitleDiscoverGistsVisible(), "Login is not navigated to Discover Gists Page");

        dropdownProfilePage.navigateToYourGistPage();

        yourGistPage.navigateToCreatedGistDetail();

        Assert.assertTrue(detailCreatedGistPage.isSubMenuCodeVisible(), "Sub Heading Code is not visible.");

        detailCreatedGistPage.deleteGist();

        Assert.assertTrue(yourGistPage.isAlertDeleteSuccessVisible(), "Alert Delete Success is not visible.");

    }

    @Test(description = "TC008_Verify that the user is able to delete the created gist right after created a gist",
            groups = "regression")
    public void tc008_deleteCreatedGist() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DiscoverGistPage discoverGistPage = new DiscoverGistPage(DriverManager.getDriver());
        CreateGistPage createGistPage = new CreateGistPage(DriverManager.getDriver());
        DetailCreatedGistPage detailCreatedGistPage = new DetailCreatedGistPage(DriverManager.getDriver());
        YourGistPage yourGistPage = new YourGistPage(DriverManager.getDriver());

        discoverGistPage.navigateToLoginPage();
        Assert.assertTrue(discoverGistPage.isNavigatedToLoginPage(), "Page is not navigated to Login Page");
        loginPage.login(config.getProperty("test.email"), config.getProperty("test.password"));
        Assert.assertTrue(loginPage.isTitleDiscoverGistsVisible());

        // Buat 2 gist
        discoverGistPage.navigateToCreateGist();
        createGistPage.createNewGist();
        Assert.assertTrue(createGistPage.isDetailCreatedGistVisible(), "Page does not navigated to Create Gist Page");

        discoverGistPage.navigateToCreateGist();
        createGistPage.createNewGist();
        Assert.assertTrue(createGistPage.isDetailCreatedGistVisible(), "Page does not navigated to Create Gist Page");

        detailCreatedGistPage.deleteGist();
        Assert.assertTrue(yourGistPage.isAlertDeleteSuccessVisible(), "Alert Delete Success is not visible.");

    }

    @Test(description = "TC009_Verify that the user is able to delete the created gist right after created a gist",
            groups = "regression")
    public void tc009_shouldDisplayCreatedGistInYourList() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DiscoverGistPage discoverGistPage = new DiscoverGistPage(DriverManager.getDriver());
        CreateGistPage createGistPage = new CreateGistPage(DriverManager.getDriver());
        YourGistPage yourGistPage = new YourGistPage(DriverManager.getDriver());
        DropdownProfilePage dropdownProfilePage = new DropdownProfilePage(DriverManager.getDriver());

        // Login
        discoverGistPage.navigateToLoginPage();
        Assert.assertTrue(discoverGistPage.isNavigatedToLoginPage(), "Page is not navigated to Login Page");
        loginPage.login(config.getProperty("test.email"), config.getProperty("test.password") );
        Assert.assertTrue(loginPage.isTitleDiscoverGistsVisible());

        // create new gist
        discoverGistPage.navigateToCreateGist();
        createGistPage.createNewGist();
        Assert.assertTrue(createGistPage.isDetailCreatedGistVisible(), "Page does not navigated to Create Gist Page");

        // navigate to Your Gists
        dropdownProfilePage.navigateToYourGistPage();

        // verify new gist appears in list
        List<String> allTitles = yourGistPage.getListOfGistTitles();
        System.out.println("Gists found: " + allTitles);

        Assert.assertTrue(
                yourGistPage.isGistTitlePresent("file_name_"),
                "Created gist title is not found in Your Gists list."
        );
    }

}
