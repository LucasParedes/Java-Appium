package data;

import org.testng.annotations.DataProvider;

public class CustomDataProviders {
    public static final String DP_CREDENTIALS = "dpCredentials";

    @DataProvider(name = DP_CREDENTIALS)
    public static Object[][] credentialsDataProvider() {
        final var invalid = DataGiver.getInvalidCredentials();
        final var locked = DataGiver.getLockedCredentials();

        return new Object[][]{
                {invalid.getUsername(), invalid.getPassword(), invalid.getMessage()},
                {locked.getUsername(), locked.getPassword(), locked.getMessage()}
        };
    }
}
