import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class jsonTest {


    @Description("hola bends")
    @Test
    public void primerTest() {
        var a = 0;
        var b = 1;
        //System.out.println("Hello, World!");
        Assert.assertEquals(a, b);
    }
}