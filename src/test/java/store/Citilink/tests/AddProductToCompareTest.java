package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.pages.CatalogPage;
import static org.junit.jupiter.api.Assertions.assertTrue;
import store.Citilink.load_and_write_data.LoadWriteProductData;
import store.Citilink.pages.ComparePage;

/**
 * Тест-класс для проверки функциональности добавления товара в список сравнения на сайте.
 * Сценарий проверяет, что товар, добавленный из каталога, действительно отображается на странице сравнения.
 */
public class AddProductToCompareTest extends TestWithProductName {

    /** Страница каталога */
    protected CatalogPage catalogPage;

    /**
     * Добавление товара в корзину посредством поиска через каталог.
     * Открывает каталог.
     * Выбирает тестовую категорию.
     * Выбирает тестовую подкатегорию.
     * Находит тестовый товар.
     * Добавляет тестовый товар в сравнение.
     * Проверяет, находиться ли тестовый товар в разделе сравнения.
     */
    @Test
    protected void addProductToCompare() {
        loadByActionType(LoadWriteProductData.ActionType.PUT_COMPARE);
        productName = "Смартфон Huawei nova 13 12/512Gb, BLK-LX9, черный";
        loader.doActionLogic(productName);
        homePage.clickCatalogButton();
        homePage.hoverButtonTextCategory("Смартфоны и планшеты");
        homePage.clickSubCategoryButtonText("Смартфоны HUAWEI");
        catalogPage = CatalogPage.openCatalogPage();
        catalogPage.addProductToCompareByName(productName);

        homePage.clickCompareButton();
        ComparePage comparePage = ComparePage.openComparePage();
        assertTrue(comparePage.containsProductWithName(productName),
                "Ожидали, что в разделе \"сранение\" есть товар с названием: " + productName);
    }
}
