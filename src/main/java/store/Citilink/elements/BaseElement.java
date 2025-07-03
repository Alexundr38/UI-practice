package store.Citilink.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;
import java.time.Duration;
import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.ex.ElementShouldNot;
import com.codeborne.selenide.ScrollOptions;


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
        baseElement = parentElement.baseElement.$x(String.format(xpath, (Object[]) params));
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

    /**
     * Проверяет, перестал ли элемент отображаться на странице.
     * Ждёт до {@link #WAIT_SECONDS} секунд перед проверкой.
     *
     * @return true — если элемент не видим, false — если видим или возникла ошибка
     */
    public boolean waitNotDisplayed() {
        try {
            baseElement.shouldNotBe(visible, Duration.ofSeconds(WAIT_SECONDS));
            return true;
        } catch (ElementShouldNot e){
            return false;
        }
    }

    /** Листает страницу так, чтобы baseElement был виден на странице */
    public void scrollToElement() {
        baseElement.scrollIntoView("{block: 'center', behavior: 'smooth'}");
    }

    /**
     * Наводит курсор мыши на элемент.
     */
    public void hover() {
        scrollToElement();
        baseElement.hover();
    }

    /**
     * Возвращает все CSS-параметры элемента в виде одной строки (через пробел)
     * @param param Название параметра
     * @return строка с перечислением всех параметров элемента или пустая строка, если атрибут отсутствует
     */
    public String getParamValue(String param) {
        return baseElement.getAttribute(param);
    }
}
