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
public class UsingPriceFiltersTest extends BaseTest {
    private int testPrice = 10000;

    protected SearchPage searchPage;

    @Test
    protected void usePriceFilters() {
        LoadWriteProductData loader = new LoadWriteProductData(LoadWriteProductData.ActionType.PUT_BASKET);
        String productName = loader.getRandomProduct();

        login();

        homePage.search(productName);
        sleep(1000);

        searchPage = SearchPage.openSearchPage();

        searchPage.usePriceFilter(Integer.toString(testPrice));

        int result = searchPage.getPrice();

        sleep(1000);
        assertTrue(result >= testPrice,
                "При поиске с применением фильтра по минимальной стоимости был найден " + productName + ", у которого цена меньше " + testPrice + " : " + result);
    }
}
