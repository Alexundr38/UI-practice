package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.load_and_write_data.LoadWriteProductData;
import store.Citilink.pages.BasketPage;
import store.Citilink.pages.HomePage;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveBasketProductTest extends BaseTest{
    protected BasketPage basketPage;

    @Test
    protected void removeBasketProductWithBin() {
        openBasketPage();
        LoadWriteProductData loader = new LoadWriteProductData(LoadWriteProductData.ActionType.REMOVE_BASKET);
        String productName = loader.getRandomProduct();
        assertTrue(basketPage.removeUpProductWithBin(productName));
    }

    @Test
    protected void removeBasketProductWithCheckBox() {
        openBasketPage();
        LoadWriteProductData loader = new LoadWriteProductData(LoadWriteProductData.ActionType.REMOVE_BASKET);
        String productName = loader.getRandomProduct();
        assertTrue(basketPage.removeUpProductWithCheckBox(productName));
    }

    @Test
    protected void openBasketPage() {
        login();
        homePage.openButton(HomePage.HeaderButton.BASKET);
        basketPage = BasketPage.openBasketPage();
        sleep(500);
        assertTrue(!basketPage.isEmptyOrder());
    }

}
