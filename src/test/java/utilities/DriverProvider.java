package utilities;

import io.appium.java_client.android.AndroidDriver;

public class DriverProvider {
    private static final ThreadLocal<AndroidDriver> threadLocal = new ThreadLocal<>();

    public void set(AndroidDriver driver) {
        threadLocal.set(driver);
    }

    public AndroidDriver get() {
        return threadLocal.get();
    }
}
