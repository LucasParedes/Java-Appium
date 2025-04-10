package data;

import models.Credenciales;

import java.util.Map;

public class Datas {
    private static Map<String, Credenciales> getCredencialesMap() {
        return LeerJson.tomarCredenciales().mappearCredenciales();
    }

    public static Credenciales credencialesValidas() {
        return getCredencialesMap().get("validas");
    }

    public static Credenciales credencialesBloqueadas() {
        return getCredencialesMap().get("bloqueadas");
    }

    public static Credenciales credencialesInvalidas() {
        return getCredencialesMap().get("invalidas");
    }
}
