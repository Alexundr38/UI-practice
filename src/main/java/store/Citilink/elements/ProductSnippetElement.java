package store.Citilink.elements;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Класс представляет элемент товара (сниппет) на странице.
 * Наследуется от BaseElement и предоставляет методы для работы с элементами товара.
 */
public class ProductSnippetElement extends BaseElement {

    /** XPath шаблон для поиска элементов по атрибуту data-meta-name */
    protected static final String DATA_META_NAME_XPATH = "//div[@data-meta-name=\"%s\"]";

    /** XPath шаблон для поиска элементов по произвольному атрибуту */
    protected static final String DATA_META_PARAM_XPATH = "//div[@%s=\"%s\"]";

    /**
     * Конструктор элемента товара
     * @param xpath XPath выражение для поиска элемента
     * @param param Параметр для подстановки в XPath
     */
    protected ProductSnippetElement(String xpath, String param){
        super(xpath, param);
    }

    /**
     * Изменяет базовый элемент на новый, найденный по указанному параметру
     * @param param Имя атрибута, по которому будет производиться поиск
     */
    protected void changeBaseElement(String param) {
        String paramValue = getDataInfo(param);
        baseElement = $x(String.format(DATA_META_PARAM_XPATH, param, paramValue));
    }

    /**
     * Получает значение атрибута элемента
     * @param param имя атрибута
     * @return Значение атрибута
     */
    private String getDataInfo(String param){
        return baseElement.attr(param);
    }
}
