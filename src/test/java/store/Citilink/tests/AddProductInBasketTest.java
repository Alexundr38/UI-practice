package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.pages.BasketPage;
import store.Citilink.pages.HomePage;
import store.Citilink.pages.SearchPage;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;
import store.Citilink.load_and_write_data.LoadWriteProductData;


/**
 * Тест проверяет добавление в корзину случайно выбранного товара.
 * Название товара берётся из внешнего JSON-файла со списком продуктов.
 */
public class AddProductInBasketTest extends BaseTest {
    protected BasketPage basketPage;
    protected SearchPage searchPage;

    @Test
    protected void addProductToBasket() {
        LoadWriteProductData loader = new LoadWriteProductData(LoadWriteProductData.ActionType.PUT_BASKET);
        String productName = loader.getRandomProduct();

        login();
        homePage.search(productName);
        sleep(1000);

        searchPage = SearchPage.openSearchPage();
        searchPage.addProductToCartByName(productName);

        homePage.openButton(HomePage.HeaderButton.BASKET);
        sleep(1000);
        basketPage = BasketPage.openBasketPage();
        sleep(1000);
        assertTrue(basketPage.containsProductWithName(productName),
                "Ожидали, что в корзине есть товар с названием: " + productName);
    }
}
