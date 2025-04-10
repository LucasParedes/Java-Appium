package models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;

public class Credenciales {
    @JsonProperty("usuario")
    private String usuario;
    @JsonProperty("contrasenia")
    private String contrasenia;
    @JsonProperty("mensaje")
    private String mensaje;

    public String mensaje() {
        return mensaje;
    }

    public String contrasenia() {
        return contrasenia;
    }

    public String usuario() {
        return usuario;
    }
}
