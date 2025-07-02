package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.load_and_write_data.LoadWriteProductData;
import store.Citilink.pages.HomePage;
import store.Citilink.pages.WishlistPage;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveWishlistProductTest extends BaseTest {
    private WishlistPage wishlistPage;

    @Test
    public void openWishlistPage() {
        login();
        homePage.openButton(HomePage.HeaderButton.WISHLIST);
        wishlistPage = WishlistPage.openWishlistPage();
        sleep(500);
        assertTrue(!wishlistPage.isEmpty());
    }


    @Test
    public void removeWishlistProductWithCross() {
        LoadWriteProductData loader = new LoadWriteProductData(LoadWriteProductData.ActionType.REMOVE_WISHLIST);
        String productName = loader.getRandomProduct();

        openWishlistPage();
        assertTrue(wishlistPage.removeProductWithCross(productName));
    }

    @Test
    public void removeWishlistProductWithRemoveAll() {
        LoadWriteProductData loader = new LoadWriteProductData(LoadWriteProductData.ActionType.REMOVE_WISHLIST);
        String productName = loader.getRandomProduct();

        openWishlistPage();

        wishlistPage.removeProductWithRemoveAll();
        sleep(500);
        assertTrue(wishlistPage.isEmpty());
    }
}
