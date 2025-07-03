package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.pages.BasketPage;
import store.Citilink.pages.SearchPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import store.Citilink.load_and_write_data.LoadWriteProductData;


/**
 * Тест проверяет добавление в корзину случайно выбранного товара.
 * Название товара берётся из внешнего JSON-файла со списком продуктов.
 */
public class AddProductToBasketTest extends TestWithProductName {

    /** Страница корзины */
    protected BasketPage basketPage;

    /** Страница поиска */
    protected SearchPage searchPage;

    /**
     * Добавление товара в корзину посредством поиска через строку поиска.
     * Ищет товар по тестируемому запросу.
     * Добавляет товар в корзину.
     * Проверяет, находиться ли товар в корзине.
     */
    @Test
    protected void addProductToBasket() {
        loadByActionType(LoadWriteProductData.ActionType.PUT_BASKET);
        productName = loader.getRandomProduct();

        homePage.search(productName);
        searchPage = SearchPage.openSearchPage();
        searchPage.addProductToCartByName(productName);

        homePage.clickBasketButton();
        basketPage = BasketPage.openBasketPage();
        assertTrue(basketPage.containsProductWithName(productName),
                "Ожидали, что в корзине есть товар с названием: " + productName);
    }
}
