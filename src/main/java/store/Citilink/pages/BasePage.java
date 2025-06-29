package store.Citilink.pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

/**
 * Базовый класс для всех страниц сайта.
 * Содержит общую логику, используемую в дочерних страницах.
 */
public class BasePage {
    /**
     * Класс страницы, необходимый для возвращения объекта текущей страницы.
     */
    protected final Class<? extends BasePage> pageClass;

    /**
     * Ожидаемая часть URL, используется для проверки, что открыта нужная страница.
     */
    protected final String expectedUrlPart;

    /**
     * Конструктор базовой страницы.
     * @param pageClass Класс страницы
     * @param expectedUrlPart Часть URL, которая должна быть в адресе при открытии страницы
     */
    protected BasePage(Class<? extends BasePage> pageClass, String expectedUrlPart) {
        this.pageClass = pageClass;
        this.expectedUrlPart = expectedUrlPart;
    }

    /**
     * Проверяет, что текущий URL содержит ожидаемую подстроку.
     * Выбрасывает AssertionError, если URL не совпадает.
     */
    protected void verifyPageUrl(){
        if (!WebDriverRunner.url().contains(expectedUrlPart)) {
            throw new AssertionError("Page url doesn't match expected url part: " + expectedUrlPart);
        }
    }

    /**
     * Обновляет страницу и возвращает новый объект текущего класса страницы.
     * @param <T> Тип страницы
     * @return Новый объект текущей страницы
     */
    public <T extends BasePage> T refresh() {
        Selenide.refresh();
        return (T) page(pageClass);
    }

    /**
     * Создаёт новый объект страницы по её классу.
     * Используется для возвращения новой страницы после переходов или обновлений.
     * @param pageClass Класс страницы
     * @param <T> Тип страницы
     * @return Новый объект переданного класса страницы
     */
    public <T extends BasePage> T page(Class<T> pageClass) {
        try {
            return pageClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
}
