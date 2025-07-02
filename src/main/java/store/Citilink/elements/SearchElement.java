package store.Citilink.elements;

/**
 * Класс элемента поиска
 */
public class SearchElement extends InputElement{

    /**
     * Приватный конструктор для создания объекта SearchElement.
     * @param xpath XPath-шаблон для поиска элемента
     * @param params Параметр для подстановки в XPath-шаблон
     */
    private SearchElement(String xpath, String params) {
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
     * Создает объект SearchElement, находящий Search-элемент по атрибуту type.
     * @param typeName Значение атрибута type
     * @return Объект SearchElement
     */
    public static SearchElement byType(String typeName) {
        return new SearchElement(TYPE_XPATH, typeName);
    }
}
