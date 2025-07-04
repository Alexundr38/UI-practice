package store.Citilink.pages;

import store.Citilink.elements.ProductWishlistElement;

/**
 * Класс представляет страницу избранных товаров (wishlist).
 * Наследуется от ListPage и предоставляет доступ к функциональности избранного.
 */

public class WishlistPage extends ListPage<ProductWishlistElement> {

    /** Часть URL, соответствующая странице избранного. */
    private static final String URL_PART = "wishlist";

    /**
     * Конструктор страницы избранного.
     * @param classType Класс-наследник
     * @param partURL Часть URL для навигации к странице избранного
     */
    private WishlistPage(Class<? extends ListPage> classType, String partURL) {
        super(classType, partURL);
    }

    /** Находит первый сниппет товара на странице */
    protected void setUpElement() {
        productSnippet = ProductWishlistElement.byDataMetaName("SnippetProductVerticalLayout");
    }

    /** Находит сниппет товара по названию товара */
    protected void setUpElementByName(String productName) {
        productSnippet = ProductWishlistElement.byName("SnippetProductVerticalLayout", productName);
    }

    /**
     * Статический метод для открытия страницы избранного.
     * @return Новый объект WishlistPage
     */
    public static WishlistPage openWishlistPage() {
        return ListPage.openListPage(WishlistPage.class, URL_PART);
    }

}
