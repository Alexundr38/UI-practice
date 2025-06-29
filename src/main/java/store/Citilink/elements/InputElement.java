package store.Citilink.elements;

/**
 * Класс, представляющий элемент поля ввода (input) на веб-странице.
 * Наследуется от BaseElement и предоставляет методы для работы с полями ввода.
 */
public class InputElement extends BaseElement {
    /** XPath шаблон для поиска поля ввода по атрибуту type */
    private static final String TYPE_XPATH = "//input[@type=\"%s\"]";

    /**
     * Приватный конструктор для создания объекта InputElement.
     * @param xpath XPath-шаблон для поиска элемента
     * @param params Параметр для подстановки в XPath-шаблон
     */
    private InputElement(String xpath, String params) {
        super(xpath, params);
    }

    /**
     * Создает объект InputElement, находящий input-элемент по атрибуту type.
     * @param typeName Значение атрибута type
     * @return Объект InputElement
     */
    public static InputElement byType(String typeName) {
        return new InputElement(TYPE_XPATH, typeName);
    }

    /**
     * Устанавливает значение в поле ввода.
     * @param text Текст, который нужно ввести в поле
     */
    public void setValue(String text){
        baseElement.setValue(text);
    }
}
