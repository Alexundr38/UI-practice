package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.pages.BasketPage;
import store.Citilink.pages.HomePage;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductInBasketTest extends BaseTest{
    protected BasketPage basketPage;

    @Test
    protected void openBasketPage() {
        login();
        homePage.openButton(HomePage.HeaderButton.BASKET);
        basketPage = BasketPage.openBasketPage();
        sleep(500);
        assertTrue(!basketPage.isEmptyOrder());
    }
}
