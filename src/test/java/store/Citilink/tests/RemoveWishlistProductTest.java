package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.load_and_write_data.LoadWriteProductData;
import store.Citilink.pages.HomePage;
import store.Citilink.pages.WishlistPage;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тест-класс для проверки функциональности удаления товаров из раздела "избранное"
 */
public class RemoveWishlistProductTest extends TestWithProductName {

    /** Страница раздела "избранное" */
    private WishlistPage wishlistPage;

    /** Входит в раздел "избранное" и проверяет не пустой ли он */
    @Test
    public void openWishlistPage() {
        homePage.openButton(HomePage.HeaderButton.WISHLIST);
        wishlistPage = WishlistPage.openWishlistPage();
        loadByActionType(LoadWriteProductData.ActionType.REMOVE_WISHLIST);
        assertTrue(!wishlistPage.isEmpty());
    }

    /**
     * Тест проверяет удаление товара из раздела "избранное"
     * посредством кнопки крестика на сниппете товара.
     *
     * Заходит в раздел "избранное".
     * Выбирает тестовый товар.
     * Удаляет тестовый товар при помощи кнопки крестика.
     * Проверяет, удалился ли товар.
     */
    @Test
    public void removeWishlistProductWithCross() {
        String productName = loader.getRandomProduct();

        openWishlistPage();
        wishlistPage.removeProductWithCross(productName);
        assertTrue(wishlistPage.isProductRemoved(),
                "Ожидали, что в разделе \"избранное\" нет товара с названием: " + productName);
    }

    /**
     * Тест проверяет удаление товара из раздела "избранное"
     * посредством кнопки "Очистить список".
     *
     * Заходит в раздел "избранное".
     * Нажимает на кнопку "Очистить список".
     * Проверяет, удалились ли товары.
     */
    @Test
    public void removeWishlistProductWithRemoveAll() {
        productName = loader.getRandomProduct();

        openWishlistPage();
        wishlistPage.removeProductWithRemoveAll();
        assertTrue(wishlistPage.isProductRemoved(),
                "Ожидали, что в разделе \"избранное\" нет товара с названием: " + productName);
    }
}
