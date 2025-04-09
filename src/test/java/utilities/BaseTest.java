package utilities;

import listeners.SuiteListeners;
import listeners.TestListeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListeners.class, SuiteListeners.class})
public class BaseTest {

    protected final String regression = "regression";
    protected final String smoke = "smoke";
    private final DriverManager driverManager = new DriverManager();
    protected final CommonFlows commonFlows = new CommonFlows();

    @BeforeMethod(alwaysRun = true)
    public void masterSetup() {
        driverManager.buildDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void masterTearDown() {
        driverManager.killDriver();
    }
}
