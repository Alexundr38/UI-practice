package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.elements.ProductActionElement;
import store.Citilink.load_and_write_data.LoadWriteProductData;
import store.Citilink.pages.WishlistPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тест проверяет добавление в избранное через раздел акции.
 * Название товара берётся из внешнего JSON-файла со списком продуктов.
 */
public class AddProductToWishListTest extends TestWithDataName {

    /** Страница избранного */
    protected WishlistPage wishlistPage;

    /**
     * Добавление товара в избранное посредством поиска через раздел акций.
     * Ищет товар по тестируемому запросу.
     * Добавляет товар в избранное.
     * Проверяет, находиться ли товар в избранном.
     */
    @Test
    void addProductToWishList() {
        ProductActionElement promoItem = ProductActionElement.firstAction();
        promoItem.scrollToElement();
        promoItem.hover();
        promoItem.addToWishlist();
        loadByActionType(LoadWriteProductData.ActionType.PUT_WISHLIST);
        String productName = promoItem.getTitle();
        loader.doActionLogic(productName);
        homePage.clickWishListButton();
        wishlistPage = WishlistPage.openWishlistPage();
        assertTrue(wishlistPage.containsProductWithName(productName),
                "Ожидали, что товар «" + productName + "» появится в избранном");
    }
}
