package store.Citilink.elements;

/** Класс карточки магазина на странице магазинов */
public class StoreCardElement extends BaseElement {

    /** XPath для параметра и текста внутри */
    private static final String PARAM_AND_TEXT_XPATH = "//*[@%s=\"%s\" and .//text()[contains(., \"%s\")]]";

    /** Кнопка сердечка */
    private final ButtonElement wishlistButton = ButtonElement.byInContains(this,
                                                                "class", "e19vs7y00");

    /** Конструктор
     * @param xpath XPath элемента
     * @param params Параметры XPath
     */
    private StoreCardElement(String xpath, String... params){
        super(xpath, params);
    }

    /** Нажимает на кнопку сердечка */
    public void addToWishlist() {
        if (!isInWishlist()) {
            wishlistButton.click();
        }
    }

    /** Проверяет, находиться ли карточка магазина в избранных */
    public boolean isInWishlist() {
        return wishlistButton.getParamValue("class").contains("072imz");
    }

    /**
     * Создает объект StoreCardElement, находящий кнопку по атрибуту type.
     * @param paramName Название параметра
     * @param paramValue Значение параметра
     * @return Объект ButtonElement
     */
    public static StoreCardElement byParamAndText(String paramName, String paramValue, String text) {
        return new StoreCardElement(PARAM_AND_TEXT_XPATH.replaceFirst("%s", paramName), paramValue, text);
    }
}
