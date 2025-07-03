package store.Citilink.elements;

/**
 * Карточка товара (сниппет) в каталоге и посике.
 * Добавляет методы для работы с товаром: кнопки добавления в сравнение и добавления в избранное.
 */
public class ProductCatalogElement extends ProductCardElement {

    /** Кнопка добавления в сравнение */
    ButtonElement compareButton = ButtonElement.byInElement(this, "data-meta-name", "Snippet__compare-button");

    /** Кнопка добавления в избранное */
    ButtonElement wishlistButton = ButtonElement.byInElement(this, "data-meta-name", "Snippet__wishlist-button");

    /**
     * Приватный конструктор.
     * @param xpath XPath выражение для поиска карточки товара
     * @param param значение для подстановки в XPath
     */
    private ProductCatalogElement(String xpath, String param) {
        super(xpath, param);
    }

    /**
     * Добавляет товар в сравнение (клик по кнопке compare).
     */
    public void addToCompare() {
        compareButton.click();
    }

    /**
     * Добавляет товар в избранное (клик по кнопке wishlist).
     */
    public void addToWishlist() {
        wishlistButton.click();
    }

    /**
     * Фабричный метод для поиска карточки по названию товара.
     * @param snippetType Тип текущего сниппета
     * @param productName Точное название товара
     * @return Новый объект ProductCardElement
     */
    public static ProductCatalogElement byName(String snippetType, String productName) {
        CARD_BY_NAME_XPATH = SNIPPET_BY_NAME_XPATH.replaceFirst("%s", snippetType);
        return new ProductCatalogElement(CARD_BY_NAME_XPATH, productName);
    }

    /**
     * Фабричный метод для поиска карточки товара по значению атрибута data-meta-name.
     *
     * @param snippetType значение атрибута data-meta-name
     * @return новый объект ProductCardElement, соответствующий найденному элементу
     */
    public static ProductCatalogElement byDataMetaName(String snippetType) {
        return new ProductCatalogElement(DATA_META_NAME_XPATH, snippetType);
    }
}
