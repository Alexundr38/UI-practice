package store.Citilink.elements;

public class CheckBoxElement extends InputElement{

    /**
     * Конструктор для создания объекта CheckBoxElement.
     * @param parentElement Родительский элемент, относительно которого
     *                      осуществляется поиск элемента
     * @param xpath XPath-шаблон для поиска элемента
     * @param param Параметр для подстановки в XPath-шаблон
     */
    private CheckBoxElement(BaseElement parentElement, String xpath, String param){
        super(parentElement, xpath, param);
    }

    /**
     * Активирует чекбокс, если он еще не был активен
     */
    public void activate() {
        scrollToElement();
        if (!isSelected()) {
            baseElement.click();
        }
    }

    /** Возвращает состояние чекбокса
     *
     * @return true, если чекбокс активен, false в противном случае
     */
    private boolean isSelected() {
        return baseElement.isSelected();
    }

    /**
     * Создает объект CheckBoxElement, находящий элемент родительскому элементу и заданным параметрам.
     * @param parentElement Родительский элемент, относительно которого
     *                      осуществляется поиск элемента
     * @param xpathParam Название параметра для поиска
     * @param paramValue Значение параметра
     * @return Объект CheckBoxElement
     */
    public static CheckBoxElement byCheckBoxInElement(BaseElement parentElement, String xpathParam, String paramValue) {
        return new CheckBoxElement(parentElement,
                INPUT_IN_ELEMENT_XPATH.replaceFirst("%s", xpathParam), paramValue);
    }
}
