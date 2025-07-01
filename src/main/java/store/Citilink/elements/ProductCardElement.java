package store.Citilink.elements;

/**
 * Карточка товара (сниппет) в результатах поиска.
 * Содержит методы для добавления товара в корзину, сравнение и избранное.
 */
public class ProductCardElement extends ProductSnippetElement {
    private static String CARD_BY_NAME_XPATH;

    /**
     * Приватный конструктор.
     *
     * @param xpath XPath выражение для поиска карточки товара
     * @param param значение для подстановки в XPath
     */
    protected ProductCardElement(String xpath, String param) {
        super(xpath, param);
    }

    /**
     * Фабричный метод для поиска карточки по названию товара.
     *
     * @param productName точное название товара
     * @return новый объект ProductCardElement
     */
    public static ProductCardElement byName(String snippetType, String productName) {
        CARD_BY_NAME_XPATH = SNIPPET_BY_NAME_XPATH.replaceFirst("%s", snippetType);
        return new ProductCardElement(CARD_BY_NAME_XPATH, productName);
    }

    /**
     * Добавляет товар в корзину (клик по кнопке "Оформить заказ").
     */
    public void addToCart() {
        ButtonElement.byInElement(this, "data-meta-name", "Snippet__cart-button").click();
    }

    /**
     * Добавляет товар в сравнение (клик по кнопке compare).
     */
    public void addToCompare() {
        ButtonElement.byInElement(this, "data-meta-name", "Snippet__compare-button").click();
    }

    /**
     * Добавляет товар в избранное (клик по кнопке wishlist).
     */
    public void addToWishlist() {
        ButtonElement.byInElement(this, "data-meta-name", "Snippet__wishlist-button").click();
    }
}