package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.elements.ProductActionElement;
import store.Citilink.load_and_write_data.LoadWriteData;
import store.Citilink.pages.WishlistPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тест проверяет добавление в избранное через раздел акции.
 * Название товара берётся из внешнего JSON-файла со списком продуктов.
 */
public class AddProductToWishListTest extends TestWithDataName {
    /**
     * Добавление товара в избранное посредством поиска через раздел акций.
     * Ищет товар по тестируемому запросу.
     * Добавляет товар в избранное.
     * Проверяет, находиться ли товар в избранном.
     */
    @Test
    public void addProductToWishList() {
        homePage.clickCookie();
        ProductActionElement promoItem = ProductActionElement.firstAction();
        promoItem.scrollToElement();
        promoItem.hover();
        promoItem.addToWishlist();
        loadByActionType(LoadWriteData.ActionType.PUT_WISHLIST);
        String productName = promoItem.getTitle();
        loader.doActionLogic(productName);
        homePage.clickWishListButton();
        WishlistPage wishlistPage = WishlistPage.openWishlistPage();
        assertTrue(wishlistPage.containsProductWithName(productName),
                "Ожидали, что товар «" + productName + "» появится в избранном");
    }
}
