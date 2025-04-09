package utilities;

import pages.LoginPage;

public class CommonFlows {
    public void goToLoginPage() {
        new LoginPage().waitPageToLoad();
    }

    public void goToShoppingPage() {
        new LoginPage().fillData("locked_out_user", "secret_sauce");
    }

    public void openBurgerMenu() {
        goToShoppingPage();
    }

//    public void goToYourCartPage(List<Integer> itemListAdd) {
//        goToShoppingPage();
//        final var shoppingPage = new ShoppingPage();
//        shoppingPage.changeViewMode();
//        shoppingPage.addToCartDrag(itemListAdd);
//        new TopBar().clickCheckout();
//        new YourCartPage().waitPageToLoad();
//    }

//    public void goToItemDetailPage(int index) {
//        goToShoppingPage();
//        new ShoppingPage().clickItemImage(index);
//        new ItemDetalPage().waitPageToLoad();
//    }
}
