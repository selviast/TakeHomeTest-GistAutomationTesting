package tests;

import core.BaseTest;
import core.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DiscoverGistPage;

public class DiscoverGistTest extends BaseTest {
    @Test(description = "TC001_verify sign in button can be accessed",
            groups = "regression")
    public void tc001_accessSignInButton(){
        DiscoverGistPage discoverGistPage = new DiscoverGistPage(DriverManager.getDriver());

        discoverGistPage.navigateToLoginPage();
        Assert.assertTrue(discoverGistPage.isNavigatedToLoginPage(), "Page is not navigated to Login Page.");
    }
}
