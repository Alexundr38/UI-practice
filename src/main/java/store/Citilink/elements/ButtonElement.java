package store.Citilink.elements;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.executeJavaScript;

/**
 * Класс, представляющий элемент кнопки на веб-странице.
 * Наследуется от BaseElement и предоставляет методы для работы с кнопками.
 */
public class ButtonElement extends BaseElement {

    /** XPath шаблон для поиска кнопки по атрибуту type */
    private static final String TYPE_XPATH = "//*[@type=\"%s\"]";

    /** XPath шаблон для поиска кнопки по параметру */
    private static final String PARAM_XPATH = "//*[@%s=\"%s\"]";

    /** XPath шаблон для поиска элемента по атрибуту data-meta-name */
    private static final String DATA_META_NAME_XPATH = "//*[@data-meta-name=\"%s\"]";

    /** XPath шаблон для поиска элемента по атрибуту data-meta-value */
    private static final String DATA_META_VALUE_XPATH = "//*[@data-meta-value=\"%s\"]";

    /** XPath шаблон для поиска категории по атрибуту data-meta-name и тексту*/
    private static final String DATA_META_NAME_AND_TEXT_CATEGORY_XPATH =
            "(//a[@data-meta-name=\"%s\" and .//span[contains(normalize-space(.), \"%s\")]])[2]";

    /** XPath шаблон для поиска текста по атрибуту data-meta-name и тексту*/
    private static final String DATA_META_NAME_AND_TEXT_XPATH =
            "//a[@data-meta-name=\"%s\" and .//span[normalize-space(text())=\"%s\"]]";

    /** XPath шаблон для поиска кнопки по атрибуту type и тексту */
    private static final String TYPE_AND_TEXT_XPATH = "//button[@type=\"%s\" and .//text()[contains(., \"%s\")]]";

    /** XPath шаблон для поиска кнопки внутри другого элемента по заданному параметру */
    private static final String BUTTON_IN_ELEMENT_XPATH = ".//*[@%s=\"%s\"]//button";

    /** XPath шаблон для поиска кнопки по атрибуту text */
    private static final String TEXT_XPATH = "//button[.//text()=\"%s\"]";

    /** Константа для XPath поиска по классу */
    private static final String CLASS_XPATH = "//*[@class=\"%s\"]";

    /** Константа для XPath поиска по id */
    private static final String ID_XPATH = "//*[@id=\"%s\"]";

    /** Константа для XPath поиска по href */
    private static final String HREF_XPATH = "//*[@href=\"%s\"]";

    /**
     * XPath шаблон для поиска вложенного элемента по заданному атрибуту и его значению
     * относительно родительского элемента.
     */
    private static final String IN_ELEMENT_XPATH = ".//*[@%s=\"%s\"]";

    /**
     * XPath шаблон для поиска вложенного элемента по содержащемуся заданному атрибуту и
     * его значению относительно родительского элемента.
     */
    private static final String IN_CONTAINS_XPATH = ".//*[contains(@%s, \"%s\")]";

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
        scrollToElement();
        baseElement.click();
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

    /**
     * Прокручивает страницу к элементу с выравниванием по центру
     * @return текущий объект ButtonElement
     */
    public ButtonElement scrollIntoViewCentered() {
        executeJavaScript(
                "arguments[0].scrollIntoView({block: 'center', inline: 'center', behavior: 'instant'});",
                baseElement
        );
        return this;
    }

    /**
     * Ожидает, пока элемент станет кликабельным
     * @return текущий объект ButtonElement
     */
    public ButtonElement waitUntilClickable() {
        baseElement.shouldBe(Condition.and(
                "clickable",
                Condition.visible,
                Condition.enabled,
                Condition.interactable
        ), Duration.ofSeconds(10));
        return this;
    }

