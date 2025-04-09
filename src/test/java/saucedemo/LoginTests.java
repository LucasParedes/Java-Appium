package saucedemo;

import data.CustomDataProviders;
import data.DataGiver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.BaseTest;

public class LoginTests extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final By tap = AppiumBy.accessibilityId("test-Toggle");

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToLoginPage();
    }

    @Test(groups = {regression, smoke})
    public void validCredentialsTest() {
        final var validCredentials = DataGiver.getValidCredentials();
        loginPage.fillData(validCredentials.getUsername(), validCredentials.getPassword());
    }

    @Test(groups = {regression, smoke}, dataProviderClass = CustomDataProviders.class, dataProvider = CustomDataProviders.DP_CREDENTIALS)
    public void credentialsFailsTest(String username, String password, String message) {
        loginPage.fillData(username, password);
        loginPage.verifyErrorMessage(message);
    }
}