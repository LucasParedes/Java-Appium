package test;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import utilities.BaseTest;

public class DrawingTest extends BaseTest {
    private WebElement canvasElement;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        final var deeplin = "swaglabs:drawing";


    }
}
