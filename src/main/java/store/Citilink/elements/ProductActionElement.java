package store.Citilink.elements;

/**
 * Специальный элемент — первая карточка товара в блоке ProductsCompilation.
 */
public class ProductActionElement extends ProductCardElement {

    /**
     * Базовый XPath на контейнер ProductsCompilation,
     * в котором нужно искать слайд по data-meta-name.
     * %s будет заменяться на значение param ("ProductsCompilation__slide").
     */
    private static final String PARENT_XPATH = "//div[@data-meta-name='ProductsCompilation']"
            + "//div[@data-meta-name='%s'][1]";

    /** Кнопка добавления в избранное */
    private final ButtonElement wishlistButton = ButtonElement.byInElement(this, "data-meta-name",
            "Snippet__wishlist-button");


    /**
     * Конструктор вызывает родительский с XPath-шаблоном,
     * а в качестве param передаём "ProductsCompilation__slide".
     */
    public ProductActionElement() {
        super(PARENT_XPATH, "ProductsCompilation__slide");
    }

    /**
     * Фабричный метод создания карточки товара из раздела акции.
     */
    public static ProductActionElement firstAction() {
        return new ProductActionElement();
    }

    /**
     * Добавляет товар в избранное (клик по кнопке wishlist).
     */
    public void addToWishlist() {
        wishlistButton.click();
    }

    /**
     * Возвращает название первого товара из блока.
     */
    public String getTitle() {
        return baseElement.$x(".//a[@data-meta-name='Snippet__title']").getText().trim();
    }
}
