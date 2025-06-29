package store.Citilink.elements;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;
import java.time.Duration;

/**
 * Базовый класс для веб-элементов, предоставляющий общие методы взаимодействия.
 * Наследуется конкретными элементами.
 */
public class BaseElement {
    /** Время ожидания по умолчанию (в секундах) для проверки видимости элемента */
    protected static final int WAIT_SECONDS = 5;

    /** Базовый Selenide-элемент, с которым происходят взаимодействия */
    protected final SelenideElement baseElement;

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

        } catch (Exception e) {
            return false;
        }
    }
}
