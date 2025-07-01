package store.Citilink.pages;

import store.Citilink.elements.ProductCardElement;

/**
 * Страница результатов поиска на сайте Citilink.
 */
public class SearchPage extends BasePage {

    /**
     * Ожидаемая часть URL для страницы результатов поиска.
     * Используется для проверки корректности загруженной страницы.
     */
    private static final String URL_PART = "/search";

    /**
     * Конструктор страницы результатов поиска.
     * Вызывает конструктор базового класса с передачей
     * класса текущей страницы и ожидаемой части URL.
     */
    public SearchPage() {
        super(SearchPage.class, URL_PART);
    }

    /**
     * Статический метод для создания страницы поиска.
     * @return новый объект SearchPage
     */
    public static SearchPage openSearchPage(){
        return new SearchPage();
    }

    /**
     * Возвращает объект карточки товара по точному названию.
     *
     * @param productName точное название товара, отображаемое в элементе Snippet__title
     * @return объект ProductCardElement для дальнейших действий
     */
    public ProductCardElement getProductCardByName(String productName) {
        return ProductCardElement.byName("SnippetProductVerticalLayout", productName);
    }

    /**
     * Добавляет товар в корзину по точному названию.
     * Выполняет поиск карточки товара и вызывает действие добавления в корзину.
     *
     * @param productName точное название товара для добавления в корзину
     */
    public void addProductToCartByName(String productName) {
        ProductCardElement productCard = getProductCardByName(productName);
        productCard.addToCart();
    }

    /**
     * Добавляет товар в сравнение по точному названию.
     * Ищет карточку товара на странице результатов и выполняет клик по кнопке сравнения.
     *
     * @param productName точное название товара, отображаемое заголовком в сниппете
     */
    public void addProductToCompareByName(String productName) {
        ProductCardElement productCard = getProductCardByName(productName);
        productCard.addToCompare();
    }

    /**
     * Добавляет товар в список избранного по точному названию.
     * Ищет карточку товара на странице результатов и выполняет клик по кнопке избранного.
     *
     * @param productName точное название товара, отображаемое заголовком в сниппете
     */
    public void addProductToWishListByName(String productName) {
        ProductCardElement productCard = getProductCardByName(productName);
        productCard.addToWishlist();
    }

}
