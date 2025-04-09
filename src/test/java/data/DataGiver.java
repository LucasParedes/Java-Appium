package data;

import models.Credentials;

import java.util.Map;

public class DataGiver {
    private static Map<String, Credentials> getCredentialMap() {
        return JsonReader.getCredentialMap().getMapCredentials();
    }

    public static Credentials getValidCredentials() {
        return getCredentialMap().get("valid");
    }

    public static Credentials getLockedCredentials() {
        return getCredentialMap().get("locked");
    }

    public static Credentials getInvalidCredentials() {
        return getCredentialMap().get("invalid");
    }
}
