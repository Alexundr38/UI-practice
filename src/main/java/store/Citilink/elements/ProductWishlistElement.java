package store.Citilink.elements;

/**
 * Карточка товара (сниппет) на странице избранного.
 * Добавляет метод добавления в сравнение.
 */
public class ProductWishlistElement extends ProductListElement {

    /** Кнопка добавления в сравнение */
    private final ButtonElement compareButton = ButtonElement.byInElement(this, "data-meta-name", "Snippet__compare-button");

    /**
     * Приватный конструктор.
     * @param xpath XPath выражение для поиска карточки товара
     * @param param значение для подстановки в XPath
     */
    private ProductWishlistElement(String xpath, String param) {
        super(xpath, param);
    }

    /** Добавляет товар в сравнение (клик по кнопке compare).*/
    public void addToCompare() {
        compareButton.click();
    }

    /**
     * Фабричный метод для поиска карточки по названию товара.
     * @param snippetType Тип текущего сниппета
     * @param productName Точное название товара
     * @return Новый объект ProductWishlistElement
     */
    public static ProductWishlistElement byName(String snippetType, String productName) {
        return ProductListElement.byName(snippetType, xpath -> new ProductWishlistElement(xpath, productName));
    }

    /**
     * Фабричный метод для поиска карточки товара по значению атрибута data-meta-name.
     * @param snippetType значение атрибута data-meta-name
     * @return новый объект ProductWishlistElement, соответствующий найденному элементу
     */
    public static ProductWishlistElement byDataMetaName(String snippetType) {
        return new ProductWishlistElement(DATA_META_NAME_XPATH, snippetType);
    }
}
