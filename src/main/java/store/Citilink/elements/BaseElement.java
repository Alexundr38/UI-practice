package store.Citilink.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;
import java.time.Duration;
import com.codeborne.selenide.ex.ElementNotFound;

/**
 * Базовый класс для веб-элементов, предоставляющий общие методы взаимодействия.
 * Наследуется конкретными элементами.
 */
public class BaseElement {
    /** Время ожидания по умолчанию (в секундах) для проверки видимости элемента */
    protected static final int WAIT_SECONDS = 5;

    /** Базовый Selenide-элемент, с которым происходят взаимодействия */
    protected SelenideElement baseElement;

    /**
     * Конструктор базового элемента.
     *
     * @param xpath  XPath-локатор элемента
     * @param params Параметры для уточнения XPath
     */
    protected BaseElement(String xpath, String... params){
        baseElement = $x(String.format(xpath, (Object[]) params));
    }

    /**
     * Конструктор базового элемента.
     *
     * @param parentElement Родительский элемент
     * @param xpath  XPath-локатор элемента
     * @param params Параметры для уточнения XPath
     */
    protected BaseElement(BaseElement parentElement, String xpath, String... params){
        baseElement = parentElement.getBaseElement().$x(String.format(xpath, (Object[]) params));
    }

    /**
     * Проверяет, отображается ли элемент на странице.
     * Ждёт до {@link #WAIT_SECONDS} секунд перед проверкой.
     *
     * @return true — если элемент видим, false — если не видим или возникла ошибка
     */
    public boolean isDisplayed() {
        try {
            return baseElement
                    .shouldBe(visible, Duration.ofSeconds(WAIT_SECONDS))
                    .isDisplayed();

        } catch (ElementNotFound e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /** Возвращает baseElement
     *
     * @return baseElement Базовый Selenide элемент
     */
    protected SelenideElement getBaseElement() {
        return baseElement;
    }
}
