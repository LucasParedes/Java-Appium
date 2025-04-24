package base;

import config.DriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.Logs;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private final boolean runServer = System.getenv("JOB_NAME") != null;

    public void buildDriver() {
        if (runServer) {
            buildRemoteDriver();
        } else {
            buildLocalDriver();
        }
    }

    public void killDriver() {
        Logs.debug("Finalizando driver");
        new DriverProvider().get().quit();
    }

    public void buildLocalDriver() {
        try {
            final var appiumUrl = "http://127.0.0.1:4723/";
            final var desiredCapabilities = getDesiredLocalCapabilities();

            Logs.debug("Iniciando driver");
            final var driver = new AndroidDriver(new URL(appiumUrl), desiredCapabilities);

            Logs.debug("Iniciando el driver al driver provider");
            new DriverProvider().set(driver);
        } catch (MalformedURLException malformedURLException) {
            Logs.error("Error al iniciar el driver", malformedURLException.getLocalizedMessage());
            throw new RuntimeException();
        }
    }

    public void buildRemoteDriver() {

    }

    private static DesiredCapabilities getDesiredLocalCapabilities() {
        final var desiredCapabilities = new DesiredCapabilities();

        final var fileApk = new File("src/test/resources/apks/2-sauceLabs.apk");

        desiredCapabilities.setCapability("appium:autoGrantPermissions", true);
        desiredCapabilities.setCapability("appium:appWaitActivity", "com.swaglabsmobileapp.MainActivity");
        desiredCapabilities.setCapability("appium:platformName", "Android");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:app", fileApk.getAbsolutePath());

        return desiredCapabilities;
    }
}