    /**
     * Создает объект ButtonElement, находящий кнопку по атрибуту type.
     * @param paramName Название параметра
     * @param paramValue Значение параметра
     * @return Объект ButtonElement
     */
    public static ButtonElement byParam(String paramName, String paramValue) {
        return new ButtonElement(PARAM_XPATH.replaceFirst("%s", paramName), paramValue);
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
     * Создает объект ButtonElement, находящий элемент по атрибуту data-meta-value.
     * @param dataMetaValue Значение атрибута data-meta-value
     * @return Объект ButtonElement
     */
    public static ButtonElement byDataMetaValue(String dataMetaValue) {
        return new ButtonElement(DATA_META_VALUE_XPATH, dataMetaValue);
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
     * Создает объект ButtonElement, находящий кнопку по атрибуту href.
     * @param href Значение атрибута href
     * @return Объект ButtonElement
     */
    public static ButtonElement byHref(String href) {
        return new ButtonElement(HREF_XPATH, href);
    }

    /**
     * Создает объект ButtonElement внутри указанного родительского элемента
     * по произвольному атрибуту и его значению.
     *
     * @param parentElement Родительский элемент, относительно которого выполняется поиск
     * @param xpathParam    Имя атрибута для поиска (например, "data-meta-name")
     * @param paramValue    Значение атрибута, по которому ищется элемент
     * @return новый экземпляр ButtonElement, соответствующий найденной кнопке
     */
    public static ButtonElement byInElement(BaseElement parentElement, String xpathParam, String paramValue) {
        return new ButtonElement(parentElement,
                IN_ELEMENT_XPATH.replaceFirst("%s", xpathParam), paramValue);
    }

    /**
     * Создает объект ButtonElement, находящий кнопку по классу.
     * @param className Значение атрибута class
     * @return Объект ButtonElement
     */
    public static ButtonElement byClass(String className) {
        return new ButtonElement(CLASS_XPATH, className);
    }

    /**
     * Проверяет, доступна ли кнопка для взаимодействия.
     * @return true, если кнопка доступна, false в противном случае
     * Создает объект ButtonElement внутри указанного родительского элемента
     * по содержанию произвольного атрибута и его значения.
     *
     * @param parentElement Родительский элемент, относительно которого выполняется поиск
     * @param xpathParam    Имя атрибута для поиска
     * @param paramValue    Значение атрибута, по которому ищется элемент
     * @return новый экземпляр ButtonElement, соответствующий найденной кнопке
     */
    public static ButtonElement byInContains(BaseElement parentElement, String xpathParam, String paramValue) {
        return new ButtonElement(parentElement,
                IN_CONTAINS_XPATH.replaceFirst("%s", xpathParam), paramValue);
    }


    /**
     * Создает объект ButtonElement для категории по атрибуту data-meta-name и тексту
     * @param dataMetaName Значение атрибута data-meta-name, указывающее категорию
     * @param text          Текст внутри элемента <span> для поиска
     * @return новый экземпляр ButtonElement, соответствующий найденной категории
     */
    public static ButtonElement byDataMetaNameAndTextCategory(String dataMetaName, String text) {
        return new ButtonElement(DATA_META_NAME_AND_TEXT_CATEGORY_XPATH, dataMetaName, text);
    }

    /**
     * Создает объект ButtonElement по атрибуту data-meta-name и тексту.
     *
     * @param dataMetaName Значение атрибута data-meta-name
     * @param text         Текст внутри <span> для поиска
     * @return новый экземпляр ButtonElement с указанными параметрами
     */
    public static ButtonElement byDataMetaNameAndText(String dataMetaName, String text) {
        return new ButtonElement(DATA_META_NAME_AND_TEXT_XPATH, dataMetaName, text);
    }

    /**
     * Создает объект ButtonElement по атрибуту id.
     *
     * @param id Значение атрибута id
     * @return новый экземпляр ButtonElement с указанными параметрами
     */
    public static ButtonElement byId(String id) {
        return new ButtonElement(ID_XPATH, id);
    }
}