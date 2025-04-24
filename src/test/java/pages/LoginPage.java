package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.Gestures;
import utilities.Logs;

public class LoginPage extends BasePage {
    public final By usernameInput = AppiumBy.accessibilityId("test-Username");
    private final By passwordInput = AppiumBy.accessibilityId("test-Password");
    private final By loginButton = AppiumBy.accessibilityId("test-LOGIN");
    private final By errorMessage = AppiumBy.androidUIAutomator(
            "description(\"test-Error message\")" + ".childSelector(className(\"android.widget.TextView\"))");
    public final By mainCanvas = AppiumBy.id("android:id/content");

    @Override
    @Step("Esperando que cargue la pagina de Login")
    public void esperarCargaPagina() {
        waitPage(usernameInput, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verificando la pagina de Login")
    public void verificarPagina() {
        Logs.info("Verificando la pagina de login");
        softAssert.assertTrue(find(usernameInput).isDisplayed());
        softAssert.assertTrue(find(passwordInput).isDisplayed());
        softAssert.assertTrue(find(loginButton).isDisplayed());
        softAssert.assertAll();
    }

    public void insertarCredencialesInicio(String username, String password) {
        Logs.info("Escriendo el username");
        find(usernameInput).sendKeys(username);

        Logs.info("Escriendo el password");
        find(passwordInput).sendKeys(password);

        Logs.info("Haciendo click en el boton de login");
        find(loginButton).click();
    }

    public void validarMensajeError(String errorText) {
        Logs.info("Esperando que el mensaje de error aparezca");
        final var errorMessageElement = waitForDisplayed(errorMessage, 4);

        Logs.info("Verificando el mensaje de error");
        softAssert.assertTrue(errorMessageElement.isDisplayed());
        softAssert.assertEquals(errorMessageElement.getText(), errorText);
        softAssert.assertAll();
    }

    public void verificarCredencialesPagina() {
        Logs.info("Verificando credenciales escritas default");
        Gestures.swipeVertical(50, 50, 20, find(mainCanvas));
    }
}
