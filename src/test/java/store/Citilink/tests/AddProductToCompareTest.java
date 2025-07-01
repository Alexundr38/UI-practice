package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.pages.HomePage;
import store.Citilink.pages.CatalogPage;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;
import store.Citilink.load_data.LoadProductData;
import store.Citilink.pages.ComparePage;

/**
 * Тест-класс для проверки функциональности добавления товара в список сравнения на сайте.
 * Сценарий проверяет, что товар, добавленный из каталога, действительно отображается на странице сравнения.
 */
public class AddProductToCompareTest extends BaseTest{
    protected CatalogPage catalogPage;

    @Test
    protected void addProductToCompare() {
        LoadProductData loader = new LoadProductData();
        String productName = loader.getRandomProduct();

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
        ComparePage comparePage = ComparePage.open();
        sleep(1000);
        assertTrue(comparePage.containsProductWithName("Смартфон Huawei Pura 70 12/256Gb, ADY-LX9, белый"),
                "Ожидали, что на странице сравнения будет товар с названием: " + productName);
    }
}
