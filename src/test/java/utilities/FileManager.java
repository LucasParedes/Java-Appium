package utilities;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class FileManager {
    private static final String rutaImagenes = "src/test/resources/screenshots";

    public static void tomarCaptura(String nombreCaptura) {
        Logs.debug("Tomando captura");

        final var capturaFile = ((TakesScreenshot) new DriverProvider().get()).getScreenshotAs(OutputType.FILE);

        final var ruta = String.format("%s/%s.png", rutaImagenes, nombreCaptura);

        try {
            FileUtils.copyFile(capturaFile, new File(ruta));
        } catch (IOException ioException) {
            Logs.error("Error al tomar la captura: %s", ioException.getLocalizedMessage());
        }
    }

    public static void borrarCapturasAnteriores() {
        try {
            Logs.debug("Borrando las carpetas de evidencias");
            FileUtils.deleteDirectory(new File(rutaImagenes));
        } catch (IOException ioException) {
            Logs.error("Error al borrar carpetas de evidencia: %s", ioException.getLocalizedMessage());
        }
    }

    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] tomarCaptura() {
        return ((TakesScreenshot) new DriverProvider().get()).getScreenshotAs(OutputType.BYTES);
    }
}
