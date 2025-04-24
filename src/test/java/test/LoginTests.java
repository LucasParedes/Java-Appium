package test;

import base.BaseTest;
import data.Credenciales;
import data.DataProvideres;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    private final LoginPage loginPage = new LoginPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToLoginPage();
    }

    @Test(groups = regresion)
    public void testCredencialesValidas() {
        final var validCredentials = Credenciales.credencialesValidas();
        loginPage.insertarCredencialesInicio(validCredentials.usuario(), validCredentials.contrasenia());
    }

    @Test(groups = regresion, dataProviderClass = DataProvideres.class, dataProvider = DataProvideres.DP_CREDENCIALES)
    public void testCredencialesErroneas(String usuario, String contrasenia, String message) {
        loginPage.insertarCredencialesInicio(usuario, contrasenia);
        loginPage.validarMensajeError(message);
    }

    @Test(groups = regresion)
    public void testValidandoCredenciasDefaultPagina() {
        loginPage.verificarCredencialesPagina();
    }
}