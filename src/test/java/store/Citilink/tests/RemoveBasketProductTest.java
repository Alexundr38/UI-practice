package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.load_and_write_data.LoadWriteData;
import store.Citilink.pages.BasketPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тест-класс для проверки функциональности удаления товаров из корзины
 */
public class RemoveBasketProductTest extends TestWithDataName {
    /** Входит в корзину и проверяет не пустая ли она */
    private BasketPage openBasketPage() {
        homePage.clickBasketButton();
        BasketPage basketPage = BasketPage.openBasketPage();
        loadByActionType(LoadWriteData.ActionType.REMOVE_BASKET);
        assertTrue(!basketPage.isEmptyOrder());
        return basketPage;
    }

    /**
     * Тест проверяет удаление товара из корзины посредством
     * кнопки мусорного бака на сниппете товара.
     *
     * Заходит в корзину.
     * Выбирает тестовый товар.
     * Удаляет тестовый товар при помощи кнопки мусорного бака.
     * Проверяет, удалился ли товар.
     */
    @Test
    public void removeBasketProductWithBin() {
        BasketPage basketPage = openBasketPage();
        dataName = loader.getRandomData();
        basketPage.removeProductWithBin(dataName);
        assertTrue(basketPage.isProductRemoved(),
                "Ожидали, что в корзине нет товара с названием: " + dataName);
    }

    /**
     * Тест проверяет удаление товара из корзины посредством выделения чекбокса
     * товара на сниппете товара и нажатием на кнопку "Удалить выбранные"
     *
     * Заходит в корзину.
     * Выбирает тестовый товар.
     * Выделяет чекбокс тестового товара.
     * Нажимает на кнопку "Удалить выбранные".
     * Проверяет, удалился ли товар.
     */
    @Test
    public void removeBasketProductWithCheckBox() {
        BasketPage basketPage = openBasketPage();
        String productName = loader.getRandomData();
        basketPage.selectProductWithCheckBox(productName);
        basketPage.clickRemoveSelectedButton();
        assertTrue(basketPage.isProductRemoved(),
                "Ожидали, что в корзине нет товара с названием: " + productName);
    }

}
