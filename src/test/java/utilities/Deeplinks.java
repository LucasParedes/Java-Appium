package utilities;

import config.DriverProvider;

public class Deeplinks {
    private static final String completeCheckout = "swaglabs://complete";
    private static final String itemDetail = "swaglabs://swag-item/%d";
    private static final String webView = "swaglabs://webView";
    private static final String yourCart = "swaglabs://cart/%s";
    private static final String shopping = "swaglabs://swag-overview/%s";

    private static void goTo(String deepLink) {
        new DriverProvider().get().get(deepLink);
    }

    public static void goToCompleteCheckout() {
        goTo(completeCheckout);
    }

    public static void goToItemDetail(int index) {
        final var deeplink = String.format(itemDetail, index);
        goTo(deeplink);
    }

    public static void goToYourCart(int list) {
        final var deeplink = String.format(yourCart, list);
        goTo(deeplink);
    }

    public static void goToWebView(int list) {
        goTo(webView);
    }

    public static void goToShopping(int list) {
        final var deeplink = String.format(shopping, list);
        goTo(deeplink);
    }
}
