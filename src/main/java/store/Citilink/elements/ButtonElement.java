package store.Citilink.elements;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;

/**
 * Класс, представляющий элемент кнопки на веб-странице.
 * Наследуется от BaseElement и предоставляет методы для работы с кнопками.
 */
public class ButtonElement extends BaseElement {

    /** XPath шаблон для поиска кнопки по атрибуту type */
    private static final String TYPE_XPATH = "//button[@type=\"%s\"]";

    /** XPath шаблон для поиска элемента по атрибуту data-meta-name */
    private static final String DATA_META_NAME_XPATH = "//*[@data-meta-name=\"%s\"]";

    /** XPath шаблон для поиска кнопки по атрибуту type и тексту */
    private static final String TYPE_AND_TEXT_XPATH = "//button[@type=\"%s\" and .//text()[contains(., \"%s\")]]";

    /**
     * Приватный конструктор для создания объекта ButtonElement.
     * @param xpath XPath-шаблон для поиска элемента
     * @param param Параметры для подстановки в XPath-шаблон
     */
    private ButtonElement(String xpath, String... param) {
        super(xpath, param);
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
     * @param value Значение атрибута data-meta-name
     * @return Объект ButtonElement
     */
    public static ButtonElement byDataMetaName(String value) {
        return new ButtonElement(DATA_META_NAME_XPATH, value);
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
