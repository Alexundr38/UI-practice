package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.load_and_write_data.LoadWriteProductData;
import store.Citilink.pages.BasketPage;
import store.Citilink.pages.HomePage;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тест-класс для проверки функциональности удаления товаров из корзины
 */
public class RemoveBasketProductTest extends TestWithProductName {

    /** Страница корзины */
    protected BasketPage basketPage;

    /** Входит в корзину и проверяет не пустая ли она */
    @Test
    protected void openBasketPage() {
        homePage.openButton(HomePage.HeaderButton.BASKET);
        basketPage = BasketPage.openBasketPage();
        loadByActionType(LoadWriteProductData.ActionType.REMOVE_BASKET);
        assertTrue(!basketPage.isEmptyOrder());
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
    protected void removeBasketProductWithBin() {
        productName = loader.getRandomProduct();

        openBasketPage();
        basketPage.removeProductWithBin(productName);
        assertTrue(basketPage.isProductRemoved(),
                "Ожидали, что в корзине нет товара с названием: " + productName);
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
    protected void removeBasketProductWithCheckBox() {
        String productName = loader.getRandomProduct();

        openBasketPage();
        basketPage.selectProductWithCheckBox(productName);
        basketPage.clickRemoveSelectedButton();
        assertTrue(basketPage.isProductRemoved(),
                "Ожидали, что в корзине нет товара с названием: " + productName);
    }

}
