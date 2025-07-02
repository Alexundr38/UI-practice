package store.Citilink.pages;

import store.Citilink.elements.ProductCompareElement;
import store.Citilink.elements.ProductWishlistElement;

/**
 * Класс представляет страницу избранных товаров (wishlist).
 * Наследуется от ListPage и предоставляет доступ к функциональности избранного.
 */

public class WishlistPage extends ListPage<ProductWishlistElement> {
    /**
     * Часть URL, соответствующая странице избранного.
     */
    private static final String URL_PART = "wishlist";

    /**
     * Конструктор страницы избранного.
     * @param cls     класс-наследник
     * @param partURL часть URL для навигации к странице избранного
     */
    protected WishlistPage(Class<? extends ListPage> cls, String partURL) {
        super(cls, partURL);
    }

    /**
     * Статический метод для открытия страницы избранного.
     * @return новый экземпляр WishlistPage
     */
    public static WishlistPage openWishlistPage() {
        return ListPage.openListPage(WishlistPage.class, URL_PART);
    }

    protected void setUpElement() {
        productSnippet = ProductWishlistElement.byDataMetaName("SnippetProductVerticalLayout");
    }

    protected void setUpElementByName(String productName) {
        productSnippet = ProductWishlistElement.byName("SnippetProductVerticalLayout", productName);
    }
}
