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
        addToBasketButton.click();
    }

    /**
     * Получение значения цены товара
     */
    public int getPrice() {
        String rawPrice = com.codeborne.selenide.Selenide.$("[data-meta-price]").getAttribute("data-meta-price");

        // Удаляем все нецифровые символы и преобразуем в число
        return Integer.parseInt(rawPrice.replaceAll("[^0-9]", ""));
    }
}