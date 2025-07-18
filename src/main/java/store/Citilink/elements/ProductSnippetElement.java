package store.Citilink.elements;

/**
 * Класс представляет элемент товара (сниппет) на странице.
 * Наследуется от BaseElement и предоставляет методы для работы с элементами товара.
 */
public class ProductSnippetElement extends BaseElement {

    /** XPath шаблон для поиска элементов по атрибуту data-meta-name */
    protected static final String DATA_META_NAME_XPATH = "//div[@data-meta-name=\"%s\"]";

    /** XPath сниппета по data-meta-name и содержащемуся title (названию товара) */
    protected static final String SNIPPET_BY_NAME_XPATH =
            "//div[@data-meta-name='%s' " +
                    "and .//a[contains(normalize-space(@title), '%s')]]";

    /**
     * Конструктор элемента товара
     * @param xpath XPath выражение для поиска элемента
     * @param param Параметр для подстановки в XPath
     */
    protected ProductSnippetElement(String xpath, String param){
        super(xpath, param);
    }

}
