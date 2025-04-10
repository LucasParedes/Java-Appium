package data;

import org.testng.annotations.DataProvider;

public class RecorrerDataProvideres {
    public static final String DP_CREDENCIALES = "dpCredenciales";

    @DataProvider(name = DP_CREDENCIALES)
    public static Object[][] credencialesDataProvider() {
        final var invalidas = Datas.credencialesInvalidas();
        final var bloqueadas = Datas.credencialesBloqueadas();

        return new Object[][]{
                {invalidas.usuario(), invalidas.contrasenia(), invalidas.mensaje()},
                {bloqueadas.usuario(), bloqueadas.contrasenia(), bloqueadas.mensaje()}
        };
    }
}
