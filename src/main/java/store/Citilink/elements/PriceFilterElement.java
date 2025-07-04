package store.Citilink.elements;

/** Класс, представляющий элемент поля фильтров */
public class PriceFilterElement extends InputElement {

    /** XPath шаблон для поиска элемента по атрибуту data-meta-name */
    private static final String DATA_META_NAME_XPATH = "//*[@data-meta-name=\"%s\"]";

    /**
     * Приватный конструктор для создания объекта PriceFilterElement.
     * @param xpath XPath-шаблон для поиска элемента
     * @param params Параметр для подстановки в XPath-шаблон
     */
    private PriceFilterElement(String xpath, String params) {
        super(xpath, params);
    }

    /**
     * Устанавливает значение в поле ввода.
     * @param text Текст, который нужно ввести в поле
     */
    public void setValue(String text){
        baseElement.setValue(text);
    }

    /**
     * Возвращает стоимость, которая является максимальной среди найденных товаров.
     */
    public int getValue() {
        String rawPrice = baseElement.getValue();
        return Integer.parseInt(rawPrice.replaceAll("[^0-9]", ""));
    }

    /**
     * Создает объект PriceFilterElement, находящий PriceFilter-элемент по атрибуту data-meta-name.
     * @param dataMetaName Значение атрибута data-meta-name
     * @return Объект PriceFilterElement
     */
    public static PriceFilterElement byDataMetaName(String dataMetaName) {
        return new PriceFilterElement(DATA_META_NAME_XPATH, dataMetaName);
    }
}