package store.Citilink.pages;

import store.Citilink.elements.ButtonElement;
import store.Citilink.elements.PriceFilterElement;
import store.Citilink.elements.ProductCatalogElement;

/**
 * Страница результатов поиска на сайте.
 */
public class SearchPage extends BasePage {
    /** Поле ввода минимальной цены в фильтрах*/
    private final PriceFilterElement PFEmin = PriceFilterElement.byDataMetaName("FilterRangeGroup__input-min");

    /** Кнопка подтверждения фильтра*/
    private final ButtonElement buttonAcceptFilter = ButtonElement.byClass("e11203e30 app-catalog-1g3e94m-Button" +
            "--StyledButton-Button--Button ekx3zbi0");

    /** Карточка первого товара*/
    private final ProductCatalogElement elementSnippet = ProductCatalogElement.byDataMetaName("SnippetProductVerticalLayout");

    /** Максимальная цена товара на странице*/
    private final PriceFilterElement elementMaxPrice = PriceFilterElement.byDataMetaName("FilterRangeGroup__input-max");

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
    private SearchPage() {
        super(SearchPage.class, URL_PART);
    }

    /**
     * Добавляет товар в корзину по точному названию.
     * Выполняет поиск карточки товара и вызывает действие добавления в корзину.
     *
     * @param productName точное название товара для добавления в корзину
     */
    public void addProductToCartByName(String productName) {
        ProductCatalogElement productCard = getProductCardByName(productName);
        productCard.addToCart();
    }

    /**
     * Добавляет товар в сравнение по точному названию.
     * Ищет карточку товара на странице результатов и выполняет клик по кнопке сравнения.
     *
     * @param productName точное название товара, отображаемое заголовком в сниппете
     */
    public void addProductToCompareByName(String productName) {
        ProductCatalogElement productCard = getProductCardByName(productName);
        productCard.addToCompare();
    }

    /**
     * Добавляет товар в список избранного по точному названию.
     * Ищет карточку товара на странице результатов и выполняет клик по кнопке избранного.
     *
     * @param productName точное название товара, отображаемое заголовком в сниппете
     */
    public void addProductToWishListByName(String productName) {
        ProductCatalogElement productCard = getProductCardByName(productName);
        productCard.addToWishlist();
    }

    /**
     * Использование фильтра цены
     */
    public void usePriceFilter(String minPrice) {
        PFEmin.setValue(minPrice);
        buttonAcceptFilter.scrollIntoViewCentered().waitUntilClickable().click();
    }

    /**
     * Получение значения цены первого товара из найденного списка
     */
    public int getPrice() {
        return elementSnippet.getPrice();
    }

    /**
     * Возвращает стоимость, которая является максимальной среди найденных товаров.
     */
    public int getMaxPrice() {
        return elementMaxPrice.getValue();
    }
  
     /**
     * Возвращает объект карточки товара по точному названию.
     *
     * @param productName точное название товара, отображаемое в элементе Snippet__title
     * @return объект ProductCatalogElement для дальнейших действий
     */
    private ProductCatalogElement getProductCardByName(String productName) {
        return ProductCatalogElement.byName("SnippetProductVerticalLayout", productName);
    }

    /**
     * Статический метод для создания страницы поиска.
     * @return новый объект SearchPage
     */
    public static SearchPage openSearchPage(){
        return new SearchPage();
    }
}
