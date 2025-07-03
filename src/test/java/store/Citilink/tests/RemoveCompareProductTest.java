package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.load_and_write_data.LoadWriteData;
import store.Citilink.pages.ComparePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тест-класс для проверки функциональности удаления товаров из раздела "сравнение"
 */
public class RemoveCompareProductTest extends TestWithDataName {

    /** Страница раздела "сравнение" */
    private ComparePage comparePage;

    /** Входит в раздел "сравнение" и проверяет не пустой ли он */
    @Test
    public void openComparePage() {
        homePage.clickCompareButton();
        comparePage = ComparePage.openComparePage();
        loadByActionType(LoadWriteData.ActionType.REMOVE_COMPARE);
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
        dataName = loader.getRandomData();

        comparePage.removeProductWithRemoveAll();
        assertTrue(comparePage.isProductRemoved(),
                "Ожидали, что в разделе \"сравнение\" нет товара с названием: " + dataName);
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
        dataName = loader.getRandomData();

        comparePage.removeProductWithCross(dataName);
        assertTrue(comparePage.isProductRemoved(),
                "Ожидали, что в разделе \"сравнение\" нет товара с названием: " + dataName);
    }
}
