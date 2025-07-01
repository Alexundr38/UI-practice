package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.pages.BasketPage;
import store.Citilink.pages.HomePage;
import store.Citilink.pages.SearchPage;


import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Тест проверяет добавление товара в корзину и то,
 * что после добавления корзина не пуста.
 */
public class AddProductInBasketTest extends BaseTest {
    protected BasketPage basketPage;
    protected SearchPage searchPage;

    @Test
    protected void addProductToBasket() {
        String productName = "Смартфон ITEL P65 6/256Gb, P671LN, титан";
        login();
        homePage.search(productName);
        sleep(5000);

        searchPage = SearchPage.openSearchPage();
        searchPage.addProductToCartByName(productName);

        homePage.openButton(HomePage.HeaderButton.BASKET);
        basketPage = BasketPage.openBasketPage();
        sleep(500);

        assertFalse(basketPage.isEmptyOrder(), "Ожидали, что корзина не пустая после добавления товара");
    }
}
