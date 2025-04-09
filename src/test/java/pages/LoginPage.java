package pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class LoginPage extends BasePage {
    public final By usernameInput = AppiumBy.accessibilityId("test-Username");
    private final By passwordInput = AppiumBy.accessibilityId("test-Password");
    private final By loginButton = AppiumBy.accessibilityId("test-LOGIN");
    private final By errorMessage = AppiumBy.androidUIAutomator(
            "description(\"test-Error message\")" + ".childSelector(className(\"android.widget.TextView\"))");

    @Override

    @Step("Esperando que cargue la pagina de Login")
    public void waitPageToLoad() {
        waitPage(usernameInput, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verificando la pagina de Login")
    public void verifyPage() {
        Logs.info("Verificando la pagina de login");
        softAssert.assertTrue(find(usernameInput).isDisplayed());
        softAssert.assertTrue(find(passwordInput).isDisplayed());
        softAssert.assertTrue(find(loginButton).isDisplayed());
        softAssert.assertAll();
    }

    public void fillData(String username, String password) {
        Logs.info("Escriendo el username");
        find(usernameInput).sendKeys(username);

        Logs.info("Escriendo el password");
        find(passwordInput).sendKeys(password);

        Logs.info("Haciendo click en el boton de login");
        find(loginButton).click();
    }

    public void verifyErrorMessage(String errorText) {
        Logs.info("Esperando que el mensaje de error aparezca");
        final var errorMessageElement = waitForDisplayed(errorMessage, 4);

        Logs.info("Verificando el mensaje de error");
        softAssert.assertTrue(errorMessageElement.isDisplayed());
        softAssert.assertEquals(errorMessageElement.getText(), errorText);
        softAssert.assertAll();
    }
}
