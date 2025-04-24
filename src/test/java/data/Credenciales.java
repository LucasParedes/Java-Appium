package data;

import java.util.Map;

public class Credenciales {
    private static Map<String, models.Credenciales> getCredencialesMap() {
        return DataReader.tomarCredenciales().mappearCredenciales();
    }

    public static models.Credenciales credencialesValidas() {
        return getCredencialesMap().get("validas");
    }

    public static models.Credenciales credencialesBloqueadas() {
        return getCredencialesMap().get("bloqueadas");
    }

    public static models.Credenciales credencialesInvalidas() {
        return getCredencialesMap().get("invalidas");
    }
}
