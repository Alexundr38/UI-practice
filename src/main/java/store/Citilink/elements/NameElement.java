package store.Citilink.elements;

public class NameElement extends InputElement {
    /**
     * Приватный конструктор для создания объекта PriceFilterElement.
     *
     * @param xpath  XPath-шаблон для поиска элемента
     * @param params Параметр для подстановки в XPath-шаблон
     */
    private NameElement(String xpath, String params) {
        super(xpath, params);
    }

    /**
     * XPath шаблон для поиска элемента по атрибуту data-meta-name
     */
    private static final String NAME_XPATH = "//*[@name=\"%s\"]";

    /**
     * Создает объект PriceFilterElement, находящий PriceFilter-элемент по атрибуту data-meta-name.
     *
     * @param name Значение атрибута data-meta-name
     * @return Объект PriceFilterElement
     */
    public static NameElement byName(String name) {

        return new NameElement(NAME_XPATH, name);
    }

    /**
     * Устанавливает имя.
     *
     * @param text Текст, который нужно ввести в поле
     */
    public void setValue(String text) {
        baseElement.setValue(text);
    }

    /**
     * Возвращает имя.
     */
    public String getValue() {
        return baseElement.getValue();
    }
}