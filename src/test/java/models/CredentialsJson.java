package models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;

import java.util.Map;

public class CredentialsJson {
    @JsonProperty("credentials")
    private Map<String, Credentials> mapCredentials;

    public Map<String, Credentials> getMapCredentials() {
        return mapCredentials;
    }
}
