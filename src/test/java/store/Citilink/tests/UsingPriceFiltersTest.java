package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.pages.SearchPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import store.Citilink.load_and_write_data.LoadWriteData;


/**
 * Тест проверяет работу фильтров цены.
 * Цена первого товара в списке должна попадать в выбранный интервал, после применения фильтра.
 */
public class UsingPriceFiltersTest extends TestWithDataName {
    /**
     * Использование фильтра цены на странице поиска.
     * Ищет товар по тестируемому запросу.
     * Применяет фильтр цены (выставляет минимальную цену).
     * Проверяет, что первый товар на странице поиска имеет цену не менее тестовой.
     */
    @Test
    public void usePriceFilters() {
        int testPrice = 10000;
        loadByActionType(LoadWriteData.ActionType.GET_COMMON);
        dataName = loader.getRandomData();
        homePage.search(dataName);
        SearchPage searchPage = SearchPage.openSearchPage();
        searchPage.usePriceFilter(Integer.toString(testPrice));
        int result = searchPage.getPrice();
        int maxPrice = searchPage.getMaxPrice();
        assertTrue(testPrice <= maxPrice,
                "Минимальная цена в тесте (" + testPrice + ") выше максимальной найденной: " + maxPrice);
        assertTrue(result >= testPrice,
                "При поиске с применением фильтра по минимальной стоимости был найден " + dataName + ", у которого цена меньше " + testPrice + " : " + result);
    }
}
