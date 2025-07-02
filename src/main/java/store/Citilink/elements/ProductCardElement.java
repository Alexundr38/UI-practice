package store.Citilink.elements;

/**
 * Карточка товара (сниппет) в результатах поиска (его основа).
 * Содержит методы для добавления товара в корзину.
 */
public class ProductCardElement extends ProductSnippetElement {

    /** Кнопка добавления товара в корзину */
    ButtonElement addToBasketButton = ButtonElement.byInElement(this, "data-meta-name", "Snippet__cart-button");

    /** XPath для элемента товара */
    protected static String CARD_BY_NAME_XPATH;

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
     * Добавляет товар в корзину (клик по кнопке "Оформить заказ").
     */
    public void addToCart() {
        addToBasketButton.click();
    }
}