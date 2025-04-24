package utilities;

import config.DriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

public class Gestures {
    private static final PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");


    private static AndroidDriver getDriver() {
        return new DriverProvider().get();
    }

    public static void tap(WebElement element) {
        final var pointCenter = getCenterPoint(element);
        final var sequence = new Sequence(finger, 1);

        Logs.debug("Moviendo el dedo hace el elemento");
        sequence.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), pointCenter));

        Logs.debug("Presionando el elemento");
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        Logs.debug("Esperando 1 segundo");
        sequence.addAction(new Pause(finger, Duration.ofMillis(1000)));

        Logs.debug("Dejando de presionar el elemento");
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        Logs.debug("Ejecutando las acciones");
        getDriver().perform(List.of(sequence));
    }

    public static void longTap(WebElement element) {
        final var pointCenter = getCenterPoint(element);
        final var sequence = new Sequence(finger, 1);

        Logs.debug("Moviendo el dedo hace el elemento");
        sequence.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), pointCenter));

        Logs.debug("Presionando el elemento");
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        Logs.debug("Esperando 3.5 segundo");
        sequence.addAction(new Pause(finger, Duration.ofMillis(3500)));

        Logs.debug("Dejando de presionar el elemento");
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        Logs.debug("Ejecutando las acciones");
        getDriver().perform(List.of(sequence));
    }

    public static void doubleTap(WebElement element) {
        final var pointCenter = getCenterPoint(element);
        final var sequence = new Sequence(finger, 1);

        Logs.debug("Moviendo el dedo hace el elemento");
        sequence.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), pointCenter));

        for (var i = 0; i < 2; i++) { //2 veces
            Logs.debug("Presionando el elemento");
            sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

            Logs.debug("Esperando 1 segundo");
            sequence.addAction(new Pause(finger, Duration.ofMillis(1000)));

            Logs.debug("Dejando de presionar el elemento");
            sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        }

        Logs.debug("Ejecutando las acciones");
        getDriver().perform(List.of(sequence));
    }

    public static void dragTo(WebElement elementOrigin, WebElement elementDestiny) {
        final var centerOrigin = getCenterPoint(elementOrigin);
        final var centerDestiny = getCenterPoint(elementDestiny);

        final var sequence = new Sequence(finger, 1);

        Logs.debug("Moviendo el dedo hacia el centro");
        sequence.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), centerOrigin));


        Logs.debug("Tocamos la pantalla para arrastar el elemento origen");
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        Logs.debug("Pausa");
        sequence.addAction(new Pause(finger, Duration.ofMillis(2000)));

        Logs.debug("Arrastramos hacia el elemento destino");
        sequence.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), centerDestiny));

        Logs.debug("Pausa");
        sequence.addAction(new Pause(finger, Duration.ofMillis(1500)));

        Logs.debug("Dejamos de tocar la pantalla");
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        Logs.debug("Ejecutamos las acciones");
        getDriver().perform(List.of(sequence));
    }

    public static void swipeGeneral2(double percentageXInitial, double percentageYInitial, double percentageXFinal, double percentageYFinal, WebElement element) {
        final var initialPoint = getElementPointUsingPercentages(percentageXInitial, percentageYInitial, element);
        final var finalPoint = getElementPointUsingPercentages(percentageXFinal, percentageYFinal, element);

        swipeGeneral(initialPoint, finalPoint);
    }

    public static void swipeHorizontal(double percentageY, double percentageXInitial, double percentageXFinal, WebElement element) {
        swipeGeneral2(percentageXInitial, percentageY, percentageXFinal, percentageY, element);
    }

    public static void swipeVertical(double percentageX, double percentageYInitial, double percentageYFinal, WebElement element) {
        swipeGeneral2(percentageX, percentageYInitial, percentageX, percentageYFinal, element);
    }

    private static void swipeGeneral(Point origin, Point destiny) {
        Logs.debug("Haciendo swipe desde el punto %s al %s", origin, destiny);
        final var sequence = new Sequence(finger, 1);

        Logs.debug("Moviendo el dedo al punto inicial");
        sequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), origin));

        Logs.debug("Tocamos la pantalla en el punto de origen");
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        Logs.debug("Pausa");
        sequence.addAction(new Pause(finger, Duration.ofMillis(1000)));

        Logs.debug("Movemos el dedo a la posicion final");
        sequence.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), destiny));

        Logs.debug("Dejamos de tocar la pantalla");
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        Logs.debug("Ejecutamos las acciones");
        getDriver().perform(List.of(sequence));
    }

    private static Point getElementPointUsingPercentages(double percentageX, double percentageY, WebElement element) {
        final var location = element.getLocation();
        final var size = element.getSize();

        final var xDelta = (percentageX / 100) * size.getWidth();
        final var yDelta = (percentageY / 100) * size.getHeight();

        final var x = (int) (location.getX() + xDelta);
        final var y = (int) (location.getX() + yDelta);

        return new Point(x, y);
    }

    public static Point getCenterPoint(WebElement element) {
        final var elementLocation = element.getLocation();
        final var elementSize = element.getSize();

        final var centerX = elementLocation.getX() + elementSize.getWidth() / 2;
        final var centerY = elementLocation.getY() + elementSize.getHeight() / 2;

        return new Point(centerX, centerY);
    }
}
