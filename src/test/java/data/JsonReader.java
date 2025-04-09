package data;

import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import models.CredentialsJson;
import utilities.Logs;

import java.io.File;
import java.io.IOException;

public class JsonReader {
    private static final String credentialPath = "src/test/resources/data/credentials.json";

    public static CredentialsJson getCredentialMap() {
        final var objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(new File(credentialPath), CredentialsJson.class);
        } catch (IOException ioException) {
            Logs.info("Error al leer el JSON", ioException.getLocalizedMessage());
            throw new RuntimeException(ioException.getLocalizedMessage());
        }

    }
}
