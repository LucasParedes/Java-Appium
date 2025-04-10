package models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;

import java.util.Map;

public class CredencialesJson {
    @JsonProperty("credenciales")
    private Map<String, Credenciales> mapCredentials;

    public Map<String, Credenciales> mappearCredenciales() {
        return mapCredentials;
    }
}
