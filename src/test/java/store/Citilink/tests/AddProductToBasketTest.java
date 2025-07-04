package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.pages.BasketPage;
import store.Citilink.pages.SearchPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import store.Citilink.load_and_write_data.LoadWriteData;


/**
 * Тест проверяет добавление в корзину случайно выбранного товара.
 * Название товара берётся из внешнего JSON-файла со списком продуктов.
 */
public class AddProductToBasketTest extends TestWithDataName {

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
    public void addProductToBasket() {
        loadByActionType(LoadWriteData.ActionType.PUT_BASKET);
        dataName = loader.getRandomData();

        homePage.search(dataName);
        searchPage = SearchPage.openSearchPage();
        searchPage.addProductToCartByName(dataName);

        homePage.clickBasketButton();
        basketPage = BasketPage.openBasketPage();
        assertTrue(basketPage.containsProductWithName(dataName),
                "Ожидали, что в корзине есть товар с названием: " + dataName);
    }
}
