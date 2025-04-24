package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.FileManager;
import utilities.Logs;

public class TestListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        Logs.info("Comenzando el test: %s", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Logs.info("Test exitoso: %s", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Logs.info("Test fallido: %s", result.getName());
        FileManager.tomarCaptura(result.getName());
        // Esto es lo que hace que Allure adjunte la screenshot:
        FileManager.adjuntarCapturaAllure();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logs.info("Test ignorado: %s", result.getName());
    }
}
