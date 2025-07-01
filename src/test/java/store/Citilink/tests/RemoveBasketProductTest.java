package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.pages.BasketPage;
import store.Citilink.pages.HomePage;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveBasketProductTest extends BaseTest{
    protected BasketPage basketPage;

    @Test
    protected void removeBasketProductWithBin() {
        openBasketPage();
        assertTrue(basketPage.removeUpProductWithBin("Смартфон TECNO Spark 30C 8/256Gb, черный"));
    }

    @Test
    protected void removeBasketProductWithCheckBox() {
        openBasketPage();
        assertTrue(basketPage.removeUpProductWithCheckBox("Смартфон TECNO Spark 30C 8/256Gb, черный"));
    }

    @Test
    protected void openBasketPage() {
        login();
        homePage.openButton(HomePage.HeaderButton.BASKET);
        basketPage = BasketPage.openBasketPage();
        sleep(500);
        assertTrue(!basketPage.isEmptyOrder());
    }

}
