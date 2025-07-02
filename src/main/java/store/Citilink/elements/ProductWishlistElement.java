package store.Citilink.elements;

public class ProductWishlistElement extends ProductListElement {
    /**
     * Приватный конструктор.
     *
     * @param xpath XPath выражение для поиска карточки товара
     * @param param значение для подстановки в XPath
     */
    protected ProductWishlistElement(String xpath, String param) {
        super(xpath, param);
    }

    public static ProductWishlistElement byName(String snippetType, String productName) {
        return ProductListElement.byName(snippetType, productName, xpath -> new ProductWishlistElement(xpath, productName));
    }

    /**
     * Фабричный метод для поиска карточки товара по значению атрибута data-meta-name.
     *
     * @param snippetType значение атрибута data-meta-name
     * @return новый объект ProductCardElement, соответствующий найденному элементу
     */
    public static ProductWishlistElement byDataMetaName(String snippetType) {
        return new ProductWishlistElement(DATA_META_NAME_XPATH, snippetType);
    }

    /**
     * Добавляет товар в сравнение (клик по кнопке compare).
     */
    public void addToCompare() {
        ButtonElement.byInElement(this, "data-meta-name", "Snippet__compare-button").click();
    }
}
