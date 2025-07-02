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
public class AddProductToCompareTest extends BaseTest{
    protected CatalogPage catalogPage;

    @Test
    protected void addProductToCompare() {
        LoadWriteProductData loader = new LoadWriteProductData(LoadWriteProductData.ActionType.PUT_COMPARE);
        String productName = "Смартфон Huawei Pura 70 12/256Gb, ADY-LX9, белый";
        loader.doActionLogic(productName);

        login();
        homePage.openButton(HomePage.HeaderButton.CATALOG);
        sleep(500);
        homePage.hoverButtonTextCategory(HomePage.HeaderButton.CATEGORY, "Смартфоны и планшеты");
        sleep(500);
        homePage.openButtonText(HomePage.HeaderButton.SUBSUBCATEGORY, "Смартфоны HUAWEI");
        sleep(500);
        catalogPage = CatalogPage.openCatalogPage();
        sleep(500);
        catalogPage.addProductToCompareByName("Смартфон Huawei Pura 70 12/256Gb, ADY-LX9, белый");
        sleep(500);
        homePage.openButton(HomePage.HeaderButton.COMPARE);
        sleep(1000);
        ComparePage comparePage = ComparePage.openComparePage();
        sleep(1000);
        assertTrue(comparePage.containsProductWithName(productName));
    }
}
