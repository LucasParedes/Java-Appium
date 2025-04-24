package base;

import config.DriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utilities.Logs;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    private final static int defaultTimeout = 5;
    protected final SoftAssert softAssert;
    private final int timeOut;


    public BasePage(int timeOut) {
        softAssert = new SoftAssert();
        this.timeOut = timeOut;
    }

    public BasePage() {
        this(defaultTimeout); //se llama al constructor de arriba
    }

    protected AndroidDriver getDriver() {
        return new DriverProvider().get();
    }

    protected WebElement waitForDisplayed(By locator, int time) {
        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForDisplayed(By locator) {
        return waitForDisplayed(locator, defaultTimeout);
    }

    protected void waitPage(By locator, String pageName) {
        Logs.info("Esperando que la pagina cargue", pageName);
        waitForDisplayed(locator, timeOut);
        Logs.info("a cargado correctamente");
    }

    protected WebElement find(By locator) {
        return getDriver().findElement(locator);
    }

    protected List<WebElement> findAll(By locator) {
        return getDriver().findElements(locator);
    }

    public void pressBack() {
        Logs.info("Presionando atras en el dispositivo movil");
        getDriver().pressKey(new KeyEvent(AndroidKey.BACK));
    }

    protected void sleep(int timeMS) {
        try {
            Thread.sleep(timeMS);
        } catch (InterruptedException interruptedException) {
            Logs.error("InterruptedException:", interruptedException);
        }
    }

    public abstract void esperarCargaPagina(); // esperar que cargue la pagina

    public abstract void verificarPagina(); // verifica la ui de la pagina
}
