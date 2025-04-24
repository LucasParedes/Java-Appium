package test;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

public class DrawingTest extends BaseTest {
    private WebElement canvasElement;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        final var deeplin = "swaglabs:drawing";


    }
}
