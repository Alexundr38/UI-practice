package store.Citilink.elements;

import store.Citilink.pages.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;

/**
 * Класс, представляющий элемент кнопки на веб-странице.
 * Наследуется от BaseElement и предоставляет методы для работы с кнопками.
 */
public class ButtonElement extends BaseElement {

    /** XPath шаблон для поиска кнопки по атрибуту type */
    private static final String TYPE_XPATH = "//*[@type=\"%s\"]";

    /** XPath шаблон для поиска элемента по атрибуту data-meta-name */
    private static final String DATA_META_NAME_XPATH = "//*[@data-meta-name=\"%s\"]";

    /** XPath шаблон для поиска кнопки по атрибуту type и тексту */
    private static final String TYPE_AND_TEXT_XPATH = "//button[@type=\"%s\" and .//text()[contains(., \"%s\")]]";

    /** XPath шаблон для поиска кнопки внутри другого элемента по заданному параметру */
    private static final String BUTTON_IN_ELEMENT_XPATH = ".//*[@%s=\"%s\"]//button";

    /** XPath шаблон для поиска кнопки по атрибуту text */
    private static final String TEXT_XPATH = "//button[.//text()=\"%s\"]";

    /**
     * Приватный конструктор для создания объекта ButtonElement.
     * @param xpath XPath-шаблон для поиска элемента
     * @param param Параметры для подстановки в XPath-шаблон
     */
    private ButtonElement(String xpath, String... param) {
        super(xpath, param);
    }

    /**
     * Приватный конструктор для создания объекта ButtonElement.
     * @param parentElement Родительский элемент, относительно которого
     *                      осуществляется поиск элемента
     * @param xpath XPath-шаблон для поиска элемента
     * @param param Параметр для подстановки в XPath-шаблон
     */
    private ButtonElement(BaseElement parentElement, String xpath, String param){
        super(parentElement, xpath, param);
    }

    /**
     * Выполняет клик по кнопке.
     */
    public void click(){
        baseElement.click();
    }

    /**
     * Создает объект ButtonElement, находящий кнопку по атрибуту type.
     * @param typeName Значение атрибута type
     * @return Объект ButtonElement
     */
    public static ButtonElement byType(String typeName) {
        return new ButtonElement(TYPE_XPATH, typeName);
    }

    /**
     * Создает объект ButtonElement, находящий кнопку по атрибуту type и тексту.
     * @param typeName Значение атрибута type
     * @param text Текст кнопки
     * @return Объект ButtonElement
     */
    public static ButtonElement byTypeAndText(String typeName, String text) {
        return new ButtonElement(TYPE_AND_TEXT_XPATH, typeName, text);
    }

    /**
     * Создает объект ButtonElement, находящий элемент по атрибуту data-meta-name.
     * @param dataMetaName Значение атрибута data-meta-name
     * @return Объект ButtonElement
     */
    public static ButtonElement byDataMetaName(String dataMetaName) {
        return new ButtonElement(DATA_META_NAME_XPATH, dataMetaName);
    }

    /**
     * Создает объект ButtonElement, находящий элемент родительскому элементу и заданным параметрам.
     * @param parentElement Родительский элемент, относительно которого
     *                      осуществляется поиск элемента
     * @param xpathParam Название параметра для поиска
     * @param paramValue Значение параметра
     * @return Объект ButtonElement
     */
    public static ButtonElement byButtonInElement(BaseElement parentElement, String xpathParam, String paramValue) {
        return new ButtonElement(parentElement,
                BUTTON_IN_ELEMENT_XPATH.replaceFirst("%s", xpathParam), paramValue);
    }

    /**
     * Создает объект ButtonElement, находящий кнопку по атрибуту text.
     * @param text Значение атрибута text
     * @return Объект ButtonElement
     */
    public static ButtonElement byText(String text) {
        return new ButtonElement(TEXT_XPATH, text);
    }

    /**
     * Проверяет, доступна ли кнопка для взаимодействия.
     * @return true, если кнопка доступна, false в противном случае
     */
    public boolean isEnabled(){
        try {
            return baseElement
                    .shouldBe(enabled, Duration.ofSeconds(WAIT_SECONDS))
                    .isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
}
