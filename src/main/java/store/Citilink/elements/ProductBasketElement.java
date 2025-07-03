package store.Citilink.elements;

/**
 * Класс представляет элемент товара в корзине.
 * Наследуется от ProductSnippetElement, добавляя функциональность для работы с товарами в корзине.
 */
public class ProductBasketElement extends ProductSnippetElement{

    /** XPath для элемента в корзине */
    private static final String BASKET_SNIPPET_BY_NAME_XPATH = SNIPPET_BY_NAME_XPATH.replaceFirst("%s", "BasketSnippet");

    /** Кнопка удаления товара из корзины */
    private final ButtonElement removeButton = ButtonElement.byButtonInElement(
            this, "data-meta-name", "DeleteAction");

    /** Checkbox для выделения товара в корзине */
    private final CheckBoxElement removeCheckBox = CheckBoxElement.byCheckBoxInElement(
            this, "type", "checkbox");

    /**
     * Конструктор элемента товара в корзине
     * @param xpath XPath выражение для поиска элемента
     * @param param Параметр для подстановки в XPath
     */
    protected ProductBasketElement(String xpath, String param){
        super(xpath, param);
    }

    /**
     * Удаляет товар из корзины (нажимает кнопку удаления)
     */
    public void removeElementWithBin(){
        removeButton.click();
    }

    /**
     * Активирует выделение товара в корзине (для дальнейшего удаления)
     */
    public void clickRemoveCheckBox() {
        removeCheckBox.activate();
    }

    /**
     * Статический метод для создания элемента по data-meta-name
     * @param productName Значение атрибута data-meta-name
     * @return Новый объект ProductBasketElement
     */
    public static ProductBasketElement byName(String productName){
        return new ProductBasketElement(BASKET_SNIPPET_BY_NAME_XPATH, productName);
    }

    /**
     * Статический метод для создания элемента по data-meta-name
     * @param dataMetaName Значение атрибута data-meta-name
     * @return Новый объект ProductBasketElement
     */
    public static ProductBasketElement byDataMetaName(String dataMetaName){
        return new ProductBasketElement(DATA_META_NAME_XPATH, dataMetaName);
    }
}
