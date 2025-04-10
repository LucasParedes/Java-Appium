package test;

import data.Datas;
import data.RecorrerDataProvideres;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.BaseTest;

public class LoginTests extends BaseTest {
    private final LoginPage loginPage = new LoginPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToLoginPage();
    }

    @Test(groups = {regression, smoke})
    public void testCredencialesValidas() {
        final var validCredentials = Datas.credencialesValidas();
        loginPage.insertarCredencialesInicio(validCredentials.usuario(), validCredentials.contrasenia());
    }

    @Test(groups = {regression, smoke}, dataProviderClass = RecorrerDataProvideres.class, dataProvider = RecorrerDataProvideres.DP_CREDENCIALES)
    public void testCredencialesErroneas(String usuario, String contrasenia, String message) {
        loginPage.insertarCredencialesInicio(usuario, contrasenia);
        loginPage.validarMensajeError(message);
    }

    @Test(groups = {regression, smoke})
    public void testValidandoCredenciasDefaultPagina() {
        loginPage.verificarCredencialesPagina();
    }
}