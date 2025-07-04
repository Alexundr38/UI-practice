package store.Citilink.elements;

/**
 * Класс, представляющий элемент input на странице.
 * Наследуется от BaseElement и предоставляет методы для работы с input.
 */
public class InputElement extends BaseElement {

    /** XPath шаблон для поиска элемента input по атрибуту type */
    protected static final String TYPE_XPATH = "//input[@type=\"%s\"]";

    /** XPath шаблон для поиска элемента input в другом элементе по поданному атрибуту */
    protected static final String INPUT_IN_ELEMENT_XPATH = ".//input[@%s=\"%s\"]";

    /**
     * Приватный конструктор для создания объекта InputElement.
     * @param xpath XPath-шаблон для поиска элемента
     * @param params Параметр для подстановки в XPath-шаблон
     */
    protected InputElement(String xpath, String params) {
        super(xpath, params);
    }


    /**
     * Приватный конструктор для создания объекта InputElement.
     * @param parentElement Родительский элемент, относительно которого
     *                      осуществляется поиск элемента
     * @param xpath XPath-шаблон для поиска элемента
     * @param param Параметр для подстановки в XPath-шаблон
     */
    protected InputElement(BaseElement parentElement, String xpath, String param){
        super(parentElement, xpath, param);
    }
}
