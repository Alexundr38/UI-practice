package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.pages.HomePage;
import store.Citilink.pages.CatalogPage;
import static com.codeborne.selenide.Selenide.sleep;
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
        productName = "Смартфон Huawei Pura 70 12/256Gb, ADY-LX9, белый";
        loader.doActionLogic(productName);

        homePage.openButton(HomePage.HeaderButton.CATALOG);
        homePage.hoverButtonTextCategory(HomePage.HeaderButton.CATEGORY, "Смартфоны и планшеты");
        homePage.openButtonText(HomePage.HeaderButton.SUBSUBCATEGORY, "Смартфоны HUAWEI");
        catalogPage = CatalogPage.openCatalogPage();
        catalogPage.addProductToCompareByName("Смартфон Huawei Pura 70 12/256Gb, ADY-LX9, белый");

        homePage.openButton(HomePage.HeaderButton.COMPARE);
        ComparePage comparePage = ComparePage.openComparePage();
        assertTrue(comparePage.containsProductWithName(productName),
                "Ожидали, что в разделе \"сранение\" есть товар с названием: " + productName);
    }
}
