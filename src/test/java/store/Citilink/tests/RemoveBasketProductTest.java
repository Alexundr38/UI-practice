package store.Citilink.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveBasketProductTest extends ProductInBasketTest{

    @Test
    protected void removeBasketProductWithBin() {
        openBasketPage();
        assertTrue(basketPage.removeUpProductWithBin());
    }

    @Test
    protected void removeBasketProductWithCheckBox() {
        openBasketPage();
        assertTrue(basketPage.removeUpProductWithCheckBox());
    }

}
