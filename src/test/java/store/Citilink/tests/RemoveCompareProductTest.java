package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.load_and_write_data.LoadWriteProductData;
import store.Citilink.pages.BasketPage;
import store.Citilink.pages.ComparePage;
import store.Citilink.pages.HomePage;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveCompareProductTest extends BaseTest{

    private ComparePage comparePage;

    @Test
    public void openComparePage() {
        login();
        homePage.openButton(HomePage.HeaderButton.COMPARE);
        comparePage = ComparePage.openComparePage();
        sleep(500);
        assertTrue(!comparePage.isEmpty());
    }

    @Test
    public void removeCompareProductWithRemoveAll() {
        LoadWriteProductData loader = new LoadWriteProductData(LoadWriteProductData.ActionType.REMOVE_COMPARE);
        String productName = loader.getRandomProduct();

        openComparePage();

        comparePage.removeProductWithRemoveAll();
        sleep(500);
        assertTrue(comparePage.isEmpty());
    }

    @Test
    public void removeCompareProductWithCross() {
        LoadWriteProductData loader = new LoadWriteProductData(LoadWriteProductData.ActionType.REMOVE_COMPARE);
        String productName = loader.getRandomProduct();

        openComparePage();

        assertTrue(comparePage.removeProductWithCross(productName));
    }
}
