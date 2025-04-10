package data;

import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import models.CredencialesJson;
import utilities.Logs;

import java.io.File;
import java.io.IOException;

public class LeerJson {
    private static final String credentialPath = "src/test/resources/data/credenciales.json";

    public static CredencialesJson tomarCredenciales() {
        final var objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(new File(credentialPath), CredencialesJson.class);
        } catch (IOException ioException) {
            Logs.info("Error al leer el JSON", ioException.getLocalizedMessage());
            throw new RuntimeException(ioException.getLocalizedMessage());
        }

    }
}
