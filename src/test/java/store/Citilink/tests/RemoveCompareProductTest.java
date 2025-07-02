package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.load_and_write_data.LoadWriteProductData;
import store.Citilink.pages.BasketPage;
import store.Citilink.pages.ComparePage;
import store.Citilink.pages.HomePage;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тест-класс для проверки функциональности удаления товаров из раздела "сравнение"
 */
public class RemoveCompareProductTest extends TestWithProductName{

    /** Страница раздела "сравнение" */
    private ComparePage comparePage;

    /** Входит в раздел "сравнение" и проверяет не пустой ли он */
    @Test
    public void openComparePage() {
        homePage.openButton(HomePage.HeaderButton.COMPARE);
        comparePage = ComparePage.openComparePage();
        loadByActionType(LoadWriteProductData.ActionType.REMOVE_COMPARE);
        assertTrue(!comparePage.isEmpty());
    }

    /**
     * Тест проверяет удаление товара из раздела "сравнение"
     * посредством кнопки "Очистить список".
     *
     * Заходит в раздел "сравнение".
     * Нажимает на кнопку "Очистить список".
     * Проверяет, удалились ли товары.
     */
    @Test
    public void removeCompareProductWithRemoveAll() {
        openComparePage();
        productName = loader.getRandomProduct();

        comparePage.removeProductWithRemoveAll();
        assertTrue(comparePage.isProductRemoved(),
                "Ожидали, что в разделе \"сравнение\" нет товара с названием: " + productName);
    }

    /**
     * Тест проверяет удаление товара из раздела "сравнение"
     * посредством кнопки крестика на сниппете товара.
     *
     * Заходит в раздел "сравнение".
     * Выбирает тестовый товар.
     * Удаляет тестовый товар при помощи кнопки крестика.
     * Проверяет, удалился ли товар.
     */
    @Test
    public void removeCompareProductWithCross() {
        openComparePage();
        productName = loader.getRandomProduct();

        comparePage.removeProductWithCross(productName);
        assertTrue(comparePage.isProductRemoved(),
                "Ожидали, что в разделе \"сравнение\" нет товара с названием: " + productName);
    }
}
