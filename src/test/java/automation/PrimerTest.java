package automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

import static java.lang.Thread.sleep;

public class PrimerTest extends BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        Logs.info("Cargando APP");
        sleep(2000);
    }

    @Test
    public void primerTest() {

//        Logs.info("Escribiendo el username");
//        driver.findElement(AppiumBy.accessibilityId("test-Username")).sendKeys("locked_out_user");
//
//        Logs.info("Escribiendo la password");
//        driver.findElement(AppiumBy.accessibilityId("test-Password")).sendKeys("secret_sauce");
//
//        Logs.info("Haciendo click boton login");
//        driver.findElement(AppiumBy.accessibilityId("test-Login")).click();
//
//        Logs.info("Esperando validacion de credenciales incorrectas");
//        sleep(1000);
//
//        Logs.info("Verificando mensaje de credenciales incorrectas");
//        final var mensajeError = driver.findElement(AppiumBy.androidUIAutomator("description(\"test-Error message\")" + ".childSelector(className(\"android.widget.TextView\"))"));
//
//        softAsser.DriverManagerassertTrue(mensajeError.isDisplayed());
//        softAssert.assertEquals(mensajeError.getText(), "Sorry, this user has been locked out.");
//        softAssert.assertAll();
    }
}
