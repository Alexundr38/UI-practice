package store.Citilink.elements;

/**
 * Карточка товара (сниппет) на странице сравнения.
 * Добавляет метод добавления в избранное.
 */
public class ProductCompareElement extends ProductListElement {

    /** Кнопка добавления в избранное */
    private final ButtonElement wishlistButton = ButtonElement.byInElement(this, "data-meta-name", "Snippet__wishlist-button");

    /**
     * Приватный конструктор.
     * @param xpath XPath выражение для поиска карточки товара
     * @param param значение для подстановки в XPath
     */
    private ProductCompareElement(String xpath, String param) {
        super(xpath, param);
    }

    /** Добавляет товар в избранное (клик по кнопке wishlist). */
    public void addToWishlist() {
        scrollToElement();
        wishlistButton.click();
    }

    /**
     * Фабричный метод для поиска карточки по названию товара.
     * @param snippetType Тип текущего сниппета
     * @param productName Точное название товара
     * @return Новый объект ProductCompareElement
     */
    public static ProductCompareElement byName(String snippetType, String productName) {
        return ProductListElement.byName(snippetType, xpath -> new ProductCompareElement(xpath, productName));
    }

    /**
     * Фабричный метод для поиска карточки товара по значению атрибута data-meta-name.
     * @param snippetType значение атрибута data-meta-name
     * @return новый объект ProductCompareElement, соответствующий найденному элементу
     */
    public static ProductCompareElement byDataMetaName(String snippetType) {
        return new ProductCompareElement(DATA_META_NAME_XPATH, snippetType);
    }
}
