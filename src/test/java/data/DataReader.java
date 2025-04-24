package data;

import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import models.CredencialesJson;
import utilities.Logs;

import java.io.File;
import java.io.IOException;

public class DataReader {
    private static final String credentialPath = "src/test/resources/data/credencialesClientes.json";
    private static CredencialesJson cache;

    public static CredencialesJson tomarCredenciales() {
        if (cache != null) return cache;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            cache = objectMapper.readValue(new File(credentialPath), CredencialesJson.class);
            return cache;
        } catch (IOException ioException) {
            Logs.info("Error al leer el JSON", ioException.getLocalizedMessage());
            throw new RuntimeException(ioException.getLocalizedMessage());
        }

    }
}