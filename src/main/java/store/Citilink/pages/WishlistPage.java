package store.Citilink.pages;

/**
 * Класс представляет страницу избранных товаров (wishlist).
 * Наследуется от ListPage и предоставляет доступ к функциональности избранного.
 */

public class WishlistPage extends ListPage {
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
    public static WishlistPage open() {
        return ListPage.openListPage(WishlistPage.class, URL_PART);
    }
}
