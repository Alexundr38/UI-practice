package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.pages.HomePage;
import store.Citilink.pages.SearchPage;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;
import store.Citilink.load_and_write_data.LoadWriteProductData;


/**
 * Тест проверяет работу фильтров цены.
 * Цена первого товара в списке должна попадать в выбранный интервал, после применения фильтра.
 */
public class UsingPriceFiltersTest extends TestWithProductName {
    private int testPrice = 10000;

    protected SearchPage searchPage;

    @Test
    protected void usePriceFilters() {
        loadByActionType(LoadWriteProductData.ActionType.GET_COMMON);
        productName = loader.getRandomProduct();

        homePage.search(productName);

        searchPage = SearchPage.openSearchPage();
        searchPage.usePriceFilter(Integer.toString(testPrice));
        int result = searchPage.getPrice();
        int maxPrice = searchPage.getMaxPrice();

        assertTrue(testPrice <= maxPrice,
                "Минимальная цена в тесте (" + testPrice + ") выше максимальной найденной: " + maxPrice);
        assertTrue(result >= testPrice,
                "При поиске с применением фильтра по минимальной стоимости был найден " + productName + ", у которого цена меньше " + testPrice + " : " + result);
    }
}
