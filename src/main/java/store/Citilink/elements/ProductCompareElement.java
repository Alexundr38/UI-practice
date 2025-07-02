package store.Citilink.elements;

public class ProductCompareElement extends ProductListElement {
    /**
     * Приватный конструктор.
     *
     * @param xpath XPath выражение для поиска карточки товара
     * @param param значение для подстановки в XPath
     */
    protected ProductCompareElement(String xpath, String param) {
        super(xpath, param);
    }

    public static ProductCompareElement byName(String snippetType, String productName) {
        return ProductListElement.byName(snippetType, productName, xpath -> new ProductCompareElement(xpath, productName));
    }

    /**
     * Фабричный метод для поиска карточки товара по значению атрибута data-meta-name.
     *
     * @param snippetType значение атрибута data-meta-name
     * @return новый объект ProductCardElement, соответствующий найденному элементу
     */
    public static ProductCompareElement byDataMetaName(String snippetType) {
        return new ProductCompareElement(DATA_META_NAME_XPATH, snippetType);
    }

    /**
     * Добавляет товар в избранное (клик по кнопке wishlist).
     */
    public void addToWishlist() {
        ButtonElement.byInElement(this, "data-meta-name", "Snippet__wishlist-button").click();
    }
}
